$(function () {
    //得到所有的错误信息
    $(".errorClass").each(function () {
        showError($(this));
    });

    //输入框得到焦点隐藏错误信息
    $(".form-control").focus(function () {
        var labelId = $(this).attr("id") + "Error"; //通过输入框找到对应的label的ID
        $("#" + labelId).text("");  //把label的内容清空
        showError($("#" + labelId));
    });

    //输入框失去焦点进行校验
    $(".form-control").blur(function () {
        var id = $(this).attr("id");  //获得当前输入框的ID
        //得到对应的校验函数名
        var funName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";
        //eval会将字符串当成JavaScript函数执行
        eval(funName);
    });

});

//登录名校验方法
function validateLoginname() {
    var id = "loginname";
    var value = $("#" + id).val(); //获取输入框内容
    //1非空校验
    if (!value){
        $("#" + id + "Error").text("用户名不能为空！");
        showError($("#" + id + "Error"));
        return false;
    }
    //2长度校验
    if (value.length < 4 || value.length > 12){
        $("#" + id + "Error").text("用户名长度为4～12之间！");
        showError($("#" + id + "Error"));
        return false;
    }
    //3是否注册校验

    return true;
}

//登录密码校验方法
function validateLoginpass() {
    var id = "loginpass";
    var value = $("#" + id).val(); //获取输入框内容
    //1非空校验
    if (!value){
        $("#" + id + "Error").text("密码不能为空！");
        showError($("#" + id + "Error"));
        return false;
    }
    //2长度校验
    if (value.length < 4 || value.length > 12){
        $("#" + id + "Error").text("密码长度为4～12之间！");
        showError($("#" + id + "Error"));
        return false;
    }
    //3是否注册校验

    return true;
}

//确认密码校验方法
function validateReloginpass() {
    var id = "reloginpass";
    var value = $("#" + id).val(); //获取输入框内容
    //1非空校验
    if (!value){
        $("#" + id + "Error").text("确认密码不能为空！");
        showError($("#" + id + "Error"));
        return false;
    }
    //2两次密码是否一致校验
    if (value != $("#loginpass").val()){
        $("#" + id + "Error").text("两次密码输入的不一致！");
        showError($("#" + id + "Error"));
        return false;
    }
    //3是否注册校验

    return true;
}

//email校验方法
function validateEmail() {
    var id = "email";
    var value = $("#" + id).val(); //获取输入框内容
    //1非空校验
    if (!value){
        $("#" + id + "Error").text("email不能为空！");
        showError($("#" + id + "Error"));
        return false;
    }
    //2email格式校验
    if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)){
        $("#" + id + "Error").text("email格式错误！");
        showError($("#" + id + "Error"));
        return false;
    }
    //3是否注册校验

    return true;
}

//验证码校验方法
function validateVerifyCode() {
    var id = "verifyCode";
    var value = $("#" + id).val(); //获取输入框内容
    //1非空校验
    if (!value){
        $("#" + id + "Error").text("验证码不能为空！");
        showError($("#" + id + "Error"));
        return false;
    }
    //2长度校验
    if (value != $("#loginpass").val()){
        $("#" + id + "Error").text("两次密码输入的不一致！");
        showError($("#" + id + "Error"));
        return false;
    }
    //3是否注册校验

    return true;
}



//判断当前元素是否有内容
function showError(ele) {
    var text = ele.text();//获取元素的内容
    if (!text){
        ele.css("display","none");//隐藏元素
    }else {
        ele.css("display","");//显示元素
    }
}

//换一张验证码
function _hyz() {
    $("#imgverfiyCode").attr("src","verfiyCode.action?a=" + new Date().getTime());
}