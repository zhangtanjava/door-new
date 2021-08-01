
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set  value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>欢迎登录防盗门管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.css" type="text/css"></link>
  <link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap-responsive.css"></link>
  <script type="text/javascript" src="${ctx}/bootstrap/js/jquery-1.7.2.js"></script>
  <script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.js"></script>
  </head>
<style>
  .change{
  width:100%; 
  height:100%; 
  FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr=#FFF,endColorStr=#D1BBFF); /*IE*/ 
  background:-moz-linear-gradient(top,#FFF,#D1BBFF);/*火狐*/ 
  background:-webkit-gradient(linear, 0% 39.1%, 0% 100%,from(#FFF), to(#D1BBFF));/*谷歌*/ 
  }
  div p{margin:0 auto;width:200px;}
</style>
  
  <body>
  
  <div class="container change">
      <%--<h2 style="text-align: center;font-size:25px; color:#ff9900">防盗门系统管理平台</h2>--%>
  <div class="modal" id="login">
      <div class="modal-header">
        <h4>用户登录</h4>
      </div>
      <div class="modal-body">
          <form id="form1" class="form-horizontal" action="${ctx}/Login/tomain.do" method="post" onsubmit="return check()">
            <div class="control-group">
              <label class="control-label">用户名</label>
              <div class="controls">
                <input id = "userName" name="userName" type="text">
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">密码</label>
              <div class="controls">
                <input id="password" name="password" type="password">
              </div>
            </div>
          </form>
      </div>
      <div style="color: gray">
        <p>${message}</p>  <%--这里显示上边的controller里边用户或者密码错误的信息--%>
      </div>
      <div class="modal-footer">
      	<button type="button" onclick="$('#form1').submit()" class="btn btn-primary">登录</button>
      </div>
  </div>
  
</div>
  
  </body>
  
  <script type="text/javascript"> 
    function check(){
        var userName = $("#userName").attr("value");    //用户名
        var password = $("#password").attr("value");      //密码

        var datas = new Object();                  //返回来的结果

        if(userName==""){
            alert("用户名  是必填项，不能为空哦！");
            document.getElementById("userName").focus();
            return false;
        }else if(password==""){
            alert("密码  是必填项，不能为空哦！");
            document.getElementById("password").focus();
            return false;
        }
        /* $.ajax({
            cache:false,                                             //是否使用缓存提交 如果为TRUE 会调用浏览器的缓存 而不会提交
            type: "POST",                                           //上面3行都是必须要的
            url: '${ctx}/User/selectLogin.do',       //地址 type 带参数
            data:"userName="+userName+"&password="+password,                         // IDCardValue 自定义的。相当于name把值赋予给 他可以在servlet 获取
            async:false,                                          // 是否 异步 提交
            success: function (result) {                          // 不出现异常 进行立面方
                if(result == null){
                    alert('用户名或者密码错误！');
                    return false;
                }else{
                    return true;
                }
            },
            error: function(data) {  }
        }); */
    }
</script> 
</html>
