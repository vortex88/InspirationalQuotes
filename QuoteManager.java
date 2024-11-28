package InspirationalQuotes;

import java.util.ArrayList;
import java.util.List;


public class QuoteManager { // Отвечает за управление цитататами
    private ArrayList<Quote> quotes; // Поле объектов Цитата

    // Метод, который добавляет цитату в коллекцию.
    public void addQuote(Quote quote) {
        quotes.add(quote);
    }

    // Метод, который удаляет цитату по её тексту.
    public void removeQuote(String text) {
        quotes.removeIf(quote -> quote.getText().equals(text)); //Метод removeIf принимает предикат
        // (это лямбда-выражение, оно проверяет, совпадает ли текст цитаты с переданным параметром text) и удаляет все элементы списка,
        // которые удовлетворяют этому условию.

    }

    // Метод, который возвращает список цитат указанного автора.
    public void findQuotesByAuthor(String author) {
        List<Quote> quotesByAuthor = new ArrayList<>(); // Создается список quotesByAuthor, который будет хранить все цитаты найденного автора.
        for (Quote quote : quotes) { // Метод проходит по всем цитатам в списке quotes.
            if (quote.getAuthor().equals(author)) { // Для каждой цитаты проверяется, совпадает ли её автор с переданным параметром author
                quotesByAuthor.add(quote); // Если автор совпадает, цитата добавляется в список quotesByAuthor.
            }
        }
        if (!quotesByAuthor.isEmpty()) { // Если список цитат не пустой, выводится заголовок с именем автора.
            System.out.println("\n Цитаты автора \"" + author + "':"); // Выводит цитату в нужном формате.
            for (Quote quote : quotesByAuthor) {
                quote.display();
            }
        } else {
            System.out.println("Цитаты автора '" + author + "' не найдены.");
        }
    }

    // Метод, который возвращает список цитат, содержащих указанное ключевое слово.
    public void findQuotesByKeyword(String keyword) {
        List<Quote> quotesByKeyword = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getKeywords().contains(keyword)) { // Для каждой цитаты проверяется, содержится ли указанное ключевое слово в списке ключевых слов цитаты.
                quotesByKeyword.add(quote); // Если ключевое слово содержится, цитата добавляется в список quotesByKeyword.
            }
        }
        if (!quotesByKeyword.isEmpty()) {
            System.out.println("\nЦитаты с ключевым словом '" + keyword + "':"); // Выводит заголовок с указанным ключевым словом.
            for (Quote quote : quotesByKeyword) { // Проходит по всем цитатам в списке quotesByKeyword.
                quote.display(); // Выводит каждую цитату в нужном формате.
            }
        } else {
            System.out.println("\nЦитаты с ключевым словом '" + keyword + "' не найдены.");
        }

    }

    // Метод, который вызывает метод toggleCase() у каждой цитаты в коллекции.
    public void toggleAllQuotesCase() {
        for (Quote quoteToggLeClase : quotes) {
            quoteToggLeClase.toggleCase();
        }
    }

    // Метод, который выводит все цитаты из коллекции.
    public void displayAllQuotes() {
        System.out.println("\nПолный список всех цитат: ");
        for (Quote quote : quotes) {
            StringBuilder keywordsString = new StringBuilder();
            for (String keyword : quote.getKeywords()) {
                keywordsString.append(keyword).append(", ");
            }
            if (keywordsString.length() > 0) {
                keywordsString.setLength(keywordsString.length() - 2);
            }
            System.out.println("«" + quote.getText() + "» — " + quote.getAuthor() + " (Ключевые слова: " + keywordsString.toString() + ")");
        }
    }

    // Метод заменяет одну цитату на другую в коллекции. Если цитата oldQuote найдена, она заменяется на newQuote. Если цитата не найдена, то выводится сообщение об этом.
    public void updateQuote(Quote oldQuote, Quote newQuote) {

        boolean found = false; // Флаг, указывающий, найдена ли цитата для замены
        for (int i = 0; i < quotes.size(); i++) { // Идем по всему списку с цитатами
            if (quotes.get(i).equals(oldQuote)) { // Если текущая цитата равна oldQuote
                quotes.set(i, newQuote); // Заменяем цитату на newQuote
                found = true; // Устанавливаем флаг, что цитата найдена и заменена
                break; // Прерываем цикл, так как цитата найдена и заменена
            }
        }
        if (!found) { // Если цитата не найдена
            System.out.println("Цитата для замены не найдена."); // Выводим сообщение об этом
        }
    }

//            if (quote.getText(oeldQuote) ){
//                quote.getText(newQuote){
//                    break;


    public QuoteManager() {
        this.quotes = new ArrayList<>();
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }
}
