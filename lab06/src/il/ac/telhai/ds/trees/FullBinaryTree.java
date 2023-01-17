package il.ac.telhai.ds.trees;

public class FullBinaryTree<T> extends BinaryTree<T> {
    public FullBinaryTree(T key) {
        super(key);
    }
    public FullBinaryTree(T key, FullBinaryTree<T> left, FullBinaryTree<T> right) {
        super(key, left, right);
        if (left != right && (left == null || right == null)) throw new RuntimeException();
    }

    @Override
    public void setRight(BinaryTreeI<T> right) {
        if(right == null && getLeft() == null) return;
        if(!(right instanceof FullBinaryTree)) throw new RuntimeException();
        if(getLeft() == null) throw new RuntimeException();
        super.setRight(right);
    }

    @Override
    public void setLeft(BinaryTreeI<T> left) {
        if(left == null && getRight() == null) return;
        if(!(left instanceof FullBinaryTree)) throw new RuntimeException();
        if(getRight() == null) throw new RuntimeException();
        super.setLeft(left);
    }

}
