<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="editUserInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${sessionScope.admin.id}">
        <div style="margin-top: 30px;">
            用户名： <input type="text" name="name" value="${sessionScope.admin.name}" class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            新密码: <input type="text" name="password"  class="easyui-textbox">
        </div>
    </form>
</div>