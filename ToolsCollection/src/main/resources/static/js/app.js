function sendFilePathToServer() {
    var fileInput = document.getElementById('fileInput');
    var filePath = fileInput.value;  // 获取文件路径

    // 去除前缀 "C:\fakepath\"，只保留文件名部分
    filePath = filePath.replace("C:\\fakepath\\", "");

    console.log(filePath);  // 在控制台打印文件路径

    // 使用 JQuery 发送 AJAX 请求到后端
    $.ajax({
        url: '/uploadFile',  // 后端接口 URL
        type: 'POST',
        data: filePath,  // 直接发送文件路径作为纯文本
        contentType: 'text/plain',  // 指定数据格式为纯文本
        success: function (response) {
            // 在这里处理后端的响应
            console.log(response);
        },
        error: function (error) {
            // 在这里处理错误
            console.log(error);
        }
    });
}
