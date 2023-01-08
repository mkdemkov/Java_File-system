package org.file_system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser();
        fileParser.findAllFiles();
    }
}