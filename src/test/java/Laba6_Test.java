
import org.example.Main;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
// Тесты для класса Main
class MainTest {
    // Тест генерации массива случайных чисел
    @Test
    void testRandomArrayGeneration() {
        int N = 10; // Задайте нужное значение N
        int[] array = new Random().ints(N, 0, 101).toArray();
        // Проверка, что длина массива соответствует N
        assertEquals(N, array.length);
        // Проверка, что все числа в диапазоне от 0 до 100
        for (int num : array) {
            assertTrue(num >= 0 && num <= 100);
        }
    }
    // Тест генерации простых чисел
    @Test
    void testGeneratePrimes() {
        int primeCount = 10; // Задайте нужное количество простых чисел
        List<Integer> primes = Main.generatePrimes(primeCount);
        // Проверка, что количество сгенерированных простых чисел равно primeCount
        assertEquals(primeCount, primes.size());
        for (Integer prime : primes) {
            assertTrue(isPrime(prime)); // Проверка, что каждое число является простым
        }
    }
    // Метод для проверки, является ли число простым
    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    // Тест работы с классом Human
    @Test
    void testHumanComparable() {
        Main.Human h1 = new Main.Human("Иван", "Петров", 25);
        Main.Human h2 = new Main.Human("Сергей", "Сидоров", 30);
        // Проверка, что Иван Петров меньше Сергея Сидорова по фамилии
        assertTrue(h1.compareTo(h2) < 0); // Петров < Сидоров
    }
    // Тест сортировки объектов Human в TreeSet
    @Test
    void testTreeSetSorting() {
        Set<Main.Human> treeSet = new TreeSet<>();
        treeSet.add(new Main.Human("Иван", "Петров", 25));
        treeSet.add(new Main.Human("Сергей", "Сидоров", 30));
        treeSet.add(new Main.Human("Анна", "Иванова", 22));
        List<Main.Human> sortedList = new ArrayList<>(treeSet);
        // Проверка порядка сортировки
        assertEquals("Анна Иванова, 22", sortedList.get(0).toString());
        assertEquals("Иван Петров, 25", sortedList.get(1).toString());
        assertEquals("Сергей Сидоров, 30", sortedList.get(2).toString());
    }
    // Тест подсчета частоты слов
    @Test
    void testWordFrequency() {
        String text = "This is a sample text. This text is for testing purposes.";
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("this", 2);
        expected.put("is", 2);
        expected.put("a", 1);
        expected.put("sample", 1);
        expected.put("text", 2);
        expected.put("for", 1);
        expected.put("testing", 1);
        expected.put("purposes", 1);

        Map<String, Integer> actual = new HashMap<>();
        for (String word : words) {
            actual.put(word, actual.getOrDefault(word, 0) + 1);
        }
        // Проверка, что фактический результат совпадает с ожидаемым
        assertEquals(expected, actual);
    }
    // Тест переключения карты
    @Test
    void testSwitchMap() {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("One", 1);
        originalMap.put("Two", 2);
        originalMap.put("Three", 3);
        Map<Integer, String> switchedMap = Main.switchMap(originalMap);
        // Проверка, что значения были правильно переключены
        assertEquals("One", switchedMap.get(1));
        assertEquals("Two", switchedMap.get(2));
        assertEquals("Three", switchedMap.get(3));
    }
}
