<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title></title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


    <!--   <link rel="stylesheet" href="${ctx}/css/roomset/roomset.css" type="text/css"></link> -->
    <link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.css" type="text/css"></link>
    <link rel="stylesheet" href="${ctx}/css/page.css" type="text/css"></link>
    <link href="${ctx}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">  <!-- start 响应式布局要添加的 -->
    <script src="${ctx}/bootstrap/js/jquery-3.1.1.min.js"></script>
    <script src="${ctx}/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${ctx}/js/page.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>


    <style>

        .container {
            margin-top: 10px;
            margin-left: 0px;
            margin-right: 0px;
            width: 98%;
            font-size: 15px;
        }

        .span12 {
            width: 98%;
        }

        .labelroomnumber {
            position: relative;
            font-size: 15px;
            float: left;
            margin-top: 15px;
        }

        .textone {
            margin-top: 12px;
        }

        .rightOne {
            margin-right: 50px;
            font-size: 15px;
        }

        .table th, .table td {
            text-align: center;
        }

        .theadone {
            background-color: #CCFF99;
        }

        .roomnumberwidth {
            width: 60%;
        }

        .heigthone {
            height: 25px;
        }

        .widthone {
            width: 100%;
        }

        .widthtwo {
            width: 100%;
        }

        .XuanXiangKa {
        . active
        }

    </style>


