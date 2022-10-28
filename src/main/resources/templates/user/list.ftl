<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<script type="text/javascript" src="../../static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../../static/js/pages.js"></script>
<script type="text/javascript" src="../../static/js/param.js"></script>
<script type="text/javascript">
    $(function () {
        list();
    });

    function list() {
        var pns = $.getUrlParam("pn");
        if (pns == null && pns == "") {
            pns = 1;
        }
        $.ajax({
            type: "post", //post请求、
            url: "/user/list", //项目路径
            dataType: "json", //返回回来的数据格式
            async: true, //异步
            data: {pn: pns}, //返回后台的参数
            success: function (data) {//servlet(后台)传过来的参数
                var con = "";
                $.each(data.list, function (i, ojb) {  //相当于for循环，for(School ojb : list)
                    con = con + "<tr align='center'>" +
                        "<td>" + ojb.id + "</td>" +
                        "<td>" + ojb.nickname + "</td>" +
                        "<td>" + ojb.email + "</td>" +
                        "<td>" + ojb.pswd + "</td>" +
                        "<td>" + ojb.status + "</td>" +
                        "<td>" + ojb.createTime + "</td>" +
                        "<td>" + ojb.lastLoginTime + "</td>" +
                        "<td>" +
                        <@shiro.hasRole name="888888">
                        "<a href='javascript:del(" + ojb.id + ")'>删除 </a>" +
                        </@shiro.hasRole>
                        <@shiro.hasRole name="888888">
                        "<a href='/user/user/" + ojb.id + "'>修改</a>" +
                        </@shiro.hasRole>
                        "</td>" +
                        "</tr>";
                });
                $("#tableid").html(con);
                pages(data.totalPage, data.currentPage, "list");
            },
            error: function (a, b, c, d) { //出错就执行这里把错误打印到控制台
                console.log(a, b, c, d);
            }
        });
    }

    function del(id) {
        document.getElementById("del").action = "/user/user/" + id;
        document.getElementById("del").submit();
        return false;
    }

</script>
<body>
<#include "../cb.ftl"/>

<#-- delete 请求 -->
<form action="" method="post" id="del">
    <input type="hidden" name="_method" value="DELETE"/>
</form>

<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>邮箱</th>
        <th>密码</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>最后登录时间</th>
        <th>编辑</th>
    </tr>
    </thead>
    <tbody id="tableid"></tbody>
</table>
<br>
<div id="pageDivId" align="center"></div>

<br/>
<br/>
<a href="/user/user">添加</a>

</body>
</html>