import java.util.List;
import java.util.Queue;

public class QueueChecker {

    public static <T> boolean checkSegmentEqual(Queue<T> queue, int i, int j) {
        if (queue == null || queue.isEmpty()) return false;
        if (i < 0 || j >= queue.size() || i >= j) return false;

        List<T> list = (List<T>) queue;

        T first = list.get(i);

        for (int k = i + 1; k <= j; k++) {
            if (!list.get(k).equals(first)) return false;
        }
        return true;
    }
}
