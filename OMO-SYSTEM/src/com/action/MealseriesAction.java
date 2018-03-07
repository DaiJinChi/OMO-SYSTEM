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
 * 该控制层同时实现了管理员功能中的管理餐品
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
	private File doc;//上传图片属性
	private String docFileName;//上传图片名称
	private String docContentType;//上传图片类型
	
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

	//查询所有菜系，分页查询菜品
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
	//按参数查询
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
	//按菜品id查找详细信息
	public String findMealById(){
		listMS = mealseriesDao.findAllMS();
		meal = mealDao.findById(id);
		return "success";
	}
	//修改菜品
	public String updateMeal() throws IOException{
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
		mealDao.updateMeal(meal);
		return "success";
	}
	//根据id删除菜品
	public String deleteMeal(){
		mealDao.deleteMeal(id);
		return "success";
	}
}
