<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.poscodx.mysite.vo.UserVo"%>
  <%@page import="com.poscodx.mysite.dao.UserDao"%>
<%
	UserVo authUser = (UserVo)session.getAttribute("authUser");
	UserVo userVo = new UserDao().findByNo(authUser.getNo());
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="user">

				<form id="join-form" name="updateForm" method="post" action="<%=request.getContextPath() %>/user">
					<input type="hidden" name="a" value="update">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="<%=authUser.getName()%>">

					<label class="block-label" for="email">이메일</label>
					<input name="email" type="hidden" value="<%=userVo.getEmail() %>">
					<h4><%=userVo.getEmail() %></h4>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
					<legend>성별</legend>
					<%if(userVo.getGender().equals("female")){ %>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					<%}else{ %>
						<label>여</label> <input type="radio" name="gender" value="female" >
						<label>남</label> <input type="radio" name="gender" value="male" checked="checked">
					<%} %>
					</fieldset>
					
					<input type="submit" value="변경하기">
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>