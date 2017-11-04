<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>涉烟案件管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>涉烟案件管理系统</h1>
            <h2><font size="5" color="red">${sessionScope.err}</font></h2>
            <form id="form_login"  action="login" onsubmit="return toLogin()" method="POST">
                <input type="text" name="staff_id" class="username" id="staffId" placeholder="用户名">
                <input type="password" name="password" class="password" id="password" placeholder="密码">
                <button type="submit" value="登录" />
                <div class="error"><span></span></div>
            </form>
        </div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

  <script>
	     //登录按钮
	     function toLogin(){
	    	 if(validateNameAndPasswd()){
	    		 var isCommitted = false;
	    		 function dosubmit(){
	    		 if(isCommitted == false){
	    			 isCommitted = true;
	    			 return true;
	    		    }else{
	    		    	return false;
	    		    }
	    		 }
	    	 }
	     }
  function validateNameAndPasswd(){
	  var $staffId = $("input[name='staff_id']");
	  var $password = $("input[name='password']");
	  if($staffId.val() == ""){
  	   		$staffId.attr('placeholder','请输入用户名');
  	   		return false ;
  	   };
	  if($password.val() == ""){
  	   		$password.attr('placeholder','请输入密码');
  	   		return false;
  	   };	  	   
  	   return true;
	  
  }
      </script>
    </body>

</html>
