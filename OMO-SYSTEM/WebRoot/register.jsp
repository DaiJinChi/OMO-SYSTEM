<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户注册页面</title>		
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
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>				    
                    <form action="addUser" method="post" name="frm"
						onsubmit="">
						<table width="100%" cellspacing="0" cellpadding="3" align="center"
							style="text-align:center; border:1px #cccccc solid;">
							<tr style="background-color:#CCCCFF;">
								<td colspan="2">
									填写注册信息
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;" >
									登录名称：
								</td>
								<td align="left">
									<input type="text" name="user.loginName" style="width:220px;" />									
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;">
									登录密码：
								</td>
								<td align="left">
									<input type="password" name="user.loginPwd" style="width:220px;" />									
								</td>
							</tr>							
							<tr>
								<td align="right" style="width:320px;">
									真实姓名：
								</td>
								<td align="left">
									<input type="text" name="user.trueName" style="width:220px;" />									
								</td>
							</tr>						
							<tr>
								<td align="right" style="width:320px;">
									电话号码：
								</td>
								<td align="left">
									<input type="text" name="user.phone" style="width:220px;" />									
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;">
									电子邮件：
								</td>
								<td align="left">
									<input type="text" name="user.email" style="width:220px;" />									
								</td>
							</tr>
							<tr>
								<td align="right" style="width:320px;">
									默认地址：
								</td>
								<td align="left">
									<input type="text" name="user.address" style="width:220px;" />									
								</td>
							</tr>
							<tr style="background-color:#CCCCFF;">
								<td colspan="2">
									<input name="register" type="submit" id="register" value="注册" />
								</td>
							</tr>
						</table>
					</form>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<br>
					<hr width=100%>
					<br>					
					<br>
					<br>
				</td>
			</tr>
		</table>
	</body>
</html>
