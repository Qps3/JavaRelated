// 初始化聊天记录，从localStorage获取或创建一个新数组
var chatHistory = JSON.parse(localStorage.getItem("chatHistory")) || [];

// 向后端服务器发送聊天数据
async function sendMessageToServer(sender, message) {
    let url = "http://localhost:8080/api/sync-chat";
    let data = { sender: sender, message: message };

    try {
        await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });
    } catch (error) {
        console.error("Error sending message to server:", error);
    }
}

// 向AI发送请求，并将AI回复显示在聊天记录容器中
async function aiResponse(input) {
    // 发送聊天数据到后端服务器
    sendMessageToServer("我", input);

    // 用你的Spring Boot应用程序的URL替换此URL
    let url = "http://13.236.186.20:8080/api/generate-text?prompt=" + encodeURIComponent(input);

    let response = await fetch(url);
    let data = await response.text();

    // 使用DOMParser从HTML字符串中提取AI回复
    let parser = new DOMParser();
    let doc = parser.parseFromString(data, "text/html");
    let aiResponse = doc.body.innerText;

    // 添加用户和AI的回复到聊天记录中
    chatHistory.push({ sender: "我", message: input });
    chatHistory.push({ sender: "AI", message: aiResponse });

    // 保存更新后的聊天记录到localStorage
    localStorage.setItem("chatHistory", JSON.stringify(chatHistory));

    // 在聊天记录容器中添加AI回复
    appendMessage("AI", aiResponse);

    return aiResponse;
}

// 在聊天记录容器中添加消息
function appendMessage(sender, message) {
    var container = document.getElementById("message-container");

    var messageDiv = document.createElement("div");
    messageDiv.classList.add("message", sender === "AI" ? "ai-response" : "user-message");
    messageDiv.innerText = sender + "：" + message;
    container.appendChild(messageDiv);

    if (sender === "AI") {
        // 创建复制按钮并添加到AI回复框的最右边
        var copyButton = document.createElement("button");
        copyButton.classList.add("copy-button");
        copyButton.addEventListener("click", function () {
            copyAiResponse(message);
        });

        messageDiv.appendChild(copyButton);

        // 添加分割线
        var separator = document.createElement("div");
        separator.classList.add("separator");
        messageDiv.appendChild(separator);
    }

    container.scrollTop = container.scrollHeight;
}

// 处理用户输入和AI回复
function submit() {
    var input = document.getElementById("user-input").value.trim();
    if (input !== "") {
        appendMessage("我", input);
        document.getElementById("user-input").value = "";

        aiResponse(input);
    }
}

// 监听回车键，按回车键发送用户输入的消息
document.getElementById("user-input").addEventListener("keyup", function (event) {
    if (event.keyCode === 13) {
        event.preventDefault();
        submit();
    }
});

// 复制AI回复内容到剪贴板
function copyAiResponse(response) {
    var tempInput = document.createElement("textarea");
    tempInput.value = response;
    document.body.appendChild(tempInput);
    tempInput.select();
    document.execCommand("copy");
    document.body.removeChild(tempInput);
}

// 下载聊天记录为txt文件
function downloadChat() {
    var chatContent = "";

    // 生成聊天内容
    var conversation = "";
    for (var i = 0; i < chatHistory.length; i++) {
        var { sender, message } = chatHistory[i];
        conversation += sender + "：" + message + "\n";

        // 如果是AI回复，添加一定的间距并创建一个新的对话框
        if (sender === "AI") {
            chatContent += "<div class='conversation'>" + conversation + "</div>";
            conversation = "";
        }
    }

    // 创建Blob对象并保存为txt文件
    var blob = new Blob([chatContent], { type: "text/plain" });
    var url = window.URL.createObjectURL(blob);
    var link = document.createElement("a");
    link.href = url;
    link.download = "chat_log.txt";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}

async function saveAllChatToRedis() {
    // 获取最新的聊天记录
    var latestChatHistory = chatHistory.slice();

    // 将所有聊天记录转换为后端期望的数据格式
    var chatData = latestChatHistory.map(function (chat) {
        return { sender: chat.sender, message: chat.message };
    });

    // 将聊天数据发送到后端的API
    try {
        let url = "http://localhost:8080/api/save-all-chat-to-redis";
        let data = chatData;

        await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        console.log("所有聊天记录已保存到Redis");
    } catch (error) {
        console.error("保存聊天记录到Redis出错:", error);
    }
}


// 页面加载时，显示所有的聊天记录
window.onload = function() {
    for (var i = 0; i < chatHistory.length; i++) {
        var { sender, message } = chatHistory[i];
        appendMessage(sender, message);
    }
};