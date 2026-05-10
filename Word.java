package org.example;

import java.util.Objects;

/**
 * Клас, що представляє слово як масив об'єктів Letter.
 */
public class Word {
    private final Letter[] letters; // Масив об'єктів нашого класу Letter

    public Word(String s) {
        this.letters = new Letter[s.length()]; // Виділяємо пам'ять під довжину слова
        for (int i = 0; i < s.length(); i++) {
            this.letters[i] = new Letter(s.charAt(i)); // Створюємо об'єкт для кожної літери
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Використовуємо StringBuilder для збірки слова
        for (Letter l : letters) {
            sb.append(l); // Додаємо кожну літеру до буфера
        }
        return sb.toString(); // Повертаємо готове слово
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це один і той самий об'єкт в пам'яті
        if (o == null || getClass() != o.getClass()) return false; // Перевірка типу
        return Objects.equals(this.toString(), o.toString()); //  Порівнюємо слова як текстові рядки
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString()); // Генеруємо хеш на основі значення слова
    }
}