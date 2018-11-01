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
        <h3 style="text-align: center;">修改信息</h3>
        
      </div>
    </div>
    
    <form action="${ctx}/ParametersHandle/update.do" method="post" onsubmit="return verify()" enctype="multipart/form-data">
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <input type="hidden" name="id" value="${list.id}" >
		<input type="hidden" name="userID" value="${sessionScope.userPo.id}" >
		<div class="span12">
		<div class="row-fluid">
				<div class="span3">
				  <label>客户名称：</label>
				  <input id="merName" name="merName" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.merName}">
				  <div id="divTwo" style="float:right;">
				  </div>
			  	</div>
			  	<div class="span3">
				  <label>客户性别：</label>
				  <input id="genderID" name="genderID" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.genderID}">
			  </div>
			   <div class="span3">
				  <label>客户住址：</label>
				  <input id="unitsOrAddress" name="unitsOrAddress" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.unitsOrAddress}" <c:if test="${sessionScope.userPo.roleID ==1}">readonly="readonly"</c:if>>
			  </div>
			  <div class="span3">
				  <label>联系电话1：</label>
				  <input id="contactPhoneNumber" name="contactPhoneNumber" type="text"
						 style="width:97%;height:27px;float:left;" onchange="checkTel()"
						 value="${list.contactPhoneNumber}" <c:if test="${sessionScope.userPo.roleID ==1}">readonly="readonly"</c:if>>
			  </div>
		  </div>
		  <div class="row-fluid">
			   <div class="span3">
					  <label>联系电话2：</label>
					  <input id="secondPhoneNumber" name="secondPhoneNumber" type="text"
							 style="width:100%;height:27px;"  placeholder="手机号或者座机" onchange="checkTel()"
							 value="${list.secondPhoneNumber}" <c:if test="${sessionScope.userPo.roleID ==1}">readonly="readonly"</c:if>>
			   </div>
			   <div class="span3">
				  <label>销售备注：</label>
				  <input id="remarks" name="remarks" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.remarks}">
			  </div>
			  <div class="span3">
					<label>合同图片描述：</label>
					<input type="text" id="agreementPhotoDes" name="agreementPhotoDes" style="width:97%;height:27px;float:left;"
					value="${list.agreementPhotoDes}">
				</div>
				<div class="span3">
					<label>请选择文件：</label>
					<input type="file" name="agreementFile" style="width:97%;height:27px;float:left;"
					value="${list.agreementPhotoPath}">
				</div>
		  </div>
			<div class="row-fluid">
				<div class="span3">
					<label>测量图片描述：</label>
					<input type="text" id="surveyorPhotoDes" name="surveyorPhotoDes" style="width:97%;height:27px;float:left;"
					value="${list.surveyorPhotoDes}">
				</div>
				
				<div class="span3">
					<label>请选择文件：</label>
					<input type="file" name="surveyorFile" style="width:97%;height:27px;float:left;"
					value="${list.surveyorPhotoPath}">
				</div>
				<div class="span3">
					<label>安装图片描述：</label>
					<input type="text" id="istallPhotoDes" name="istallPhotoDes" style="width:97%;height:27px;float:left;"
					value="${list.istallPhotoDes}">
				</div>
				<div class="span3">
					<label>请选择文件：</label>
					<input type="file" name="istallFile" style="width:97%;height:27px;float:left;"
					value="${list.istallPhotoPath}">
				</div>
			</div>
			
			<div class="row-fluid">
		     <div class="span3">
		        <label>合同编号：</label>
		        <input id="agreementID" name="agreementID"  type="text" style="width:97%;height:27px;float:left;"  
		        value="${list.agreementID}" onblur="selectAgreementID(this.value)" >
				 <div id="divOne" style="float:right;">
				 </div>
			 </div>
			 <div class="span3">
				  <label>付款凭证号：</label>
				  <input id="paymentID" name="paymentID" type="text" style="width:97%;height:27px;float:left;"
				  value="${list.paymentID}" >
			  </div>
			  <div class="span3">
				  <label>订货日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="createDateStr" name="createDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})" 
						 value="<fmt:formatDate value="${list.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
			  </div>
			  <div class="span3">
				  <label>交款日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="payDateStr" name="payDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						 value="<fmt:formatDate value="${list.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
			  </div>
		  </div>
		  <div class="row-fluid">
		  	  <div class="span3">
				  <label>门的型号：</label>
				  <input id="model" name="model" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.model}" <c:if test="${sessionScope.userPo.roleID ==1}">readonly="readonly"</c:if>>
			  </div>
			  <div class="span3">
				  <label>价格：</label>
				  <input id="price" name="price" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.price}" <c:if test="${sessionScope.userPo.roleID ==1}">readonly="readonly"</c:if>>
			  </div>
			  <div class="span3">
				  <label>定金：</label>
				  <input id="deposit" name="deposit" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.deposit}">
			  </div>
			  <div class="span3">
				  <label>日期金额：</label>
				  <input id="dateMoney" name="dateMoney" type="text" style="width:97%;height:27px;float:left;" 
				   value="${list.dateMoney}">
			  </div>
		  </div>
		  <div class="row-fluid">
			  <div class="span3">
					  <label>洞口尺寸：</label>
					  <input id="holeSize" name="holeSize" type="text" style="width:97%;height:27px;float:left;" 
					  value="${list.holeSize}">
				  </div>
				  <div class="span3">
					  <label>门尺寸：</label>
					  <input id="doorSize" name="doorSize" type="text" style="width:97%;height:27px;float:left;" 
					  value="${list.doorSize}">
				  </div>
				  <div class="span3">
					  <label>木套尺寸：</label>
					  <input id="woodcase" name="woodcase" type="text" style="width:97%;height:27px;float:left;" 
					  value="${list.woodcase}">
				  </div>
				  <div class="span3">
					  <label>压条尺寸：</label>
					  <input id="moundlayer" name="moundlayer" type="text" style="width:97%;height:27px;float:left;" 
					  value="${list.moundlayer}">
			  	  </div>
		  </div>
		  <div class="row-fluid">
		  	  <div class="span3">
					  <label>开口方向：</label>
					  <input id="direction" name="direction" type="text" style="width:97%;height:27px;float:left;" 
					  value="${list.direction}">
				  </div>
				  <div class="span3">
				  <label>智能锁：</label>
				  <input id="smartLock" name="smartLock" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.smartLock}">
			  </div>
			   <div class="span3">
				  <label>智能猫眼：</label>
				  <input id="smartCatEye" name="smartCatEye" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.smartCatEye}">
			  </div>
			  <div class="span3">
				  <label>室内情况：</label>
				  <input id="indoorInfo" name="indoorInfo" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.indoorInfo}">
			  </div>
	      </div>
		  <div class="row-fluid">
			  <div class="span3">
				  <label>割边情况：</label>
				  <input id="cutInfo" name="cutInfo" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.cutInfo}">
			  </div>
			  <div class="span3">
				  <label>安装师：</label>
				  <input id="installPerson" name="installPerson" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.installPerson}">
			  </div>
			  <div class="span3">
				  <label>安装日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="installDateStr" name="installDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						 value="<fmt:formatDate value="${list.installDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" >
			  </div>
			  <div class="span3">
				  <label>安装备注：</label>
				  <input id="installPerSmark" name="installPerSmark" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.installPerSmark}">
			  </div>
		  </div>
		  <div class="row-fluid">
		  	<div class="span3">
		        <label>测量师：</label>
		        <input id="surveyor" name="surveyor" type="text" style="width:97%;height:27px;float:left;" 
		        value="${list.surveyor}">
		      </div>
			  <div class="span3">
				  <label>测量日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="surveyorDateStr" name="surveyorDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						 value="<fmt:formatDate value="${list.surveyorDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
			  </div>
			  <div class="span3">
				  <label>测量备注：</label>
				  <input id="surveyorSmark" name="surveyorSmark" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.surveyorSmark}">
			  </div>
			  <div class="span3">
				  <label>操作员工：</label>
				  <input id="operatorID" name="operatorID" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.operatorID}" readonly="readonly">
			  </div>
		  </div>
			<div class="row-fluid">
			  <div class="span3">
				  <label>维修服务项目：</label>
				  <input id="fixObject" name="fixObject" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.fixObject}">
			  </div>
			   <div class="span3">
				  <label>维修服务日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="fixDateStr" name="fixDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						 value="<fmt:formatDate value="${list.fixDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
			  </div>
			  <div class="span3">
				  <label>维修备注1：</label>
				  <input id="fixSmarkOne" name="fixSmarkOne" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.fixSmarkOne}">
			  </div>
			  <div class="span3">
				  <label>维修备注2：</label>
				  <input id="fixSmarkTwo" name="fixSmarkTwo" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.fixSmarkTwo}">
			  </div>
		  </div>
		  <div class="row-fluid">
			   <div class="span3">
				  <label>垭口服务日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="yaKouInstallDateStr" name="yaKouInstallDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						 value="<fmt:formatDate value="${list.yaKouInstallDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" >
			  </div>
			  <div class="span3">
				  <label>垭口颜色要求：</label>
				  <input id="colorRequire" name="colorRequire" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.colorRequire}">
			  </div>
			  <div class="span3">
				  <label>门底槛情况：</label>
				  <input id="doorBottomInfo" name="doorBottomInfo" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.doorBottomInfo}">
			  </div>
			  <div class="span3">
				  <label>垭口备注：</label>
				  <input id="yaKouSmark" name="yaKouSmark" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.yaKouSmark}">
			  </div>
		  </div>
			<div class="row-fluid">
			  <div class="span3">
				  <label>转账信息备注：</label>
				  <input id="transAcctSmark" name="transAcctSmark" type="text" style="width:97%;height:27px;float:left;" 
				  value="${list.transAcctSmark}">
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
         }else if(document.getElementById("holeSize").value.length>16){
             alert("洞口尺寸不能超过16位！");
             document.getElementById("holeSize").focus();
             return false;
         }else if(document.getElementById("doorSize").value.length>16){
             alert("门尺寸不能超过16位");
             document.getElementById("doorSize").focus();
             return false;
         }else if(document.getElementById("direction").value.length>16){
             alert("开口方向长度不能超过16位！");
             document.getElementById("direction").focus();
             return false;
         }else if(document.getElementById("indoorInfo").value.length>64){
             alert("室内情况长度不能超过64位！");
             document.getElementById("indoorInfo").focus();
             return false;
         }else if(document.getElementById("surveyor").value.length>16){
             alert("测量师长度不能超过16位！");
             document.getElementById("surveyor").focus();
             return false;
         }else if(document.getElementById("surveyorSmark").value.length>64){
             alert("测量师备注长度不能超过64位！");
             document.getElementById("surveyorSmark").focus();
             return false;
         }else if(document.getElementById("woodcase").value.length>16){
             alert("木套长度不能超过16位！");
             document.getElementById("woodcase").focus();
             return false;
         }else if(document.getElementById("moundlayer").value.length>16){
             alert("压条长度不能超过16位！");
             document.getElementById("moundlayer").focus();
             return false;
         }else if(document.getElementById("installPerson").value.length>16){
             alert("安装师长度不能超过16位！");
             document.getElementById("installPerson").focus();
             return false;
         }else if(document.getElementById("installPerSmark").value.length>64){
             alert("安装师备注长度不能超过64位！");
             document.getElementById("installPerSmark").focus();
             return false;
         }else if(document.getElementById("otherSmark").value.length>64){
             alert("其它备注长度不能超过64位！");
             document.getElementById("otherSmark").focus();
             return false;
         }else if(document.getElementById("merName").value.length>10){
             alert("商户名长度不能超过10位！");
             document.getElementById("merName").focus();
             return false;
         }else if(document.getElementById("surveyorPhotoDes").value.length>32){
             alert("测量图片描述长度不能超过32位！");
             document.getElementById("surveyorPhotoDes").focus();
             return false;
         }else if(document.getElementById("istallPhotoDes").value.length>32){
             alert("安装图片描述长度不能超过32位！");
             document.getElementById("istallPhotoDes").focus();
             return false;
         }else if(document.getElementById("fixObject").value.length>16){
	    	alert("服务项目长度不能超过16位!");
            document.getElementById("fixObject").focus();
            return false;
        }else if(document.getElementById("fixSmarkOne").value.length>64){
            alert("维修备注1长度不能超过64位！");
            document.getElementById("fixSmarkOne").focus();
            return false;
        }else if(document.getElementById("fixSmarkTwo").value.length>32){
            alert("维修备注2长度不能超过64位！");
            document.getElementById("fixSmarkTwo").focus();
            return false;
        }else if(document.getElementById("colorRequire").value.length>16){
	    	alert("颜色要求长度不能超过16位!");
	        document.getElementById("colorRequire").focus();
	        return false;
	    }else if(document.getElementById("doorBottomInfo").value.length>32){
	        alert("门槛底部情况长度不能超过32位！");
	        document.getElementById("doorBottomInfo").focus();
	        return false;
	    }else if(document.getElementById("yaKouSmark").value.length>64){
	        alert("垭口备注不能超过64位！");
	        document.getElementById("yaKouSmark").focus();
	        return false;
    	}else{
	       return true;
	    }
   }
   
   function deletefunction(){
	     parent.document.getElementById('Mainid').src='${ctx}/ParametersHandle/tolist.do?userID='+${sessionScope.userPo.id};
	   }
	 
   
 </script>
   
  </body>
</html>
