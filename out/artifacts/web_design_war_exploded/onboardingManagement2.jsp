<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>人才库入职</title>

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
		<div id="main">

			<form class="form-inline " style="padding: 1% 0% 0% 1%;" role="form">


				<div class="form-group ">
					<input type="text" class="form-control" id="name" name="name" placeholder="姓名">
				</div>
				<div class="form-group ">
					<input type="text" class="form-control" id="idcardNo" name="idcardNo" placeholder="身份证号">
				</div>
				<a  href="javascript:;" onclick="Search()" class="btn btn-primary" style="font-size: 15px;"> 查找</a>
				<a class="btn btn-primary" href="javascript:;" onclick="createAction()" style="font-size: 15px;">员工入职</a>
			</form>


			<table id="table"></table>
		</div>
		<!-- 新增 -->

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
					url: 'GetSTPByNIServlet',
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
					columns: [{
							field: 'state',
							checkbox: true
						},
						{
							field: 'id',
							title: '编号',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'name',
							title: '姓名',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'sex',
							title: '性别',
							sortable: true,
							halign: 'center'
						},

						{
							field: 'phone',
							title: '联系电话',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'idcardNo',
							title: '身份证号',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'email',
							title: '邮箱',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'formOfEmployment',
							title: '用工类型',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'sourceOfStaff',
							title: '人员来源',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'politicCountenance',
							title: '政治面貌',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'nation',
							title: '民族',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'nativePlace',
							title: '籍贯',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'height',
							title: '身高',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'bloodType',
							title: '血型',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'maritalStatus',
							title: '婚姻状况',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'birthPlace',
							title: '出生地',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'Hukou',
							title: '户口所在地',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'highestEducation',
							title: '最高学历',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'highestDegree',
							title: '最高学位',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'university',
							title: '毕业院校',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'majors',
							title: '所学专业',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'dateOfGraduation',
							title: '毕业日期',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'entryDate',
							title: '入职日期',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'workDate',
							title: '参加工作日期',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'pid',
							title: '岗位编号',
							sortable: true,
							halign: 'center'
						},{
							field: 'did',
							title: '部门编号',
							sortable: true,
							halign: 'center'
						},{
							field: 'maritalStatus',
							title: '婚姻状况',
							sortable: true,
							halign: 'center'
						},

					]
				}).on('all.bs.table', function(e, name, args) {
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
				'click .like': function(e, value, row, index) {
					alert('You click like icon, row: ' + JSON.stringify(row));
					console.log(value, row, index);
				},
				'click .edit': function(e, value, row, index) {
					alert('You click edit icon, row: ' + JSON.stringify(row));
					console.log(value, row, index);
				},
				'click .remove': function(e, value, row, index) {
					alert('You click remove icon, row: ' + JSON.stringify(row));
					console.log(value, row, index);
				}
			};

			function detailFormatter(index, row) {
				var html = [];
				$.each(row, function(key, value) {
					html.push('<p><b>' + key + ':</b> ' + value + '</p>');
				});
				return html.join('');
			}
			// 新增
			function createAction() {
				var rows = $table.bootstrapTable('getSelections');
				if (rows.length !=1) {
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


					window.location.href='AddStaffFromTP?id='+rows[0].id+'&'+'sex='+rows[0].sex+'&'+'birthDate='+rows[0].birthDate
							+'&'+'idcardNo='+rows[0].idcardNo+'&'+'formOfEmployment='+rows[0].formOfEmployment+'&'+'sourceOfStaff='+rows[0].sourceOfStaff+'&'+'politicCountenance='+rows[0].politicCountenance+'&'+'nation='+rows[0].nation
							+'&'+'nativePlace='+rows[0].nativePlace+'&'+'phone='+rows[0].phone+'&'+'email='+rows[0].email+'&'+'height='+rows[0].height
							+'&'+'name='+rows[0].name+'&'+'maritalStatus='+rows[0].maritalStatus+'&'+'birthPlace='+rows[0].birthPlace+'&'+'hukou='+rows[0].hukou
							+'&'+'highestEducation='+rows[0].highestEducation+'&'+'highestDegree='+rows[0].highestDegree+'&'+'university='+rows[0].university+'&'+'majors='+rows[0].majors
							+'&'+'dateOfGraduation='+rows[0].dateOfGraduation+'&'+'entryDate='+rows[0].entryDate+'&'+'workDate='+rows[0].workDate+'&'+'bloodType='+rows[0].bloodType
							+'&'+'pid='+rows[0].pid+'&'+'did='+rows[0].did


				}

			}
			function Search() {
				var name=$('#name').val();
				var idcardNo=$('#idcardNo').val();

				$('#table').bootstrapTable('refresh',
						{
							url:'GetSTPByNIServlet?name='+name+'&'+'idcardNo='+idcardNo
						}
				)
			}
		</script>
	</body>
</html>
