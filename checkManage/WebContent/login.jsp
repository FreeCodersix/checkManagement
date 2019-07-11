<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.lero.model.Admin" %>
<%@ page import="com.lero.model.DormManager"%>
<%@ page import="com.lero.model.Student" %>
<%
	if(request.getAttribute("user")==null){
		String userName=null;
		String password=null;
		String userType=null;
		String remember=null;
		
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("dormuser")){
				userName=cookies[i].getValue().split("-")[0];
				password=cookies[i].getValue().split("-")[1];
				userType=cookies[i].getValue().split("-")[2];
				remember=cookies[i].getValue().split("-")[3];
			}
		}
		
		if(userName==null){
			userName="";
		}
		
		if(password==null){
			password="";
		}
		
		if(userType==null){
			userType="";
		} else if("admin".equals(userType)){
			pageContext.setAttribute("user", new Admin(userName,password));
			pageContext.setAttribute("userType", 1);
		} else if("dormManager".equals(userType)) {
			pageContext.setAttribute("user", new DormManager(userName,password));
			pageContext.setAttribute("userType", 2);
		} else if("student".equals(userType)) {
			pageContext.setAttribute("user", new Student(userName,password));
			pageContext.setAttribute("userType", 3);
		}
		
		if("yes".equals(remember)) {
			pageContext.setAttribute("remember", 1);
		}
		
	}
%>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>考勤管理系统登录</title>
<script src="WebContent/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/fonts/glyphicons-halflings-regular.woff" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/fonts/glyphicons-halflings-regular.woff2" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		var userTypes = document.getElementsByName("userType");
		var userType = null;
		for(var i=0;i<userTypes.length;i++) {
			if(userTypes[i].checked) {
				userType=userTypes[i].value;
				break;
			}
		}
		if (userName == null || userName == "") {
			document.getElementById("error").innerHTML = "用户名不能为空";
			return false;
		}
		if (password == null || password == "") {
			document.getElementById("error").innerHTML = "密码不能为空";
			return false;
		}
		if (userType == null || userType == "") {
			document.getElementById("error").innerHTML = "请选择用户类型";
			return false;
		}
		return true;
	}
</script>

<style type="text/css">
	  body {
        padding-top: 200px;
        padding-bottom: 40px;
        background-image: url('images/background1.jpg');
        background-position: center;
		background-repeat: no-repeat;
		background-attachment: fixed;
      }
      
      .radio {
      	padding-top: 10px;
       	padding-bottom:10px;
       	font-size:17px;
       	font-weight:700px;
      }
      
      .form-signin-heading{
      	text-align: center;
      	font-size:36px;
      	font-family:"微软雅黑";
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 80px auto 20px;
        background-color: #bddbcfa1;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
</style>

</head>
<body>
<div class="container">
      <form name="myForm" class="form-signin" action="login" method="post" onsubmit="return checkForm()">
      
        <h2 class="form-signin-heading"><font color="">考勤管理系统</font></h2>
         <label class="radio inline" style="margin-left:5px">
      	  	<input id="admin" type="radio" name="userType" value="admin"  checked/> 超级管理员
		</label>
		<label class="radio inline">
			<input id="dormManager" type="radio" name="userType" value="dormManager" ${userType==2?'checked':''} /> 管理员老师
		</label>
		<label class="radio inline" style="float:right;">
			<input id="student" type="radio" name="userType" value="student"  ${userType==3?'checked':''}/> 学生
		</label>
        <span class="glyphicon glyphicon-user" aria-hidden="true"></span><input id="userName" name="userName" value="${user.userName }" type="text" class="input-block-level" placeholder="用户名">
        <span class="glyphicon glyphicon-search" aria-hidden="true"></span><input id="password" name="password" value="${user.password }" type="password" class="input-block-level" placeholder="密码" >
        
        
        
        
       <div id="kaptcha" style="width: 300;height: 50;line-height: 50px;">
                <input type="text" name="code" id="kaptcha_input" placeholder="请输入验证码" class="layui-input" style="width: 190;height: 100%"><img title="点击更换" src="Kaptcha.jpg" name="kaptcha" id="kaptcha_img" style="width: 100;height: 100%;display: inline-block;margin-bottom:15;margin-left: 10">
       </div>
            
            
            
            
        <label class="checkbox">
          <input id="remember" name="remember" type="checkbox" value="remember-me" ${remember==1?'checked':''}>记住密码 &nbsp;&nbsp;&nbsp;&nbsp; <font id="error" color="red"></font>  
        </label>
         &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-large btn-success" type="submit">登录</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-large btn-info" type="button" >重置</button>
        <br>
        <br>

  </form> 
</div>
<script type="text/javascript">
$(function () {
    $("#kaptcha_img").click(function () {
        $(this).hide().attr('src', this.src + '?' + new Date().getTime()).fadeIn();
    });
    var kaptcha_input = document.getElementById("kaptcha_input");
    kaptcha_input.value = "";
});

$("#kaptcha_input").blur(function () {
    kaptch_check();
});

function kaptch_check() {
    var $code = $("#kaptcha_input").val();
    $.getJSON(
        "Servlet",
        {"code": $code},
        function (result) {

            if (result.msg === "true") {
                login();
            } else {
                alert("验证码错误!");
                var kaptcha_input = document.getElementById("kaptcha_input");
                kaptcha_input.value = "";

            }
        }
    )
}

//-->
</script>
</body>
</html>