<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update</title>
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
                        <h1 class="h3 mb-0 text-gray-800">회원 정보 수정</h1>
                    </div>

                    <!-- Content Row -->
                    <div class="row justify-content-center mt-5">
                        <div class="col-lg-6">

                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">User Update</h6>
                                </div>

                                <div class="card-body">

                                    <form:form modelAttribute="dto" method="post" enctype="multipart/form-data">

                                        <!-- username (수정 불가) -->
                                        <div class="form-group mb-3">
                                            <label>아이디</label>
                                            <form:input path="username" cssClass="form-control" readonly="true"/>
                                        </div>

                                        <!-- name -->
                                        <div class="form-group mb-3">
                                            <label>이름</label>
                                            <form:input path="name" cssClass="form-control"/>
                                        </div>

                                        <!-- email -->
                                        <div class="form-group mb-3">
                                            <label>이메일</label>
                                            <form:input path="email" cssClass="form-control"/>
                                            <form:errors path="email" cssClass="text-danger small"/>
                                        </div>

                                        <!-- phone -->
                                        <div class="form-group mb-3">
                                            <label>전화번호</label>
                                            <form:input path="phone" cssClass="form-control"/>
                                        </div>

                                        <!-- birth -->
                                        <div class="form-group mb-3">
                                            <label>생년월일</label>
                                            <form:input path="birth" cssClass="form-control" type="date"/>
                                        </div>

                                        <!-- profile -->
                                        <div class="form-group mb-3">
                                            <label>프로필 사진 변경</label>
                                            <input type="file" name="profile" class="form-control"/>
                                        </div>

                                        <button type="submit" class="btn btn-primary w-100">수정 완료</button>

                                    </form:form>

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
                        <span>COPYRIGHT &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>

        </div>

	</div>

<c:import url="/WEB-INF/views/template/foot.jsp"></c:import>
</body>
</html>
