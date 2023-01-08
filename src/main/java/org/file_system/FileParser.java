package org.file_system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileParser {

    FilenameFilter textFilter;
    File file;

    public FileParser() {
        File f = new File("files"); // директория с нужными файлами на проверку
        this.file = f;
        // критерий, по которому берем только файлы txt
        FilenameFilter textFilter = (dir, name) -> name.toLowerCase().endsWith(".txt");
        this.textFilter = textFilter;
    }

    public void findAllFiles() {
        File[] files = file.listFiles(textFilter);
        try {
            assert files != null;
            ArrayList<String> names = new ArrayList<>();
            if (files.length != 0) {
                for (File file : files) {
                    names.add(file.getName());
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Файлов не найдено!");
        }
    }
}
