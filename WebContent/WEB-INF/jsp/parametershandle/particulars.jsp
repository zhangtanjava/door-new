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
  <script type="text/javascript" src="${ctx}/js/common.js"></script>
   
   <style>
   
   .container{
     margin-top: 10px;
   }
   
   .theadone{
     background-color: #CCFF99;
    }
   
   .floatont{
     float:left;
   }
   
   .labelroomnumber{
      position: relative;
      font-size: 17px;
      float: left;
      margin-top:3px;
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
      margin-top: -15px;
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
    
    .table th,.table td{
       text-align: center; 
    }
    .yanseblue{
     color:blue;
    }
    .yansered{
      color:red;
    }
  
  </style>
  
  </head>
  
 
  <body > 
  <div class="container" style="height:630px;overflow-x:auto;">
    <input type="hidden" id="minId" value="${min}"/>
    <input type="hidden" id="maxId" value="${max}"/>
    
    <div class="span11" style=" border: solid; border-color: #DDDDDD;">
    <div class="span9 margin-top-one">
      <div class="row-fluid">
        <h3 style="text-align: center;">交易信息详情</h3>
        
      </div>
    </div>
    
    <div class="span4" >
      <div class="row-fluid" >
		   <div class="span4 pull-right"  style="margin-bottom: 8px;"> 
		   	 <button class="btn btn-warning" type="button" onclick="deletefunction()">
		   	  <li class="icon-remove icon-white"></li>取消</button>
		   </div>
	   </div>
    </div>
    
    <div class="span6">
      <div class="row-fluid">
		   <div class="span4"  style="margin-bottom:8px;"> 
		   	 <button id="btn1" class="btn btn-warning btn-small pull-right" type="button" onclick="hedden()">
		   	  <li class="icon-chevron-down icon-white"></li>显示</button>
		   	  <button id="btn2" class="btn btn-inverse btn-small pull-right" type="button" onclick="hedden2()">
		   	  <li class="icon-chevron-up icon-white"></li>隐藏</button>
		   </div>
	   </div>
    </div>
    
    <form action="${ctx}/StayRegister/add.do" method="post" onsubmit="return verify()">
        <div id="divhidden" hidden>
        <div class="span12">
				<div class="row-fluid">
					<div class="span4">
						<label class="floatont">客户名称：</label>
						<label class="yanseblue">${list.merName}</label>
					</div>
					<div class="span4">
						<label class="floatont">客户性别：</label>
						<label class="yanseblue">${list.genderID}</label>
					</div>
					<div class="span4">
						<label class="floatont">客户住址：</label>
						<label class="yanseblue">${list.unitsOrAddress}</label>
					</div>
				</div>
			</div>
			<div class="span12">
				<div class="row-fluid">
					<div class="span4">
						<label class="floatont">联系电话1：</label>
						<label class="yanseblue">${list.contactPhoneNumber}/></label>
					</div>
				<div class="span4">
						<label class="floatont">联系电话2：</label>
						<label class="yanseblue">${list.secondPhoneNumber}</label>
					</div>
					<div class="span4">
						<label class="floatont">客户信息备注：</label>
						<label class="yanseblue">${list.remarks}</label>
					</div>
				</div>
			</div>
			<div class="span12">
				<div class="row-fluid">
					<div class="span4">
						<label class="floatont">安装图片描述：</label>
						<label class="yanseblue">${list.istallPhotoDes}</label>
					</div>
					<div class="span4">
						<label class="floatont">测量图片描述：</label>
						<label class="yanseblue">${list.surveyorPhotoDes}</label>
					</div>
					<div class="span4">
						<label class="floatont">测量图片描述：</label>
						<label class="yanseblue">${list.agreementPhotoDes}</label>
					</div>
				</div>
			</div>
	    <div class="span12">
	      <div class="row-fluid">
		     <div class="span4">
		        <label class="floatont">合同编号：</label>
		        <label class="yanseblue">${list.agreementID}</label>
		     </div>
		     <div class="span4">
		        <label class="floatont">付款凭证号：</label>
		        <label class="yanseblue">${list.paymentID}</label>
		     </div>
		     <div class="span4">
		        <label class="floatont">订货日期：</label> <!-- 散客 -->
		        <label class="yanseblue"><fmt:formatDate value="${list.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
		     </div>
		  </div>
	    </div>
	    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <div class="span12">
	      <div class="row-fluid">
		     <div class="span4">
		        <label class="floatont">交款日期：</label>
		        <label class="yanseblue"><fmt:formatDate value="${list.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
		     </div>
		     <div class="span4">
		        <label class="floatont">门的型号：</label>
		        <label class="yanseblue">${list.model}</label>
		     </div>
			  <div class="span4">
				  <label class="floatont">价格：</label>
				  <label class="yanseblue">${list.price}</label>
			  </div>
		  </div>
	    </div>
	    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <div class="span12">
	      <div class="row-fluid">
		     <div class="span4">
		        <label class="floatont">定金：</label>
		        <label class="yanseblue">${list.deposit}</label>
		     </div>
			  <div class="span4">
				  <label class="floatont">日期金额：</label>
				  <label class="yanseblue">${list.dateMoney}</label>
			  </div>
			  <div class="span4">
				  <label class="floatont">洞口尺寸：</label>
				  <label class="yanseblue">${list.holeSize}</label>
			  </div>
		  </div>
		</div>
			<div class="span12">
				<div class="row-fluid">
					<div class="span4">
						<label class="floatont">门尺寸：</label>
						<label class="yanseblue">${list.doorSize}</label>
					</div>
					<div class="span4">
						<label class="floatont">木套尺寸：</label>
						<label class="yanseblue">${list.woodcase}"</label>
					</div>
					<div class="span4">
						<label class="floatont">压条尺寸：</label>
						<label class="yanseblue">${list.moundlayer}</label>
					</div>
				</div>
			</div>
			<div class="span12">
				<div class="row-fluid">
					<div class="span4">
						<label class="floatont">开口方向：</label>
						<label class="yanseblue">${list.direction}</label>
					</div>
					<div class="span4">
						<label class="floatont">智能锁：</label>
						<label class="yanseblue">${list.smartLock}</label>
					</div>
					<div class="span4">
						<label class="floatont">智能猫眼：</label>
						<label class="yanseblue">${list.smartCatEye}</label>
					</div>
				</div>
			</div>
			<div class="span12">
				<div class="row-fluid">
					<div class="span4">
						<label class="floatont">室内情况：</label>
						<label class="yanseblue">${list.indoorInfo}</label>
					</div>
					<div class="span4">
						<label class="floatont">割边情况：</label>
						<label class="yanseblue">${list.cutInfo}</label>
					</div>
					<div class="span4">
						<label class="floatont">操作员工：</label>
						<label class="yanseblue">${list.operatorID}</label>
					</div>
				</div>
			</div>
		
		<div class="span12">
			<div class="row-fluid">
				<div class="span4">
						<label class="floatont">安装师：</label>
						<label class="yanseblue">${list.installPerson}</label>
				</div>
				<div class="span4">
					<label class="floatont">安装日期：</label>
					<label class="yanseblue"><fmt:formatDate value="${list.installDate}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
				</div>
				<div class="span4">
					<label class="floatont">安装备注：</label>
					<label class="yanseblue">${list.installPerSmark}</label>
				</div>
			</div>
		</div>
		
	    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
			<div class="span12">
			<div class="row-fluid">
				<div class="span4">
				<label class="floatont">测量师：</label>
				<label class="yanseblue">${list.surveyor}</label>
			</div>
			<div class="span4">
				<label class="floatont">测量日期：</label>
				<label class="yanseblue"><fmt:formatDate value="${list.surveyorDate}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
			</div>
			<div class="span4">
				<label class="floatont">测量备注：</label>
				<label class="yanseblue">${list.surveyorSmark}</label>
			</div>
			</div>
		</div>
			<div class="span12">
				<div class="row-fluid">
				<div class="span4">
					<label class="floatont">维修服务项目：</label>
					<label class="yanseblue">${list.fixObject}</label>
				</div>
				<div class="span4">
					<label class="floatont">维修服务日期：</label>
					<label class="yanseblue"><fmt:formatDate value="${list.fixDate}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
				</div>
				<div class="span4">
						<label class="floatont">维修备注：</label>
						<label class="yanseblue">${list.fixSmarkOne}</label>
					</div>
				</div>
			</div>
			<div class="span12">
				<div class="row-fluid">
				<div class="span4">
						<label class="floatont">维修备注2：</label>
						<label class="yanseblue">${list.fixSmarkTwo}</label>
					</div>
					<div class="span4">
						<label class="floatont">垭口服务日期：</label>
						<label class="yanseblue"><fmt:formatDate value="${list.yaKouInstallDate}" pattern="yyyy-MM-dd HH:mm:ss"/></label>
					</div>
				<div class="span4">
						<label class="floatont">垭口颜色要求：</label>
						<label class="yanseblue">${list.colorRequire}</label>
					</div>
				</div>
			</div>
			<div class="span12">
				<div class="row-fluid">
				<div class="span4">
						<label class="floatont">门底槛情况：</label>
						<label class="yanseblue">${list.doorBottomInfo}</label>
					</div>
					<div class="span4">
						<label class="floatont">垭口备注：</label>
						<label class="yanseblue">${list.yaKouSmark}</label>
					</div>
				</div>
			</div>
			
    </div>
    </form>

	</div>
  </div>

 
 
 
 
 <script type="text/javascript">
 
 document.getElementById("btn2").style.display="none"; //隐藏
 
 
 
 function deletefunction(){
     var datemin=document.getElementById("minId").value;
     var datemax=document.getElementById("maxId").value;
     parent.document.getElementById('Mainid').src='${ctx}/ParametersHandle/tolist.do?datemin='+
     datemin+'&datemax='+datemax+'&userID='+${sessionScope.userPo.id};
 }
 

 
 
   function hedden(){
     document.getElementById("divhidden").style.display="block"; //显示
     document.getElementById("btn2").style.display="block"; //隐藏
     document.getElementById("btn1").style.display="none"; //隐藏
   }
   function hedden2(){
     document.getElementById("divhidden").style.display="none"; //显示
     document.getElementById("btn2").style.display="none"; //隐藏
     document.getElementById("btn1").style.display="block"; //隐藏
   }
 </script>
   
  </body>
</html>
