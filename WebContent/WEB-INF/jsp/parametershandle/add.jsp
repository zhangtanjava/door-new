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
  <script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
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
        <h3 style="text-align: center;">新增信息</h3>

      </div>
    </div>


    <form action="${ctx}/ParametersHandle/add.do" method="post" onsubmit="return verify()" enctype="multipart/form-data">
		<input type="hidden" name="userID" value="${sessionScope.user.id}" >
	    <div class="span12">
	    <div class="row-fluid">
	   			 <div class="span3">
				  <label>店面：</label>
				  <select id="storeID" name="storeID" style="width:97%;height:27px;float:left;" <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
      					<option value="0" selected="selected">请选择</option>
					</select>
			  	</div>
			  	<div class="span3">
				  <label>销售员：</label>
				  <input id="saler" name="saler" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
	    		<div class="span3">
				  <label>订货日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="createDateStr" name="createDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  	</div>
			  	<div class="span3">
					<label>定金图片：</label>
					<input type="file" id="frontMoneyFile" name="frontMoneyFile" style="width:97%;height:27px;float:left;">
				</div>
		  </div>
		  <div class="row-fluid">
	    		<div class="span3">
				  <label>地址：</label>
				  <input id="unitsOrAddress" name="unitsOrAddress" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>电话1：</label>
				  <input id="contactPhoneNumber" name="contactPhoneNumber" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>电话2：</label>
				  <input id="secondPhoneNumber" name="secondPhoneNumber" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
					<label>合同图片1：</label>
					<input type="file" id="agreementFile" name="agreementFile" style="width:97%;height:27px;float:left;">
				</div>
		  </div>
	    <div class="row-fluid">
			  	<div class="span3">
				  <label>型号：</label>
				  <input id="model" name="model" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>价格：</label>
				  <input id="price" name="price" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>定金：</label>
				  <input id="deposit" name="deposit" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
					<label>合同图片2：</label>
					<input type="file" id="seAgreementFile" name="seAgreementFile" style="width:97%;height:27px;float:left;">
		  		</div>
		  </div>
		  <div class="row-fluid">
			  	<!-- <div class="span3">
				  <label>智能锁：</label>
				  <input id="smartLock" name="smartLock" type="text" style="width:97%;height:27px;float:left;" >
			  	</div> -->
			  	<div class="span3">
				  <label>尾款去向：</label>
				  <input id="jjrAmt" name="jjrAmt" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<div class="span3">
				  <label>交尾款日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="payDateStr" name="payDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  	</div>
			  	<div class="span3">
				  <label>安装备注：</label>
				  <input id="installPerSmark" name="installPerSmark" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  	<!-- <div class="span3">
				  <label>安装备注：</label>
				  <input id="saleRemarks" name="saleRemarks" type="text" style="width:97%;height:27px;float:left;" >
			  	</div> -->
		  </div>
		  <div class="row-fluid">
			  <hr width="100%" />
			</div>
		  <div class="row-fluid">
		 		 <div class="span3">
					  <label>洞口尺寸：</label>
					  <input id="holeSize" name="holeSize" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
				  <div class="span3">
					  <label>门的尺寸：</label>
					  <input id="doorSize" name="doorSize" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
				  <div class="span3">
					  <label>开向：</label>
					  <!-- <select id="direction" name="direction" style="width:97%;height:27px;float:left;">
      					<option value="外左" selected="selected">外左</option>
      					<option value="外右" selected="selected">外右</option>
						</select> -->
					  <input id="direction" name="direction" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
				  <div class="span3">
						<label>测量图片：</label>
						<input type="file" id= "surveyorFile" name="surveyorFile" style="width:97%;height:27px;float:left;">
					</div>
				  <!-- <div class="span3">
					  <label>出库数量：</label>
					  <input id="doorAmount" name="doorAmount" type="text" style="width:97%;height:27px;float:left;" >
				  </div> -->
			</div>	
			<div class="row-fluid">
				  <div class="span3">
					  <label>测量日期：</label>
					  <input style="width:97%;height:27px;float:left;" type="text" id="surveyorDateStr" name="surveyorDateStr" class="input-text Wdate"
							 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
				  </div>
				  <div class="span3">
			        <label>测量师傅：</label>
			        <input id="surveyor" name="surveyor" type="text" style="width:97%;height:27px;float:left;" >
			      </div>
				  <div class="span3">
					  <label>测量备注：</label>
					  <input id="surveyorSmark" name="surveyorSmark" type="text" style="width:97%;height:27px;float:left;" >
				  </div>
			</div>	 
			<div class="row-fluid">
			  <hr width="100%" />
			</div> 
			<div class="row-fluid">
			  <div class="span3">
				  <label>安装日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="installDateStr" name="installDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  </div>
			  <div class="span3">
				  <label>安装师傅：</label>
				  <input id="installPerson" name="installPerson" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
					<label>门安装图片：</label>
					<input type="file" id="istallFile" name="istallFile" style="width:97%;height:27px;float:left;">
			  </div>
		  </div>
		  <div class="row-fluid">
			  <hr width="100%" />
		  </div> 
		  <div class="row-fluid">
			  <div class="span3">
				  <label>垭口安装：</label>
				  <input id="yaKouSmark" name="yaKouSmark" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>智能猫眼：</label>
				  <input id="smartCatEye" name="smartCatEye" type="text" style="width:97%;height:27px;float:left;" >
			  	</div>
			  <div class="span3">
					  <label>智能锁安装时间：</label>
					  <input style="width:97%;height:27px;float:left;" type="text" id="smartLockDateStr" name="smartLockDateStr" class="input-text Wdate"
							 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})">
			  </div>
			  <div class="span3">
					<label>锁安装图片：</label>
					<input type="file" id="smartLockFile" name="smartLockFile" style="width:97%;height:27px;float:left;">
				</div>
		  </div>
		  <div class="row-fluid">
			  <hr width="100%" />
		  </div> 
		  <div class="row-fluid">
			  	<div class="span3">
				  <label>售后服务1：</label>
				  <input id="fixSmarkOne" name="fixSmarkOne" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务2：</label>
				  <input id="fixSmarkTwo" name="fixSmarkTwo" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务3：</label>
				  <input id="fixSmarkSan" name="fixSmarkSan" type="text" style="width:97%;height:27px;float:left;" >
				  <div id="divTwo" style="float:right;">
				  </div>
			  	</div>
			  	<div class="span3">
				  <label>售后服务4：</label>
				  <input id="fixSmarkSi" name="fixSmarkSi" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			</div>
		  <div class="row-fluid">
			  	<div class="span3">
				  <label>售后服务5：</label>
				  <input id="fixSmarkWu" name="fixSmarkWu" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务6：</label>
				  <input id="fixSmarkLiu" name="fixSmarkLiu" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>售后服务7：</label>
				  <input id="fixSmarkQi" name="fixSmarkQi" type="text" style="width:97%;height:27px;float:left;" >
				  <div id="divTwo" style="float:right;">
				  </div>
			  	</div>
			  	<div class="span3">
				  <label>垭口安装时间：</label>
				  <input id="fixSmarkBa" name="fixSmarkBa" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			</div>
		  <div class="row-fluid">
			  <div class="span3">
				  <label>库存：</label>
				  <input id="fixSmarkJiu" name="fixSmarkJiu" type="text" style="width:97%;height:27px;float:left;" <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
			      
			  </div>
			  <div class="span3">
				  <label>下单：</label>
				  <input id="fixSmarkShi" name="fixSmarkShi" type="text" style="width:97%;height:27px;float:left;" <c:if test="${sessionScope.user.roleID ==1}">readonly="readonly"</c:if>>
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
		 </div> 
		  <div class="span6" style="text-align:center;">
		      <div class="row-fluid">
			      <div class="span12" style="margin-top: 10px;margin-bottom: 8px;">
				   	 <button class="btn btn-primary" type="submit">
				   	 <li class="icon-check icon-white"></li>保存</button>
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
 $(function(){  
     getStoreId();  
 });  
	function getStoreId(){   
	 		$.ajax({   
		      type:"POST",   
		      dataType: "json",   
		      url:"${ctx}/User/selectStoreId.do",   
		      data:"",   
		      success:function(result){   
		            var len=result.length;   
		            $('#storeID').attr("length",'0');   
			      for(i=0;i<len;i++){   
			          $("#storeID").append($('<option value='+result[i].storeID+'>'+result[i].storeID+'</option>'));  
					}   
				}   
			});   
	 }   
 
 	var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
 	function deletefunction(){
	    parent.document.getElementById('Mainid').src='${ctx}/ParametersHandle/tolist.do?userID=${sessionScope.user.id}';
	} 
	 
     
    function verify(){
    	if(!checkDupl()){
    		return false;
    	}
    	if($("#unitsOrAddress").val() != null && $("#unitsOrAddress").val() !=""){
    		if($("#saler").val() == null || $("#saler").val()==""){
    			alert("销售员不能为空！");
    			return false;
    		}
    		if($("#createDateStr").val() == null || $("#createDateStr").val()==""){
    			alert("订货日期不能为空！");
    			return false;
    		}
    		if($("#frontMoneyFile").val() == null || $("#frontMoneyFile").val()==""){
    			alert("定金图片不能为空！");
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
    	if($("#agreementFile").val() != null && $("#agreementFile").val()!=""){
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
    			alert("开向不能为空！");
    			return false;
    		}
    		if($("#surveyorFile").val() == null || $("#surveyorFile").val()==""){
    			alert("测量图片不能为空！");
    			return false;
    		}
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
    		if($("#istallFile").val() == null || $("#istallFile").val()==""){
    			alert("门安装图片不能为空！");
    			return false;
    		}
    	}
    	
    	if(document.getElementById("saler").value.length>16){
   	     alert("销售员不能超过16位！");
   	     document.getElementById("saler").focus();
   	     return false;
   	    }else if(document.getElementById("unitsOrAddress").value.length>64){
		     alert("住址不要超出64位长度");
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
	       alert("开向长度不能超过16位！");
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
    }
    function checkDupl(){
    	var flag = true;
    	var model = $("#model").val();
	    var size = $("#doorSize").val();
	    var direction = $("#direction").val();
	    /* var doorAmount = $("#doorAmount").val(); */
	    /* if(model==null || model==""){
	    	alert("型号不能为空");
	    	$("#model").val("");
	    	$("#model").focus();
	    	flag = false;
	    }else if(size==null || size==""){
	    	alert("门的尺寸不能为空");
	    	$("#doorSize").val("");
	    	$("#doorSize").focus();
	    	flag = false;
	    }else if(direction==null || direction==""){
	    	alert("开向不能为空");
	    	$("#direction").val("");
	    	$("#direction").focus();
	    	flag = false;
	    } */
	    return flag;

	    /* if(model!=null && model!="" && size!=null && size!="" && direction!=null && direction!=""){
	    	$.ajax({
		          cache:false,                                             //是否使用缓存提交 如果为TRUE 会调用浏览器的缓存 而不会提交
		          type: "POST",                                           //上面3行都是必须要的
		          url: '${ctx}/StoreHandle/selectInfoByModelSize.do',       //地址 type 带参数
		          data:"model="+model+"&size="+size,                         // IDCardValue 自定义的。相当于name把值赋予给 他可以在servlet 获取
		          async:false,                                          // 是否 异步 提交
		          success: function (result) {                          // 不出现异常 进行立面方
		              if(result==null){
		                   alert("库存中该型号尺寸不存在！");                     //提示框
		                   flag = false;
		              }else {
		            	  if(direction.indexOf("右") != -1){
		            		  if(result.outRight>=1){
		            			  flag = true;
		            		  }else{
		            			  alert("该型号外右库存不足！");
		            			  flag = false;
		            		  }
		            	  }else if(direction.indexOf("左") != -1){
							  if(result.outLeft>=1){
								  flag = true;
		            		  }else{
		            			  alert("该型号外左库存不足！");
		            			  flag = false;
		            		  }
		            	  }
		              }
		          },
		          error: function(result) { 
		        	  alert("导入数据信息异常！");
		        	  flag = false;
		          }
		      }); 
	    	return flag;
	    } */
	    
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
