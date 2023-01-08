package org.file_system.FilesProcessing;

import org.file_system.Constants.Constants;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class FileParser {

    private FilenameFilter textFilter; // условие отбора файлов
    private File directory; // директория с файлами

    private ArrayList<File> files; // все текстовые файлы

    /**
     * конструктор класса, задающий условие отбора файлов
     */
    public FileParser() {
        this.directory = new File("files");
        // критерий, по которому берем только файлы txt
        this.textFilter = (dir, name) -> name.toLowerCase().endsWith(".txt");
    }

    /**
     * метод, который ищет все текстовые файлы и выводит их названия
     */
    public void findAllFiles() {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles(textFilter))));
        this.files = files; // записываем все текстовые файлы в поле класса
        System.out.println(Constants.foundThisFiles);
        int counter = 1;
        try {
            if (!files.isEmpty()) {
                for (File file : files) {
                    System.out.printf(counter++ + ". " + file.getName() + "\n");
                }
                System.out.println();
            }
        } catch (NullPointerException exception) {
            System.out.println(Constants.filesNotFound);
        }
    }

    /**
     * вывод содержимого файлов на экран
     */
    public void printAllFiles() {
        for (File file : files) {
            try {
                System.out.printf("Содержимое файла " + file.getName() + ":\n");
                List<String> text = Files.readAllLines(file.toPath());
                text.forEach((System.out::println));
                System.out.println(Constants.demeliter);
            } catch (IOException exception) {
                System.out.println(Constants.somethingWentWrong);
            }
        }
    }
}
