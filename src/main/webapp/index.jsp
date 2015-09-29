<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>test</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		
		<link href="css/signin.css" rel="stylesheet">
	</head>

	<body>
		<div class="container">

      <form class="form-signin" action="hello" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userName" class="sr-only">E-mail</label>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="UserName" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div>
	</body>
</html>
