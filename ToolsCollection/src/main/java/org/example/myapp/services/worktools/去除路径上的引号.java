package org.example.myapp.services.worktools;

public class 去除路径上的引号 {

    // 方法：删除文件路径中的双引号
    public String removeQuotes(String filePath) {
        // 使用replace()方法替换所有的双引号为空字符
        return filePath.replace("\"", "");
    }
}
