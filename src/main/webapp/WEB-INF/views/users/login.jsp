<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">

        <div class="col-md-5">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">로그인</h4>
                </div>

                <div class="card-body">

                    <!-- 로그인 실패 메시지 -->
                    <c:if test="${param.error == 'true'}">
                        <div class="alert alert-danger">
                            아이디 또는 비밀번호가 올바르지 않습니다.
                        </div>
                    </c:if>

                    <form action="/users/login" method="post">

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

                        <button type="submit" class="btn btn-primary w-100">
                            로그인
                        </button>

                    </form>

                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
