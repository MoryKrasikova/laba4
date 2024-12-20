import java.io.*;
import java.util.*;


public class Word {
    private String randomword; // Строка для хранения случайного слова
    private int length; // Длина слова

    // Конструктор
    public Word() {
        randomword = null;
        length = 0;
    }

    // Метод для выбора случайного слова
    public void SelectRandomWord(String filename) throws IOException {

        List<String> words = new ArrayList<>(); // Список для хранения слов

        // Используем try-with-resources для автоматического закрытия файла
        try (BufferedReader file = new BufferedReader(new FileReader(filename))) {
            String word;

            // Читаем все слова из файла
            while ((word = file.readLine()) != null) { // Читаем построчно
                words.add(word); // Добавляем каждое считанное слово в список
            }

            if (!words.isEmpty()) {
                Random rand = new Random(); // Инициализация генератора случайных чисел
                int randomindex = rand.nextInt(words.size()); // Генерация случайного индекса
                randomword = words.get(randomindex);// Сохраняем случайное слово
                length = words.get(randomindex).length(); // Узнаем длину случайного слово

            }
        } catch (FileNotFoundException e) {
            throw new IOException("Ошибка открытия файла: " + filename, e);
        } catch (IOException e) {
            throw new IOException("Ошибка чтения файла: " + filename, e);
        }
    }

    // Метод для получения слова
    public String GetRandomWord() {
        return randomword;
    }

    // Метод для получения длины слова
    public int GetLength() {
        return length;
    }
}
