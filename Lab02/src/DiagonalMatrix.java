public class DiagonalMatrix implements Matrix {
    private final int size;
    private double[] diagonalMatrix;
    private boolean isTranspose = false;

    public DiagonalMatrix(int size) {
        this.size = size;
        diagonalMatrix = new double[this.size * 2 - 1];


    }

    public DiagonalMatrix() {
        this.size = MAX_SIZE;
        diagonalMatrix = new double[MAX_SIZE * 2 - 1];


    }

    @Override
    public double get(int i, int j) {

        if (i > this.size || j > this.size || this.size < 1 || i < 1 || j < 1)
            throw new IndexOutOfBoundsException();
        if (isTranspose) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        int index = (j - i) + size - 1;
        return diagonalMatrix[index];
    }

    @Override
    public void set(int i, int j, double x) {
        if (i > this.size || j > this.size || this.size < 1 || i < 1 || j < 1) throw new IndexOutOfBoundsException();
        if (isTranspose) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        int index = (j - i) + size -1;
        diagonalMatrix[index] = x;
    }


    @Override
    public void transpose() {
        if (isTranspose) isTranspose = false;
        else isTranspose = true;

    }

    @Override
    public Matrix getTranspose() {
        DiagonalMatrix mt = new DiagonalMatrix(size);
        mt.diagonalMatrix = diagonalMatrix;
        mt.isTranspose = isTranspose;
        mt.transpose();
        return mt;
    }


    @Override
    public String toString() {
        StringBuilder Mtx = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                double num = this.get(i, j);
                if (j != size) Mtx.append(num).append("\t");
                else Mtx.append(num);
            }
            Mtx.append("\n");
        }
        return Mtx.toString();
    }
}