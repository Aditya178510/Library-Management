package com.aditya.library;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookDBLogger extends Thread {
    private final String message;
    private static final String LOG_PATH = "library-actions.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public BookDBLogger(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            String timestamp = LocalDateTime.now().format(FORMATTER);
            String logEntry = "[" + timestamp + "] " + message;

            try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
                writer.write(logEntry + "\n");
            }

            System.out.println("[LOG] " + logEntry);
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}
