<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.staffmanage.Filter.LoginFilter" %>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登录页</title>

	<link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="resources/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
	<link href="resources/css/login.css" rel="stylesheet"/>
</head>
<body>

<div id="login-window">
	<form action="${pageContext.request.contextPath }/Login" method="post">
		<div class="input-group m-b-20">
			<span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
			<div class="fg-line">
				<input id="username" type="text" class="form-control" name="username" placeholder="帐号">
			</div>
		</div>
		<div class="input-group m-b-20">
			<span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
			<div class="fg-line">
				<input id="password" type="password" class="form-control" name="password" placeholder="密码">
			</div>
		</div>
		<%if(request.getAttribute("error")!=null){%>
		<p style="margin-left: 10px"><%=request.getAttribute("error")%></p>
		<%}%>
		<div class="checkbox">
			<input id="rememberMe" type="checkbox" class="checkbix" data-text="自动登录" name="rememberMe">
		</div>
		<button type="submit" id="login-bt" class="waves-effect waves-button waves-float">
			<i class="zmdi zmdi-arrow-forward"></i>
		</button>
	</form>
</div>
<script src="resources/plugins/jquery.1.12.4.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="resources/plugins/waves-0.7.5/waves.min.js"></script>
<script src="resources/plugins/checkbix/js/checkbix.min.js"></script>

<script src="resources/js/login.js"></script>
<script type="text/javascript">
	Checkbix.init();
</script>
</body>
</html>