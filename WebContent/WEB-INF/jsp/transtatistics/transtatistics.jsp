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
                <label style="float:left;">下单日期：</label>
                <!--最大日期为 id="datemax"的选中值或者当前系统日期-->
                <input style="width:25%;height:26px;" type="text" id="datemin" class="input-text Wdate"
                       onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" value="${min}"> ~
                <!--最大日期为当前系统日期，最小日期为id="datemin选中值"-->
                <input style="width:25.5%;height:26px;" type="text" id="datemax" class="input-text Wdate"
                       onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" value="${max}">
                <div>
                    <label style="float:left;">合同编号：</label>
                    <input id="agreementID" name="agreementID" class="tnput-text" style="width:54.5%;height:26px;" type="text"  value="${agID}">
                    <button onclick="timeSelect()" type="button" class="btn-success" style="margin-top:-12px;height:25px;">
                        <li class="icon-search icon-white"></li>
                        查询
                    </button>
                    <%--合同号--%>
                    <button onclick="particulars()" type="button" class="btn-info" style="margin-top:-12px;height:25px;">
                        <li class="icon-zoom-in icon-white"></li>
                        详情
                    </button>
                </div>
            </div>
            <label style="float:left;">订单总金额：</label>
            <label style="float:left;margin-right:15px;color:blue;">${sumMoney}</label>
            <label style="float:left;">订单数量：</label>
            <label style="float:left;color:red;">${sumCount}</label>
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
    </div>
    <div class="span12" style="margin-top:10px;">
        <div class="dgvone">
            <table class="table table-condensed table-bordered table-striped" id="tableid">
                <thead class="theadone">
                <tr>
                    <th>选择</th>
                    <th>合同编号</th>
                    <th>交款凭证ID</th>
                    <th>产品型号</th>
                    <th>订单金额</th>
                    <th>定金</th>
                    <th>下单日期</th>
                    <th>交款日期</th>
                    <th>客户名称</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <c:forEach items="${list.result}" var="item">
                    <tr>
                        <td><input type="radio" name="id" value="${item.id}"></td>
                        <td>${item.agreementID}</td>
                        <td>${item.paymentID}</td>
                        <td>${item.model}</td>
                        <td>${item.price}</td>
                        <td>${item.deposit}</td>
                        <td><fmt:formatDate value="${item.playDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                        <td><fmt:formatDate value="${item.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                        <td>${item.merName}</td>
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


    function timeSelect() {
        var datemin = document.getElementById("datemin").value;
        var datemax = document.getElementById("datemax").value;
        var agreementID = document.getElementById("agreementID").value;
        parent.document.getElementById('Mainid').src = '${ctx}/TranStatistics/tolist.do?datemin=' +
            datemin + '&datemax=' + datemax +'&agreementID=' + agreementID+'&userID=${sessionScope.userPo.id}';
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
            parent.document.getElementById('Mainid').src = '${ctx}/TranStatistics/toinformation.do?id='
                + id + '&stayregisterdetailsId=' + stayregisterdetailsId + '&min=' + datemin + '&max=' + datemax;
        } else {
            alert("请选择一条数据再按 详情");
        }
    }


    /* 分页要用的 */
    $(".tcdPageCode").createPage({
        pageCount:${list.totalPage},
        current:${list.currentPage},
        backFn: function (p) {
            var datemin = document.getElementById("datemin").value;
            var datemax = document.getElementById("datemax").value;
            location.href = "${ctx}/TranStatistics/tolist.do?currentPage=" + p +
                "&datemin=" + datemin + "&datemax=" + datemax+"&userID=${sessionScope.userPo.id}";
        }
    });

    function addfunction(){
        parent.document.getElementById('Mainid').src='${ctx}/TranStatistics/toadd.do';
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
                parent.document.getElementById("Mainid").src='${ctx}/TranStatistics/toupdate.do?id='+chk_value;
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
                parent.document.getElementById("Mainid").src='${ctx}/TranStatistics/delete.do?id='+chk_value
                    +'&userID=${sessionScope.userPo.id}';
            }
        }else{
            alert("请选择一条或多条数据进行删除");
        }
    }
</script>

</body>
</html>
