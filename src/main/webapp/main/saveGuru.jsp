<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="saveGuruInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top: 30px;">
            姓&nbsp;&nbsp;&nbsp;&nbsp;名： <input type="text" style="width:120px;height: 25px;" name="name"  class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            头像路径: <input type="text" style="width:120px;height: 25px;"  name="file" class="easyui-filebox">
        </div>

        <div style="margin-top: 20px;">
            性&nbsp;&nbsp;&nbsp;&nbsp;别: <select name="sex" class="easyui-combobox" style="width:120px;height: 25px;">
                        <option value="男">男</option>
                        <option value="女">女</option>
                 </select>
        </div>
    </form>
</div>