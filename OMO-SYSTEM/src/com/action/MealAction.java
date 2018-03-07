package com.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.dao.MealseriesDao;
import com.entity.Meal;
import com.entity.Mealseries;
/**
 * �������Ա�����е���Ӳ�Ʒ
 * @author DaiJinchi
 * 2017-8-25
 */
@Controller
public class MealAction implements RequestAware{
	private Map<String, Object> request;
	private Meal meal;
	private File doc;//�ϴ�ͼƬ����
	private String docFileName;//�ϴ�ͼƬ����
	private String docContentType;//�ϴ�ͼƬ����
	
	@Resource
	private MealseriesDao mealseriesDao;
	@Resource
	private MealDao mealDao;
	
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	//��ȡ��ϵ�����ص�addMeal����
	public String doAddMeal(){
		List<Mealseries> list = mealseriesDao.findAllMS();
		request.put("mealseriesList", list);
		return "success";
	}
	//������Ʒ,������������Ʒ����
	public String addMeal() throws IOException{
		if (docFileName != null){
			//��ȡ�ļ�Ŀ¼����·��
			String path = ServletActionContext.getServletContext().getRealPath("/mealimages");
			//�޸��ļ���
			String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
			int random = new Random().nextInt(10000);
			int position = docFileName.lastIndexOf(".");
			String extension = docFileName.substring(position);
			docFileName = formatDate + random + extension;
			//����Ŀ���ļ�
			File target = new File(path, docFileName);
			//���ļ���Ϣ���Ƶ�Ŀ���ļ�
			FileUtil.copyFile(doc, target);
			meal.setMealImage(docFileName);
		}
		mealDao.addMeal(meal);
		return "success";
	}
}
