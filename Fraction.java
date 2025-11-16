import java.util.Objects;

public final class Fraction implements Fractionable {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Override
    public double toDouble() {
        return FractionCache.getInstance().compute(this);
    }

    @Override
    public void setNumerator(int n) {
        this.numerator = n;
    }

    @Override
    public void setDenominator(int d) {
        if (d <= 0) {
            throw new IllegalArgumentException("Знаменатель должен быть положительным");
        }
        this.denominator = d;
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fraction)) {
            return false;
        }
        Fraction other = (Fraction) o;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
