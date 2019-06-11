$(".change").on("click",function () {
    var fileId = sessionStorage.getItem('fileId');
    var index = layer.msg('请稍等，图片正在转换中...', { icon: 16, shade: 0.01,shadeClose:false,time:200000});
    $.ajax({
        type:"GET",
        url:'/index/toAscII?' + 'fileId=' + fileId,
        success: function (res) {
            layer.close(index);
            sessionStorage.setItem('url',res.data);
            $("#changeImg1").attr('src', "http://"+res.data);
            $("#changeImg1").css("display","block");
        },
        error: function (err) {
            console.log(err);
        }
    })
});