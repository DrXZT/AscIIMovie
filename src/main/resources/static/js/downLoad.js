$(".download").on("click",function () {
    var url = sessionStorage.getItem('url')
    var fileName =url.split('/')[2]
    $.ajax({
        type:"GET",
        url:'/download?'+'fileName='+fileName,
        success: function (res) {
            console.log(res);
        },
        error: function (err) {
            console.log(err);
        }
    })
});