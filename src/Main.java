public class Main {
    public static void main(String[] args) throws CustomException {
        ComplexNumber n = new ComplexNumber(2, 1);
        ComplexNumber m = new ComplexNumber(2, 2);
        System.out.println("Operations with complex numbers: ");
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        System.out.println("n-m: " + n.differ(m));
        System.out.println("n+m: " + n.sum(m));
        System.out.println("n*m: " + n.multiply(m) + "\n");
        System.out.println("Operations with matrices:");
        ComplexMatrix matrix1 = new ComplexMatrix(2, 1);
        matrix1.setValue(0,0, n);
        matrix1.setValue(0, 1, m);
        System.out.println("matrix1:\n" + matrix1);
        ComplexMatrix matrix2 = new ComplexMatrix(1, 2);
        matrix2.setValue(0,0, n);
        matrix2.setValue(1, 0, m);
        System.out.println("matrix2:\n" + matrix2 + "\n");
        System.out.println("matrix1 * matrix2:\n" + matrix1.multiply(matrix2) + "\n");
        System.out.println("Transposed matrix1:\n" + matrix1.getTransposed() + "\n");
        System.out.println("matrix1 - matrix1:\n" + matrix1.minus(matrix1) + "\n");
        System.out.println("matrix2 + matrix2:\n" + matrix2.plus(matrix2) + "\n");
    }
}
