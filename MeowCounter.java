public class MeowCounter implements Meowable {
    private final Meowable target;
    private int count;

    public MeowCounter(Meowable target) {
        this.target = target;
    }

    @Override
    public void meow() {
        target.meow();
        count++;
    }

    public int getCount() {
        return count;
    }
}
