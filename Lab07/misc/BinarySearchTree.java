package il.ac.telhai.ds.misc;

public class BinarySearchTree<T extends Comparable<T>> {

    private BstNode root;
    private int size;

    // Binary Search Tree Node
    class BstNode {
        T val;
        BstNode left, right;


        public BstNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public enum Direction {
        LEFT, RIGHT
    }


    // Returns the val given a path from the root.
    // Used for testing. DO NOT DELETE.
    public T getValInPath(Direction... direction) {
        BstNode node = root;
        for (Direction d : direction) {
            if (d.equals(Direction.LEFT) && node.left != null)
                node = node.left;
            else if (d.equals(Direction.RIGHT) && node.right != null)
                node = node.right;
            else
                return null;
        }
        return node.val;
    }

    /**
     * Constructs an empty BinarySearchTree.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }


    public int size() {
        return this.size;
    }


    public boolean add(T val) {
        if (contains(val)) return false;
        addRec(val, root);
        size++;
        return true;

    }

    public BstNode addRec(T val, BstNode n) {
        if (isLeaf(n)) {
            BstNode newVal = new BstNode(val);
            if (val.compareTo(n.val) < 0) n.left = newVal;
            if (val.compareTo(n.val) > 0) n.right = newVal;
            return newVal;
        }
        if (val.compareTo(n.val) < 0) return addRec(val, n.left);
        if (val.compareTo(n.val) > 0) return addRec(val, n.right);
        return null;
    }

    /**
     * Removes the object in the tree which is equal to the parameter.
     * Nothing is done if not found
     *
     * @param val: the object to be looked for in the tree
     * @return True, if the element was removed. Otherwise false.
     */
    public boolean remove(T val) {
        if (!contains(val)) return false;
        recRemove(val, root);
        return true;

    }

    public BstNode recRemove(T val, BstNode n) {

        if (isLeaf(n) && n.val.compareTo(val) == 0) n = null;


        if (n.right != null && isLeaf(n.right) && n.left == null) {
            if (n.val.compareTo(val) == 0) {
                n = n.right;
                n.right = null;
            }
        }

        if (n.left != null && isLeaf(n.left) && n.right == null) {
            if (n.val.compareTo(val) == 0) {
                n = n.left;
                n.right = null;
            }
        }

        BstNode successor = findTheSuccessor(val, n.right);
        T value = n.val;
        n.val = successor.val;
        successor.val = value;
        return recRemove(val, successor);

    }

    public BstNode findTheSuccessor(T val, BstNode n) {
        if (n.left == null) return n;
        return findTheSuccessor(val, n.left);
    }


    /**
     * Looks for an object which is equal to the parameter.
     *
     * @param val: the object to be looked for in the tree
     * @return true if the tree contains this object. Otherwise, return false.
     */


    public boolean contains(T val) {
        BstNode n = root;
        return containsRec(val, root);

    }

    public boolean isLeaf(BstNode n) {
        return (n.left == null && n.right == null);
    }

    public boolean containsRec(T val, BstNode n) {
        if (isLeaf(n)) {
            if (val.compareTo(n.val) == 0) return true;
            return false;
        }
        if (val.compareTo(n.val) == 0) return true;
        if (val.compareTo(n.val) < 0) return containsRec(val, n.left);
        if (val.compareTo(n.val) > 0) return containsRec(val, n.right);
        return false;
    }

    /**
     * Looks for the minimal object in the tree, which is greater than or equal to
     * the parameter.
     *
     * @param val: the object to be looked for in the tree
     * @return a reference to the found object.
     */
    public T findGe(T val) {
        // Complete this code.
    }

}
