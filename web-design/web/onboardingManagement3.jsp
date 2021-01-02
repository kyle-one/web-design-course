<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>人才库入职</title>

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
    <h4>基本信息录入</h4>
    </p>
    <hr>
    <form action="${pageContext.request.contextPath }/AddStaffFromTP2" method="post" onsubmit="return checkEmpty1()">
        <div class="form-group">
            <label for="id" class="active">编号</label>
            <input id="id" name="id" type="text" class="form-control" value="${s.id}" readonly>
        </div>
        <div class="form-group">
            <label for="name" class="active">姓名</label>
            <input id="name" name="name" type="text" class="form-control" value="${s.name}">
        </div>
        <div>
            <select name="sex" id="sex" class="form-control">
                <option value="">(请选择性别)</option>
                <option value="男" selected="selected">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <br>
        <div class="form-group">
            <label for="birthDate" class="active">出生日期</label>
            <input id="birthDate" name="birthDate" type="date" class="form-control" value="${s.birthDate}">
        </div>
        <div class="form-group">
            <label for="idcardNo" class="active">身份证号</label>
            <input id="idcardNo" name="idcardNo" type="text" class="form-control" value="${s.idcardNo}">
        </div>
        <div>
            <select name="formOfEmployment" id="formOfEmployment" class="form-control">
                <option value="">(请选择用工形式)</option>
                <option value="正式员工">正式员工</option>
                <option value="临时员工">临时员工</option>
            </select>
        </div>
        <hr>
        <div>
            <select name="sourceOfStaff" id="sourceOfStaff" class="form-control">
                <option value="">(请选择人员来源)</option>
                <option value="校园招聘">校园招聘</option>
                <option value="社会招聘">社会招聘</option>
                <option value="其他">其他</option>

            </select>
        </div>
        <hr>
        <div>
            <select name="politicCountenance" id="politicCountenance" class="form-control">
                <option value="">(请选择政治面貌)</option>
                <option value="党员">党员</option>
                <option value="预备党员">预备党员</option>
                <option value="团员">团员</option>
                <option value="其他">其他</option>

            </select>
        </div>
        <hr>
        <div>
            <select name="nation" id="nation" class="form-control">
                <option value="">(请选择民族)</option>
                <option value="汉族">汉族</option>
                <option value="蒙古族">蒙古族</option>
                <option value="回族">回族</option>
                <option value="藏族">藏族</option>
                <option value="维吾尔族">维吾尔族</option>
                <option value="苗族">苗族</option>
                <option value="彝族">彝族</option>
                <option value="壮族">壮族</option>
                <option value="布依族">布依族</option>
                <option value="朝鲜族">朝鲜族</option>
                <option value="满族">满族</option>
                <option value="侗族">侗族</option>
                <option value="瑶族">瑶族</option>
                <option value="白族">白族</option>
                <option value="土家族">土家族</option>
                <option value="哈尼族">哈尼族</option>
                <option value="哈萨克族">哈萨克族</option>
                <option value="傣族">傣族</option>
                <option value="黎族">黎族</option>
                <option value="傈僳族">傈僳族</option>
                <option value="佤族">佤族</option>
                <option value="畲族">畲族</option>
                <option value="高山族">高山族</option>
                <option value="拉祜族">拉祜族</option>
                <option value="水族">水族</option>
                <option value="东乡族">东乡族</option>
                <option value="纳西族">纳西族</option>
                <option value="景颇族">景颇族</option>
                <option value="柯尔克孜族">柯尔克孜族</option>
                <option value="土族">土族</option>
                <option value="达斡尔族">达斡尔族</option>
                <option value="仫佬族">仫佬族</option>
                <option value="羌族">羌族</option>
                <option value="布朗族">布朗族</option>
                <option value="撒拉族">撒拉族</option>
                <option value="毛南族">毛南族</option>
                <option value="仡佬族">仡佬族</option>
                <option value="锡伯族">锡伯族</option>
                <option value="阿昌族">阿昌族</option>
                <option value="普米族">普米族</option>
                <option value="塔吉克族">塔吉克族</option>
                <option value="怒族">怒族</option>
                <option value="乌孜别克族">乌孜别克族</option>
                <option value="俄罗斯族">俄罗斯族</option>
                <option value="鄂温克族">鄂温克族</option>
                <option value="德昂族">德昂族</option>
                <option value="保安族">保安族</option>
                <option value="裕固族">裕固族</option>
                <option value="京族">京族</option>
                <option value="塔塔尔族">塔塔尔族</option>
                <option value="独龙族">独龙族</option>
                <option value="鄂伦春族">鄂伦春族</option>
                <option value="赫哲族">赫哲族</option>
                <option value="门巴族">门巴族</option>
                <option value="珞巴族">珞巴族</option>
                <option value="基诺族">基诺族</option>
            </select>
        </div>
        <hr>
        <div class="form-group">
            <label for="nativePlace" class="active">籍贯</label>
            <input id="nativePlace" name="nativePlace" type="text" class="form-control" value="${s.nativePlace}">
        </div>
        <div class="form-group">
            <label for="phone" class="active">联系电话</label>
            <input id="phone" name="phone" type="text" class="form-control" value="${s.phone}">
        </div>
        <div class="form-group">
            <label for="email" class="active">电子邮件</label>
            <input id="email" name="email" type="text" class="form-control" value="${s.email}">
        </div>
        <div class="form-group">
            <label for="height" class="active">身高</label>
            <input id="height" name="height" type="text" class="form-control" value="${s.height}">
        </div>
        <div>
            <select name="bloodType" id="bloodType" class="form-control">
                <option value="">(请选择离职血型)</option>
                <option value="A型">A型</option>
                <option value="B型">B型</option>
                <option value="AB型">AB型</option>
                <option value="O型">O型</option>
                <option value="其他血型">其他血型</option>
            </select>
        </div>
        <hr>
        <div>
            <select name="maritalStatus" id="maritalStatus" class="form-control">
                <option value="">(请选择婚姻状况)</option>
                <option value="已婚">已婚</option>
                <option value="未婚">未婚</option>
                <option value="丧偶">丧偶</option>
                <option value="离婚">离婚</option>
                <option value="其他">其他</option>
            </select>
        </div>
        <hr>
        <div class="form-group">
            <label for="birthPlace" class="active">出生地</label>
            <input id="birthPlace" name="birthPlace" type="text" class="form-control" value="${s.birthPlace}">
        </div>
        <div class="form-group">
            <label for="Hukou" class="active">户口所在地</label>
            <input id="Hukou" name="Hukou" type="text" class="form-control" value="${s.birthPlace}">
        </div>
        <div>
            <select name="highestEducation" id="highestEducation" class="form-control">
                <option value="">(请选择最高学历)</option>
                <option value="高中及以下">高中及以下</option>
                <option value="大专">大专</option>
                <option value="本科">本科</option>
                <option value="研究生">研究生</option>
            </select>
        </div>
        <hr>
        <div>
            <select name="highestDegree" id="highestDegree" class="form-control">
                <option value="">(请选择最高学位)</option>
                <option value="无学位">无学位</option>
                <option value="学士">学士</option>
                <option value="双学士">双学士</option>
                <option value="硕士">硕士</option>
                <option value="博士">博士</option>
                <option value="博士后">博士后</option>
            </select>
        </div>
        <br>
        <div class="form-group">
            <label for="university" class="active">毕业院校</label>
            <input id="university" name="university" type="text" class="form-control" value="${s.university}">
        </div>

        <div class="form-group">
            <label for="majors" class="active">所学专业</label>
            <input id="majors" name="majors" type="text" class="form-control" value="${s.majors}">
        </div>
        <div class="form-group">
            <label for="dateOfGraduation" class="active">毕业日期</label>
            <input id="dateOfGraduation" name="dateOfGraduation" type="date" class="form-control"
                   value="${s.dateOfGraduation}">
        </div>

        <hr>
        <p>
        <h4>部门信息录入</h4>
        </p>
        <hr>
        <div>
            <%--            <select name="did" id="did" class="form-control">--%>
            <%--                <option value="">(请选择部门)</option>--%>
            <%--                <option value="0001">开发1部</option>--%>
            <%--                <option value="0002">开发2部</option>--%>
            <%--                <option value="0003">开发3部</option>--%>


            <%--            </select>--%>
            <select name="did" id="did" class="form-control">
                <%
                    out.flush();
                    request.getRequestDispatcher("SelectForDepartment").include(request, response);
                %>
            </select>
        </div>
        <hr>
        <p>
        <h4>岗位信息录入</h4>
        </p>
        <hr>
        <div>
            <%--					<select name="pid" id="pid" class="form-control">--%>
            <%--						<option value="">(请选择岗位)</option>--%>
            <%--						<option value="0001">管理</option>--%>
            <%--						<option value="0002">技术</option>--%>
            <%--						<option value="0003">营销</option>--%>
            <%--						<option value="0004">市场</option>--%>
            <%--					</select>--%>
            <select name="pid" id="pid" class="form-control">
                <%
                    out.flush();
                    request.getRequestDispatcher("SelectForPost").include(request, response);
                %>
            </select>
            <hr>
            <div class="form-group">
                <label for="entryDate" class="active">入职日期</label>
                <input id="entryDate" name="entryDate" type="date" class="form-control" value="${s.entryDate}">
            </div>
            <div class="form-group">
                <label for="workDate" class="active">参加工作日期</label>
                <input id="workDate" name="workDate" type="date" class="form-control" value="${s.workDate}">
            </div>

        </div>

        <hr>
        <div align="center">
            <input type="submit" value="提交" class="btn btn-primary" style="font-size: 15px;">
        </div>
    </form>
