<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>订单处理</title>       
		<link rel="stylesheet" href="/OMO-SYSTEM/css/styles.css" type="text/css" />
	</head>

	<body>
		<table width="90%" height="629" border="0" cellpadding="0"
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
						<img src="images/003.gif" width="191" height="8">
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="1450" height="70" />
					<br />
					<div align="left">
				      <form theme="simple" method="post" action="findOrdersByParam">
		                <label >订单号：</label>
		                <input name="orders.oid"/><br>
		                <label >订单状态：</label>
		                <select name="orders.orderState">
		                	<option checked="true">全部</option>
		                	<option>未处理</option>
		                	<option>已处理</option>
		                </select><br>
		        	    <input value="查询" type="submit"/>						
					  </form>
					</div>
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>					
					<br />
					<img src="images/icon_order.gif" align="top" />
					订单列表
					<br />
					<hr />
					<table align="center" width="95%" cellspacing="0" cellpadding="3"
						style="text-align:center; border:1px #cccccc solid;">
						<tr style="background-color:#CCCCFF;">
							<td>订单编号</td>
							<td>用户姓名</td>
							<td>订单时间</td>
							<td>订单状态</td>
							<td>总额</td>
							<td>处理</td>
						</tr>
						<s:iterator value="ordersList">
						<tr style="background-color:#FFFFFF;">						  
							<td>								
								<s:property value="oid"/>
							</td>
							<td>								
								<s:property value="users.loginName"/>
							</td>
							<td>								
								<s:property value="orderTime"/>
							</td>
							<td>
								<s:property value="orderState"/>
							</td>
							<td>
								<s:property value="orderPrice"/>
							</td>							
							<td>
								  <a href="doOrder?oid=<s:property value="oid"/>"><img src="images/handle.gif"
								width="12" height="12" /></a>
							</td>
						</tr>
						</s:iterator>
						<!-- 分页超链接开始 -->
						<table align="right">
	  <tr>
		<td width="130"></td>
		<td width="80">
				<A href='findAllOrders?page=1'>首页</A>&nbsp;&nbsp;
				<A href='findAllOrders?page=<s:property value="Page-1"/>'>上一页</A>
		</td>
		<td width="80">
				<A href='findAllOrders?page=<s:property value="Page+1"/>'>下一页</A>&nbsp;&nbsp;
				<A href='findAllOrders?page=<s:property value="totalPage"/>'>尾页</A>
		</td>
		<td>共<s:property value="totalNum"/>记录，共<s:property value="page"/>/<s:property value="totalPage"/>页&nbsp;&nbsp;
		
		</td>
	  </tr>
	</table>
						
						<!-- 分页超链接结束-->
						
					</table>
					<br />
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>	
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
