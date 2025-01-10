window.onload = function () {
    var dropZone = document.getElementById('drop-zone');
    dropZone.ondrop = function (e) {
        e.preventDefault();
        uploadFile(e.dataTransfer.files[0]);
    };

    dropZone.ondragover = function () {
        return false;
    };
};

function uploadFile(file) {
    var url = '/upload';
    var xhr = new XMLHttpRequest();
    var fd = new FormData();
    xhr.open("POST", url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // File uploaded successfully
        }
    };
    fd.append("file", file);
    xhr.send(fd);
}
