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

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">글쓰기</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>
					
					<div class="row justify-content-center" >
						<div class="w-50 pt-5">
							<form action="./add" method="post">
								<div class="mb-3">
									<label class="form-label">제목</label> 
									<input type="text" name="boardTitle" class="form-control" required>
								</div>
								<div class="mb-3">
									<label class="form-label">작성자</label> 
									<input type="text"name="boardWriter" class="form-control" required>
								</div>
								<div class="mb-3">
									<label class="form-label">내용</label>
									<textarea name="boardContents" class="form-control" rows="6" required></textarea>
								</div>
								<div class="d-flex justify-content-between">
									<a href="./list" class="btn btn-secondary">목록</a>
									<button type="submit" class="btn btn-primary">등록</button>
								</div>
							</form>
						</div>
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