<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        $("#dg").datagrid({
            url:'${pageContext.request.contextPath}/banner/findAll',//用来请求远程数据
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
                {title:'名称',field:'title',width:160,},
                /*{title:'图片路径',field:'imgPath',width:160,
                        formatter:function (value,row,index) {
                            return "<img style='width:100px;height:100px;' src='${pageContext.request.contextPath}"+row.imgPath+"'>"
                        }
                    },*/
                /*{title:'描述',field:'descs',width:160},*/
                {title:'状态',field:'status',width:160,},
                {title:'日期',field:'date',width:160,sortable:true},
                {title:'options',field:'options',width:200,
                    formatter:function(value,row,index){
                        return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-delete',plain:true\">删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' class='options' onclick=\"updateImg('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">更新</a>";
                    }
                }
            ]],
           view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=3 style="border:0"><img src="${pageContext.request.contextPath}/lunbotupian/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>图片路径: ' + rowData.imgPath + '</p>' +
                    '<p>描述: ' + rowData.descs + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#banner',
        });
    })

    //删除一行的事件
    function delRow(id){
        //获取当前点击id发送ajax请求删除id这个人的信息
        $.post("${pageContext.request.contextPath}/banner/delete",{"id":id},function (result) {//响应成功之后回调
            //刷新datagrid数据
            $("#dg").datagrid('reload');//刷新当前datagrid
        });
    }


    //修改用户的对话框
    function updateImg(id){
        $("#editUpdateImg").dialog({
            width:400,
            height:330,
            href:'${pageContext.request.contextPath}/main/editbanner.jsp?id='+id,
            buttons:[
                {
                    iconCls:'icon-save',
                    text:"修改",
                    handler:function(){
                        $("#editUpdateImgInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/banner/update",
                            success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                //关闭dialog
                                $("#editUpdateImg").dialog('close');
                                //刷新datagrid
                                $("#dg").datagrid('reload');//刷新当前datagrid
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
                        $("#editUpdateImg").dialog('close');
                    }
                },
            ]
        });
    }

    //添加用户对话框函数
    function openSaveBannerDialog(){
        $("#saveBannerDialog").dialog({
            buttons:[{
                iconCls:'icon-add',
                text:'保存',
                handler:function(){
                    //保存用户信息
                    $("#saveUpdateImgInputForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/insert',
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
                            $("#saveBannerDialog").dialog('close');
                            //刷新datagrid
                            $("#dg").datagrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                handler:function(){
                    $("#saveBannerDialog").dialog('close');
                }
            }]
        });
    }
</script>


<table id="dg"></table>
<table id="editUpdateImg"></table>
<div id="saveBannerDialog"  data-options="href:'${pageContext.request.contextPath}/main/savebanner.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'添加图片信息'">



</div>
<div id="banner">
    <a href="#" class="easyui-linkbutton" onclick="openSaveBannerDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>
