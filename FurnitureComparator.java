package org.example;

import java.util.Comparator;

/**
 * Окремий клас для сортування меблів.
 * Сортує таким чином: Ціна за зростанням,  Вага за спаданням.
 */
public class FurnitureComparator implements Comparator<Furniture> {

    @Override
    public int compare(Furniture f1, Furniture f2) {
        // 1. Спочатку порівнюємо ціни (за зростанням)
        int priceCompare = Double.compare(f1.getPrice(), f2.getPrice());

        // 2. Якщо ціни однакові (priceCompare == 0), порівнюємо вагу
        if (priceCompare == 0) {
            // f2 порівнюємо з f1 для сортування за спаданням
            return Double.compare(f2.getWeight(), f1.getWeight());
        }

        return priceCompare;
    }
}