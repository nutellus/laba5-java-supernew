import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Лабораторная работа №5 — Шаблоны ООП и коллекции ===");
            System.out.println("1) Задание 1: Дроби (Fraction)");
            System.out.println("2) Задание 2: Количество мяуканий (Cat/Meowable)");
            System.out.println("3) Задание 3.5: Удалить из списка все элементы с указанным значением");
            System.out.println("4) Задание 4: Олимпиада — участники с максимальной суммой баллов");
            System.out.println("5) Задание 5: Согласные из файла (Set/Map)");
            System.out.println("6) Задание 6: Очередь — проверка равенства участка");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт меню: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Некорректный ввод.");
                continue;
            }

            switch (choice) {
                case 1 -> runFractions();
                case 2 -> runCats();
                case 3 -> runListRemoval();
                case 4 -> runOlympiad();
                case 5 -> runUniqueConsonants();
                case 6 -> runQueueCheck();
                case 0 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Нет такого пункта меню.");
            }
        }
    }

    // ---------- Задание 1 ----------
    private static void runFractions() {
        System.out.println("\n--- Задание 1: Дроби ---");

        try {
            System.out.print("Введите числитель: ");
            int num = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите знаменатель (не 0): ");
            int den = Integer.parseInt(scanner.nextLine());

            Fraction f = new Fraction(num, den);
            System.out.println("Дробь: " + f + " = " + f.toDouble());

            System.out.print("Новый числитель (для демонстрации setNumerator): ");
            int newNum = Integer.parseInt(scanner.nextLine());
            f.setNumerator(newNum);
            System.out.println("После изменения: " + f + " = " + f.toDouble());

            Fraction f2 = new Fraction(newNum, den);
            System.out.println("Сравнение equals с другой дробью " + f2 + ": " + f.equals(f2));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // ---------- Задание 2 ----------
    private static void runCats() {
        System.out.println("\n--- Задание 2: Количество мяуканий ---");

        System.out.print("Введите имя кота: ");
        String name = scanner.nextLine();
        Cat cat = new Cat(name);
        MeowCounter counter = new MeowCounter(cat);

        System.out.print("Введите количество мяуканий: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Ошибка ввода, будет 5 по умолчанию.");
            n = 5;
        }

        Funs.meowsCare(counter, n);
        System.out.println("Счётчик зафиксировал, что " + cat + " мяукал "
                + counter.getCount() + " раз.");

    }


    // ---------- Задание 3 ----------
    private static void runListRemoval() {
        System.out.println("\n--- Задание 3: Удалить элементы списка ---");

        List<String> list = new ArrayList<>();
        System.out.println("Введите элементы списка через Enter (пустая строка — конец):");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;
            list.add(line);
        }

        System.out.println("Ваш список: " + list);
        System.out.print("Введите значение для удаления: ");
        String val = scanner.nextLine();

        ListRemover.removeAllOccurrences(list, val);
    }

    // ---------- Задание 4 ----------
    private static void runOlympiad() {
        System.out.println("\n--- Задание 4: Олимпиада (Map) ---");
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine().trim();

        Map<String, Integer> results = new HashMap<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {

            int n = Integer.parseInt(fileScanner.nextLine().trim());

            for (int i = 0; i < n; i++) {
                String surname = fileScanner.next();
                String name = fileScanner.next();
                int s1 = fileScanner.nextInt();
                int s2 = fileScanner.nextInt();
                int s3 = fileScanner.nextInt();

                String fullName = surname + " " + name;
                int total = s1 + s2 + s3;

                results.put(fullName, total);
            }

            int max = Collections.max(results.values());

            System.out.println("Максимальный результат: " + max);
            System.out.println("Победители:");

            for (Map.Entry<String, Integer> entry : results.entrySet()) {
                if (entry.getValue() == max) {
                    System.out.println(entry.getKey());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        } catch (Exception e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }


    // ---------- Задание 5 ----------
    private static void runUniqueConsonants() {
        System.out.println("\n--- Задание 5: Сет ---");
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine().trim();
        UniqueConsonants.printUniqueConsonants(filename);
    }

    // ---------- Задание 6 ----------
    private static void runQueueCheck() {
        System.out.println("\n--- Задание 6: Очередь ---");

        Queue<String> q = new LinkedList<>();

        System.out.println("Введите элементы очереди через Enter (пустая строка — конец):");
        while (true) {
            String s = scanner.nextLine().trim();
            if (s.isEmpty()) break;
            q.add(s);
        }

        System.out.println("Очередь: " + q);

        System.out.print("Введите i: ");
        int i = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите j (i < j): ");
        int j = Integer.parseInt(scanner.nextLine());

        boolean ok = QueueChecker.checkSegmentEqual(q, i, j);
        System.out.println("Все элементы в диапазоне равны? " + ok);
    }


}
