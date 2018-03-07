package com.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;

import com.dao.MealDao;
import com.dao.MealseriesDao;
import com.entity.Meal;
import com.entity.Mealseries;
/**
 * �ÿ��Ʋ�ͬʱʵ���˹���Ա�����еĹ����Ʒ
 * @author DaiJinchi
 *	2017-8-20
 */
@Controller
public class MealseriesAction {
	private Meal meal;
	private List<Mealseries> listMS;
	private List<Meal> listM;
	private int totalPage;
	private int page;
	private int pageSize;
	private int totalNum;
	private int status = 0;
	private int id;
	private File doc;//�ϴ�ͼƬ����
	private String docFileName;//�ϴ�ͼƬ����
	private String docContentType;//�ϴ�ͼƬ����
	
	@Resource
	private MealseriesDao mealseriesDao;
	@Resource
	private MealDao mealDao;
	
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public List<Meal> getListM() {
		return listM;
	}
	public void setListM(List<Meal> listM) {
		this.listM = listM;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public List<Mealseries> getListMS() {
		return listMS;
	}
	public void setListMS(List<Mealseries> listMS) {
		this.listMS = listMS;
	}

	//��ѯ���в�ϵ����ҳ��ѯ��Ʒ
	public String findAllMS(){
		status = 1;
		meal = null;
		listMS = mealseriesDao.findAllMS();
		totalNum = mealDao.findAllCount();
		if (totalNum % pageSize == 0){
			totalPage = totalNum/pageSize;
		}else {
			totalPage = totalNum/pageSize + 1;
		}
		if (page<1){
			page = 1;
		}else if (page > totalPage){
			page = totalPage;
		}
		listM = mealDao.findAllMeal(page, pageSize);
		return "success";
	}
	//��������ѯ
	public String findByParam(){
		status = 2;
		listMS = mealseriesDao.findAllMS();
		totalNum = mealDao.findCountByparam(meal);
		if (totalNum % pageSize == 0){
			totalPage = totalNum/pageSize;
		}else {
			totalPage = totalNum/pageSize + 1;
		}
		if (page<1){
			page = 1;
		}else if (page > totalPage){
			page = totalPage;
		}
		listM = mealDao.findByParam(page, pageSize, meal);
		return "success";
	}
	//����Ʒid������ϸ��Ϣ
	public String findMealById(){
		listMS = mealseriesDao.findAllMS();
		meal = mealDao.findById(id);
		return "success";
	}
	//�޸Ĳ�Ʒ
	public String updateMeal() throws IOException{
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
		mealDao.updateMeal(meal);
		return "success";
	}
	//����idɾ����Ʒ
	public String deleteMeal(){
		mealDao.deleteMeal(id);
		return "success";
	}
}
