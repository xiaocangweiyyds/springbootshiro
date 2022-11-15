<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
</head>
<body>
<@shiro.user>
<a href="logout">注销</a>&nbsp;&nbsp;
</@shiro.user>

<@shiro.hasPermission name="user_query">
    <a href="/user/list">列表</a>
</@shiro.hasPermission>

</body>
</html>