<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editGuruInputForm").form('load','${pageContext.request.contextPath}/Guru/findOneGuru?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editGuruInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top: 30px;">
            姓名： <input type="text" name="name"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            头像路径: <input type="text" name="headPic"  class="easyui-textbox">
            <input name="file" class="easyui-filebox"/>
        </div>

        <div style="margin-top: 20px;">
            性别: <input type="text" name="sex"  class="easyui-textbox">
        </div>

    </form>
</div>