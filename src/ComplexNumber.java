public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber(double re) {
        this.re = re;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public ComplexNumber sum(ComplexNumber a){
        return new ComplexNumber(re + a.re, im + a.im);
    }

    public void plus(ComplexNumber a){
        re += a.re;
        im += a.im;
    }

    public ComplexNumber differ(ComplexNumber a){
        return new ComplexNumber(re - a.re, im - a.im);
    }

    public ComplexNumber multiply(ComplexNumber a){
        return new ComplexNumber(re * a.re - im * a.im, re * a.im + im * a.re);
    }

    @Override
    public String toString() {
        return re + " + " + im + "i";
    }
}
