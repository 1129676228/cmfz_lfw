<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        $("#guru").datagrid({
            url:'${pageContext.request.contextPath}/Guru/findAllGuru',//用来请求远程数据
            pagination:true,//显示分页工具栏
            pageNumber:1,//当前页
            pageSize:10,//每页显示记录数
            pageList:[2,5,10,15,30,50],
            fit:true,
            striped:true,//是否显示斑马线效果.
            rownumbers:false, //如果为true，则显示一个行号列。
            singleSelect:true,  //如果为true，则只允许选择一行。
            ctrlSelect:true, //在启用多行选择的时候允许使用Ctrl键+鼠标点击的方式进行多选操作。
         /* fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
            remoteSort:false, //定义从服务器对数据进行排序。
            multiSort:true,//定义是否允许多列排序     */
            columns:[[
                {title:'姓名',field:'name',width:160,},
                /*{title:'图片路径',field:'imgPath',width:160,
                        formatter:function (value,row,index) {
                            return "<img style='width:100px;height:100px;' src='${pageContext.request.contextPath}"+row.imgPath+"'>"
                        }
                    },*/
                /*{title:'描述',field:'descs',width:160},*/
                {title:'头像路径',field:'headPic',width:160,},
                {title:'性别',field:'sex',width:160,sortable:true},
                {title:'options',field:'options',width:200,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' class='options' onclick=\"delguru('"+row.id+"')\" data-options=\"iconCls:'icon-delete',plain:true\">删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='options' onclick=\"updateGuru('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">更新</a>";
                    }
                }
            ]],
           view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=3 style="border:0"><img src="${pageContext.request.contextPath}/shangshitupian/' + rowData.headPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>图片路径: ' + rowData.headPic + '</p>' +
                    '<p>性别: ' + rowData.sex + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#tb',
        });
    })


    //修改用户的对话框
    function updateGuru(id){
        $("#editGuru").dialog({
            width:400,
            height:330,
            href:'${pageContext.request.contextPath}/main/editGuru.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-save',
                    text:"修改",
                    handler:function(){
                        $("#editGuruInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/Guru/updateGuru",
                            success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                //关闭dialog
                                $("#editGuru").dialog('close');
                                //刷新datagrid
                                $("#guru").datagrid('reload');//刷新当前datagrid
                                //提示修改信息
                                $.messager.show({title:'提示',msg:"用户信息修改成功!!!"});
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:"取消",
                    handler:function(){
                        $("#editGuru").dialog('close');
                    }
                },
            ]
        });
    }

    //删除一行的事件
    function delguru(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/Guru/deleteGuru",{"id":id},function (result) {
            $("#guru").datagrid('reload');
        });
    }

    //添加用户对话框函数
    function openSaveGuruDialog(){
        $("#saveGuruDialog").dialog({
            buttons:[{
                iconCls:'icon-add',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveGuruInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/Guru/insertGuru',
                        success:function(results){//响应的一定是json格式字符串   使用应该先转为js对象
                            var resultObj = $.parseJSON(results);
                            if(resultObj.success){
                                //提示信息
                                $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                            }else{
                                //提示信息
                                $.messager.show({title:'提示',msg:resultObj.message});
                            }
                            //关闭对话框
                            $("#saveGuruDialog").dialog('close');
                            //刷新datagrid
                            $("#guru").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveGuruDialog").dialog('close');
                }
            }]
        });
    }
</script>


<table id="guru"></table>
<table id="editGuru"></table>
<div id="saveGuruDialog"  data-options="href:'${pageContext.request.contextPath}/main/saveGuru.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加上师信息'">



</div>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="openSaveGuruDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>

</div>
