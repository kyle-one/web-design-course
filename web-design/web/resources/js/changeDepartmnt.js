function isDispatched() {
    document.getElementById('searchCondition').innerHTML ="    <form action=\"${pageContext.request.contextPath }/changeDepartment\" method=\"post\" id=\"toolbar\">\n" +
        "            <div class=\"btn-group\">\" +\n" +
        "                    <button type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" style=\"margin-bottom: 5px;\">\n" +
        "                        已调度 <span class=\"caret\"></span>\n" +
        "                    </button>\n" +
        "                    <ul class=\"dropdown-menu\">\n" +
        "                            <li><a href=\"javascript:notDispatched()\">未调度查询</a></li>\n" +
        "                            <li><a href=\"javascript:isDispatched()\">已调度查询</a></li>\n" +
        "                        </ul>\n" +
        "                </div>\n" +
        "            <div class=\"input-group\"  style=\"margin-bottom: 5px;\">\n" +
        "                <span class=\"input-group-addon\">开始时间</span>\n" +
        "                <input type=\"date\" class=\"form-control\" placeholder=\"twitterhandle\">\n" +
        "            </div>\n" +
        "            <div class=\"input-group\" style=\"margin-bottom: 5px;\">\n" +
        "                <span class=\"input-group-addon\">结束时间</span>\n" +
        "                <input type=\"date\" class=\"form-control\" placeholder=\"twitterhandle\">\n" +
        "            </div>\n" +
        "            <input type=\"text\" class=\"form-control3\" placeholder=\"员工编号\"  style=\"width: 120px\">\n" +
        "            <input type=\"text\" class=\"form-control3\" placeholder=\"员工姓名\"  style=\"width: 120px\">\n" +
        "            <input type=\"text\" class=\"form-control3\" placeholder=\"调度方式\"  style=\"width: 120px\">\n" +
        "            <input type=\"submit\" class=\"btn btn-default dropdown-toggle\" value=\"搜索\" style=\"margin-bottom: 5px;\">\n" +
        "    </form>";
}

function notDispatched() {
    document.getElementById('searchCondition').innerHTML ="    <form action=\"${pageContext.request.contextPath }/changeDepartment\" method=\"post\" id=\"toolbar\">\n" +
        "        <div class=\"btn-group\">\n" +
        "            <button type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" style=\"margin-bottom: 5px;\">\n" +
        "                未调度 <span class=\"caret\"></span>\n" +
        "            </button>\n" +
        "            <ul class=\"dropdown-menu\">\n" +
        "                <li><a href=\"javascript:notDispatched()\">未调度查询</a></li>\n" +
        "                <li><a href=\"javascript:isDispatched()\">已调度查询</a></li>\n" +
        "            </ul>\n" +
        "        </div>\n" +
        "        <input type=\"text\" class=\"form-control3\" name=\"did\" id=\"did\" placeholder=\"部门编号\"  style=\"width: 120px\">\n" +
        "        <input type=\"text\" class=\"form-control3\" name=\"dname\" id=\"dname\" placeholder=\"部门名称\"  style=\"width: 120px\">\n" +
        "        <input type=\"text\" class=\"form-control3\" name=\"sid\" id=\"sid\" placeholder=\"员工编号\"  style=\"width: 120px\">\n" +
        "        <input type=\"text\" class=\"form-control3\" name=\"sname\" id=\"sname\" placeholder=\"员工姓名\"  style=\"width: 120px\">\n" +
        "        <input type=\"submit\" class=\"btn btn-default dropdown-toggle\" value=\"搜索\" style=\"margin-bottom: 5px;\">\n" +
        "    </form>";
}