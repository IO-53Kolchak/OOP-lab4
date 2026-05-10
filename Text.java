package org.example;

/**
 * Клас для тексту (представляє текст як масив речень)
 */
public class Text {
    private final Sentence[] sentences; // Масив об'єктів речень

    public Text(String raw) {
        // Міняємо всі табуляції та послідовності пробілів на один
        String processed = raw.replaceAll("[\\t ]+", " ").trim();
        // Розбиваємо текст на частини після знаків.
        String[] split = processed.split("(?<=[.!?])\\s*");
        this.sentences = new Sentence[split.length]; // Створюємо масив потрібного розміру
        for (int i = 0; i < split.length; i++) {
            this.sentences[i] = new Sentence(split[i]); // Кожну частину перетворюємо на об'єкт Sentence
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Збираємо весь текст
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i]); // Додаємо речення
            if (i < sentences.length - 1) sb.append(" "); // Пробіл між реченнями для читабельності
        }
        return sb.toString(); // Повертаємо фінальний текст
    }
}