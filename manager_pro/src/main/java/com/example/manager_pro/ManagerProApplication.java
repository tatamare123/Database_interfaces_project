package com.example.manager_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class ManagerProApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerProApplication.class, args);
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:8080/view/dashboard"));
            } catch (IOException | URISyntaxException e) {
                System.out.println("Could not open browser automatically: " + e.getMessage());
            }
        }

    }
}
