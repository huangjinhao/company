
$(function () { //$(function(){ })则是用来在DOM加载完成之后运行\执行那些预行定义好的函数
    dlg_Edit = $('#Dlg-Edit').dialog({
        closed: true, //定义是否可以关闭窗口
        modal: true,  //定义是否将窗体显示为模式化窗口
        toolbar: [{   //设置对话框窗口顶部工具栏..话框窗口工具栏通过数组进行定义：
            text: '保存',
            iconCls: 'icon-save',
            handler: saveData
        }, '-', {
            text: '关闭',
            iconCls: 'icon-no',
            handler: function () {
                dlg_Edit.dialog('close');
            }
        }]
    });
    
    
    dlg_Edit_form = dlg_Edit.find('form');

    //加载表格 datagrid
    grid = $('#test').datagrid({ 
        title: '员工管理', 		//列标题
        iconCls: 'icon-save',	//设置一个16x16图标的CSS类ID显示在面板左上角
        methord: 'get',			//使用HTTP的哪一种方法读取内容页。可用值：'get','post'。（该属性自1.3.6版开始可用）
        url: 'queryAll.action', //一个URL从远程站点请求数据
        sortName: 'userId',  //定义哪些列可以进行排序
        sortOrder: 'desc', //定义列的排序顺序，只能是'asc'或'desc'
        idField: 'userId', //指明哪一个字段是标识字段
        pageSize: 30,    //在设置分页属性的时候初始化页面大小
        frozenColumns: [[ //同列属性，但是这些列将会被冻结在左侧
           {field: 'ck', checkbox: true },     //前面的多选 框         
           {title: '员工idididi', field: 'stuId', width: 80, sortable: true }
		]],   //title :列标题文本  filed:列字段名称   sorttable:true 如果为true，则允许列使用排序
        columns: [[  //DataGrid列配置对象，详见列属性说明中更多的细节
					{ field: 'userId', title: '员工姓名22', width: 150, sortable: true },
					{ field: 'password', title: '员工性别', width: 150, sortable: true },
					{ field: 'name', title: '员工出生日期', width: 150, sortable: true },
					{ field: 'sex', title: '员工角色', width: 150, sortable: true }
		]],
        fit:true, //当设置为true的时候面板大小将自适应父容器。下面的例子显示了一个面板，可以自动在父容器的最大范围内调整大小
        pagination: true, //分页
        rownumbers: true, //显示行号
        fitColumns: true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动
        singleSelect: false, //如果为true，则只允许选择一行。
        toolbar: [{  //顶部工具栏的DataGrid面板。
            text: '新增',
            iconCls: 'icon-add',
            handler: add
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: edit
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: del
        }],
        
        //onHeaderContextMenu:在鼠标右击一行记录的时候触发。
       onHeaderContextMenu: function (e, field) {
            e.preventDefault();
            if (!$('#tmenu').length) {
                createColumnMenu();
            }
            $('#tmenu').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        }
    });
    
    //使用JavaScript创建分页控件。
	var p = $('#test').datagrid('getPager');
	if (p){
		$(p).pagination({
			onBeforeRefresh:function(){//在点击刷新按钮刷新之前触发，返回false可以取消刷新动作
				alert('before refresh');
			}
		});
	}
      $('body').layout();
});

//创建列菜单
function createColumnMenu() {
    var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
    var fields = grid.datagrid('getColumnFields');
    for (var i = 0; i < fields.length; i++) {
        $('<div iconCls="icon-ok"/>').html(fields[i]).appendTo(tmenu);
    }
    tmenu.menu({
        onClick: function (item) {
            if (item.iconCls == 'icon-ok') {
                grid.datagrid('hideColumn', item.text);
                tmenu.menu('setIcon', {
                    target: item.target,
                    iconCls: 'icon-empty'
                });
            } else {
                grid.datagrid('showColumn', item.text);
                tmenu.menu('setIcon', {
                    target: item.target,
                    iconCls: 'icon-ok'
                });
            }
        }
    });
}
//定义变量
var tree;//树形
var grid;//表格 datagrid
var dlg_Edit;
var dlg_Edit_form; //编辑表单

//点击树的节点时的方法
function clickTree(nodeid) {
    grid.datagrid({ url: 'student_xxx.action?PID=' + nodeid });
    grid.datagrid('clearSelections');
}
//查找选中多行时的ID,返回id数组
function getSelectedArr() {
    var ids = [];
    var rows = grid.datagrid('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids.push(rows[i].stuId);
    }
    return ids;
}
function getSelectedID() {
    var ids = getSelectedArr();
    return ids.join(',');
}
//删除多个ID时,加上分隔twf
function arr2str(arr) {
    return arr.join(',');
}

//增加方法
function add() {
    dlg_Edit.dialog('open');
    dlg_Edit_form.form('clear');
    dlg_Edit_form.url='student_addStu.action';
}
//编辑方法
function edit() {
    var rows = grid.datagrid('getSelections');
    var num = rows.length;
    if (num == 0) {
        Msgslide('请选择一条记录进行操作!'); //$.messager.alert('提示', '请选择一条记录进行操作!', 'info');
        return;
    }
    else if (num > 1) {
        Msgfade('您选择了多条记录,只能选择一条记录进行修改!'); //$.messager.alert('提示', '您选择了多条记录,只能选择一条记录进行修改!', 'info');
        return;
    }
    else {
        dlg_Edit.dialog('open');
        dlg_Edit_form.form('load','student_toEditStu.action?stuId='+rows[0].stuId);
        dlg_Edit_form.url = 'student_editStu.action?stuId='+rows[0].stuId;
    }
}
//删除方法 
function del() {
    var arr = getSelectedArr();
    if (arr.length > 0) {
        $.messager.confirm('提示信息', '您确认要删除吗?', function (data) {
            if (data) {
                $.ajax({
                    url: 'student_delStu.action?deId='+arr2str(arr),
                    type: 'GET',
                    timeout: 1000,
                    error: function () {
                        $.messager.alert('成功', '删除成功!', 'show');
                    },
                    success: function (data) {
                        eval('data=' + data);
                        if (data.success) {
                            grid.datagrid('reload');
                            grid.datagrid('clearSelections');
                        } else {
                            $.messager.alert('错误', data.msg, 'error');
                        }
                    }
                });
            }
        });
    } else {
        Msgshow('请先选择要删除的记录。');
    }
}
//弹出框
function Msgshow(msg) {
    $.messager.show({
        title: '提示',
        msg: msg,
        showType: 'show'
    });
}

//弹出框
function Msgslide(msg) {
    $.messager.show({
        title: '提示',
        msg: msg,
        timeout: 3000,
        showType: 'slide'
    });
}
//弹出框
function Msgfade(msg) {
    $.messager.show({
        title: '提示',
        msg: msg,
        timeout: 3000,
        showType: 'fade'
    });
}

//操作保存修改后的结果
function saveData() {
    dlg_Edit_form.form('submit', {
        url: dlg_Edit_form.url,
        onSubmit: function () {
            return $(this).form('validate');
        },
        success: function (data) {
            eval('data=' + data);
            if (data.success) {
                grid.datagrid('reload');
                dlg_Edit.dialog('close');
            } else {
                $.messager.alert('错误', data.msg, 'error');
            }
        }
    });
}
