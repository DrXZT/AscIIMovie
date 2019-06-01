var img = {};
$(".pic").on('change',function (e) {
    img = e.target.files[0];
    var url = getObjectURL(img)
    $("#uploadImg1").attr('src', url);
    $("#uploadImg1").css("display","block");
});
$(".upload").on("click", function () {
    var imgList = new FormData();
    imgList.append("img", img);
    console.log(imgList);
    //接口地址
    // $.ajax({
    //     type: 'POST',
    //     data: imgList,
    //     processData: false,
    //     contentType : false,
    //     url: 'http://192.168.3.74:8080/index/getFile',
    //     success: function (res) {
    //         console.log(res);
    //     },
    //     error: function (err) {
    //         console.log(err);
    //     }
    // })
})
function getObjectURL(img) {
    let url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(img) ;
    }else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(img) ;
    }else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(img) ;
    }
    return url ;
}