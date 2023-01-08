package org.file_system;

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

    public FileParser() {
        this.directory = new File("files");
        // критерий, по которому берем только файлы txt
        this.textFilter = (dir, name) -> name.toLowerCase().endsWith(".txt");
    }

    public void findAllFiles() {
        ArrayList<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles(textFilter))));
        this.files = files; // записываем все текстовые файлы в поле класса
        System.out.println("Были найдены следующие файлы:");
        int counter = 1;
        try {
            if (!files.isEmpty()) {
                for (File file : files) {
                    System.out.printf(counter++ + ". " + file.getName() + "\n");
                }
                System.out.println();
            }
        } catch (NullPointerException exception) {
            System.out.println("Файлов не найдено!");
        }
    }

    public void printAllFiles() {
        for (File file : files) {
            try {
                System.out.printf("Содержимое файла " + file.getName() + ":\n");
                List<String> text = Files.readAllLines(file.toPath());
                text.forEach((System.out::println));
                System.out.println("-----------------------------");
            } catch (IOException exception) {
                System.out.println("Что-то пошло не так при работе с файлом");
            }
        }
    }
}
