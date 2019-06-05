$(".change").on("click",function () {
    var fileId = sessionStorage.getItem('fileId')
    $.ajax({
        type:"GET",
        url:'/index/toAscII?' + 'fileId=' + fileId,
        success: function (res) {
            console.log(res);
            sessionStorage.setItem('url',res.data);
            $("#changeImg1").attr('src', res.data);
            $("#changeImg1").css("display","block");
        },
        error: function (err) {
            console.log(err);
        }
    })
});