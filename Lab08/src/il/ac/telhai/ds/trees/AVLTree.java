package il.ac.telhai.ds.trees;


public class AVLTree<T extends Comparable<T>> {

    private AVLTree<T> left;
    private AVLTree<T> right;
    private final T key;
    private int height;

    public AVLTree(T value) {
        this.key = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }


    public AVLTree<T> add(T value) {
        if (key.compareTo(value) > 0) {
            if (left == null) {
                left = new AVLTree<>(value);
                updateHeight();
                return this;
            }
            left = left.add(value);
            updateHeight();
            if (getBalanceFactor() > 1) {
                if (left.getBalanceFactor() >= 0) {
                    return leftLeft(this);
                }
                updateHeight();
                return leftRight(this);
            }
            updateHeight();
            return this;
        }

        if (right == null) {
            right = new AVLTree<>(value);
            updateHeight();
            return this;
        }
        right = right.add(value);
        updateHeight();
        if (getBalanceFactor() < -1) {
            if (right.getBalanceFactor() <= 0) {
                return rightRight(this);
            }
            updateHeight();
            return rightLeft(this);
        }
        updateHeight();
        return this;
    }

    public AVLTree<T> rightRight(AVLTree<T> tree) {
        AVLTree<T> head = tree.right;
        AVLTree<T> tmp = tree.right.left;
        tree.right.left = tree;
        tree.right = tmp;
        upDateSide(head);
        return head;
    }

    public AVLTree<T> leftLeft(AVLTree<T> tree) {
        AVLTree<T> head = tree.left;
        AVLTree<T> tmp = tree.left.right;
        tree.left.right = tree;
        tree.left = tmp;
        upDateSide(head);
        return head;
    }

    public AVLTree<T> leftRight(AVLTree<T> tree) {
        AVLTree<T> left = tree.left;
        AVLTree<T> leftRight = tree.left.right;
        left.right = leftRight.left;
        leftRight.left = left;
        tree.left = leftRight;
        return leftLeft(tree);
    }

    public AVLTree<T> rightLeft(AVLTree<T> tree) {
        AVLTree<T> right = tree.right;
        AVLTree<T> rightLeft = tree.right.left;

        right.left = rightLeft.right;
        rightLeft.right = right;
        tree.right = rightLeft;
        return rightRight(tree);
    }

    public void upDateSide(AVLTree<T> tree) {
        tree.right.updateHeight();
        tree.left.updateHeight();
        tree.updateHeight();
    }

    public int getLeftH(){
        return (left == null) ? -1 : left.height;
    }

    public int getRightH(){
       return (this.right == null) ? -1 : this.right.height;
    }

    public int getBalanceFactor() {
        int leftHeight = getLeftH();
        int rightHeight = getRightH();
        return leftHeight - rightHeight;
    }


    public void updateHeight() {
        int leftHeight = getLeftH();
        int rightHeight = getRightH();
        height = 1 + Math.max(leftHeight, rightHeight);
    }

    public T getValue() {
        return key;
    }

    public AVLTree<T> getLeft() {
        return left;

    }

    public AVLTree<T> getRight() {
        return right;
    }

}
