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
        <h3 style="text-align: center;">交易新增</h3>

      </div>
    </div>

    <form action="${ctx}/TranStatistics/add.do" method="post" onsubmit="return verify()">
		<input type="hidden" name="userID" value="${sessionScope.userPo.id}" >
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <div class="span12">
	      <div class="row-fluid">
		     <div class="span3">
		        <label>合同编号：</label>
		        <input id="agreementID" name="agreementID"  type="text" style="width:97%;height:27px;float:left;"  onblur="selectAgreementID(this.value)">
		        <div id="divOne" style="float:right;">
			         <label class="yansered" style="margin-top:7px;">*</label>
			    </div>
		      </div>
		     <div class="span3">
		        <label>交款凭证号：</label>
		        <input id="paymentID" name="paymentID" type="text" style="width:97%;height:27px;float:left;">
		        <div id="divTwo" style="float:right;">
			         <label class="yansered" style="margin-top:7px;">*</label>
			    </div>
		      </div>
			  <div class="span3">
				  <label>客户名称：</label>
				  <input id="merName" name="merName" type="text" style="width:97%;height:27px;float:left;" onchange="selectNames(this.value)">
				  <div  id="divFive" style="float:right;">
					  <label class="yansered" style="margin-top:7px;">*</label>
				  </div>
			  </div>
			  <div class="span3">
				  <label>价格：</label>
				  <input id="price" name="price" type="text" style="width:97%;height:27px;float:left;">
				  <div  id="divThree" style="float:right;">
					  <label class="yansered" style="margin-top:7px;">*</label>
				  </div>
			  </div>
		  </div>
		  <div class="row-fluid">
			  <div class="span3">
				  <label>定金：</label>
				  <input id="deposit" name="deposit" type="text" style="width:97%;height:27px;float:left;" >
				  <div  id="divfour" style="float:right;">
					  <label class="yansered" style="margin-top:7px;">*</label>
				  </div>
			  </div>
			  <div class="span3">
				  <label>下单日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="playDateStr" name="playDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})">
			  </div>
			  <div class="span3">
				  <label>交款日期：</label>
				  <input style="width:97%;height:27px;float:left;" type="text" id="payDateStr" name="payDateStr" class="input-text Wdate"
						 onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})">
			  </div>
			  <div class="span3">
				  <label>智能锁：</label>
				  <input id="smartLock" name="smartLock" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
		  </div>
		  <div class="row-fluid">
			  <div class="span3">
				  <label>智能猫眼：</label>
				  <input id="smartCatEye" name="smartCatEye" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>产品型号：</label>
				  <input id="model" name="model" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>店面备注：</label>
				  <input id="remarks" name="remarks" type="text" style="width:97%;height:27px;float:left;" >
			  </div>
			  <div class="span3">
				  <label>日期金额：</label>
				  <input id="dateMoney" name="dateMoney" type="text" style="width:97%;height:27px;float:left;" >
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

    function selectNames(value){
    	if(value!=""){
            $.ajax({
                cache:false,                                             //是否使用缓存提交 如果为TRUE 会调用浏览器的缓存 而不会提交
                type: "POST",                                           //上面3行都是必须要的
                url: '${ctx}/Passenger/selectByUserName.do',       //地址 type 带参数
                data:"userName="+value,                         // IDCardValue 自定义的。相当于name把值赋予给 他可以在servlet 获取
                async:false,                                          // 是否 异步 提交
                success: function (result) {                          // 不出现异常 进行立面方
                    if(result>=1){
                        alert("姓名已存在！");                     //提示框
                        document.getElementById("nameId").value="";     //这个id的文本框的值 将会清空
                        document.getElementById("nameId").focus();      // 给这个id的文本框提供焦点
                        document.getElementById("nameId").style.display="block"; //显示
                    }
                },
                error: function(data) {  }
            });
        }
   }

   function selectAgreementID(value){
	     if(value!=""){
	       $.ajax({
	          cache:false,                                             //是否使用缓存提交 如果为TRUE 会调用浏览器的缓存 而不会提交
	          type: "POST",                                           //上面3行都是必须要的
	          url: '${ctx}/TranStatistics/selectByAgreementID.do',       //地址 type 带参数
	          data:"agreementID="+value,                         // IDCardValue 自定义的。相当于name把值赋予给 他可以在servlet 获取
	          async:false,                                          // 是否 异步 提交
	          success: function (result) {                          // 不出现异常 进行立面方
	              if(result>=1){
	                   alert("合同编号已经存在！");                     //提示框
	                   document.getElementById("agreementID").value="";     //这个id的文本框的值 将会清空
	                   document.getElementById("agreementID").focus();      // 给这个id的文本框提供焦点
	                   document.getElementById("agreementID").style.display="block"; //显示
	              }
	          },
	          error: function(data) {  }
	      });
	     }
   }

 </script>

  </body>
</html>
