<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        $("#album").treegrid({
            url:'${pageContext.request.contextPath}/Album/findAllAlbum',//用来请求远程数据
            idField:'id',
            treeField:'title',
            pagination:true,//显示分页工具栏
            pageNumber:1,//当前页
            pageSize:10,//每页显示记录数
            pageList:[2,5,10,15,30,50],
            fit:true,
            striped:true,//是否显示斑马线效果.
            rownumbers:false, //如果为true，则显示一个行号列。
            singleSelect:true,  //如果为true，则只允许选择一行。
            ctrlSelect:true, //在启用多行选择的时候允许使用Ctrl键+鼠标点击的方式进行多选操作。
            columns:[[
                {title:'名称',field:'title',width:160,},
                {title:'下载路径',field:'downPath',width:160,},
                {title:'章节大小',field:'size',width:160,},
                {title:'章节时长',field:'duration',width:160,},
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#tb',
        });
    })
//添加专辑
function openSaveAlbumDialog() {
        $("#saveAlbumDialog").dialog({
            buttons:[{
                iconCls:'icon-add',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveAlbumInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/Album/insertAlbum',
                        success:function(results){//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(results);
                            if(resultObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:"专辑添加成功!!!"});
                            }else{
                                //提示信息
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#saveAlbumDialog").dialog('close');
                            //刷新datagrid
                            $("#album").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveAlbumDialog").dialog('close');
                }
            }]
        });
}
    //删除一行的事件
    function delAlbum(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/Album/deleteAlbum",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#album").treegrid('reload');//刷新当前datagrid
        });
    }

    //专辑详情展示
    function chapterXingqing() {
        var row = $("#album").treegrid("getSelected");
        if(row != null){
            if(row.size == null){
                $("#ChapterXQ").dialog({
                    href:'${pageContext.request.contextPath}/main/ChapterXiangqing.jsp?id='+row.id,
                    buttons:[{
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function(){
                            $("#ChapterXQ").dialog('close');
                        }
                    }]
                })
            }else{
                $.messager.show({title:'提示',msg:"请选中专辑！！！"});
            }
        }else{
            $.messager.show({title:'提示',msg:"请选中一行"});
        }

    }

    //添加章节
function insertChapter() {
    var row = $("#album").treegrid("getSelected");
    if(row != null){
        if(row.size == null){
            $("#saveChapter").dialog({
                href:'${pageContext.request.contextPath}/main/saveChapter.jsp?id='+row.id,
                buttons:[{
                    iconCls:'icon-add',
                    text:'保存',
                    handler:function(){
                        //保存用户信息
                        $("#saveChapterInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/Chapter/insertChap',
                            success:function(results){//响应的一定是json格式字符串   使用应该先转为js对象
                                var resultObj = $.parseJSON(results);
                                if(resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"章节添加成功!!!"});
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:resultObj.message});
                                }
                                //关闭对话框
                                $("#saveChapter").dialog('close');
                                //刷新datagrid
                                $("#album").treegrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function(){
                        $("#saveChapter").dialog('close');
                    }
                }]
            });
        }else {
            $.messager.show({title:'提示',msg:"请选中专辑！！！"});
        }
    }else {
        $.messager.show({title:'提示',msg:"请选中一行！！！！！！"});
    }
}

function downLoadChap() {
    var row = $("#album").treegrid("getSelected");
    if(row != null){
        if(row.size != null){
            location.href='${pageContext.request.contextPath}/Chapter/download?fileName='+row.downPath;
        }else {
            $.messager.show({title:'提示',msg:"请选中章节！！！！！！"});
        }
    }else {
        $.messager.show({title:'警告',msg:"请选中一行！！！！"});
    }
}

</script>


<table id="album"></table>
<div id="saveAlbumDialog"  data-options="href:'${pageContext.request.contextPath}/main/saveAlbum.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加专辑'"></div>
<div id="saveChapter"  data-options="href:'${pageContext.request.contextPath}/main/saveChapter.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加章节'"></div>
<div id="ChapterXQ" data-options="draggable:false,iconCls:'icon-save',width:600,height:400,title:'专辑详情'"></div>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="chapterXingqing();" data-options="iconCls:'icon-people',plain:true">专辑详情</a>
    <a href="#" class="easyui-linkbutton" onclick="openSaveAlbumDialog();" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
    <a href="#" class="easyui-linkbutton" onclick="insertChapter()" id="SaveChapterDialog" data-options="iconCls:'icon-pencil',plain:true">添加章节</a>
    <a href="#" class="easyui-linkbutton" onclick="downLoadChap()" data-options="iconCls:'icon-undo',plain:true">下载音频</a>
</div>
