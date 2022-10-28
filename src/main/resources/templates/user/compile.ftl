<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>
        <#if user.id ?? && user.id != 0>
            修改
        <#else>
            添加
        </#if>
    </title>
</head>
<body>

<form action="/user/user" method="post">
    <#if user.id ?? && user.id != 0>
        <input type="hidden" name="id" value="${user.id}"/>
        <input type="hidden" name="_method" value="PUT"/>
    </#if>
    用户名:
    <input type="text" name="nickname" value="<#if user.nickname ??>${user.nickname}</#if>"/>
    <br/>
    邮箱:
    <input type="text" name="email" value="<#if user.email ??>${user.email}</#if>"/>
    <br/>
    <#if user.id ?? && user.id != 0>
        请输入新密码:
        <input type="password" name="pswd" value=""/>
    <#else>
        请输入密码:
        <input type="password" name="pswd" value=""/>
    </#if>

    <br/>
    <br/><br/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>