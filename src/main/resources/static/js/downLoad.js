$(".download").on("click",function () {
    var url = sessionStorage.getItem('url');
    var fileName =url.split('/')[2];
    var downloadUrl = 'localhost:8080/download?'+'fileName='+fileName;
    window.open(downloadUrl);
});