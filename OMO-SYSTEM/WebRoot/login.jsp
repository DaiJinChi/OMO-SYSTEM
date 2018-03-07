<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>登录页面</title>		
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
				<td valign="top">
					<p>
						<img src="images/left_top.jpg" width="200" height="70" />					
				</td>
				<td valign="top" width="80%">
					<img src="images/001.jpg" width="1450" height="70" />
					<br />
					
					<div style="background-image:url(images/004.gif)">
						&nbsp;
					</div>
					<div style="background-color:#FFCC99;" align="center">
						网上订餐系统用户请直接登录
					</div>
					<br>
					<br />
					
					<%-- <s:if test="#paramters.role[0]=='user'"> --%>
					<s:if test="%{#parameters.role[0] == 'user'}">
					<form action="checkUser" method="post" name="ufrm">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td width="74">
									用户名：
								</td>
								<td width="189">
									<input type="text" name="user.loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									密 &nbsp;&nbsp;码：
								</td>
								<td>
									<input type="password" name="user.loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="登 录" />
								</td>
							</tr>
						</table>
					</form>
					</s:if>
					<!-- user登录用户名或密码错误时 -->
					<s:if test="role=='user'">
					<form action="checkUser" method="post" name="ufrm">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td width="74">
									用户名：
								</td>
								<td width="189">
									<input type="text" name="user.loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									密 &nbsp;&nbsp;码：
								</td>
								<td>
									<input type="password" name="user.loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="登 录" />
									<s:property value="msg"/>
								</td>
							</tr>
						</table>
					</form>
					</s:if>
					
					<!-- admin登录用户名或密码错误时 -->
					<s:if test="role=='admin'">
						<form action="checkAdmin" method="post" name="afrm">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td width="74">
									登录名：
								</td>
								<td width="189">
									<input type="text" name="admin.loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									密 &nbsp;&nbsp;码：
								</td>
								<td>
									<input type="password" name="admin.loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="登 录" />
									<s:property value="msg"/>
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
								</td>
							</tr>
						</table>
					</form>			
					</s:if>
					
					<!-- show.jsp跳转时 -->
					<s:if test="%{#parameters.role[0] == 'admin'}">
					<form action="checkAdmin" method="post" name="afrm">
						<table width="263" border="0" cellspacing="0" cellpadding="4"
							align="center">
							<tr>
								<td width="74">
									登录名：
								</td>
								<td width="189">
									<input type="text" name="admin.loginName" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									密 &nbsp;&nbsp;码：
								</td>
								<td>
									<input type="password" name="admin.loginPwd" style="width:150;" />
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									<input type="submit" name="login" value="登 录" />
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
								</td>
							</tr>
						</table>
					</form>			
					</s:if>					
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
