# MyApp

## 项目简介

**MyApp** 是一个功能强大的基于 **Spring Boot** 构建的综合性 Web 应用，集成了多种关键功能模块，包括 AI 驱动的文本生成、用户管理、文件处理与翻译服务，以及通过 SFTP 进行文件传输。该应用充分利用 **Redis** 作为高效的数据缓存与存储解决方案，结合 **OpenAI** 的 API 实现先进的自然语言处理，并集成 **DeepL** 提供高质量的文档翻译服务。此外，MyApp 还支持多种文件格式的上传与处理，提供灵活的跨域资源共享（CORS）配置，确保前后端的无缝交互。

前端部分采用了现代的前端技术，包括 **HTML5**、**CSS3** 和原生 **JavaScript**，打造了简洁直观的用户界面，支持响应式设计，适配不同设备和屏幕尺寸。通过精心设计的用户界面，用户可以方便地与 AI 进行互动，管理账户信息，以及处理和翻译各类文件。

## 功能特性

### AI 聊天集成

- **文本生成**：利用 OpenAI 的 GPT-3.5 Turbo 模型，根据用户提供的提示生成自然语言文本，支持多轮对话和复杂文本生成。
- **聊天记录管理**：将用户与 AI 的对话历史保存至 Redis，支持后续查询与分析，提升用户体验。
- **API 密钥轮换**：支持多组 OpenAI API 密钥，自动轮换使用以优化调用次数和提升系统稳定性。

### 用户管理

- **用户注册与登录**：提供安全的用户注册和登录接口，确保用户信息的安全存储与验证。
- **数据存储**：采用 Redis 的 Hash 结构高效存储用户数据，包括邮箱、用户名和密码，保障数据的快速访问和安全性。

### 文件处理与翻译

- **文本移除与替换**：支持用户上传多个文件，移除或替换指定的文本内容，并将处理后的文件打包为 ZIP 下载，简化文件管理流程。
- **文档翻译**：集成 DeepL API，支持将上传的文本文件从源语言翻译为目标语言，生成翻译后的 SRT 字幕文件，满足多语言需求。

### 文件传输

- **SFTP 上传**：通过配置的 SFTP 服务器实现安全文件上传，支持多文件同时传输，确保文件传输的高效与安全。
- **视频上传**：提供 REST API 端点和 Servlet 两种方式上传视频文件，支持大文件上传，满足多样化的视频处理需求。

### 应用控制

- **外部应用打开**：通过后端接口直接打开服务器上的外部应用程序，支持灵活的应用管理，提升系统的可操作性。

### 跨域资源共享（CORS）

- **灵活配置**：支持指定源的跨域请求，确保前端应用与后端服务之间的安全通信，提升用户体验。

## 技术栈

### 后端技术

- **Spring Boot**：作为应用的核心框架，提供快速开发和简化配置，支持构建高效的 RESTful API。
- **Redis**：高性能的内存数据存储，用于缓存和持久化用户数据与聊天记录。
- **OpenAI API**：用于生成自然语言文本，支持多轮对话和复杂文本生成。
- **DeepL API**：提供高质量的文档翻译服务，支持多种语言之间的转换。
- **SFTP (JSch)**：实现安全文件传输，支持文件的上传与下载。
- **Gson**：用于 JSON 数据的序列化与反序列化，简化数据处理。
- **Maven**：项目的依赖管理和构建工具，确保项目的可维护性和可扩展性。

### 前端技术

- **HTML5**：构建结构化的网页内容，确保兼容性和语义化。
- **CSS3**：设计响应式和美观的用户界面，使用现代布局和样式技术。
- **JavaScript**：实现前端逻辑和与后端 API 的交互，提升用户体验。
- **原生 JavaScript**：无需依赖外部框架，保持代码的轻量和高效。

## 安装与运行

### 环境准备

在开始之前，请确保您的系统已安装以下软件：

- **Java 8 或更高版本**：用于运行 Spring Boot 应用。
- **Maven 3.6+**：用于构建和管理项目依赖。
- **Redis 服务器**：用于数据存储与缓存。
- **SFTP 服务器**：用于文件传输功能。
- **OpenAI API 密钥**：用于 AI 文本生成。
- **DeepL API 密钥**：用于文档翻译服务。

### 克隆仓库

首先，克隆项目仓库到本地：

### 配置设置

1. **应用配置文件**：在 `src/main/resources/application.properties` 文件中配置必要的参数。

   ```properties
   # 服务器配置
   server.port=8080
   
   # 文件上传配置
   spring.servlet.multipart.max-file-size=1024MB
   spring.servlet.multipart.max-request-size=1024MB
   
   # SFTP 配置
   sftp.host=your.sftp.server
   sftp.port=22
   sftp.user=username
   sftp.password=password
   sftp.workingdir=/path/to/your/directory/
   
   # OpenAI API 密钥
   openai.api.keys=sk-YourOpenAIKey1,sk-YourOpenAIKey2,sk-YourOpenAIKey3,sk-YourOpenAIKey4
   proxy.url=http://127.0.0.1:7890
   single.chat.prefix=bot, @bot
   
   # Redis 配置
   spring.redis.host=13.236.186.20
   spring.redis.port=6379
   spring.redis.password=111111
   ```

    - **服务器配置**
        - `server.port`：应用运行的端口号。
    - **文件上传配置**
        - `spring.servlet.multipart.max-file-size`：单个文件上传的最大限制。
        - `spring.servlet.multipart.max-request-size`：整个上传请求的最大限制。
    - **SFTP 配置**
        - `sftp.host`：SFTP 服务器地址。
        - `sftp.port`：SFTP 服务器端口。
        - `sftp.user`：SFTP 用户名。
        - `sftp.password`：SFTP 密码。
        - `sftp.workingdir`：SFTP 工作目录路径。
    - **OpenAI 配置**
        - `openai.api.keys`：逗号分隔的多个 OpenAI API 密钥，用于轮换调用。
        - `proxy.url`：代理服务器 URL（如有需要）。
        - `single.chat.prefix`：单聊前缀设置。
    - **Redis 配置**
        - `spring.redis.host`：Redis 服务器地址。
        - `spring.redis.port`：Redis 服务器端口。
        - `spring.redis.password`：Redis 服务器密码。

2. **DeepL API 配置**：在 `TranslationFileTransferService` 类中，将 `DEEPL_API_KEY` 替换为您的 DeepL API 密钥。

   ```java
   private String DEEPL_API_KEY = "your-deepl-api-key"; // DeepL API Key
   ```

3. **其他配置**：根据需要，调整 CORS 设置或其他应用特性。例如，您可以在 `MyApplication` 类中的 `corsConfigurer` 方法中指定允许的跨域源和方法。

### 构建与运行

在完成配置后，使用以下命令构建并运行应用程序：

```bash
mvn clean install
mvn spring-boot:run
```

应用程序启动后，控制台将显示类似以下信息：

```
应用程序已启动，可以访问网址：http://localhost:8080
```

您可以通过浏览器访问该地址，开始使用 MyApp 提供的各项功能。



## 许可

本项目采用 [MIT 许可证](https://chatgpt.com/LICENSE) 进行许可。您可以自由使用、修改和分发本项目的代码，但需保留原作者的版权声明和许可声明。详细信息请参阅 LICENSE 文件。

