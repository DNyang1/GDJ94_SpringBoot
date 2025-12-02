<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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

                    <form action="/users/register" method="post" enctype="multipart/form-data">

                        <!-- username -->
                        <div class="mb-3">
                            <label for="username" class="form-label">아이디</label>
                            <input type="text" class="form-control" id="username"
                                   name="username" required>
                        </div>

                        <!-- password -->
                        <div class="mb-3">
                            <label for="password" class="form-label">비밀번호</label>
                            <input type="password" class="form-control" id="password"
                                   name="password" required>
                        </div>

                        <!-- name -->
                        <div class="mb-3">
                            <label for="name" class="form-label">이름</label>
                            <input type="text" class="form-control" id="name"
                                   name="name" required>
                        </div>
                        
                        <div class="mb-3">
                            <label for="email" class="form-label">이메일</label>
                            <input type="text" class="form-control" id="email"
                                   name="email" required>
                        </div>

                        <!-- phone -->
                        <div class="mb-3">
                            <label for="phone" class="form-label">전화번호</label>
                            <input type="text" class="form-control" id="phone"
                                   name="phone" placeholder="010-0000-0000" required>
                        </div>

                        <!-- birth -->
                        <div class="mb-3">
                            <label for="birth" class="form-label">생년월일</label>
                            <input type="date" class="form-control" id="birth"
                                   name="birth" required>
                        </div>
												<div>
													<input type="file" name="profile"><br>
												</div>
                        <button type="submit" class="btn btn-primary w-100">
                            회원가입
                        </button>

                    </form>

                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