<body>
<div class="container" style="height:630px;overflow-x:auto;">
    <div class="span12" style="margin-top:10px;">
        <div class="row-fluid">
               <div class="span6">
                <label style="float:left;">订货日期：</label>
                <!--最大日期为 id="datemax"的选中值或者当前系统日期-->
                <input style="width:25%;height:26px;" type="text" id="datemin" class="input-text Wdate"
                       onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" value="${min}"> ~
                <!--最大日期为当前系统日期，最小日期为id="datemin选中值"-->
                <input style="width:25.5%;height:26px;" type="text" id="datemax" class="input-text Wdate"
                       onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" value="${max}">
               </div>
                <div class="span6">
                    <label style="float:left;">联系电话：</label>
                    <input id="contactPhoneNumber" name="contactPhoneNumber" class="tnput-text" style="width:54.5%;height:26px;" type="text"  value="${agID}">
                </div>
        </div>
        <div class="row-fluid">
                <div class="span6">
                    <label style="float:left;">经营店铺：</label>
                    <input id="stID" name="stID" class="tnput-text" style="width:54.5%;height:26px;" type="text"  value="${sID}"
                    <c:if test="${sessionScope.userPo.roleID ==1}">readonly="readonly"</c:if>>
                </div>
                <div class="span6">
                    <label style="float:left;">安装师傅：</label>
                    <input id="installPerson" name="installPerson" class="tnput-text" style="width:54.5%;height:26px;" type="text"  value="${instPerson}">
                </div>
        </div>
        <div class="row-fluid">
                <div class="span6">
                    <label style="float:left;">客户住址：</label>
                    <input id="unitsOrAddress" name="unitsOrAddress" class="tnput-text" style="width:54.5%;height:26px;" type="text"  value="${merN}">
                    <button onclick="timeSelect()" type="button" class="btn-success" style="margin-top:-12px;height:25px;">
                        <li class="icon-search icon-white"></li>
                        查询
                    </button>
                    <%--合同号--%>
                    <!-- <button onclick="particulars()" type="button" class="btn-info" style="margin-top:-12px;height:25px;">
                        <li class="icon-zoom-in icon-white"></li>
                        详情
                    </button> -->
                </div>
                <div class="span6">
                 <label style="float:left;">订单总金额：</label>
            	<label style="float:left;margin-right:15px;color:blue;">${sumMoney}</label>
            	<label style="float:left;">订单总定金额：</label>
            	<label style="float:left;margin-right:15px;color:blue;">${sumDepositMoney}</label>
            	<label style="float:left;">订单数量：</label>
            	<label style="float:left;color:red;">${sumCount}</label>
            	</div>
        </div>
        
        <div >
                <div class="span3">
                    <button class="btn btn-info btn-small textone" type="button" onclick="wlInstallWord()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>王力安装表</button>
                </div>
                <div class="span3">
                    <button class="btn btn-info btn-small textone" type="button" onclick="wlSurveyWord()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>王力测量表</button>
                </div>
                <div class="span3">
                    <button class="btn btn-info btn-small textone" type="button" onclick="wlFixWord()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>王力服务表</button>
                </div>
                <div class="span3">
	                <button class="btn btn-danger btn-small textone" type="button" onclick="yaKouWord()"
	                <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>垭口安装表</button>
	        	 </div>
	        	 <div class="span3">
                    <button class="btn btn-warning btn-small textone" type="button" onclick="ppInstallWord()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>盼盼安装表</button>
                </div>
                <div class="span3">
                    <button class="btn btn-warning btn-small textone" type="button" onclick="ppSurveyWord()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>盼盼测量表</button>
                </div>
                <div class="span3">
                    <button class="btn btn-warning btn-small textone" type="button" onclick="ppFixWord()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>>盼盼服务表</button>
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
                    <button class="btn btn-danger btn-small textone" type="button" onclick="deletefunction()"
                    <c:if test="${sessionScope.userPo.roleID ==1}">style="display:none"</c:if>><li class="icon-remove icon-white"></li>删除</button>
                </div>
                <!-- <div>
                	<button id="js-export" type="button" class="btn btn-primary">导出Excel</button>
                </div>-->
            </div>
        </div>
    </div>
    
    <div class="span12" style="margin-top:10px;">
        <div class="dgvone">
            <table class="table table-condensed table-bordered table-striped" id="tableid">
                <thead class="theadone">
                <tr>
                    <th>选择</th>
                    <th>订货日期</th>
                    <th>店铺</th>
                    <th>客户住址</th>
                    <th>联系电话1</th>
                    <th>型号</th>
                    <th>尺寸</th>
                    <th>方向</th>
                    <th>价格</th>
                    <th>安装师傅</th>
                    <th>定金</th>
                    <th>合同1</th>
                    <th>合同2</th>
                    <th>测量</th>
                    <th>门安装</th>
                    <th>锁安装</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <c:forEach items="${list.result}" var="item">
                    <tr>
                        <td><input type="radio" name="id" value="${item.id}"></td>
                        <td><fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${item.storeID}</td>
                        <td>${item.unitsOrAddress}</td>
                        <td>${item.contactPhoneNumber}</td>
                        <td>${item.model}</td>
                        <td>${item.doorSize}</td>
                        <td>${item.direction}</td>
                        <td>${item.price}</td>
                        <td>${item.installPerson}</td>
                        <td>
                            <a id="downloadsurvery" href="${ctx}/Download/download.do?filepath=${item.frontMoneyFilePath}" onclick="downloadSurVal()">
                                    <c:if test="${not empty item.frontMoneyFileName}">下载</c:if>
                            </a>
                        </td>
                        <td>
                            <a id="downloadistall" href="${ctx}/Download/download.do?filepath=${item.agreementPhotoPath}" onclick="downloadIstallVal()">
                                    <c:if test="${not empty item.agreementPhotoName}">下载</c:if>
                            </a>
                        </td>
                        <td>
                            <a id="downloadsurvery" href="${ctx}/Download/download.do?filepath=${item.seAgreementPhotoPath}" onclick="downloadSurVal()">
                                    <c:if test="${not empty item.seAgreementPhotoName}">下载</c:if>
                            </a>
                        </td>
                        <td>
                            <a id="downloadsurvery" href="${ctx}/Download/download.do?filepath=${item.surveyorPhotoPath}" onclick="downloadSurVal()">
                                    <c:if test="${not empty item.surveyorPhotoName}">下载</c:if>
                            </a>
                        </td>
                        <td>
                            <a id="downloadistall" href="${ctx}/Download/download.do?filepath=${item.istallPhotoPath}" onclick="downloadIstallVal()">
                                    <c:if test="${not empty item.istallPhotoName}">下载</c:if>
                            </a>
                        </td>
                        <td>
                            <a id="downloadsurvery" href="${ctx}/Download/download.do?filepath=${item.smartLockFilePath}" onclick="downloadSurVal()">
                                    <c:if test="${not empty item.smartLockFileName}">下载</c:if>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="span11">
        <div class="row-fluid">
            <div class="tcdPageCode" style="text-align:center;"></div>
        </div>
    </div>
