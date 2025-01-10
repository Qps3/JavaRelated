package org.example.myapp.services.worktools;

import org.springframework.stereotype.Service;

@Service
public class AppService {
    public void openApp() throws Exception {
        Runtime.getRuntime().exec("C:\\Path\\To\\Your\\App.exe");
    }
}
