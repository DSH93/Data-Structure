package il.ac.telhai.ds.trees;

public class BinaryTree<T> implements BinaryTreeI<T> {

    private T key;
    private BinaryTreeI<T> left;
    private BinaryTreeI<T> right;


    public BinaryTree(T key, BinaryTreeI<T> left, BinaryTreeI<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(T key) {
        this.key = key;
    }

    @Override
    public BinaryTreeI<T> getLeft() {
        return this.left;
    }

    @Override
    public BinaryTreeI<T> getRight() {
        return this.right;
    }

    @Override
    public T getValue() {
        return this.key;
    }

    @Override
    public void setValue(T value) {
        this.key = value;
    }

    @Override
    public void setLeft(BinaryTreeI<T> left) {
        this.left = left;
    }

    @Override
    public void setRight(BinaryTreeI<T> right) {
        this.right = right;
    }

    @Override
    public boolean isLeaf() {
        return getRight() == null && getLeft() == null;
    }

    
    @Override
    public int height() {
        if (isLeaf()) return 0;
        if (getRight() == null) return 1 + getLeft().height();
        if (getLeft() == null) return 1 + getRight().height();
        return 1 + Math.max(getLeft().height(), getRight().height());
    }

    @Override
    public int size() {
        if (isLeaf()) return 1;
        if (left == null) return 1 + getRight().size();
        if (right == null) return 1 + getLeft().size();
        return 1 + getLeft().size() + getRight().size();
    }


    @Override
    public void clear() {
        this.right = null;
        this.left = null;

    }

    @Override
    public String preOrder() {
        return preOrder(" ", " ");
    }


    @Override
    public String preOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder result = new StringBuilder();
        result.append(separationBeforeVal).append(key.toString()).append(separationAfterVal);
        if (getLeft() != null) result.append(getLeft().preOrder(separationBeforeVal, separationAfterVal));
        if (getRight() != null) result.append(getRight().preOrder(separationBeforeVal, separationAfterVal));
        return result.toString();
    }

    @Override
    public String inOrder() {
        return inOrder(" ", " ");
    }

    @Override
    public String inOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder result = new StringBuilder();
        if (isLeaf()) return separationBeforeVal + key.toString() + separationAfterVal;
        if (getLeft() != null) result.append(getLeft().inOrder(separationBeforeVal, separationAfterVal));
        result.append(separationBeforeVal).append(key.toString()).append(separationAfterVal);
        if (getRight() != null) result.append(getRight().inOrder(separationBeforeVal, separationAfterVal));
        return result.toString();
    }


    @Override
    public String postOrder() {
        return postOrder(" ", " ");
    }

    @Override
    public String postOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder result = new StringBuilder();
        if (getLeft() != null) result.append(getLeft().postOrder(separationBeforeVal, separationAfterVal));
        if (getRight() != null) result.append(getRight().postOrder(separationBeforeVal, separationAfterVal));
        result.append(separationBeforeVal).append(key.toString()).append(separationAfterVal);
        return result.toString();
    }
}
