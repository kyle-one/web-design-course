<%@ page import="java.util.List" %>
<%@ page import="com.staffmanage.entity.Department" %>
<%@ page import="com.staffmanage.entity.Post" %>
<%@ page import="com.staffmanage.dao.Imp.changeDepartmentImp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>部门调动</title>

    <link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="resources/css/form2.css" rel="stylesheet"/>

    <link href="resources/css/common.css" rel="stylesheet"/>
</head>
<body>
<div id="main" style="margin-top: 10px">
    <!-- 未调职 or 已调职 -->
    <div id="toolbar">
        <input type="text" class="form-control3" name="did" id="did" placeholder="部门编号" style="width: 120px">
        <input type="text" class="form-control3" name="dname" id="dname" placeholder="部门名称" style="width: 120px">
        <input type="text" class="form-control3" name="sid" id="sid" placeholder="员工编号" style="width: 120px">
        <input type="text" class="form-control3" name="sname" id="sname" placeholder="员工姓名" style="width: 120px">
        <a class="waves-effect waves-button" href="javascript:;" onclick="Search()"><i class="zmdi zmdi-search"></i> 查找</a>

        <!--<input type="button" class="btn btn-default dropdown-toggle" id="btn_query" value="搜索"
               style="margin-bottom: 5px;">-->
    </div>
    <table id="table"></table>
</div>
<!--编辑信息-->
<div id="changeDataDialog" class="crudDialog" hidden>
    <form>
        <%
            //List<Post> postList;
            List<Department> departmentList;

            changeDepartmentImp cdd = new changeDepartmentImp();

            departmentList = cdd.getAllDepartment();
            //postList = cdd.getAllPost();
        %>
        <div class="form-group">
            <a style="font-size: 16px;">调入部门：</a><br>
            <select class="form-control2" id="departmentGroup">
                <%for (int i = 0; i < departmentList.size(); i++) {%>
                <option value="<%=departmentList.get(i).getDnum()%>"><%=departmentList.get(i).getDname()%>
                </option>
                <%}%>
            </select><br>
            <%--            <select class="form-control2" id="postGroup" style="margin-bottom: 10px">--%>
            <%--                <%for(int i=0;i<postList.size();i++){%>--%>
            <%--                    <option id="post<%=postList.get(i).getPnum()%>"><%=postList.get(i).getPname()%></option>--%>
            <%--                <%}%>--%>
            <%--            </select><br>--%>
            <a style="font-size: 16px;">调动方式：</a><br>
            <select class="form-control2" id="type" style="margin-bottom: 10px">
                <option id="activeChange" value="1">主动调动</option>
                <option id="passiveChange" value="2">被动调动</option>
                <%--                <option >数据错误</option>--%>
            </select><br>
            <a style="font-size: 16px;">调动时间：</a>
            <input type="date" class="form-control" id="tdate" style="width: 30%;margin-bottom: 10px;">
            <a style="font-size: 16px;">调动原因：</a>
            <input type="text" style="width: 100%;height: 100px" id="reason">
            <a style="font-size: 16px;">备注：</a><br>
            <input type="text" style="width: 100%;height: 100px" id="remarks"><br>
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

<script src="resources/js/changeDepartmnt.js"></script>
<script src="resources/js/common.js"></script>
<script>
    var $table = $('#table');
    $(function () {
        $(document).on('focus', 'input[type="text"]', function () {
            $(this).parent().find('label').addClass('active');
        }).on('blur', 'input[type="text"]', function () {
            if ($(this).val() == '') {
                $(this).parent().find('label').removeClass('active');
            }
        });
        // bootstrap table初始化
        // http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
        $table.bootstrapTable({
            url: 'changeDepartment',
            height: getHeight(),
            striped: false,
            search: false,
            searchOnEnterKey: false,
            showRefresh: false,
            showToggle: false,
            showColumns: false,
            minimumCountColumns: 2,
            showPaginationSwitch: false,
            clickToSelect: true,
            detailView: true,
            detailFormatter: 'detailFormatter',
            pagination: true,
            paginationLoop: false,
            classes: 'table table-hover table-no-bordered',
            //sidePagination: 'server',
            //silentSort: false,
            smartDisplay: false,
            idField: 'id',
            sortName: 'id',
            sortOrder: 'desc',
            escape: true,
            //searchOnEnterKey: true,
            //idField: 'systemId',
            maintainSelected: true,
            toolbar: '#toolbar',
            columns: [
                {field: 'state', checkbox: true},
                {field: 'id', title: '编号', sortable: true, halign: 'center'},
                {field: 'name', title: '姓名', sortable: true, halign: 'center'},
                {field: 'did', title: '部门编号', sortable: true, halign: 'center'},
                {field: 'dname', title: '部门名称', sortable: true, halign: 'center'},
                {field: 'pid', title: '岗位编号', sortable: true, halign: 'center'},
                {field: 'pname', title: '岗位名称', sortable: true, halign: 'center'},
                {
                    field: 'action',
                    title: '操作',
                    halign: 'center',
                    align: 'center',
                    formatter: 'actionFormatter',
                    clickToSelect: false
                }
            ],
        }).on('all.bs.table', function (e, name, args) {
            $('[data-toggle="tooltip"]').tooltip();
            $('[data-toggle="popover"]').popover();
        });
    });

    function actionFormatter(value, row, index) {
        return [
            '<a class="like" href="javascript:changeData()" data-toggle="tooltip" title="编辑"><i class="glyphicon glyphicon-edit"></i></a>　',
        ].join('');
    }

    function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }

    function Search() {
        var did = $('#did').val();
        var dname = $('#dname').val();
        var sid = $('#sid').val();
        var sname = $('#sname').val();
        console.log(dname);

        $('#table').bootstrapTable('refresh',
            {
                url: 'changeDepartment?did=' + did + '&' +
                    'dname=' + dname + '&' +
                    'sid=' + sid + '&' +
                    'sname=' + sname
            }
        );
    }


    //更新框
    function changeData() {
        var row = $table.bootstrapTable('getSelections');

        if (row.length === 0 || row.length > 1) {
            $.confirm({
                title: false,
                content: '请选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        } else {
            window.location.href = "changeDepartmentUpdate.jsp?"+
                "sid=" + row[0].id + "&" +
                "did=" + row[0].did;
        }
    }

</script>
</body>
</html>