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
   	.label{
            position: relative;
        }
        #frontMoneyFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #agreementFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #seAgreementFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #surveyorFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #istallFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #smartLockFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        [name=fileButton]{
            margin-right: 5px;
        }
        
        
		
		
		
		
		
        /* [name=fileText]{
            color: red;
  		}  */
        /* #frontMoneyFile{
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
        #frontMoneyFileBtn{
            margin-right: 5px;
        }
        #frontMoneyFileText{
            color: red;
  		} */
        
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
        <h3 style="text-align: center;">修改信息</h3>
        
      </div>
    </div>
    
    <form action="${ctx}/ParametersHandle/update.do" method="post" onsubmit="return verify()" enctype="multipart/form-data">
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <input type="hidden" name="id" value="${list.id}" >
		<input type="hidden" name="userID" value="${sessionScope.user.id}" >
		<input type="hidden" id ="selectedStoreId" value="${list.storeID}" >
		<div class="span12">
	    <div class="row-fluid">
	   			 <div class="span3">
				  <label>店面：</label>
				  <select id="storeId" name="storeId">
				  		<option value="0">请选择</option>
					</select>
			  	</div>
			  	<div class="span3">
				  <label>销售员：</label>
				  <input value="${list.saler}" id="saler" name="saler" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
	    		<div class="span3">
				  <label>订货日期：</label>
				  <input value="<fmt:formatDate value="${list.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				  style="width:97%;height:27px;float:left;" type="text" id="createDateStr" name="createDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  	</div>
			  	<div class="span3">
			  		<label>定金图片：</label>
					<label for="frontMoneyFile">
						<input type="hidden" id="frontMoneyFileHide" value="${list.frontMoneyFileName}">
						<input type="file" id="frontMoneyFile" name="frontMoneyFile">
			        	<input type="button" id="frontMoneyFileBtn" name="fileButton" value="图片上传"><span id="frontMoneyFileText" name="fileText">${list.frontMoneyFileName}</span>
			        </label>
					<%-- <label>定金图片：</label>
					<input value="${list.frontMoneyFilePath}" type="file" id="frontMoneyFile" name="frontMoneyFile" style="width:97%;height:27px;float:left;"> --%>
				</div>
		  </div>
		  <div class="row-fluid">
	    		<div class="span3">
				  <label>地址：</label>
				  <input value="${list.unitsOrAddress}" id="unitsOrAddress" name="unitsOrAddress" type="text" style="width:97%;height:27px;float:left;" 
				  <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
			  	</div>
			  	<div class="span3">
				  <label>电话1：</label>
				  <input value="${list.contactPhoneNumber}"  id="contactPhoneNumber" name="contactPhoneNumber" type="text" style="width:97%;height:27px;float:left;" 
				  <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
			  	</div>
			  	<div class="span3">
				  <label>电话2：</label>
				  <input value="${list.secondPhoneNumber}"  id="secondPhoneNumber" name="secondPhoneNumber" type="text" style="width:97%;height:27px;float:left;" 
				  <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
			  	</div>
			  	<div class="span3">
					<label>合同图片1：</label>
					<label for="agreementFile">
						<input type="hidden" id="agreementPhotoHide" value="${list.agreementPhotoName}">
						<input type="file" id="agreementFile" name="agreementFile">
			        	<input type="button" id="agreementPhotoBtn" name="fileButton" value="图片上传"><span id="agreementPhotoNameText" name="fileText" >${list.agreementPhotoName}</span>
			        </label>
					<!-- <input type="file" id="agreementPhoto" name="agreementPhoto" style="width:97%;height:27px;float:left;"> -->
				</div>
		  </div>
	    <div class="row-fluid">
			  	<div class="span3">
				  <label>型号：</label>
				  <input value="${list.model}" id="model" name="model" type="text" style="width:97%;height:27px;float:left;" 
				  <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
			  	</div>
			  	<div class="span3">
				  <label>价格：</label>
				  <input value="${list.price}"  id="price" name="price" type="text" style="width:97%;height:27px;float:left;" 
				  <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
			  	</div>
			  	<div class="span3">
				  <label>定金：</label>
				  <input value="${list.deposit}" id="deposit" name="deposit" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
					<label>合同图片2：</label>
					<label for="seAgreementFile">
						<input type="hidden" id="seAgreementPhotoHide" value="${list.seAgreementPhotoName}">
						<input type="file" id="seAgreementFile" name="seAgreementFile">
			        	<input type="button" id="seAgreementPhotoBtn" name="fileButton" value="图片上传"><span id="seAgreementPhotoNameText" name="fileText" >${list.seAgreementPhotoName}</span>
			        </label>
					<!-- <input type="file" id="seAgreementPhoto" name="seAgreementPhoto" style="width:97%;height:27px;float:left;"> -->
		  		</div>
		  </div>
		  <div class="row-fluid">
			  	<div class="span3">
				  <label>智能锁：</label>
				  <input value="${list.smartLock}" id="smartLock" name="smartLock" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>销售备注：</label>
				  <input value="${list.saleRemarks}" id="saleRemarks" name="saleRemarks" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>交居然日期：</label>
				  <input value="<fmt:formatDate value="${list.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				  style="width:97%;height:27px;float:left;" type="text" id="payDateStr" name="payDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  	</div>
			  	<div class="span3">
				  <label>交居然金额：</label>
				  <input value="${list.jjrAmt}" id="jjrAmt" name="jjrAmt" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
		  </div>
		  <div class="row-fluid">
			  <div class="span3">
					<label>—————————————————————————————————————————————————————————————————————————</label>
				</div>
			</div>
		  <div class="row-fluid">
		 		 <div class="span3">
					  <label>洞口尺寸：</label>
					  <input value="${list.holeSize}" id="holeSize" name="holeSize" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
				  <div class="span3">
					  <label>门的尺寸：</label>
					  <input value="${list.doorSize}" id="doorSize" name="doorSize" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
				  <div class="span3">
					  <label>门的方向：</label>
					  <input value="${list.direction}"  id="direction" name="direction" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
			  		<div class="span3">
						<label>测量图片：</label>
						<label for="surveyorFile">
						<input type="hidden" id="surveyorPhotoHide" value="${list.surveyorPhotoName}">
						<input type="file" id="surveyorFile" name="surveyorFile">
			        	<input type="button" id="surveyorPhotoBtn" name="fileButton" value="图片上传"><span id="surveyorPhotoNameText" name="fileText" >${list.surveyorPhotoName}</span>
			        </label>
						<!-- <input type="file" id= "surveyorFile" name="surveyorFile" style="width:97%;height:27px;float:left;"> -->
					</div>
			</div>	
			<div class="row-fluid">
				  <div class="span3">
					  <label>测量日期：</label>
					  <input value="<fmt:formatDate value="${list.surveyorDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					  style="width:97%;height:27px;float:left;" type="text" id="surveyorDateStr" name="surveyorDateStr" class="input-text Wdate"
							 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
				  </div>
				  <div class="span3">
			        <label>测量师傅：</label>
			        <input value="${list.surveyor}" id="surveyor" name="surveyor" type="text" style="width:97%;height:27px;float:left;" >
			      </div>
				  <div class="span3">
					  <label>测量备注：</label>
					  <input value="${list.surveyorSmark}" id="surveyorSmark" name="surveyorSmark" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
			</div>	 
			<div class="row-fluid">
			  <div class="span3">
					<label>—————————————————————————————————————————————————————————————————————————</label>
				</div>
			</div> 
			<div class="row-fluid">
			  <div class="span3">
				  <label>安装日期：</label>
				  <input value="<fmt:formatDate value="${list.installDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				  style="width:97%;height:27px;float:left;" type="text" id="installDateStr" name="installDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  </div>
			  <div class="span3">
				  <label>安装师傅：</label>
				  <input value="${list.installPerson}" id="installPerson" name="installPerson" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>安装备注：</label>
				  <input value="${list.installPerSmark}" id="installPerSmark" name="installPerSmark" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
					<div class="span3">
						<label>门安装图片：</label>
						<label for="istallFile">
							<input type="hidden" id="istallPhotoHide" value="${list.istallPhotoName}">
							<input type="file" id="istallFile" name="istallFile">
				        	<input type="button" id="istallPhotoBtn" name="fileButton" value="图片上传"><span id="istallPhotoNameText" name="fileText" >${list.istallPhotoName}</span>
			        	</label>
					<!-- <input type="file" id="istallFile" name="istallFile" style="width:97%;height:27px;float:left;"> -->
			  </div>
		  </div>
		  <div class="row-fluid">
			  <div class="span3">
					<label>—————————————————————————————————————————————————————————————————————————</label>
				</div>
		  </div> 
		  <div class="row-fluid">
			  <div class="span3">
				  <label>垭口安装：</label>
				  <input value="${list.yaKouSmark}" id="yaKouSmark" name="yaKouSmark" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>智能猫眼：</label>
				  <input value="${list.smartCatEye}"  id="smartCatEye" name="smartCatEye" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  <div class="span3">
					  <label>智能锁安装时间：</label>
					  <input value="<fmt:formatDate value="${list.smartLockDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					  style="width:97%;height:27px;float:left;" type="text" id="smartLockDateStr" name="smartLockDateStr" class="input-text Wdate"
							 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  </div>
				<div class="span3">
					<label>锁安装图片：</label>
					<label for="smartLockFile">
					<input type="hidden" id="smartLockFileHide" value="${list.smartLockFileName}">
					<input type="file" id="smartLockFile" name="smartLockFile">
		        	<input type="button" id="smartLockFileBtn" name="fileButton" value="图片上传"><span id="smartLockFileNameText" name="fileText" >${list.smartLockFileName}</span>
		        </label>
				<!-- <input type="file" id="smartLockFile" name="smartLockFile" style="width:97%;height:27px;float:left;"> -->
			</div>
		  </div>
		  <div class="row-fluid">
			  <div class="span3">
					<label>—————————————————————————————————————————————————————————————————————————</label>
				</div>
		  </div> 
		  <div class="row-fluid">
			  	<div class="span3">
				  <label>售后服务1：</label>
				  <input value="${list.fixSmarkOne}"  id="fixSmarkOne" name="fixSmarkOne" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务2：</label>
				  <input value="${list.fixSmarkTwo}"  id="fixSmarkTwo" name="fixSmarkTwo" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务3：</label>
				  <input value="${list.fixSmarkSan}"  id="fixSmarkSan" name="fixSmarkSan" type="text" style="width:97%;height:27px;float:left;" >
				  <div id="divTwo" style="float:right;">
				  </div>
			  	</div>
			  	<div class="span3">
				  <label>售后服务4：</label>
				  <input value="${list.fixSmarkSi}"  id="fixSmarkSi" name="fixSmarkSi" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			</div>
		  <div class="row-fluid">
			  	<div class="span3">
				  <label>售后服务5：</label>
				  <input value="${list.fixSmarkWu}"  id="fixSmarkWu" name="fixSmarkWu" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务6：</label>
				  <input value="${list.fixSmarkLiu}"  id="fixSmarkLiu" name="fixSmarkLiu" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务7：</label>
				  <input value="${list.fixSmarkQi}"  id="fixSmarkQi" name="fixSmarkQi" type="text" style="width:97%;height:27px;float:left;" >
				  <div id="divTwo" style="float:right;">
				  </div>
			  	</div>
			  	<div class="span3">
				  <label>售后服务8：</label>
				  <input value="${list.fixSmarkBa}"  id="fixSmarkBa" name="fixSmarkBa" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			</div>
		  <div class="row-fluid">
			  <div class="span3">
				  <label>售后服务9：</label>
				  <input value="${list.fixSmarkJiu}"  id="fixSmarkJiu" name="fixSmarkJiu" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务10：</label>
				  <input value="${list.fixSmarkShi}"  id="fixSmarkShi" name="fixSmarkShi" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
		</div>
		<div style="display: none;">
			  <div class="row-fluid">
				  <div class="span3">
					  <label>操作员工：</label>
					  <input id="operatorID" name="operatorID" type="text" style="width:97%;height:27px;float:left;" 
					  value="${sessionScope.user.userName}" readonly="readonly">
				  </div>
			  </div>
		  </div>
			<div class="span6" style="text-align:center;">
				<div class="row-fluid">
					<div class="span12" style="margin-top: 10px;margin-bottom: 8px;">
						<button class="btn btn-primary" type="submit">
							<li class="icon-check icon-white"></li>保存</button>
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
//定金图片
$("#frontMoneyFile").change(function () {
	var fileName = $("#frontMoneyFileHide").val();
	var	fileVal = $("#frontMoneyFile").val();
	
	if(fileVal!=null && fileVal!=''){
		$("#frontMoneyFileText").html(fileVal);
		return;
	}else if(fileName!=null && fileName!=''){
		$("#frontMoneyFileText").html(fileName);
		return;
	} else{
		$("#frontMoneyFileText").html("请上传图片");
	}
 })
 
 //合同图片
$("#agreementFile").change(function () {
	var fileName = $("#agreementPhotoHide").val();
	var fileVal = $("#agreementFile").val();
	
	if(fileVal!=null && fileVal!=''){
		$("#agreementPhotoNameText").html(fileVal);
		return;
	}else if(fileName!=null && fileName!=''){
		$("#agreementPhotoNameText").html(fileName);
		return;
	} else{
		$("#agreementPhotoNameText").html("请上传图片");
	}
 })
 //合同图片2
$("#seAgreementFile").change(function () {
	var fileName = $("#seAgreementPhotoHide").val();
	var fileVal = $("#seAgreementFile").val();
	
	if(fileVal!=null && fileVal!=''){
		$("#seAgreementPhotoNameText").html(fileVal);
		return;
	}else if(fileName!=null && fileName!=''){
		$("#seAgreementPhotoNameText").html(fileName);
		return;
	} else{
		$("#seAgreementPhotoNameText").html("请上传图片");
	}
 })
 
 //测量图片
$("#surveyorFile").change(function () {
	var fileName = $("#surveyorPhotoHide").val();
	var fileVal = $("#surveyorFile").val();
	
	if(fileVal!=null && fileVal!=''){
		$("#surveyorPhotoNameText").html(fileVal);
		return;
	}else if(fileName!=null && fileName!=''){
		$("#surveyorPhotoNameText").html(fileName);
		return;
	} else{
		$("#surveyorPhotoNameText").html("请上传图片");
	}
 })
 //安装图片
$("#istallFile").change(function () {
	var fileName = $("#istallPhotoHide").val();
	var fileVal = $("#istallFile").val();
	
	if(fileVal!=null && fileVal!=''){
		$("#istallPhotoNameText").html(fileVal);
		return;
	}else if(fileName!=null && fileName!=''){
		$("#istallPhotoNameText").html(fileName);
		return;
	} else{
		$("#istallPhotoNameText").html("请上传图片");
	}
 })
 
 //智能锁图片
$("#smartLockFile").change(function () {
	var fileName = $("#smartLockFileHide").val();
	var fileVal = $("#smartLockFile").val();
	
	if(fileVal!=null && fileVal!=''){
		$("#smartLockFileNameText").html(fileVal);
		return;
	}else if(fileName!=null && fileName!=''){
		$("#smartLockFileNameText").html(fileName);
		return;
	} else{
		$("#smartLockFileNameText").html("请上传图片");
	}
 })
 $(function(){  
     getStoreId();  
     initFileText();
 });  
	function getStoreId(){   
			var key=$("#selectedStoreId").val();
	 		$.ajax({   
		      type:"POST",   
		      dataType: "json",   
		      url:"${ctx}/User/selectStoreId.do",   
		      data:"",   
		      success:function(result){   
		            var len=result.length;   
		            $('#storeId').attr("length",'0');   
			      for(i=0;i<len;i++){   
			    	  if(result[i].storeID == key){
			    		  $("#storeId").append($('<option value='+result[i].storeID+' selected="selected" >'+result[i].storeID+'</option>'));
			    	  }else{
			    		  $("#storeId").append($('<option value='+result[i].storeID+'>'+result[i].storeID+'</option>'));
			    	  }
			            
					}   
				}   
			});  
	 		
	 }   
	function initFileText(){
		if($("#frontMoneyFileHide").val() =="" || $("#frontMoneyFileHide").val() ==null){
			$("#frontMoneyFileText").html("请上传图片");
		}
		if($("#agreementPhotoHide").val() =="" || $("#agreementPhotoHide").val() ==null){
			$("#agreementPhotoNameText").html("请上传图片");
		}
		if($("#seAgreementPhotoHide").val() =="" || $("#seAgreementPhotoHide").val() ==null){
			$("#seAgreementPhotoNameText").html("请上传图片");
		}
		if($("#surveyorPhotoHide").val() =="" || $("#surveyorPhotoHide").val() ==null){
			$("#surveyorPhotoNameText").html("请上传图片");
		}
		if($("#istallPhotoHide").val() =="" || $("#istallPhotoHide").val() ==null){
			$("#istallPhotoNameText").html("请上传图片");
		}
		if($("#smartLockFileHide").val() =="" || $("#smartLockFileHide").val() ==null){
			$("#smartLockFileNameText").html("请上传图片");
		}
	} 
	
 	var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
 	function deletefunction(){
	    parent.document.getElementById('Mainid').src='${ctx}/ParametersHandle/tolist.do?userID=${sessionScope.user.id}';
	} 
	 
    function verify(){
    	if($("#storeId").val() != 0){
    		if($("#saler").val() == null || $("#saler").val()==""){
    			alert("销售员不能为空！");
    			return false;
    		}
    		if($("#createDateStr").val() == null || $("#createDateStr").val()==""){
    			alert("订货日期不能为空！");
    			return false;
    		}
    		if($("#frontMoneyFileText").innerHTML =="请上传图片"){
    			alert("定金图片不能为空！");
    			return false;
    		}
    		/* if($("#frontMoneyFile").val() == null || $("#frontMoneyFile").val()==""){
    			alert("定金图片不能为空！");
    			return false;
    		} */
    		if($("#unitsOrAddress").val() == null || $("#unitsOrAddress").val()==""){
    			alert("地址不能为空！");
    			return false;
    		}
    		if($("#contactPhoneNumber").val() == null || $("#contactPhoneNumber").val()==""){
    			alert("电话1不能为空！");
    			return false;
    		}
    		if($("#model").val() == null || $("#model").val()==""){
    			alert("型号不能为空！");
    			return false;
    		}
    		if($("#price").val() == null || $("#price").val()==""){
    			alert("价格不能为空！");
    			return false;
    		}
    		if($("#deposit").val() == null || $("#deposit").val()==""){
    			alert("定金不能为空！");
    			return false;
    		}
        }
    	if($("#agreementPhoto").val() != null && $("#agreementPhoto").val()!=""){
    		if($("#payDateStr").val() == null || $("#payDateStr").val()==""){
    			alert("交居然日期不能为空！");
    			return false;
    		}
    		if($("#jjrAmt").val() == null || $("#jjrAmt").val()==""){
    			alert("交居然金额不能为空！");
    			return false;
    		}
    	}
    	if($("#holeSize").val() != null && $("#holeSize").val()!=""){
    		if($("#doorSize").val() == null || $("#doorSize").val()==""){
    			alert("门的尺寸不能为空！");
    			return false;
    		}
    		if($("#direction").val() == null || $("#direction").val()==""){
    			alert("门的方向不能为空！");
    			return false;
    		}
    		
    		if($("#surveyorPhotoNameText").innerHTML =="请上传图片"){
    			alert("测量图片不能为空！");
    			return false;
    		}
    		/* if($("#surveyorFile").val() == null || $("#surveyorFile").val()==""){
    			alert("测量图片不能为空！");
    			return false;
    		} */
    		if($("#surveyorDateStr").val() == null || $("#surveyorDateStr").val()==""){
    			alert("测量日期不能为空！");
    			return false;
    		}
    		if($("#surveyor").val() == null || $("#surveyor").val()==""){
    			alert("测量师傅不能为空！");
    			return false;
    		}
    		if($("#surveyorSmark").val() == null || $("#surveyorSmark").val()==""){
    			alert("测量备注不能为空！");
    			return false;
    		}
    	}
    	if($("#installDateStr").val() != null && $("#installDateStr").val()!=""){
    		if($("#installPerson").val() == null || $("#installPerson").val()==""){
    			alert("安装师傅不能为空！");
    			return false;
    		}
    		if($("#installPerSmark").val() == null || $("#installPerSmark").val()==""){
    			alert("安装备注不能为空！");
    			return false;
    		}
    		if($("#istallPhotoNameText").innerHTML =="请上传图片"){
    			alert("门安装图片不能为空！");
    			return false;
    		}
    		/* if($("#istallFile").val() == null || $("#istallFile").val()==""){
    			alert("门安装图片不能为空！");
    			return false;
    		} */
    	}
    	
    	if(document.getElementById("saler").value.length>16){
   	     alert("销售员不能超过16位！");
   	     document.getElementById("saler").focus();
   	     return false;
   	    }else if(document.getElementById("unitsOrAddress").value.length>64){
		     alert("地址不要超出64位长度");
		     document.getElementById("unitsOrAddress").focus();
		     return false;
        }else if(document.getElementById("model").value.length>16){
	     alert("型号不能超过16位");
	     document.getElementById("model").focus();
	     return false;
        }else if (!($("#price").val() == null || $("#price").val()=="")
        		&& !reg.test(document.getElementById("price").value)){
            alert("输入的价格格式不对");
            document.getElementById("price").focus();
            return false;
        }else  if (!($("#deposit").val() == null || $("#deposit").val()=="") 
        		&& !reg.test(document.getElementById("deposit").value)){
            alert("输入的定金格式不对");
            document.getElementById("deposit").focus();
            return false;
        }else if(document.getElementById("smartLock").value.length>32){
	       alert("智能锁长度不能超过32位！");
	       document.getElementById("smartLock").focus();
	       return false;
	    }else if(document.getElementById("saleRemarks").value.length>64){
            alert("销售备注长度不能超过64位！");
            document.getElementById("saleRemarks").focus();
            return false;
        }else  if (!($("#jjrAmt").val() == null || $("#jjrAmt").val()=="") 
        		&& !reg.test(document.getElementById("jjrAmt").value)){
            alert("输入的交居然金额格式不对");
            document.getElementById("jjrAmt").focus();
            return false;
        }else if(document.getElementById("holeSize").value.length>16){
	     alert("洞口尺寸不能超过16位！");
	     document.getElementById("holeSize").focus();
	     return false;
        }else if(document.getElementById("doorSize").value.length>16){
	     alert("门的尺寸不能超过16位");
	     document.getElementById("doorSize").focus();
	     return false;
        }else if(document.getElementById("direction").value.length>16){
	       alert("门的方向长度不能超过16位！");
	       document.getElementById("direction").focus();
	       return false;
	    }else if(document.getElementById("surveyor").value.length>16){
            alert("测量师傅长度不能超过16位！");
            document.getElementById("surveyor").focus();
            return false;
        }else if(document.getElementById("surveyorSmark").value.length>64){
            alert("测量备注长度不能超过64位！");
            document.getElementById("surveyorSmark").focus();
            return false;
        }else if(document.getElementById("installPerson").value.length>16){
            alert("安装师傅长度不能超过16位！");
            document.getElementById("installPerson").focus();
            return false;
        }else if(document.getElementById("installPerSmark").value.length>64){
            alert("安装备注长度不能超过64位！");
            document.getElementById("installPerSmark").focus();
            return false;
        }else if(document.getElementById("yaKouSmark").value.length>32){
            alert("垭口安装长度不能超过32位！");
            document.getElementById("yaKouSmark").focus();
            return false;
        }else if(document.getElementById("smartCatEye").value.length>32){
            alert("智能猫眼长度不能超过32位！");
            document.getElementById("smartCatEye").focus();
            return false;
        }else if(document.getElementById("fixSmarkOne").value.length>64){
            alert("售后服务1长度不能超过64位！");
            document.getElementById("fixSmarkOne").focus();
            return false;
        }else if(document.getElementById("fixSmarkTwo").value.length>64){
            alert("售后服务2长度不能超过64位！");
            document.getElementById("fixSmarkTwo").focus();
            return false;
        }else if(document.getElementById("fixSmarkSan").value.length>64){
            alert("售后服务3长度不能超过64位！");
            document.getElementById("fixSmarkSan").focus();
            return false;
        }else if(document.getElementById("fixSmarkSi").value.length>64){
            alert("售后服务4长度不能超过64位！");
            document.getElementById("fixSmarkSi").focus();
            return false;
        }else if(document.getElementById("fixSmarkWu").value.length>64){
            alert("售后服务5长度不能超过64位！");
            document.getElementById("fixSmarkWu").focus();
            return false;
        }else if(document.getElementById("fixSmarkLiu").value.length>64){
            alert("售后服务6长度不能超过64位！");
            document.getElementById("fixSmarkLiu").focus();
            return false;
        }else if(document.getElementById("fixSmarkQi").value.length>64){
            alert("售后服务7长度不能超过64位！");
            document.getElementById("fixSmarkQi").focus();
            return false;
        }else if(document.getElementById("fixSmarkBa").value.length>64){
            alert("售后服务8长度不能超过64位！");
            document.getElementById("fixSmarkBa").focus();
            return false;
        }else if(document.getElementById("fixSmarkJiu").value.length>64){
            alert("售后服务9长度不能超过64位！");
            document.getElementById("fixSmarkJiu").focus();
            return false;
        }else if(document.getElementById("fixSmarkShi").value.length>64){
            alert("售后服务10长度不能超过64位！");
            document.getElementById("fixSmarkShi").focus();
            return false;
        }else{
	       	return true;
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
   }
   
 </script>
   
  </body>
</html>