</div>
<script>
    function checkEmpty1() {
        var result = document.getElementById("name");
        if (result.value == null || result.value == "") {
            alert("请填写姓名，该项为必填项");
            return false;
        }
        var result = document.getElementById("sex");
        if (result.value == null || result.value == "") {
            alert("请填写性别，该项为必填项");
            return false;
        }
        var result = document.getElementById("birthDate");
        if (result.value == null || result.value == "") {
            alert("请填写出生日期，该项为必填项");
            return false;
        }
        var result = document.getElementById("idcardNo");
        if (result.value == null || result.value == "") {
            alert("请填写身份证号，该项为必填项");
            return false;
        }
        var result = document.getElementById("formOfEmployment");
        if (result.value == null || result.value == "") {
            alert("请填写用工形式，该项为必填项");
            return false;
        }
        var result = document.getElementById("sourceOfStaff");
        if (result.value == null || result.value == "") {
            alert("请填写人员来源，该项为必填项");
            return false;
        }
        var result = document.getElementById("did");
        if (result.value == null || result.value == "") {
            alert("请填写部门，该项为必填项");
            return false;
        }
        var result = document.getElementById("pid");
        if (result.value == null || result.value == "") {
            alert("请填写岗位，该项为必填项");
            return false;
        }
        var result = document.getElementById("dateOfGraduation");
        if (result.value == null || result.value == "") {
            alert("请填写毕业日期，该项为必填项");
            return false;
        }
        var result = document.getElementById("entryDate");
        if (result.value == null || result.value == "") {
            alert("请填写入职时间，该项为必填项");
            return false;
        }
        var result = document.getElementById("workDate");
        if (result.value == null || result.value == "") {
            alert("请填写参加工作时间，该项为必填项");
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
