package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Юніт-тести для перевірки логіки
 */
class FurnitureTest {

    @Test
    @DisplayName("Перевірка форматування тексту: видалення табів та зайвих пробілів")
    void testTextFormatting() {
        // Вхідний рядок із табуляцією та множинними пробілами
        String input = "Меблі   з	табом.    Нове   речення.";
        Text text = new Text(input);

        // Очікуваний результат після обробки регулярним виразом у класі Text
        String expected = "Меблі з табом. Нове речення.";
        assertEquals(expected, text.toString(), "Текст має бути очищений від зайвих пробілів та табів");
    }

    @Test
    @DisplayName("Перевірка сортування: Ціна (зростання), Вага (спадання)")
    void testSortingLogic() {
        // Створюємо об'єкти, де f1 та f2 мають однакову ціну (1500.0)
        Furniture f1 = new Furniture("Стілець", "Дуб", 1500.0, 5.0, true);
        Furniture f2 = new Furniture("Табурет", "Дуб", 1500.0, 10.0, true);
        Furniture f3 = new Furniture("Стіл", "Дуб", 5000.0, 20.0, true);

        Furniture[] items = {f1, f2, f3};

        // Використовуємо FurnitureComparator
        Arrays.sort(items, new FurnitureComparator());

        // f2 має бути першим, бо при ціні 1500 його вага 10кг > 5кг
        assertEquals(f2, items[0], "При однаковій ціні важчий об'єкт має бути вище");
        assertEquals(f1, items[1], "Об'єкт з меншою вагою має бути другим");
        assertEquals(f3, items[2], "Об'єкт з більшою ціною має бути останнім");
    }

    @Test
    @DisplayName("Перевірка порівняння об'єктів через equals")
    void testEquality() {
        // Перевірка для Word
        Word w1 = new Word("Дуб");
        Word w2 = new Word("Дуб");
        assertEquals(w1, w2, "Об'єкти Word з однаковим текстом повинні бути рівними");

        // Перевірка для Furniture
        Furniture item1 = new Furniture("Стіл", "Дуб", 5000.0, 40.0, true);
        Furniture item2 = new Furniture("Стіл", "Дуб", 5000.0, 40.0, true);

        assertEquals(item1, item2, "Об'єкти Furniture з ідентичними полями повинні бути рівними");
    }

    @Test
    @DisplayName("Перевірка пошуку об'єкта через FurnitureManager")
    void testManagerSearch() {
        Furniture f1 = new Furniture("Стілець", "Дуб", 1500.0, 5.2, true);
        Furniture f2 = new Furniture("Стіл", "Сосна", 4500.0, 20.0, true);

        FurnitureManager manager = new FurnitureManager(new Furniture[]{f1, f2});

        // Шукаємо об'єкт, який точно є в масиві (з тими самими параметрами)
        Furniture target = new Furniture("Стіл", "Сосна", 4500.0, 20.0, true);

        assertTrue(manager.hasItem(target), "Менеджер повинен успішно знаходити ідентичний об'єкт");

        // Шукаємо об'єкт, якого немає
        Furniture missing = new Furniture("Шафа", "Метал", 999.0, 1.0, false);
        assertFalse(manager.hasItem(missing), "Менеджер не повинен знаходити відсутній об'єкт");
    }
}