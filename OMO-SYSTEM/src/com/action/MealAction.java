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
 * 负责管理员功能中的添加菜品
 * @author DaiJinchi
 * 2017-8-25
 */
@Controller
public class MealAction implements RequestAware{
	private Map<String, Object> request;
	private Meal meal;
	private File doc;//上传图片属性
	private String docFileName;//上传图片名称
	private String docContentType;//上传图片类型
	
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
	//获取菜系，返回到addMeal界面
	public String doAddMeal(){
		List<Mealseries> list = mealseriesDao.findAllMS();
		request.put("mealseriesList", list);
		return "success";
	}
	//新增菜品,返回至新增菜品界面
	public String addMeal() throws IOException{
		if (docFileName != null){
			//获取文件目录绝对路径
			String path = ServletActionContext.getServletContext().getRealPath("/mealimages");
			//修改文件名
			String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
			int random = new Random().nextInt(10000);
			int position = docFileName.lastIndexOf(".");
			String extension = docFileName.substring(position);
			docFileName = formatDate + random + extension;
			//创建目标文件
			File target = new File(path, docFileName);
			//将文件信息复制到目标文件
			FileUtil.copyFile(doc, target);
			meal.setMealImage(docFileName);
		}
		mealDao.addMeal(meal);
		return "success";
	}
}
