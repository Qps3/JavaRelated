package org.example.myapp.models;

public class Address {
    private String filePath;

    public Address() {}

    public Address(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
