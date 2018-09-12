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
  <script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>

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
    
    <form action="${ctx}/TranStatistics/update.do" method="post" onsubmit="return verify()">
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <input type="hidden" name="id" value="${list.id}" >
		<input type="hidden" name="userID" value="${sessionScope.userPo.id}" >
	    <div class="span12">
			<div class="row-fluid">
				<div class="span3">
					<label>合同编号：</label>
					<input id="agreementID" name="agreementID"  type="text" style="width:97%;height:27px;float:left;"
						    value="${list.agreementID}" readonly="readonly"/>
					<div id="divOne" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
				<div class="span3">
					<label>交款凭证号：</label>
					<input id="paymentID" name="paymentID" type="text" style="width:97%;height:27px;float:left;"  value="${list.paymentID}">
					<div id="divTwo" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
				<div class="span3">
					<label>客户名称：</label>
					<input id="merName" name="merName" type="text" style="width:97%;height:27px;float:left;"  value="${list.merName}">
					<div id="divFive" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>

				<div class="span3">
					<label>价格：</label>
					<input id="price" name="price" type="text" style="width:97%;height:27px;float:left;"   value="${list.price}">
					<div  id="divThree" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span3">
					<label>定金：</label>
					<input id="deposit" name="deposit" type="text" style="width:97%;height:27px;float:left;"   value="${list.deposit}">
					<div  id="divfour" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
				<div class="span3">
					<label>下单日期：</label>
					<input style="width:97%;height:27px;float:left;" type="text" id="playDateStr" name="playDateStr" class="input-text Wdate"
						   onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						   value="<fmt:formatDate value="${list.playDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
				</div>
				<div class="span3">
					<label>交款日期：</label>
					<input style="width:97%;height:27px;float:left;" type="text" id="payDateStr" name="payDateStr" class="input-text Wdate"
						   onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						   value="<fmt:formatDate value="${list.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
				</div>
				<div class="span3">
					<label>智能锁：</label>
					<input id="smartLock" name="smartLock" type="text" style="width:97%;height:27px;float:left;"   value="${list.smartLock}">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span3">
					<label>智能猫眼：</label>
					<input id="smartCatEye" name="smartCatEye" type="text" style="width:97%;height:27px;float:left;"  value="${list.smartCatEye}">
				</div>
				<div class="span3">
					<label>产品型号：</label>
					<input id="model" name="model" type="text" style="width:97%;height:27px;float:left;"  value="${list.model}">
				</div>
				<div class="span3">
					<label>店面备注：</label>
					<input id="remarks" name="remarks" type="text" style="width:97%;height:27px;float:left;"  value="${list.remarks}">
				</div>
				 <div class="span3">
				  <label>日期金额：</label>
				  <input id="dateMoney" name="dateMoney" type="text" style="width:97%;height:27px;float:left;"  value="${list.dateMoney}">
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
			<div class="span4" style="text-align:center;">
				<div class="row-fluid">
					<div class="span4"  style="margin-top: 10px;margin-bottom: 8px;">
						<button class="btn btn-warning" type="button" onclick="deletefunction()">
							<li class="icon-remove icon-white"></li>取消</button>
					</div>
				</div>
			</div>
		</div>
      </form>
    </div>
  </div>
 
 
 
 
 <script type="text/javascript">
     var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
     function verify(){
         if(document.getElementById("agreementID").value==""){
             alert("合同编号  是必填项，不能为空哦！");
             document.getElementById("agreementID").focus();
             return false;
         }else if(document.getElementById("agreementID").valuelength>64){
             alert("合同编号长度不能超过64位！");
             document.getElementById("agreementID").focus();
             return false;
         }if(document.getElementById("paymentID").value==""){
             alert("交款凭证号  是必填项，不能为空哦！");
             document.getElementById("agreementID").focus();
             return false;
         }else if(document.getElementById("paymentID").value.length>64){
             alert("付款凭证号不能超过64位！");
             document.getElementById("paymentID").focus();
             return false;
         }else if(document.getElementById("model").value.length>16){
             alert("型号不能超过16位");
             document.getElementById("model").focus();
             return false;
         }else  if (!reg.test(document.getElementById("price").value)){
             alert("输入的金额格式不对");
             document.getElementById("price").focus();
             return false;
         }else  if (!reg.test(document.getElementById("deposit").value)){
             alert("输入的金额格式不对");
             document.getElementById("deposit").focus();
             return false;
         }else if(document.getElementById("smartLock").value.length>32){
             alert("智能锁长度不能超过32位！");
             document.getElementById("smartLock").focus();
             return false;
         }else if(document.getElementById("smartCatEye").value.length>32){
             alert("智能猫眼长度不能超过32位！");
             document.getElementById("smartCatEye").focus();
             return false;
         }else if(document.getElementById("merName").value.length>10){
             alert("客户名称长度不能超过10位！");
             document.getElementById("merName").focus();
             return false;
         }if(document.getElementById("merName").value==""){
             alert("客户名称  是必填项，不能为空哦！");
             document.getElementById("merName").focus();
             return false;
         }if(document.getElementById("dateMoney").value.length>32){
             alert("日期金额长度不能超过32位！");
             document.getElementById("dateMoney").focus();
             return false;
         }else{
             return true;
         }
   }
   
    function deletefunction(){
     parent.document.getElementById('Mainid').src='${ctx}/TranStatistics/tolist.do?userID=${sessionScope.userPo.id}';
   }
   
 </script>
   
  </body>
</html>
