<%@ page import="com.staffmanage.entity.Department" %>
<%@ page import="com.staffmanage.dao.Imp.changeDepartmentImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.staffmanage.entity.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--
  Created by IntelliJ IDEA.
  User: kkans
  Date: 2021/1/2
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>更新</title>

    <link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet" />
    <link href="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet" />
    <link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet" />
    <link href="resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet" />
    <link href="resources/plugins/select2/css/select2.min.css" rel="stylesheet" />
    <script src="resources/plugins/select2/js/select2.min.js"></script>
    <link href="resources/css/common.css" rel="stylesheet" />
</head>
<body>
<%
    String sid = request.getParameter("sid");
    String pid1 = request.getParameter("pid");
%>
<div id="changeDataDialog" class="crudDialog" style="padding: 30px 20%;">
    <form action="${pageContext.request.contextPath }/updateChangePost" method="post" id="justform2">
        <%
            List<Post> postList;
            //List<Department> departmentList;

            changeDepartmentImp cdd = new changeDepartmentImp();

            //departmentList = cdd.getAllDepartment();
            postList = cdd.getAllPost();
        %>
        <div class="form-group">
            <a style="font-size: 16px;">员工ID：</a><br>
            <input type="text" class="form-control" value="<%=sid%>" name="sid" >
            <a style="font-size: 16px;">原岗位：</a><br>
            <input type="text" class="form-control" value="<%=pid1%>" name="pid1" >
            <a style="font-size: 16px;">调入岗位：</a><br>
            <select class="form-control2" name="pid2">
                <%for (int i = 0; i < postList.size(); i++) {%>
                <option id="<%=postList.get(i).getPname()%>" value="<%=postList.get(i).getPnum()%>"><%=postList.get(i).getPname()%>
                </option>
                <%}%>
            </select><br>
            <a style="font-size: 16px;">调动方式：</a><br>
            <select class="form-control2" name="type" style="margin-bottom: 10px">
                <option id="activeChange" value="1">主动调动</option>
                <option id="passiveChange" value="2">被动调动</option>
            </select><br>
            <a style="font-size: 16px;">调动时间：</a>
            <input type="date" class="form-control" name="tdate" style="width: 30%;margin-bottom: 10px;">
            <a style="font-size: 16px;">调动原因：</a>
            <input type="text" class="form-control" name="reason">
            <a style="font-size: 16px;">备注：</a><br>
            <input type="text" class="form-control" name="remarks"><br>
            <button href="javascript:updateAction()" class="btn btn-default">更新</button>
        </div>
    </form>
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
    function updateAction() {
        // if(checkEmpty()==0){
        //     return 0;
        // }
            //console.log(document.getElementById("justform"))
            document.getElementById("justform2").submit();
        // var did2 = $("#departmentGroup  option:selected").val();
        // var tdate = $('#tdate').val();
        // var type = $('#type').val();
        // var reason = $('#reason').val();
        // var remarks = $('#remarks').val();
        // var sid;
        // var did1;
        // $.each(row, function (i, item) {
        //     sid = item.id;
        //     did1 = item.did;
        // })
        // console.log($("#departmentGroup").find("option:selected").val())
        //
        //
        // $('#table').bootstrapTable('refresh',
        //     {
        //         url: 'updateChange?sid=' + sid + '&' +
        //             'did1=' + did1 + '&' +
        //             'did2=' + did2 + '&' +
        //             'tdate=' + tdate + '&' +
        //             'reason=' + reason + '&' +
        //             'remarks=' + remarks + '&' +
        //             'type=' + type
        //     }
        // );
    }
    function checkEmpty() {
        var sid = $('#sid').val();
        var did1 = $('#did1').val();
        var did2 = $('#did2').val();
        var tdate = $('#tdate').val();
        var reason = $('#reason').val();
        var remarks = $('#remarks').val();
        //consloe.log(dnum,dname,type,phone,des,parent,)
        // if (dname == null || dname == ""|| type == null || type == ""|| phone == null || phone == ""|| establishDate == null || establishDate == "") {
        //     alert("有必填项还未填写！");
        //     return 0;
        // }
        // else{
        //     return 1;
        // }
    }
</script>

</body>
</html>
