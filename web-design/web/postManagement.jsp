<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>岗位管理</title>

	<link href="resources/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="resources/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
	<link href="resources/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
	<link href="resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
	<script src="resources/plugins/select2/js/select2.min.js"></script>
	
	<link href="resources/css/common.css" rel="stylesheet"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增岗位</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 修改岗位</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除岗位</a>
		<a class="waves-effect waves-button" href="javascript:;" onclick="searchAction()"><i class="zmdi zmdi-search"></i> 查询部门员工</a>


		<input class="form-control2" style="width:100px" id="pnumSearch" placeholder="岗位编号">
		<input class="form-control2" style="width:100px" id="pnameSearch" placeholder="名称">
		<input class="form-control2" style="width:100px" id="typeSearch" placeholder="类型">

		<a class="waves-effect waves-button" href="javascript:;" onclick="Search()"><i class="zmdi zmdi-search"></i> 查找</a>
	</div>
	<table id="table"></table>
</div>





<!-- 新增 -->
<div id="createDialog" class="crudDialog" hidden>
	<form>
		<div class="form-group">
			<label for="input1">编号</label>
			<input id="input1" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="input2">名称</label>
			<input id="input2" type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="input3">岗位编制</label>
			<input id="input3" type="text" class="form-control">
		</div>



		<div class="form-group">
			<select class="form-control">
				<option disabled>(请选择岗位类型)</option>
				<option>管理</option>
				<option>技术</option>
				<option>销售</option>
				<option>市场</option>
			</select>  
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
var $table = $('#table');
$(function() {
	$(document).on('focus', 'input[type="text"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="text"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});
	// bootstrap table初始化
	// http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
	$table.bootstrapTable({
		url: 'PostManage',
		height: getHeight(),
		striped: true,
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
		searchOnEnterKey: true,
		idField: 'systemId',
		maintainSelected: true,
		toolbar: '#toolbar',
		columns: [
			{field: 'state', checkbox: true},
			{field: 'pnum', title: '编号', sortable: true, halign: 'center'},
			{field: 'pname', title: '名称', sortable: true, halign: 'center'},
			{field: 'type', title: '岗位类型', sortable: true, halign: 'center'},
			{field: 'authorizedStrength', title: '岗位编制', sortable: true, halign: 'center'},
		]
	}).on('all.bs.table', function (e, name, args) {
		$('[data-toggle="tooltip"]').tooltip();
		$('[data-toggle="popover"]').popover();  
	});
});
function actionFormatter(value, row, index) {
    return [
        '<a class="like" href="javascript:void(0)" data-toggle="tooltip" title="Like"><i class="glyphicon glyphicon-heart"></i></a>　',
        '<a class="edit ml10" href="javascript:void(0)" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
        '<a class="remove ml10" href="javascript:void(0)" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}

window.actionEvents = {
    'click .like': function (e, value, row, index) {
        alert('You click like icon, row: ' + JSON.stringify(row));
        console.log(value, row, index);
    },
    'click .edit': function (e, value, row, index) {
        alert('You click edit icon, row: ' + JSON.stringify(row));
        console.log(value, row, index);
    },
    'click .remove': function (e, value, row, index) {
        alert('You click remove icon, row: ' + JSON.stringify(row));
        console.log(value, row, index);
    }
};
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}

//查找对应的下属员工列表
function searchAction() {
	var rows = $table.bootstrapTable('getSelections');
	console.log(rows);

	if (rows.length ==0 || rows.length>1) {
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
		console.log(rows[0].dnum);

		window.location.href="departmentSearch.jsp?"+"" +
				"dnameFromDep="+rows[0].dname
		//dnameFromDep=row.dname
		//Update();

	}
}




// 新增
function createAction() {
	window.location.href = "postAdd.jsp";
}
// 编辑
function updateAction() {
	var rows = $table.bootstrapTable('getSelections');
	console.log(rows);


	if (rows.length ==0 || rows.length>1) {
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
		console.log(rows[0].pnum);

		window.location.href="postUpdate.jsp?"+"" +
				"pnum="+rows[0].pnum+"&"+
				"pname="+rows[0].pname+"&"+
				"type="+rows[0].type+"&"+
				"authorizedStrength="+rows[0].authorizedStrength
		//Update();

	}
}

//查找岗位列表
function Search() {
	var pname= $('#pnameSearch').val();
	var pnum= $('#pnumSearch').val();
	var type= $('#typeSearch').val();
	console.log(pnum);
	setTimeout(function(){
		$('#table').bootstrapTable('refresh',
				{
					url:'PostManage?pname='+pname+'&'+
							'pnum='+pnum+'&'+
							'type='+type
				}

		);
	},500)
	//window.location.href = "temp";

}




// 删除
function Delete() {
	var rows = $table.bootstrapTable('getSelections');
	var i=0;
	var s="";
	for(i=0;i<rows.length;i++){
		s=s+rows[i].pnum;
		s+=','
	}
	//rows=rows[0].dname;
	console.log(s);
	$('#createDialog').bootstrapTable(
			{
				method:'get',
				url:'PostDelete',
				queryParams: {
					pnumList:s,
				}
			}
	)
}


function deleteAction() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length == 0) {
		$.confirm({
			title: false,
			content: '请至少选择一条记录！',
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
		Delete();
		$.confirm({
			title: "删除成功！",
			content: '删除成功！',
			backgroundDismiss: true,
			buttons: {
				yes: {
					text: '确定',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
		setTimeout(function(){
			$('#table').bootstrapTable('refresh',
					{
						url:'PostManage'
					}

			);
		},1000)

	}
}

</script>
</body>
</html>