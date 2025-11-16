import java.util.Iterator;
import java.util.List;

public class ListRemover {
    public static <T> void removeAllOccurrences(List<T> list, T value) {
        if (list == null || list.isEmpty()) {
            System.out.println("Список пуст или не инициализирован.");
            return;
        }

        Iterator<T> it = list.iterator();
        int count = 0;

        while (it.hasNext()) {
            if (it.next().equals(value)) {
                it.remove();
                count++;
            }
        }

        System.out.println("Удалено элементов: " + count);
        System.out.println("Список после удаления: " + list);
    }
}
