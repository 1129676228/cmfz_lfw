<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editUpdateImgInputForm").form('load','${pageContext.request.contextPath}/banner/findOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editUpdateImgInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top: 30px;">
            名称： <input type="text" name="title"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            图片路径:  <input  name="file" class="easyui-filebox" data-options="required"/>
        </div>

        <div style="margin-top: 20px;">
            描述: <input type="text" name="descs"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            状态: <input type="text" name="status"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            日期: <input type="text" name="date"  class="easyui-datebox">
        </div>
    </form>
</div>