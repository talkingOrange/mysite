<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.request.contextPath }/board" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<td>${(paging.totalCount - ((paging.page -1) * paging.limit ))  - status.index}</td>
							<td style="padding-left:${(vo.oNo-1)*30 }px">
								<div style="display: flex">

									<c:choose>
										<c:when test='${vo.oNo ne 1}'>
											<div class="reply"></div>
										</c:when>
									</c:choose>
									<div>
										<a
											href="${pageContext.request.contextPath }/board?a=view&no=${vo.no }">${vo.title }</a>
									</div>
								</div>
							</td>
							<td>${vo.userName}</td>
							<td>${vo.hit }</td>
							<td>${vo.date }</td>
							<c:choose>
								<c:when test="${authUser.no eq vo.userNo }">
									<td><a
										href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no }"
										class="del">삭제</a></td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>

				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<c:if test="${paging.prev}">
							<li><a
								href="${pageContext.request.contextPath }/board?page=${paging.beginPage-1}">◀</a></li>
						</c:if>
						<c:forEach begin="${paging.beginPage}"
								end="${paging.endPage}" step="1" var="index">
								<c:choose>
									<c:when test="${paging.page==index}"><li class="selected"> ${index}</li></c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath }/board?page=${index}">${index}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						<c:if test="${paging.next}">
							<li><a href="${pageContext.request.contextPath }/board?page=${paging.endPage+1}">▶</a></li>
						</c:if>

					</ul>
				</div>
				<!-- pager 추가 -->

				<div class="bottom">
					<c:choose>
						<c:when test="${empty authUser }">
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath }/board?a=writeform"
								id="new-book">글쓰기</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>