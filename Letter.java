package org.example;

/**
 * Клас для представлення однієї літери.
 */
public class Letter {
    private final char value; // Поле для зберігання одного символу

    public Letter(char value) {
        this.value = value; // Записуємо символ у поле класу
    }

    @Override
    public String toString() {
        return String.valueOf(value); // Повертаємо символ як рядок для виводу
    }
}