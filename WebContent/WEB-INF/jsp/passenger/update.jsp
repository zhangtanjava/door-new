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
        <h3 style="text-align: center;">修改客户</h3>
        
      </div>
    </div>
    
    <form action="${ctx}/Passenger/update.do?userID=${sessionScope.userPo.id}" method="post" onsubmit="return verify()">
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <input type="hidden" name="id" value="${list.id}" />
		<input type="hidden" name="userID" value="${sessionScope.userPo.id}" >
	    <div class="span12">
	      <div class="row-fluid">
		     <div class="span3">
		        <label>姓名：</label>
		        <input id="nameId" name="name" type="text" value="${list.name}"
		        style="width:97%;height:26px;float:left;"  readonly="readonly"/>
				 <div id="divOne" style="float:right;">
					 <label class="yansered" style="margin-top:7px;">*</label>
				 </div>
		      </div>
		     <div class="span3">
		        <label>性别：</label>
		        <select name="genderID" style="width:100%;height:26px;">
			          <option value="0" <c:if test="${0==list.genderID}">selected="selected"</c:if>>
			            男
			          </option>
						<option value="1" <c:if test="${1==list.genderID}">selected="selected"</c:if>>
							女
						</option>
		          </select>
		     </div>
			  <div class="span3">
				  <label>联系电话：</label>
				  <input id="contactPhoneNumberId" name="contactPhoneNumber" type="text"
						 value="${list.contactPhoneNumber}"
						 style="width:100%;height:27px;"  placeholder="只能为手机号码" onchange="checkTel()">
			  </div>
		  </div>
	    </div>
	    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	     <div class="span12">
	      <div class="row-fluid">
	      	<div class="span3">
				  <label>电话2：</label>
				  <input id="secondPhoneNumber" name="secondPhoneNumber" type="text"
						 value="${list.contactPhoneNumber}"
						 style="width:100%;height:27px;"  placeholder="只能为手机号码" onchange="checkTel()">
			  </div>
		     <div class="span3">
		        <label>单位或住址：</label>
		        <input name="unitsOrAddress" type="text" style="width:100%;height:26px;" value="${list.unitsOrAddress}"> 
		     </div>

			 <div class="span3">
				 <label style="float: left;">备注：</label>
				 <input name="remarks" type="text" style="width:100%;height:26px;" value="${list.remarks}">
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
	    if(document.getElementById("nameId").value==""){
	       alert("姓名  是必填项，不能为空哦！");
	       document.getElementById("nameId").focus();
	       return false;
	    }else if(document.getElementById("nameId").value.length>10){
	     alert("你输入的   姓名  太过长了  请不要超出  10  位长度");
	     document.getElementById("nameId").focus();
	     return false;
        }else if(document.getElementById("unitsOrAddressId").value.length>25){
	     alert("你输入的   单位或住址  太过长了  请不要超出  25  位长度");
	     document.getElementById("unitsOrAddressId").focus();
	     return false;
        }else if(document.getElementById("remarks").value.length>50){
	     alert("你输入的   备注  太过长了  请不要超出  50 位长度");
	     document.getElementById("remarks").focus();
	     return false;
        }else{
	       return true;
	    }
   }
   
    function deletefunction(){
     parent.document.getElementById('Mainid').src='${ctx}/Passenger/tolist.do?userID=${sessionScope.userPo.id}';
   }
   
   function checkTel(){
	     var shouji = /^1\d{10}$/;
	     var zuoji = /^0\d{2,3}-?\d{7,8}$/;
	     //联系电话
	     if(document.getElementById("contactPhoneNumberId").value!=""){
	        	 if(!shouji.test(document.getElementById("contactPhoneNumberId").value) &&
	             		!zuoji.test(document.getElementById("contactPhoneNumberId").value))
		       {
		          document.getElementById("contactPhoneNumberId").focus();
		          document.getElementById("contactPhoneNumberId").value="";
		          alert("你输入的电话号码有误，请重新输入！");
		       }
	     }
	     if(document.getElementById("secondPhoneNumber").value!=""){
	    	 if(!shouji.test(document.getElementById("secondPhoneNumber").value) &&
	          		!zuoji.test(document.getElementById("secondPhoneNumber").value))
	 	       {
	 	          document.getElementById("secondPhoneNumber").focus();
	 	          document.getElementById("secondPhoneNumber").value="";
	 	          alert("你输入的电话号码有误，请重新输入！");
	 	       }
	      }
	   }
 </script>
   
  </body>
</html>
