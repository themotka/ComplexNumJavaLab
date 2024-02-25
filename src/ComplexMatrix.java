import java.util.Arrays;

public class ComplexMatrix {
    private ComplexNumber[][] matrix;

    public ComplexMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    public ComplexMatrix(int row, int col) {
        matrix = new ComplexNumber[row][col];
    }

    public void setMatrix(ComplexNumber[][] matrix) {
        this.matrix = matrix;
    }

    public ComplexNumber[][] getMatrix() {
        return matrix;
    }

    public void setValue(int w, int h, ComplexNumber val) {
        matrix[h][w] = val;
    }

    public ComplexNumber getValue(int w, int h) {
        return matrix[h][w];
    }

    public int[] getSize(){
        int[] size = new int[2];
        size[1] = matrix.length;
        size[0] = matrix[0].length;
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int w = this.getSize()[0];
        int h = this.getSize()[1];
        for (int row = 0; row < h; row++) {
            for (int column = 0; column < w; column++) {
                stringBuilder.append(matrix[row][column]);
                stringBuilder.append(column != w - 1 ? ", " : ";");
            }
            stringBuilder.append(row != h - 1 ? "\n" : "");
        }
        stringBuilder.append("] ");
        return stringBuilder.toString();
    }

    public ComplexMatrix plus(ComplexMatrix a) throws CustomException {
        int h = this.getSize()[0];
        int w = this.getSize()[1];
        ComplexMatrix res = new ComplexMatrix(w, h);
        if (!Arrays.equals(this.getSize(), a.getSize())){
            throw new CustomException("Matrices should have the same size!");
        }
        else {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    res.setValue(i, j, a.getValue(i,j).sum(this.getValue(i,j)));
                }
            }
        }
        return res;
    }
    public ComplexMatrix minus(ComplexMatrix a) throws CustomException {
        int h = this.getSize()[0];
        int w = this.getSize()[1];
        ComplexMatrix res = new ComplexMatrix(w, h);
        if (!Arrays.equals(this.getSize(), a.getSize())){
            throw new CustomException("Matrices should have the same size!");
        }
        else {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    res.setValue(i, j, a.getValue(i,j).differ(this.getValue(i,j)));
                }
            }
        }
        return res;
    }
    public ComplexMatrix multiply(ComplexMatrix a) throws CustomException {
        int h1 = this.getSize()[1];
        int w2 = a.getSize()[0];

        int w1 = this.getSize()[0];
        int h2 = a.getSize()[1];

        ComplexMatrix res = new ComplexMatrix(h1, w2);
        if (w1 != h2) {
            throw new CustomException("1st matrix cols != 2nd matrix rows");
        }
        else {
            for (int i = 0; i < res.getSize()[0]; i++) {
                for (int j = 0; j < res.getSize()[1]; j++) {
                    res.setValue(i, j, new ComplexNumber(0));
                    for (int k = 0; k < w1; k++) {
                        res.setValue(i, j, res.getValue(i,j).sum(this.getValue(k,j).multiply(a.getValue(i, k))));
                    }
                }
            }
        }
        return res;
    }

    public ComplexMatrix getTransposed(){
        int h = this.getSize()[1];
        int w = this.getSize()[0];
        ComplexMatrix res = new ComplexMatrix(w, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                res.setValue(i, j, this.getValue(j, i));
            }
        }

        return res;
    }

}