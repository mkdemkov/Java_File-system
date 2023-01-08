package org.file_system;


public class Main {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        fileParser.findAllFiles();
        fileParser.printAllFiles();
    }
}