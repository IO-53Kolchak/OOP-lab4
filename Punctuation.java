package org.example;

/**
 * Клас для представлення розділових знаків.
 */
public class Punctuation {
    private final char symbol; // Поле для зберігання знаку пунктуації

    public Punctuation(char symbol) {
        this.symbol = symbol; // Ініціалізуємо символ (кома, крапка тощо)
    }

    @Override
    public String toString() {
        return String.valueOf(symbol); // Повертаємо знак як рядок
    }
}