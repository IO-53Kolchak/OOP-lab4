package org.example;

import java.util.Arrays;

/**
 * Клас-менеджер, що інкапсулює логіку обробки масиву меблів.
 */
public class FurnitureManager {
    private final Furniture[] items;

    public FurnitureManager(Furniture[] items) {
        this.items = items;
    }

    /**
     * Сортування масиву за допомогою зовнішнього компаратора.
     */
    public void sortItems() {
        Arrays.sort(items, new FurnitureComparator());
    }

    /**
     * Пошук об'єкта, що по своїй суті дорівнює цільовому.
     */
    public boolean hasItem(Furniture target) {
        for (Furniture item : items) {
            if (item.equals(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Виведення вмісту масиву.
     */
    public void displayAll() {
        for (Furniture item : items) {
            System.out.println(item);
        }
    }
}