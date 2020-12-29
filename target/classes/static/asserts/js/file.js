var imgCount = 0;  //验证是否能上传多张图片

function fileUp() {
    var type = "file";          //后台接收时需要的参数名称，自定义即可
    var id = "imgFile";         //即input的id，用来寻找值
    var formData = new FormData();
    var files = $("#" + id)[0].files;  //获取指定input中的所有文件
    if($($("#" + id)[0]).attr("multiple") !== 'multiple' && imgCount > 0){
        layer.msg("最多上传一张照片");
        return;
    }
    imgCount++;
    for (var i = 0; i < files.length; i++) {
        formData.append(type, files[i]);    //生成一对表单属性
    }
    $.ajax({
        url: "/file/imgup",
        type: 'post',
        data: formData,
        processData: false,  //异步上传必须
        contentType: false,  //异步上传必须
        success: function (data) {
            if (data.flag !== 1) {
                if(data.path === ''){
                    layer.msg(data.msg, {icon: 5});
                    return;
                }
                console.log('图片路径：' + data.path);
                var imgPaths = data.path.split("|");
                for (var i = 0; i < imgPaths.length && imgPaths[i] !== ''; i++) {
                    $("#checkImg").append("<span id='empImgs" + i + "' style='display:inline-block;margin-left: 5px;position: relative;'>" +
                        "<span style='display:inline-block;position: absolute;top: -10px;left: 139px;'>" +
                        "<img src='/asserts/img/del.png' width='20px' height='20px' onclick=\"delImg('" + i + "');\"/>" +
                        "</span>" +
                        "<img id='empImg" + i + "' src='" + imgPaths[i] + "' width='150px' height='150px'/></span>");
                }
                if($("input[name='empImg']").length > 0){
                    $("input[name='empImg']").val(imgPaths);
                }else{
                    $("#imgup").append('<input type="hidden" name="empImg" value="' + imgPaths + '"/>');
                }
            } else {
                layer.msg(data.msg, {icon: 5});
            }
        },
        dataType: 'json',
        error: function () {
            layer.msg('图片上传出错', {icon: 5});
        }
    })
}

function delImg(imgID) {
    $.ajax({
        url: '/file/delimg',
        type: 'post',
        data: {'path': $("#empImg" + imgID).attr("src")},
        dataType: 'json',
        success: function (data) {
            if (data.flag !== 1) {
                $("#empImgs" + imgID).remove();
                layer.msg(data.msg);
                $("input[name='empImg']").remove();
                imgCount--;
            } else {
                layer.msg(data.msg, {icon: 5});
            }
        },
        error: function () {
            layer.msg('删除图片出错', {icon: 5});
        }
    })
}