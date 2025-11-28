<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Custom fonts for this template-->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- side bar -->
		<c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>
		<!-- side bar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content" class="flex-grow-1">

				<!-- topbar -->
				<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>
				<!-- topbar -->
				
				<div class="row justify-content-center mb-3">
					<form class="form-inline" method="get" action="./list">
						<select name="kind" class="form-control mr-2">
							<option value="k1">제목</option>
							<option value="k2">내용</option>
							<option value="k3">작성자</option>
						</select> <input type="text" name="search" class="form-control mr-2"
							placeholder="검색어를 입력하세요" value="${param.search}">

						<button class="btn btn-primary" type="submit">검색</button>
					</form>
				</div>
				
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">${category}</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>

					<!-- Content Row -->
					<div class="row justify-content-center">
						<table class="table col-sm-8 mt-5">
							<thead class="thead-dark">
								<tr>
									<th scope="col">번호</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="dto">
									<tr>
										<th scope="row">${dto.boardNum}</th>
										<td>
										<c:catch>
											<c:forEach begin="" end="${dto.boardDepth}">--</c:forEach>
											<a href="./detail?boardNum=${dto.boardNum}">
											${dto.boardTitle}</a>
										</c:catch>
										</td>
										<td>${dto.boardWriter}</td>
										<td>${dto.boardDate}</td>
										<td>${dto.boardHit}</td>
									</tr>
								</c:forEach>
								<c:if test="${empty list}">
									<tr>
										<td colspan="5">등록된 공지사항이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>
					<div class="row justify-content-center">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link"
									href="./list?page=${pager.begin-1}&kind=${param.kind}&search=${param.search}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach begin="${pager.begin}" end="${pager.end}" var="i">
									<li class="page-item"><a class="page-link"
										href="./list?page=${i}&kind=${param.kind}&search=${param.search}">${i}</a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link"
									href="./list?page=${pager.end+1}&kind=${param.kind}&search=${param.search}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
					<div class="row justify-content-center">
						<a href="./add" class="btn btn-primary">글쓰기</a>
					</div>
					<!-- End of Content Row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/foot.jsp"></c:import>
</body>
</html>