package org.example.myapp.services.worktools;

import com.jcraft.jsch.*;
import org.example.myapp.config.SftpConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileTransferService {

    @Resource
    private SftpConfig config;

    public void uploadFile(MultipartFile file) throws JSchException, IOException, SftpException {
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        JSch jsch = new JSch();
        session = jsch.getSession(config.getUser(), config.getHost(), config.getPort());
        session.setPassword(config.getPassword());
        java.util.Properties configProperties = new java.util.Properties();
        configProperties.put("StrictHostKeyChecking", "no");
        session.setConfig(configProperties);
        session.connect();

        channel = session.openChannel("sftp");
        channel.connect();
        channelSftp = (ChannelSftp) channel;

        channelSftp.cd(config.getWorkingDir());

        InputStream stream = file.getInputStream();
        channelSftp.put(stream, file.getOriginalFilename());

        stream.close();
        channelSftp.exit();
        session.disconnect();
    }
}
