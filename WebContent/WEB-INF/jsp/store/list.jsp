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
  <link rel="stylesheet" href="${ctx}/css/page.css" type="text/css"></link>
  <link href="${ctx}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">  <!-- start 响应式布局要添加的 -->
  <script src="${ctx}/bootstrap/js/jquery-3.1.1.min.js"></script>
  <script src="${ctx}/bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="${ctx}/js/page.js"></script>
   <style>
   
   .container{
     margin-top: 10px;
   }
   
    .labelroomnumber{
      position: relative;
      font-size: 17px;
      float: left;
      margin-top: 15px;
    }
    
    .textone{
    margin-top:12px;
    }
    
    .rightOne{
    margin-right: 50px;
    font-size:16px;
    }
    
    .table th,.table td{
       text-align: center; 
    }
    
    .theadone{
     background-color: #CCFF99;
    }
    
    .dgvone{
      margin-top: 12px;
    }
    
    .roomnumberwidth{
      width:70%;
    }
    
  
  </style>
  
 </head>
  
 
  <body>
  <div class="container" >
    <div class="span5">
	    <div class="row-fluid">
		    <label class="labelroomnumber">型号：</label>
		    <form action="${ctx}/StoreHandle/tolist.do" method="post" style="float: left;">
			   <input id="txtmodelid" name="txtmodel" class="textone roomnumberwidth" style="border-radius:0px; border-top-left-radius:4px; border-bottom-left-radius:4px;height:26px;" type="text" placeholder="请输入关键字" value="${txtmodel}">
			   <div class="input-append">  
			      <button type="submit" class="btn-success textone" style="margin-left:-4px;height:26px;"><li class="icon-search icon-white"></li>搜索</button>
			   </div>
		    </form>
	    </div>
    </div>
    <div class="span6">
      <div class="row-fluid">
       <div class="span3">
         <button class="btn btn-info btn-small textone" type="button" onclick="addfunction()"><li class="icon-plus icon-white"></li>新增</button>
       </div>
       <div class="span3">
         <button class="btn btn-warning btn-small textone" type="button" onclick="updatefunction()"><li class="icon-pencil icon-white"></li>修改</button>
       </div>
       <div class="span3">
         <button class="btn btn-danger btn-small textone" type="button" onclick="deletefunction()"><li class="icon-remove icon-white"></li>删除</button>
       </div>
      </div>
    </div>
    <br>
    <div class="dgvone">
       <table class="table table-condensed table-bordered table-striped" id="tableid">
	      <thead class="theadone">
	        <tr>
	          <th >选择</th>
	          <th >型号</th>
	          <th >尺寸</th>
	          <th >外左</th>
	          <th >外右</th>
	        </tr>
	      </thead>
	      <tbody id="tbody">
	        <c:forEach items="${list.result}" var="item">
		        <tr>
		          <td><input type="checkbox" name="id" value="${item.id}"></td>
		          <td>${item.model}</td>
		          <td>${item.size}</td>
		          <td>${item.outLeft}</td>
		          <td>${item.outRight}</td>
		        </tr>
	        </c:forEach>
	      </tbody>
	    </table>
    </div>

    <div class="span11">
      <div class="row-fluid">
        <div class="tcdPageCode" style="text-align:center;"></div>
      </div>
    </div>
  </div>
 
 <script type="text/javascript">
   function addfunction(){
     parent.document.getElementById('Mainid').src='${ctx}/StoreHandle/toadd.do';
   }
   
   function updatefunction(){
   var chk_value=[];
  	$('input[name="id"]:checked').each(function(){
  		chk_value.push($(this).val());
  	});
  	if(chk_value!=""){
		if(chk_value.toString().indexOf(",")>0){
		   alert("修改只能选择一条");
		}else{
		   parent.document.getElementById("Mainid").src='${ctx}/StoreHandle/toupdate.do?id='+chk_value;
		}
	}else{
	  alert("请选择一条数据进行修改");
	}
  }
  
   function deletefunction(){
   var chk_value=[];
  	$('input[name="id"]:checked').each(function(){
  		chk_value.push($(this).val());
  	});
  	if(chk_value!=""){
  	var flag=window.confirm("注意：您确定要永久删除该信息吗?");
     if(flag){
  	  parent.document.getElementById("Mainid").src='${ctx}/StoreHandle/delete.do?id='+chk_value;
  	}
  	}else{
	  alert("请选择一条或多条数据进行删除");
	}
	
  }
  
  
  
  
   
   
   
  /* 分页要用的 */
  $(".tcdPageCode").createPage({
     pageCount:${list.totalPage},
     current:${list.currentPage},
     backFn:function(p){
     var txtmodel=document.getElementById("txtmodelid").value;
     location.href="${ctx}/StoreHandle/tolist.do?currentPage="+p+"&txtmodel="+txtmodel;
     }
   });
  
 </script>
   
  </body>
</html>
