package org.example;

import java.util.Objects;

/**
 * Клас меблів з використанням класу Word.
 */
public class Furniture {
    private final Word name; // Назва тепер зберігається як об'єкт класу Word
    private final Word material; // Матеріал також як Word
    private final double price; // Ціна
    private final double weight; // Вага
    private final boolean isAvailable; // Прапорець наявності

    public Furniture(String name, String material, double price, double weight, boolean isAvailable) {
        this.name = new Word(name); // Перетворюємо вхідний String у наш об'єкт Word
        this.material = new Word(material); // Робимо те саме для матеріалу
        this.price = price; // Записуємо ціну
        this.weight = weight; // Записуємо вагу
        this.isAvailable = isAvailable; // Записуємо статус наявності
    }

    // Методи для отримання значень (потрібні для сортування)
    public double getPrice() { return price; }
    public double getWeight() { return weight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це один і той самий об'єкт
        if (o == null || getClass() != o.getClass()) return false; // Якщо типи не збігаються
        Furniture f = (Furniture) o; // Приведення типів для порівняння
        // Порівнюємо кожне поле об'єкта
        return Double.compare(f.price, price) == 0 &&
                Double.compare(f.weight, weight) == 0 &&
                isAvailable == f.isAvailable &&
                name.equals(f.name) &&
                material.equals(f.material);
    }

    @Override
    public int hashCode() {
        // Генерація хеш-коду для роботи з колекціями
        return Objects.hash(name, material, price, weight, isAvailable);
    }

    @Override
    public String toString() {
        // Форматований вивід інформації про меблі
        return String.format("Назва: %s, Матеріал: %s, Ціна: %.2f, Вага: %.2fкг",
                name, material, price, weight);
    }
}