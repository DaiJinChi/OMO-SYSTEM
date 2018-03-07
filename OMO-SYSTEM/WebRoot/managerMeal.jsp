<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>管理餐品</title>
		<link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />
	</head>

	<body>
		<table width="95%" height="170" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td width="200" height="101">
					<img src="images/jb_logo.jpg" width="64" height="32" />
					<strong><span
						style="font-size: 20px;">网上订餐系统</span> </strong>
				</td>
				<td width="640" style="padding-left: 40px;">
					
				</td>
			</tr>
			<tr>
				<td height="41" colspan="2"
					style="background-image:url(images/001.gif);" align="center">
					|
					<a href="/OMO-SYSTEM/showMeal">网站首页</a> |
					<!-- 首页 -->
					<s:if test="(#session.user==null)&&(#session.admin==null)">
					<a href="register.jsp">用户注册</a> |
					<a href="login.jsp?role=user">用户登录</a> |
					<a href="login.jsp?role=admin">管理员登录</a> |
					</s:if>
					<!-- 用户登录后首页 -->
					<s:if test="(#session.user!=null)">
					<a href="modifyMyInfo.jsp">修改个人信息</a> |
					<a href="shopCart.jsp">我的购物车</a> |
					<a href="findOrders">我的订单</a> |
					<a href="logout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">欢迎您：${sessionScope.user.loginName}</font>
					</s:if>
					<!-- 管理员登录后首页 -->
					<s:if test="(#session.admin!=null)">
					<a href="doAddMeal">添加餐品</a> |
					<a href="manager">管理餐品</a> |
					<a href="findAllOrders">订单处理</a> |
					<a href="logout">注销</a> &nbsp;&nbsp; &nbsp;&nbsp;
					<font style="color: red">欢迎您：${sessionScope.admin.loginName}</font>
					</s:if>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					<p>
						<img src="images/left_top.jpg" width="200" height="70" />
						<br>
						<img src="images/003.gif" width="200" height="8">
						<!-- 菜系循环开始 -->
						<br>
						<s:iterator value="listMS">
							<h1><a href="byParamMealInmanager?meal.mealseries.seriesId=<s:property value="seriesId"/>"><s:property value="seriesName"/></a><br>
						</h1>
						</s:iterator>
						<br>
						<!-- 菜系循环结束 -->
						
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="1450" height="70" />
					<br />
					<div align="left">
				      <s:form theme="simple" method="post" action="byParamMealInmanager">
		                <s:label>输入菜名</s:label>
		        	    <s:textfield name="meal.mealName"/>
						<s:submit value="查询"/>		
					  </s:form>
					</div>
					<br />
					<div style="background-image: url(images/004.gif)">
						&nbsp;
					</div>
					<br><br>
					<table width="75%" cellspacing="0" cellpadding="4" align="center"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>
								菜系
							</td>
							<td>
								菜名
							</td>
							<td>
								摘要
							</td>
							<td>
								价格
							</td>	
							<td>
								修改
							</td>		
							<td>
								删除
							</td>					
						</tr>
						<s:iterator value="listM" status="s">
						<tr>							
							<td>
								<s:property value="mealseries.seriesName"/>
							</td>
							<td>
								<s:property value="mealName"/>
							</td>
							<td>
								<s:property value="mealSummarize"/>
							</td>
							<td>
								<s:property value="mealPrice"/>
							</td>	
							<td>
							    <a href="findMealForUpdate?id=<s:property value="mealId"/>">修改</a>								
							</td>	
							<td>
								<a href="deleteMeal?id=<s:property value="mealId"/>">删除</a>
							</td>				
						</tr>
						</s:iterator>
						<!-- 分页超链接开始 -->
						<table align="right">
						  <tr>
							<td width="130"></td>
							<td width="250">
								<s:if test="status==1">
									<A href='manager?page=1'>首页</A>&nbsp;&nbsp;
									<A href='manager?page=<s:property value="Page-1"/>'>上一页</A>
									<A href='manager?page=<s:property value="Page+1"/>'>下一页</A>&nbsp;&nbsp;
									<A href='manager?page=<s:property value="totalPage"/>'>尾页</A>
								</s:if>
								<s:if test="status==2">
									<A href='byParamMealInmanager?page=1'>首页</A>&nbsp;&nbsp;
									<A href='byParamMealInmanager?page=<s:property value="Page-1"/>'>上一页</A>
									<A href='byParamMealInmanager?page=<s:property value="Page+1"/>'>下一页</A>&nbsp;&nbsp;
									<A href='byParamMealInmanager?page=<s:property value="totalPage"/>'>尾页</A>
								</s:if>
								
							</td>
							<td>共<s:property value="totalNum"/>记录，共<s:property value="page"/>/<s:property value="totalPage"/>页&nbsp;&nbsp;
							
							</td>
						  </tr>
						</table>
						<!-- 分页超链接结束-->
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
