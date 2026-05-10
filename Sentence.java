package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для речення (представляє його як масив слів та розділових знаків)
 */
public class Sentence {
    private final Object[] elements; // Масив, де лежать і Word, і Punctuation

    public Sentence(String s) {
        // Регулярний вираз розбиває текст, зберігаючи знаки пунктуації як окремі елементи
        String[] parts = s.split("(?=[,.!?])|\\s+");
        List<Object> temp = new ArrayList<>(); // Тимчасовий список для збору елементів
        for (String part : parts) {
            if (part.isEmpty()) continue; // Пропускаємо порожні рядки
            if (part.matches("[,.!?]")) {
                temp.add(new Punctuation(part.charAt(0))); // Якщо знак, то створюємо об'єкт Punctuation
            } else {
                temp.add(new Word(part)); // Якщо слово, то створюємо об'єкт Word
            }
        }
        this.elements = temp.toArray(); // Перетворюємо список у масив об'єктів
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Створюємо буфер для збірки речення
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]); // Додаємо слово або знак
            // Ставимо пробіл між двома словами, щоб текст не зливався
            if (i < elements.length - 1 && elements[i] instanceof Word && elements[i+1] instanceof Word) {
                sb.append(" ");
            }
        }
        return sb.toString(); // Повертаємо готове речення
    }
}