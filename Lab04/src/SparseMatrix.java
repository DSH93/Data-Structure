public class SparseMatrix<T> implements Matrix<T> {
    private final DLinkedList<SparseMatrixEntry> Mat;

    private class SparseMatrixEntry {
        private T value;
        private int row;
        private int col;


        public SparseMatrixEntry(int row, int col, T val) {
            this.col = col;
            this.row = row;
            this.value = val;
        }
        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T newVal) {
            this.value = newVal;
        }

    }
    private int size;
    private T domVal;
    private boolean isTranspose = false;

    public SparseMatrix(T defaultValue) {
        Mat = new DLinkedList<>();
        size = MAX_SIZE;
        domVal = defaultValue;
    }

    SparseMatrix(int size, T defaultValue) {
        Mat = new DLinkedList<>();
        this.size = size;
        this.domVal = defaultValue;
    }

    @Override
    public T get(int row, int col) {
        if (row > size || col > size || col < 1 || row < 1) return null;
//        if (isTranspose) {
//            int tmp = col;
//            col = row;
//            row = tmp;
//        }
        Mat.goToBeginning();
        while (Mat != null) {
            if (Mat.getCursor().row == row && Mat.getCursor().col == col) {
                return Mat.getCursor().value;
            }
            Mat.getNext();
        }
        return domVal;
    }

    @Override
    public void set(int row, int col, T element) {
        if (row > size || col > size || col < 1 || row < 1) return;
//        if (isTranspose) {
//            int tmp = col;
//            col = row;
//            row = tmp;
//        }
        Mat.goToBeginning();

        while (Mat != null) {
            if (Mat.getCursor().row == row && Mat.getCursor().col == col) {
                Mat.getCursor().value = element;
                return;
            }
            Mat.getNext();
        }
        Mat.insert(new SparseMatrixEntry(row,col,element));
    }

    @Override
    public void transpose() {
        if (!isTranspose) isTranspose = true;
        else isTranspose = false;
    }

//    @Override
//    public Matrix<T> getTranspose() {
//        SparseMatrix mt = new SparseMatrix(size,domVal);
//        mt.transpose();
//        return mt;
//    }

}
