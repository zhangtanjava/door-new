<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set  value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	
<!--   <link rel="stylesheet" href="${ctx}/css/roomset/roomset.css" type="text/css"></link> -->
  <link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.css" type="text/css"></link>
  <link href="${ctx}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">  <!-- start 响应式布局要添加的 -->
  <script src="${ctx}/bootstrap/js/jquery-3.1.1.min.js"></script>
  <script src="${ctx}/bootstrap/js/bootstrap.js"></script>
   
   <style>
   
   .container{
     margin-top: 10px;
   }
   
   .theadone{
     background-color: #CCFF99;
    }
   
   
   .labelroomnumber{
      position: relative;
      font-size: 17px;
      float: left;
      margin-top: 15px;
    }
    
    .marginrightone{
      margin-right: 33px;
    }
    
    .marginrighttwo{
      margin-right: 16.5px;
    }
    
    .marginrightthree{
      margin-right: 43px;
    }
    
   .textone{
    margin-top:12px;
    }
    
    .inputone{
    width:54.2%;
    }
    
    .inputtwo{
      width:46.8%;
    }
    
    .inputthree{
      width:46.8%;
    }
    
    .cboone{
      margin-top:10px;
      height: 27px;
    }
    
    .margin-top-one{
      margin-top: -10px;
    }
    
    .margin-top-two{
      margin-top: -20px;
    }
  
    .textwidth{
      width: 138px;
    }
    
    .radiusone{
     margin-left: -4px;
    }
    
     @media(min-width:731px) and (max-width:767px){
      .inputthree{
      width: 50.5%;
    }
    }
    
    @media(min-width:550px) and (max-width:730px){
      .inputtwo{
      width: 46.2%;
    }
        .inputthree{
      width: 49.2%;
    }
    }
    
    
     @media(min-width:431px) and (max-width:550px){
      .inputtwo{
      width: 43.2%;
    }
      .inputthree{
      width: 47.5%;
    }
    }
    
    @media(min-width:366px) and (max-width:430px){
      .inputtwo{
      width: 40.2%;
    }
      .inputthree{
      width: 46%;
    }
    }
    
     @media(min-width:285px) and (max-width:366px){
      .inputtwo{
      width: 37.2%;
    }
      .inputthree{
      width: 44%;
    }
    }
    
     @media(min-width:237px) and (max-width:285px){
      .inputtwo{
      width: 30%;
    }
      .inputthree{
      width: 40%;
    }
    }
    .span12{
      width:95%;
    }
    
    .yansered{
      color:red;
    }
  
  </style>
  
  </head>
  
 
  <body > 
  <div class="container" style="height:630px;overflow-x:auto;">
  
    <div class="span11" style=" border: solid; border-color: #DDDDDD;">
    <div class="span9 margin-top-one">
      <div class="row-fluid">
        <h3 style="text-align: center;">用户修改</h3>
        
      </div>
    </div>
    
    <form action="${ctx}/User/update.do" method="post" onsubmit="return verify()">
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <input type="hidden" name="id" value="${list.id}" />
	    <div class="span12">
	      <div class="row-fluid">
		     <div class="span3">
		        <label>用户名：</label>
		        <input id="userName" name="userName" type="text" value="${list.userName}"
		        style="width:97%;height:26px;float:left;" onchange="onchangeOne()">
				 <div id="divOne" style="float:right;">
					 <label class="yansered" style="margin-top:7px;">*</label>
				 </div>
		      </div>
		       <div class="span3">
		        <label>密码：</label>
		        <input id="password" name="password" type="text" value="${list.password}"
		        style="width:97%;height:26px;float:left;" onchange="onchangeOne()">
				   <div id="divTwo" style="float:right;">
					   <label class="yansered" style="margin-top:7px;">*</label>
				   </div>
		     </div>
		     <div class="span3">
		        <label>角色：</label>
		        <select name="roleID" style="width:100%;height:26px;">
			          <option value="0" <c:if test="${0==list.roleID}">selected="selected"</c:if>>
			            领导
			          </option>
			          <option value="1" <c:if test="${1==list.roleID}">selected="selected"</c:if> >
			            员工
			          </option>
		          </select>
		     </div>
			  <div class="span3">
				  <label>店铺：</label>
				  <select id="storeID" name="storeID" style="width:100%;height:27px;">
					  <option value="1" <c:if test="${1==list.storeID}">selected="selected"</c:if>>
						  1号店
					  </option>
					  <option value="2"<c:if test="${2==list.storeID}">selected="selected"</c:if>>
						  2号店
					  </option>
					  <option value="3"<c:if test="${3==list.storeID}">selected="selected"</c:if>>
						  3号店
					  </option>
					  <option value="4"<c:if test="${4==list.storeID}">selected="selected"</c:if>>
						  4号店
					  </option>
					  <option value="5"<c:if test="${5==list.storeID}">selected="selected"</c:if>>
						  5号店
					  </option>
					  <option value="6"<c:if test="${6==list.storeID}">selected="selected"</c:if>>
						  6号店
					  </option>
					  <option value="7"<c:if test="${7==list.storeID}">selected="selected"</c:if>>
						  7号店
					  </option>
					  <option value="8"<c:if test="${8==list.storeID}">selected="selected"</c:if>>
						  8号店
					  </option>
				  </select>
			  </div>
	  		</div>
		</div>

		<div class="span6" style="text-align:center;">
			<div class="row-fluid">
				<div class="span12" style="margin-top: 10px;margin-bottom: 8px;">
					<button class="btn btn-primary" type="submit">
						<li class="icon-check icon-white"></li>修改</button>
				</div>

			</div>
		</div>
	</form>

      
      <div class="span4" style="text-align:center;">
      <div class="row-fluid">
		   <div class="span4"  style="margin-top: 10px;margin-bottom: 8px;"> 
		   	 <button class="btn btn-warning" type="button" onclick="deletefunction()">
		   	  <li class="icon-remove icon-white"></li>取消</button>
		   </div>
	     </div>
      </div>
       
    </div>
  </div>

 
 
 
 <script type="text/javascript">
 var Name=document.getElementById("papersNumberId").value;
 
    function verify(){
    	if(document.getElementById("userName").value==""){
 	       alert("用户名  是必填项，不能为空哦！");
 	       document.getElementById("userName").focus();
 	       return false;
 	    }else if(document.getElementById("password").value==""){
 	       alert("密码  是必填项，不能为空哦！");
 	       document.getElementById("password").focus();
 	       return false;
 	    }else if(document.getElementById("userName").value.length>10){
 	     alert("你输入的   用户名  太过长了  请不要超出  10  位长度");
 	     document.getElementById("userName").focus();
 	     return false;
         }else if(document.getElementById("password").value.length>10){
 	     alert("你输入的   密码  太过长了  请不要超出  10  位长度");
 	     document.getElementById("password").focus();
 	     return false;
         }else if(document.getElementById("roleID").value==""){
 	       alert("角色  是必填项，不能为空哦！");
 	       document.getElementById("roleID").focus();
 	       return false;
 	    }else if(document.getElementById("storeID").value==""){
            alert("店铺  是必填项，不能为空哦！");
            document.getElementById("roleID").focus();
            return false;
        }else{
 	       return true;
 	    }
   }
   
    function deletefunction(){
     parent.document.getElementById('Mainid').src='${ctx}/User/tolist.do';
   }
   
   function onchangeOne(){
     //姓名
     if(document.getElementById("nameId").value!=""){
       document.getElementById("divOne").style.display="none";
     }else{
       document.getElementById("divOne").style.display="block"; //显示
     }
 	//密码
     if(document.getElementById("password").value!=""){
         document.getElementById("divTwo").style.display="none";
       }else{
         document.getElementById("divTwo").style.display="block"; //显示
       }
   }
   
 </script>
   
  </body>
</html>
