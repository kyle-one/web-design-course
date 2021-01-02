<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/1/1
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工离职</title>

    <link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <script src="resources/plugins/select2/js/select2.min.js"></script>
    <link href="resources/css/common.css" rel="stylesheet"/>
</head>
<body>
<div style="padding: 30px 20%;">
    <p>
    <h4>员工离职</h4>
    </p>
    <div id="createDialog" class="crudDialog">
        <form action="${pageContext.request.contextPath }/DeleteStaffServlet2" method="post" onsubmit="return checkEmpty1()">
            <div hidden>

                    <input id="id" name="id" type="text" class="form-control" value="${s.id}">

                    <input id="name" name="name" type="text" class="form-control" value="${s.name}">

                    <input type="text" name="sex" id="sex" class="form-control" value="${s.sex}">

                    <input id="birthDate" name="birthDate" type="text" class="form-control" value="${s.birthDate}">

                    <input id="idcardNo" name="idcardNo" type="text" class="form-control" value="${s.idcardNo}">

                    <input type="text" name="formOfEmployment" id="formOfEmployment" class="form-control" value="${s.formOfEmployment}">

                    <input type="text" name="sourceOfStaff" id="sourceOfStaff" class="form-control" value="${s.sourceOfStaff}">

                    <input type="text" name="politicCountenance" id="politicCountenance" class="form-control" value="${s.politicCountenance}">

                    <input type="text" name="nation" id="nation" class="form-control" value="${s.nation}">

                    <input id="nativePlace" name="nativePlace" type="text" class="form-control" value="${s.nativePlace}">

                    <input id="phone" name="phone" type="text" class="form-control" value="${s.phone}">

                    <input id="email" name="email" type="text" class="form-control" value="${s.email}">

                    <input id="height" name="height" type="text" class="form-control" value="${s.height}">

                    <input type="text" name="bloodType" id="bloodType" class="form-control" value="${s.bloodType}">

                    <input type="text" name="maritalStatus" id="maritalStatus" class="form-control" value="${s.maritalStatus}">

                    <input id="birthPlace" name="birthPlace" type="text"
                           class="form-control" value="${s.birthPlace}">

                    <input id="Hukou" name="Hukou" type="text" class="form-control"value="${s.hukou}">

                    <input type="text" name="highestEducation" id="highestEducation "
                           class="form-control" value="${s.highestEducation}">
                    <input type="text" name="highestDegree" id="highestDegree"
                           class="form-control" value="${s.highestDegree}">
                    <input id="university" name="university" type="text"
                           class="form-control" value="${s.university}">

                    <input id="majors" name="majors" type="text"
                           class="form-control" value="${s.majors}">

                    <input id="dateOfGraduation" name="dateOfGraduation" type="text"
                           class="form-control" value="${s.dateOfGraduation}">

                    <input type="text" name="did" id="did" class="form-control" value="${s.did}">
                    <input type="text" name="pid" id="pid" class="form-control" value="${s.pid}">
                    <input type="text" id="entryDate" name="entryDate" type="text"
                           class="form-control" value="${s.entryDate}">
                    <input type="text" id="workDate" name="workDate" type="text"
                           class="form-control" value="${s.workDate}">

            </div>
            <br>
            <div class="form-group">
                <label for="departureDate" class="active">离职日期</label>
                <input id="departureDate" name="departureDate" type="date" class="form-control">
            </div>
            <div>
                <select name="type" id="type" class="form-control">
                    <option value="">(请选择离职类型)</option>
                    <option value="主动辞职">主动辞职</option>
                    <option value="辞退">辞退</option>
                    <option value="退休">退休</option>
                    <option value="开除">开除</option>
                    <option value="试用期未通过">试用期未通过</option>
                </select>
            </div>
            <br>
            <div class="form-group">
                <label for="direction">离职去向</label>
                <input id="direction" name="direction" type="text" class="form-control">
            </div>
            <div class="form-group">
                <label for="enterTalentPool">是否进入人才库</label>
                <input id="enterTalentPool" name="enterTalentPool" type="text" class="form-control">
            </div>
            <div class="form-group">
                <label for="remarks">备注</label>
                <input id="remarks" name="remarks" type="text" class="form-control">
            </div>
            <input type="submit" value="提交" class="btn btn-primary" style="font-size: 15px;">
<%--            <a class="waves-effect waves-button" href="javascript:;" onclick="Sure()"><i class="zmdi zmdi-seat"></i> 提交</a>--%>
        </form>
    </div>

</div>

<script src="resources/plugins/jquery.1.12.4.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="resources/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="resources/plugins/waves-0.7.5/waves.min.js"></script>
<script src="resources/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<script src="resources/plugins/select2/js/select2.min.js"></script>


<script src="resources/js/common.js"></script>


<script>

    function checkEmpty1() {
        var result = document.getElementById("departureDate");
        if (result.value == null || result.value == "") {
            alert("请填写离职日期，该项为必填项");
            return false;
        }
        var result = document.getElementById("type");
        if (result.value == null || result.value == "") {
            alert("请填写离职类型，该项为必填项");
            return false;
        }
        var result = document.getElementById("direction");
        if (result.value == null || result.value == "") {
            alert("请填写离职去向，该项为必填项");
            return false;
        }
        return true;

    }

</script>
<script src="resources/plugins/jquery.1.12.4.min.js"></script>
<script src="resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="resources/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="resources/plugins/waves-0.7.5/waves.min.js"></script>
<script src="resources/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<script src="resources/plugins/select2/js/select2.min.js"></script>


<script src="resources/js/common.js"></script>

</body>
</html>

