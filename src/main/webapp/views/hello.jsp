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
      <form class="form-signin" action="chatroom" method="post">
		<h2 class="form-signin-heading">Hello,${userName }</h2>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Chat Room</button>
      </form>

    </div>
	</body>
</html>
