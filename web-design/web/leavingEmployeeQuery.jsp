<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>

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
					<input type="text" style="width: 120px;" class="form-control" id="id" name="id" placeholder="员工编号">
				</div>
				<div class="form-group ">
					<input type="text"  style="width: 120px;"class="form-control"  id="name" name="name" placeholder="姓名">
				</div>
				<div class="form-group ">
					<input type="text" style="width: 120px;"class="form-control" id="dname" name="dname" placeholder="部门名称">
				</div>
				<div class="form-group ">
					<input type="text"style="width: 120px;" class="form-control"  id="pname" name="pname" placeholder="岗位名称">
				</div>
				<div class="form-group ">
					<input type="text" style="width: 120px;"class="form-control" id="type" name="type" placeholder="离职类型">
				</div>
				<div class="input-group">
					<span class="input-group-addon">开始时间</span>
					<input type="date" style="width: 155px;" class="form-control" placeholder="twitterhandle" id="startDate" name="startDate">
				</div>
				<div class="input-group">
					<span class="input-group-addon">结束时间</span>
					<input type="date" style="width: 155px;" class="form-control" placeholder="twitterhandle" id="endDate" name="endDate">
				</div>
				<a  href="javascript:;" onclick="Search()" class="btn btn-primary" style="font-size: 15px;"> 查找</a>
			</form>
			
			<table id="table"></table>
		</div>
		<!-- 新增 -->

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
					url: 'GetStaffQuitByINDPTSE',
					height: getHeight(),
					striped: true,
					search: false,
					searchOnEnterKey:false,
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
							field: 'did',
							title: '原部门号',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'pid',
							title: '原岗位号',
							sortable: true,
							halign: 'center'
						},
						{
							field: 'quitDate',
							title: '离职时间',
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
			$(document).ready(function() {
				var time = new Date();
				var day = ("0" + time.getDate()).slice(-2);
				var month = ("0" + (time.getMonth() + 1)).slice(-2);
				var today = time.getFullYear() + "-" + (month) + "-" + (day);
				var nowMonthFirstDay = time.getFullYear() + "-" + (month) + "-" + ("01");

				$('#beginTime').val(nowMonthFirstDay); //开始日期的id：beginTime
				$('#endTime').val(today); //结束日期的id endTime

			})
			function Search() {
				var id=$('#id').val();
				var name=$('#name').val();
				var dname=$('#dname').val();
				var pname=$('#pname').val();
				var type=$('#type').val();
				var startDate=$('#startDate').val();
				var endDate=$('#endDate').val();
				$('#table').bootstrapTable('refresh',
						{

							url:'GetStaffQuitByINDPTSE?id='+id+'&'+'name='+name+'&'
									+'dname='+dname+'&'+'pname='+pname+'&'+'type='+type+'&'+'startDate='+startDate+'&'+'endDate='+endDate

						}
				)

			}
		</script>
	</body>
</html>
