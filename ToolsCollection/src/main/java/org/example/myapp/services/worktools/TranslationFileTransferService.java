package org.example.myapp.services.worktools;

import com.deepl.api.*;
import com.jcraft.jsch.*;
import org.example.myapp.config.SftpConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// 声明服务类
@Service
public class TranslationFileTransferService {

    private Translator translator; // DeepL API 翻译器
    private String DEEPL_API_KEY = "123"; // DeepL API Key

    @Resource // 自动注入 SftpConfig 实例
    private SftpConfig config;

    // 在构造函数中初始化 Translator 实例
    public TranslationFileTransferService() {
        this.translator = new Translator(DEEPL_API_KEY);
    }

    // 文档翻译方法
    public boolean documentTranslationExamples(String inputFilePath, String outputFilePath, String sourceLang, String targetLang) {
        try {
            File inputFile = new File(inputFilePath); // 创建输入文件
            File outputFile = new File(outputFilePath); // 创建输出文件
            translator.translateDocument(inputFile, outputFile, sourceLang, targetLang); // 翻译文档
            System.out.println("Document translation completed successfully.");
            return true; // 翻译成功返回 true
        } catch (DocumentTranslationException exception) {
            // 如果翻译过程中发生异常，打印异常信息
            DocumentHandle handle = exception.getHandle();
            System.out.printf("Error after uploading %s, document handle: id: %s key: %s%n",
                    exception.getMessage(),
                    handle.getDocumentId(),
                    handle.getDocumentKey());
        } catch (Exception e) {
            e.printStackTrace(); // 打印其他异常信息
        }
        return false; // 如果出现任何异常，返回 false
    }

    // 文件上传方法
    public void uploadFile(MultipartFile file) throws JSchException, IOException, SftpException {
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        JSch jsch = new JSch(); // 创建 JSch 实例
        // 使用 SftpConfig 实例中的信息创建新的 SFTP 会话
        session = jsch.getSession(config.getUser(), config.getHost(), config.getPort());
        session.setPassword(config.getPassword()); // 设置密码
        java.util.Properties configProperties = new java.util.Properties();
        configProperties.put("StrictHostKeyChecking", "no"); // 设置主机密钥检查为 no
        session.setConfig(configProperties); // 设置配置属性
        session.connect(); // 连接会话

        channel = session.openChannel("sftp"); // 打开 SFTP 通道
        channel.connect(); // 连接通道
        channelSftp = (ChannelSftp) channel; // 获取 SFTP 通道

        channelSftp.cd(config.getWorkingDir()); // 切换到工作目录

        // 获取文件的输入流并上传文件，使用文件的原始文件名作为目标文件名
        InputStream stream = file.getInputStream();
        channelSftp.put(stream, file.getOriginalFilename());

        stream.close(); // 关闭输入流
        channelSftp.exit(); // 退出 SFTP 通道
        session.disconnect(); // 断开会话
    }
}
