package org.example;

import java.util.Arrays;

/**
 * Точка входу в програму
 */
public class Main {
    /**
     * @param args аргументи командного рядка.
     */
    public static void main(String[] args) {
        // 1. Обробка тексту
        String rawInput = "Меблі   високої \t якості Доставка   \t безкоштовна.";
        Text processedText = new Text(rawInput);
        System.out.println("\nОброблений текст: " + processedText + "\n");

        // 2. Вихідні дані
        Furniture[] initialData = {
                new Furniture("Стілець", "Дуб", 1500.0, 5.2, true),
                new Furniture("Стіл", "Сосна", 4500.0, 20.0, true),
                new Furniture("Крісло", "Шкіра", 8000.0, 15.5, true),
                new Furniture("Табуретка", "Береза", 1500.0, 3.0, true),
                new Furniture("Полиця", "Метал", 3000.0, 3.0, true)
        };

        //Створення екземпляра FurnitureManager для подальшої обробки даних
        FurnitureManager manager = new FurnitureManager(initialData);

        //Виводимо початковий список меблів та викликаємо методи об'єкта manager
        System.out.println("Початковий список меблів");
        manager.displayAll();
        //Сортуємо
        manager.sortItems();
        System.out.println("\nПісля сортування (Ціна ↑, Вага ↓)");
        manager.displayAll();

        //Реалізуємо пошук ідентичного об'єкта
        Furniture target = new Furniture("Стіл", "Сосна", 4500.0, 20.0, true);
        System.out.println("\nШукаємо об'єкт: " + target);

        if (manager.hasItem(target)) {
            System.out.println("Результат: Об'єкт знайдено в масиві!");
        } else {
            System.out.println("Результат: Об'єкт не знайдено.");
        }
    }
}