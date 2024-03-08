<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン画面</title>
<%@include file="layouts/css.jsp"%>
</head>
<body>
    <%@include file="layouts/js.jsp"%>
    <%@include file="layouts/logout-header-navi.jsp"%>

    <h2>ログイン画面</h2>
    <div class="progress mb-4">
        <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
    </div>


    <div class="card bg-light mb-3" style="max-width: 20rem;">
        <div class="card-header">テスト用アカウント</div>
        <div class="card-body">
            <p class="card-text">メールアドレス: test@example.com</p>
            <p class="card-text">パスワード : test</p>
        </div>
    </div>

    <!-- エラーメッセージ -->
    <%@include file="layouts/error-message.jsp"%>

    <form action="login-servlet" method="post" class="text-center">
        <h1>
            <i class="fas fa-user-circle fa-2x"></i>
        </h1>
        <p>
            <input type="email" name="userId" placeholder="メールアドレス" value="test@example.com" required autofocus>
        </p>
        <p>
            <input type="password" name="password" placeholder="パスワード" value="test" required>
        </p>
        <p>
            <button class="btn btn-primary" type="submit">ログイン</button>
        </p>
    </form>
</body>
</html>
