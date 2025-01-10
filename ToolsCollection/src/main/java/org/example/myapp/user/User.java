package org.example.myapp.user;

public class User {

    private String email;
    private String username;
    private String password;

    // 可以根据需要添加更多用户信息，比如姓名、邮箱等

    // 构造函数
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter和setter方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
