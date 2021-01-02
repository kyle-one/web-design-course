<%--
  Created by IntelliJ IDEA.
  User: kyle
  Date: 20/12/30
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新增部门</title>

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
<div style="padding: 30px 20%;">
    <p>
    <h4>输入部门基本信息</h4>
    <br>

        <%
            String pname=request.getParameter("pname");
            String type=request.getParameter("type");
            String pnum=request.getParameter("pnum");
            String authorizedStrength=request.getParameter("authorizedStrength");
            if(pname==null){pname=" ";}
            if(type==null){type=" ";}
            if(authorizedStrength==null){authorizedStrength=" ";}
            if(pname=="undefined"){pname=" ";}
            if(type=="undefined"){type=" ";}
            if(authorizedStrength=="undefined"){authorizedStrength=" ";}

        %>


    </p>
    <div id="createDialog" class="crudDialog">
        <form id="newForm" action="${pageContext.request.contextPath }/PostUpdate" method="post">
            <div class="form-group" hidden>
                <label for="pnum" class="active">编号</label>
                <input id="pnum" name="pnum" type="text" value="<%=pnum%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="pname" class="active">名称</label>
                <input id="pname" name="pname" type="text"  value="<%=pname%>" class="form-control">
            </div>
            <div class="form-group" >
                <label for="authorizedStrength" class="active">岗位编制</label>
                <input id="authorizedStrength" name="authorizedStrength" type="text"  value="<%=authorizedStrength%>" class="form-control">
            </div>


            <div class="form-group">
                <select class="form-control"  name="type" id="type">
                    <option >(请选择岗位类型)</option>
                    <option>管理</option>
                    <option>技术</option>
                    <option>销售</option>
                    <option>市场</option>
                </select>
            </div>
            <a class="waves-effect waves-button" href="javascript:;" onclick="Sure()"><i class="zmdi zmdi-seat"></i> 提交</a>


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


    function Sure() {
        if(checkEmpty1()==0){
            return 0;
        }
        else{
            console.log(document.getElementById("newForm"))
            document.getElementById("newForm").submit();

        }
    }

    function checkEmpty1() {
        var type = $('#type').val();
        var pname = $('#pname').val();
        if (pname == null || pname == ""|| type == null || type == "") {
            alert("有必填项还未填写！");
            return 0;
        }
        else{
            return 1;
        }
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

