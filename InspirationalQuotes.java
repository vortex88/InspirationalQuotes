package InspirationalQuotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InspirationalQuotes {
    public static void main(String[] args) {

        // Создание объектов Quote с использованием конструктора
        Quote quote = new Quote("Мнения как яйца — сколько не имей, а получать по ним больно.", "Варрик Тетрас.",
                Arrays.asList("мнения", "яйца", "больно"));
        Quote quote1 = new Quote("Самые лучшие злодеи не считают себя злодеями. Они борются за благое дело и готовы испачкать руки.", "Варрик Тетрас.",
                Arrays.asList("злодеи", "благое дело", "руки"));
        Quote quote2 = new Quote("Глядите, оптимист! Вымирающий вид. Я будто единорога встретил!", "Дориан Павус.",
                Arrays.asList("оптимист", "вымирающий вид", "единорог", "Dragon age"));
        Quote quote3 = new Quote("Дружелюбие можно изобразить. А вот с умом, к сожалению, такой фокус не пройдет.", "Морриган",
                Arrays.asList("дружелюбие", "изобразить", "ум", "фокус", "сожаление", "Dragon age"));
        Quote quote4 = new Quote("Я умею все: от убийства до завивки волос.", "Зевран",
                Arrays.asList("умею", "все", "убийство", "завивка волос", "Dragon age"));


        // Метод, который выводит цитату в нужном формате
        quote.display();
        quote1.display();
        quote2.display();
        quote3.display();
        quote4.display();


        // Вывод исходного текста
        System.out.println("\nОригинальная цитата: " + quote.getText());

        // Используем метод для переключения регистра в тексте
        quote.toggleCase();

        // Вывод текста после переключения регистра
        System.out.println("Цитата после переключения регистра: " + quote.getText());

        // Используем метод для добавления ключевого слова в список
        quote.addKeyword("имей");
        System.out.println("\nНовый список ключевых слов после добавления: " + quote.getKeywords());

        // Используем метод для удаления ключевого слова из списка
        quote1.removeKeyword("тяжело");
        quote.removeKeyword("имей");
        System.out.println("\nНовый список ключевых слов после удаления: " + quote.getKeywords());

        // Создание объекта QuoteManager
        QuoteManager quoteManager = new QuoteManager();
        quoteManager.addQuote(quote);
        quoteManager.addQuote(quote1);
        quoteManager.addQuote(quote3);
        quoteManager.addQuote(quote4);

        // Метод показывает все цитаты в списке
        quoteManager.displayAllQuotes();

        // Найти по ключевому слову все цитаты из списка
        quoteManager.findQuotesByKeyword("Dragon age");

        // Удалить цитату из списка по тексту.
        quoteManager.removeQuote("Я умею все: от убийства до завивки волос.");

        // Вывести все цитаты оставшиеся в списке
        quoteManager.displayAllQuotes();

        // Вывести цитаты найденные по имени автора:
        quoteManager.findQuotesByAuthor("Варрик Тетрас.");

        // Переводит все в другой регистр
        quoteManager.toggleAllQuotesCase();
        // Метод показывает все цитаты в списке
        quoteManager.displayAllQuotes();

        //
        quoteManager.updateQuote(quote3,quote2);
        // Метод показывает все цитаты в списке
        quoteManager.displayAllQuotes();


    }
}
