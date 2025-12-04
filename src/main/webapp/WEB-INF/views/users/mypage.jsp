<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<c:import url="/WEB-INF/views/template/head.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">

		<!-- Sidebar -->
		<c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>

		<!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

	            <!-- Topbar -->
	            <c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">My Page</h1>
                    </div>

                    <!-- Content Row -->
                    <div class="row justify-content-center mt-5">
                        <div class="col-lg-6 mt-5">

                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">내 정보</h6>
                                </div>

                                <div class="card-body">

                                    <p><strong>아이디:</strong> ${user.username}</p>
                                    <p><strong>이름:</strong> ${user.name}</p>
                                    <p><strong>이메일:</strong> ${user.email}</p>
                                    <p><strong>전화번호:</strong> ${user.phone}</p>
                                    <p><strong>생년월일:</strong> ${user.birth}</p>

                                    <a href="./update?username=${user.username}" class="btn btn-primary"> 정보 수정 </a>
																		<c:if test="${not empty profile}">
																		    <img src="/uploads/profile/${profile.fileName}">
																		</c:if>
                                </div>
                             </div>

                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
            </div>

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>

        </div>
	</div>

<jsp:include page="/WEB-INF/views/template/foot.jsp"></jsp:include>
</body>
</html>
