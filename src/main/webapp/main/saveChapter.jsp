<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveChapterInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top: 30px;">
            名称： <input type="text" name="title"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            下载路径: <input type="text" name="multipartFile"  class="easyui-filebox">
        </div>

        <div style="margin-top: 20px;">
            下载时间: <input type="text" name="uploadTime"  class="easyui-datebox">
        </div>

        <div style="margin-top: 20px;">
             <input type="hidden"  name="album_id" value="${param.id}">
        </div>
    </form>
</div>