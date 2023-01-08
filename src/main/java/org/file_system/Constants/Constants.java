package org.file_system.Constants;

public class Constants {
    /**
     * конструктор класса, показывающий, что класс не предназначен для работы в ООП стиле
     */
    private Constants() {
        throw new RuntimeException("Нельзя создать экземпляр этого класса!");
    }

    public static String demeliter = "-----------------------------";
    public static String foundThisFiles = "Были найдены следующие файлы:";
    public static String filesNotFound = "Файлов не найдено!";
    public static String somethingWentWrong = "Что-то пошло не так при работе с файлом";
}
