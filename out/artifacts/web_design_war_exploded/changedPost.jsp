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
        <input type="date" class="form-control3" name="starttime" id="starttime" placeholder="开始时间" style="width: 120px">
        <input type="date" class="form-control3" name="endtime" id="endtime" placeholder="结束时间" style="width: 120px">
        <input type="text" class="form-control3" name="sid" id="sid" placeholder="员工编号" style="width: 120px">
        <input type="text" class="form-control3" name="sname" id="sname" placeholder="员工姓名" style="width: 120px">
        <input type="text" class="form-control3" name="type" id="type" placeholder="类型" style="width: 120px">
        <a class="waves-effect waves-button" href="javascript:;" onclick="Search()"><i class="zmdi zmdi-search"></i> 查找</a>
    </div>
    <table id="table"></table>
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
            url: 'getPostTransfer',
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
                {field: 'sid', title: '编号', sortable: true, halign: 'center'},
                {field: 'name', title: '姓名', sortable: true, halign: 'center'},
                {field: 'pid1', title: '前岗位编号', sortable: true, halign: 'center'},
                {field: 'pid2', title: '现岗位编号', sortable: true, halign: 'center'},
                // {field: 'dname', title: '部门名称', sortable: true, halign: 'center'},
                {field: 'tdate', title: '调动时间', sortable: true, halign: 'center'},
                {field: 'reason', title: '调动原因', sortable: true, halign: 'center'},
                {field: 'postname', title: '调动方式', sortable: true, halign: 'center'},
                {field: 'remarks', title: '备注', sortable: true, halign: 'center'},
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
        var starttime = $('#starttime').val();
        var endtime = $('#endtime').val();
        var sid = $('#sid').val();
        var sname = $('#sname').val();
        var type = $('#type').val();

        // console.log(dname);

        $('#table').bootstrapTable('refresh',
            {
                url: 'getPostTransfer?starttime=' + starttime + '&' +
                    'endtime=' + endtime + '&' +
                    'sid=' + sid + '&' +
                    'sname=' + sname + '&' +
                    'type=' + type

            }
        );
    }
</script>
</body>
</html>