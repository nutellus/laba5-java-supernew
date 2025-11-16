import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UniqueConsonants {
    private static final String CONS = "бвгджзйклмнпрстфхцчшщ";

    public static void printUniqueConsonants(String filename) {
        Map<Character, Integer> counter = new HashMap<>();

        try (Scanner sc = new Scanner(new File(filename), "UTF-8")) {
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase(Locale.ROOT);
                Set<Character> inWord = new HashSet<>();

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (CONS.indexOf(c) >= 0) {
                        inWord.add(c);
                    }
                }

                for (char c : inWord) {
                    counter.merge(c, 1, Integer::sum);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
            return;
        }

        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> e : counter.entrySet()) {
            if (e.getValue() == 1) {
                result.add(e.getKey());
            }
        }
        Collections.sort(result);

        for (char c : result) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
