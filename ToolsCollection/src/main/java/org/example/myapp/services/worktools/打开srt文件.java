package org.example.myapp.services.worktools;

import java.awt.Desktop;
        import java.io.File;
        import java.io.IOException;
        import java.net.URI;
        import java.util.Scanner;

public class 打开srt文件 {

    // 请求用户输入要打开的文件路径并执行打开文件操作
    public void openUserInputFile() {
        // 创建一个新的Scanner实例以从控制台读取输入
        Scanner scanner = new Scanner(System.in);

        // 请求用户输入要打开的文件路径
        System.out.println("请输入要打开的文件路径:");
        String filePath = scanner.nextLine();

        // 执行打开文件操作
        openFileInBrowser(filePath);
    }

    // 在默认浏览器中打开给定的文件路径
    public void openFileInBrowser(String filePath) {
        // 确认当前环境是否支持使用默认浏览器打开文件
        if(Desktop.isDesktopSupported()){
            try {
                // 创建一个URI实例
                URI uri = new File(filePath).toURI();

                // 获取当前环境的Desktop实例
                Desktop desktop = Desktop.getDesktop();

                // 使用默认浏览器打开提供的文件路径
                desktop.browse(uri);
            } catch (IOException e) {
                // 捕获并打印任何I/O异常
                System.out.println("发生错误：" + e.getMessage());
            }
        }else{
            System.out.println("当前环境不支持使用默认浏览器打开文件！");
        }
    }
}
