
fetch('/sayHello')
    .then(response => response.text())
    .then(data => console.log(data));