</div>


<script type="text/javascript">

	$('#js-export').click(function(){
	    //window.location.href="${ctx}/excel/exportfeedback?type="+$('#type').val()+"&startDate="+$('#table_start_date').val()+"&endDate="+$('#table_end_date').val();
		window.location.href="${ctx}/ParametersHandle/exportfeedback.do";
	});

    function timeSelect() {
        var datemin = document.getElementById("datemin").value;
        var datemax = document.getElementById("datemax").value;
        var unitsOrAddress = document.getElementById("unitsOrAddress").value;
        var contactPhoneNumber = document.getElementById("contactPhoneNumber").value;
        var stID = document.getElementById("stID").value;
        var installPerson = document.getElementById("installPerson").value;
        parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/tolist.do?datemin=' +
            datemin + '&datemax=' + datemax +'&contactPhoneNumber=' + contactPhoneNumber+'&unitsOrAddress=' + 
            unitsOrAddress+'&userID=' + ${sessionScope.userPo.id}+'&stID=' + stID+'&installPerson='+installPerson;
    }
    function wlInstallWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/wlInstallWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    function ppInstallWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/ppInstallWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    function wlSurveyWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/wlSurveyWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    function ppSurveyWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/ppSurveyWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    function wlFixWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/wlFixWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    function ppFixWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/ppFixWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    function yaKouWord() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
        });
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/yaKouWord.do?id='
                + id;
        } else {
            alert("请选择一条数据");
        }
    }
    
    function particulars() {
        var id = [];
        var table = document.getElementById("tbody");
        var selectedIndex = "";
        var stayregisterdetailsId = "";
        var datemin = document.getElementById("datemin").value;
        var datemax = document.getElementById("datemax").value;
        $('input[name="id"]:checked').each(function () {             // 遍历获取input被checked的
            id.push($(this).val());                             // 获取选中的ID
            selectedIndex = this.parentNode.parentNode.rowIndex;
            /*stayregisterdetailsId = table.rows[selectedIndex - 1].cells[9].innerHTML;*/
        });
        /*if (stayregisterdetailsId == "") {
            alert("请选择一条数据再按 详情");
            return false;
        }*/
        if (id != "") {
            parent.document.getElementById('Mainid').src = '${ctx}/ParametersHandle/toinformation.do?id='
                + id + '&stayregisterdetailsId=' + stayregisterdetailsId + '&min=' + datemin + '&max=' + datemax;
        } else {
            alert("请选择一条数据再按 详情");
        }
    }
    

    function addfunction(){
        parent.document.getElementById('Mainid').src='${ctx}/ParametersHandle/toadd.do';
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
                parent.document.getElementById("Mainid").src='${ctx}/ParametersHandle/toupdate.do?id='+chk_value;
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
                parent.document.getElementById("Mainid").src='${ctx}/ParametersHandle/delete.do?id='+chk_value+'&userID=${sessionScope.userPo.id}';
            }
        }else{
            alert("请选择一条或多条数据进行删除");
        }
    }
    
    /* 分页要用的 */
    $(".tcdPageCode").createPage({
        pageCount:${list.totalPage},
        current:${list.currentPage},
        backFn: function (p) {
            var datemin = document.getElementById("datemin").value;
            var datemax = document.getElementById("datemax").value;
            var unitsOrAddress = document.getElementById("unitsOrAddress").value;
            var stID = document.getElementById("stID").value;
            var installPerson = document.getElementById("installPerson").value;
            location.href = "${ctx}/ParametersHandle/tolist.do?currentPage=" + p +
                "&datemin=" + datemin + "&datemax=" + datemax+'&unitsOrAddress=' + 
            unitsOrAddress+'&userID=' + ${sessionScope.userPo.id}+'&stID=' + stID +
            '&installPerson='+installPerson;
        }
    });
    
</script>

</body>
</html>
