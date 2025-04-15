package stepik;
import java.lang.Double;
import java.util.Objects;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        ComplexNumber that = (ComplexNumber) other;
        return Double.compare(re, that.re) == 0 && Double.compare(im, that.im) == 0;
    }
    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
}
//same return type or subclass
//same access modificator or more accessible
//Override not required, but strongly recommended
