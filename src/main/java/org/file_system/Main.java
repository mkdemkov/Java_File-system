package org.file_system;


import org.file_system.FilesProcessing.FileParser;

public class Main {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        fileParser.findAllFiles();
        fileParser.printAllFiles();
    }
}