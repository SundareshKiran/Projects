<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="style.css">

<style type="text/css">
body
{
    background: #000 !important;
}


.icon
{
    color: #ffffffc4;
}
.input-holder
{
    padding-top: 30px;
}
.input
{
    caret-color: #fffffff0;
    color: #fffffff0;
    border: none;
    background: transparent;
    outline: none;
    border-bottom: 0.5px solid #fffffff0;
    margin-left: 12px;
    width: 90%;
    padding-bottom: 8px;
}
.input:focus
{
    border-bottom: 0.5px solid #fff;
}
.login-form
{
    margin-top: 20%;
}
.button
{
    float: right;
    margin-right: 10px;
    padding: 8px 30px;
    background: #3d59fe;
    outline: none;
    border: none;
    border-radius: 5px;
    color: #fff;
    cursor: pointer;
}
.button:hover
{
    background: #2c49ee;
}
.link
{
    color: #ffffffb2;
}
.link:hover
{
    color: #fff;
    text-decoration: none;
}

</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<div class="login-form">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<form action="login" method="post">
						<div class="input-holder">
							<i class="icon far fa-user"></i><input class="input" type="text"
								placeholder="Email" name="email">
						</div>
						<div class="input-holder">
							<i class="icon fas fa-lock"></i><input class="input"
								type="password" placeholder="Password" name="password">
						</div>
						<div><br/>
						<input class="button" type="submit" value="Log In">
						</div>
						</form>
				</div>
				
			</div>
		</div>
	</div>
	${msg}
</body>
</html>