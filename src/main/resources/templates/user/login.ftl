<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<script type="text/javascript" src="../static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

    function login() {
        var un = document.getElementById("username").value;
        if (un == undefined || un == null || un == "") {
            alert("请输入账号");
            return false;
        }
        var ps = document.getElementById("password").value;
        if (ps == undefined || ps == null || ps == "") {
            alert("请输入密码");
            return false;
        }
        $.ajax({
            type: "post", //post请求、
            url: "login", //请求路径
            dataType: "json", //返回回来的数据格式
            async: false, //异步
            data: {username: un, password: ps}, //返回后台的参数
            success: function (data) {//servlet(后台)传过来的参数
                if (data == "200"){
                    alert("登录成功");
                    window.location.href="index";
                }else {
                    alert("账号或密码错误");
                }
            },
            error: function (a, b, c, d) { //出错就执行这里把错误打印到控制台
                console.log(a, b, c, d);
            }
        });
    }

</script>
<body>

<table border="0" cellpadding="20" cellspacing="0" align="center">
    <thead>
    <tr>
        <th align="center">
            <form onsubmit="return false;">
                账号:<input id="username" type="text" name="username"/><br><br>
                密码:<input id="password" type="password" name="password"/><br><br>
                <input type="submit" onclick="login()" value="登录"/>
            </form>
        </th>
    </tr>
    </thead>
</table>

</body>
</html>