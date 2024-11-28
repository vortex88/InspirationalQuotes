package InspirationalQuotes;

import java.util.ArrayList;
import java.util.List;

public class Quote {  // Цитата

    private String text; // Текст цитаты
    private String author; // Автор цитаты
    private boolean isUpperCase; // Для отслеживания в верхнем ли регистре текст
    private List<String> keywords; // Для хранения ключевых слов, связанных с цитатой


    // Метод, который переключает текст цитаты между верхним и нижним регистром.
    public void toggleCase() {
        if (isUpperCase) {
            text = text.toLowerCase(); // Преобразуем в нижний регистр
        } else {
            text = text.toUpperCase(); // Преобразуем в верхний регистр
        }
        isUpperCase = !isUpperCase; // Если не инвертировать isUpperCase, то при следующем вызове метод не будет знать,
                                    // в каком регистре находится текст, и не сможет правильно его преобразовать.
    }

    // Метод, который добавляет ключевое слово в список, если его там нет.
    public void addKeyword(String keyword) {
        if (!keywords.contains(keyword)) { // Если это слово найдено в списке, то
            keywords.add(keyword);
        } else {
            System.out.println("\nДанное ключевое слово: \"" + keyword + "\" уже было добавлено в список");
        }
    }

    // Метод removeKeyword(String keyword), который удаляет ключевое слово из списка.
    public void removeKeyword(String keyword) {
        if (!keywords.contains(keyword)) {
            System.out.println("\nДанное ключевое слово: \"" + keyword + "\" не находится в списке");
        } else {
            keywords.remove(keyword); // Используем перегруженный метод remove(Object o)
            System.out.println("\nДанное ключевое слово: \"" + keyword + "\" было удалено из списка");
        }
    }

    // Метод display(), который выводит цитату в формате: "«<текст>» — <автор> (Ключевые слова: <ключевые_слова>)".
    public void display() {
        StringBuilder keywordsString = new StringBuilder(); // Создается объект StringBuilder для построения строки ключевых слов.
        for (String keyword : keywords) { // Начинается цикл, который проходит по всем ключевым словам в списке keywords
            keywordsString.append(keyword).append(", "); // Добавляет текущее ключевое слово и запятую с пробелом в StringBuilder.
        }
        if (keywordsString.length() > 0) { // Проверяет, есть ли ключевые слова в StringBuilder. Если есть, то выполняется следующая строка.
            keywordsString.setLength(keywordsString.length() - 2); // Удаляет последнюю запятую и пробел из строки ключевых слов.
        }
        System.out.println("\n«" + text + "» — " + author + " (Ключевые слова: " + keywordsString.toString() + ")");
    }

    // Конструктор
    public Quote(String text, String author, List<String> keywords) {
        this.text = text;
        this.author = author;
        this.keywords = new ArrayList<>(keywords);
        ;
        this.isUpperCase = false; // Изначально текст в нижнем регистре !!! Не совсем поняла !!!
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isUpperCase() {
        return isUpperCase;
    }

    public void setUpperCase(boolean upperCase) {
        isUpperCase = upperCase;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }


    @Override
    public String toString() {
        return "\n" + text + " - " + author + "\nКлючевые слова: " + keywords;
    }
}
