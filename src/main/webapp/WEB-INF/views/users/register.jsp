<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">

        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">회원가입</h4>
                </div>

                <div class="card-body">

                    <form:form modelAttribute="dto" action="/users/register" method="post" enctype="multipart/form-data">

                        <!-- username -->
                        <div class="mb-3">
                            <label for="username" class="form-label">아이디</label>
                            <form:input path="username" cssClass="form-control" id="username" />
                            <form:errors path="username" cssClass="text-danger small"></form:errors>
                        </div>

                        <!-- password -->
                        <div class="mb-3">
                            <label for="password" class="form-label">비밀번호</label>
                            <form:password path="password" cssClass="form-control" id="password" />
                            <form:errors path="password" cssClass="text-danger small"></form:errors>
                        </div>
                        <div class="mb-3">
													  <label for="passwordCheck" class="form-label">비밀번호 확인</label>
													  <form:password path="passwordCheck" cssClass="form-control" id="passwordCheck"/>
													  <form:errors path="passwordCheck" cssClass="text-danger small"/>
												</div>

                        <!-- name -->
                        <div class="mb-3">
                            <label for="name" class="form-label">이름</label>
                            <form:input path="name" cssClass="form-control" id="name" />
                            <form:errors path="name" cssClass="text-danger small"></form:errors>
                        </div>

                        <!-- email -->
                        <div class="mb-3">
                            <label for="email" class="form-label">이메일</label>
                            <form:input path="email" cssClass="form-control" id="email" />
                            <form:errors path="email" cssClass="text-danger small"></form:errors>
                        </div>

                        <!-- phone -->
                        <div class="mb-3">
                            <label for="phone" class="form-label">전화번호</label>
                            <form:input path="phone" cssClass="form-control" id="phone" placeholder="010-0000-0000" />
                            <form:errors path="phone" cssClass="text-danger small"></form:errors>
                        </div>

                        <!-- birth -->
                        <div class="mb-3">
                            <label for="birth" class="form-label">생년월일</label>
                            <form:input path="birth" type="date" cssClass="form-control" id="birth" />
                            <form:errors path="birth" cssClass="text-danger small"></form:errors>
                        </div>

                        <!-- file upload -->
                        <div class="mb-3">
                            <label class="form-label">프로필 사진</label>
                            <input type="file" name="profile" class="form-control"/>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            회원가입
                        </button>

                    </form:form>

                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
