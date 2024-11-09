package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        // a) Создайте массив из N случайных чисел от 0 до 100.
        int N = 10; // Задайте нужное значение N
        int[] array = new Random().ints(N, 0, 101).toArray();
        System.out.println("Массив: " + Arrays.toString(array));

        // b) На основе массива создайте список List.
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("Список: " + list);

        // c) Отсортируйте список по возрастанию.
        Collections.sort(list);
        System.out.println("Отсортированный список (возрастание): " + list);

        // d) Отсортируйте список в обратном порядке.
        Collections.reverse(list);
        System.out.println("Отсортированный список (обратный порядок): " + list);

        // e) Перемешайте список.
        Collections.shuffle(list);
        System.out.println("Перемешанный список: " + list);

        // f) Выполните циклический сдвиг на 1 элемент.
        if (!list.isEmpty()) {
            Integer first = list.remove(0);
            list.add(first);
        }
        System.out.println("Список после циклического сдвига: " + list);

        // g) Оставьте в списке только уникальные элементы.
        Set<Integer> uniqueSet = new HashSet<>(list);
        list.clear();
        list.addAll(uniqueSet);
        System.out.println("Список с уникальными элементами: " + list);

        // h) Оставьте в списке только дублирующиеся элементы.
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        list.clear();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        System.out.println("Список с дублирующимися элементами: " + list);

        // i) Из списка получите массив.
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(newArray));

        // j) Посчитайте количество вхождений каждого числа в массив и выведите на экран.
        System.out.println("Частота вхождения чисел:");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Генерация простых чисел
        int primeCount = 10; // Задайте нужное количество простых чисел
        List<Integer> primes = generatePrimes(primeCount);
        System.out.println("Первые " + primeCount + " простых чисел: " + primes);

        // Вывод простых чисел в обратном порядке
        Collections.reverse(primes);
        System.out.println("Первые " + primeCount + " простых чисел в обратном порядке: " + primes);
        // Работа с классом Human
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Иван", "Петров", 25));
        humans.add(new Human("Сергей", "Сидоров", 30));
        humans.add(new Human("Анна", "Иванова", 22));

        // a) HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c) TreeSet
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);

        // d) TreeSet с компаратором
        Set<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByLastName());
        treeSetWithComparator.addAll(humans);
        System.out.println("TreeSet с компаратором по фамилии: " + treeSetWithComparator);

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetWithAnonymousComparator = new TreeSet<>(Comparator.comparingInt(Human::getAge));
        treeSetWithAnonymousComparator.addAll(humans);
        System.out.println("TreeSet с анонимным компаратором по возрасту: " + treeSetWithAnonymousComparator);

        // f) Комментарии
        /*
        HashSet не сохраняет порядок добавления элементов.
        LinkedHashSet сохраняет порядок добавления элементов.
        TreeSet сортирует элементы по естественному порядку или по заданному компаратору.
        */
        // Работа с частотой слов
        String text = "This is a sample text. This text is for testing purposes.";
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Частота слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Переключение карты
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("One", 1);
        originalMap.put("Two", 2);
        originalMap.put("Three", 3);
        Map<Integer, String> switchedMap = switchMap(originalMap);
        System.out.println("Оригинальная карта: " + originalMap);
        System.out.println("Перевернутая карта: " + switchedMap);
    }
    // Генерация простых чисел
    public static List<Integer> generatePrimes(int N) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        int num = 2; // Начинаем с первого простого числа
        while (count < N) {
            if (isPrime(num)) {
                primes.add(num);
                count++;
            }
            num++;
        }
        return primes;
    }
    // Проверка, является ли число простым
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    // Класс Human
    public static class Human implements Comparable<Human> {
        private final String firstName;
        private final String lastName;
        private final int age;
        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public String getLastName() {
            return lastName;
        }
        public int getAge() {
            return age;
        }
        @Override
        public int compareTo(Human other) {
            return this.lastName.compareTo(other.lastName);
        }
        @Override
        public String toString() {
            return firstName + " " + lastName + ", " + age;
        }
    }
    // Компаратор для класса Human по фамилии
    static class HumanComparatorByLastName implements Comparator<Human> {
        @Override
        public int compare(Human h1, Human h2) {
            return h1.getLastName().compareTo(h2.getLastName());
        }
    }
    // Переключение карты
    public static <K, V> Map<V, K> switchMap(Map<K, V> originalMap) {
        Map<V, K> switchedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            switchedMap.put(entry.getValue(), entry.getKey());
        }
        return switchedMap;
    }
}
