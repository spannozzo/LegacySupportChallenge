package com.fime.solid;

public class FileProcessor {
    public void processFile(String filePath) {

        String content = readFile(filePath);
        String processedData = processData(content);
        saveToDatabase(processedData);
    }

    private String readFile(String filePath) {
        return "File content";
    }

    private String processData(String content) {
        return content.toUpperCase();
    }

    private void saveToDatabase(String data) {
        System.out.println("Saving: " + data);
    }
}
