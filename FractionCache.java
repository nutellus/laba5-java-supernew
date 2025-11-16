import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FractionCache {
    private static final FractionCache INSTANCE = new FractionCache();
    private final Map<String, Double> cache = new ConcurrentHashMap<>();

    private FractionCache() {}

    public static FractionCache getInstance() {
        return INSTANCE;
    }

    public double compute(Fractionable f) {
        String key = f.getNumerator() + "/" + f.getDenominator();
        return cache.computeIfAbsent(key,
                k -> ((double) f.getNumerator()) / f.getDenominator());
    }

    public void clear() {
        cache.clear();
    }
}
