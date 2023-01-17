package il.ac.telhai.ds.hash;

import il.ac.telhai.ds.linkedlist.DLinkedList;

public class HashTable<V> {
    public static final int DEF_MAX_HASH_SIZE = 10;

    private final DLinkedList[] array;
    private final int size;
    private int currentSize = 0;

    public HashTable() {
        this(DEF_MAX_HASH_SIZE);
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public HashTable(int hashSize) {
        this.size = hashSize;
        array = new DLinkedList[size];

        for (int i = 0; i < hashSize; i++) {
            array[i] = new DLinkedList<V>();
        }
    }


    public boolean contains(V val) {
        DLinkedList<V> result = hashFunction(val);
        result.goToBeginning();
        if (result.remove(val) != null) {
            result.insert(val);
            return true;
        }
        return false;
    }


    public boolean add(V val) {
        DLinkedList<V> result = hashFunction(val);
        if (contains(val)) return false;
        result.insert(val);
        currentSize++;
        return true;
    }


    public boolean remove(V val) {
        if (contains(val)) {
            hashFunction(val).remove(val);
            currentSize = currentSize - 1;
            return true;
        }
        return false;
    }

    /**
     * clear al the data in the hash-table
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    /**
     * @return true if the hase-table is empty, otherwise return false.
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    private DLinkedList<V> hashFunction(V val) {
        return array[Math.abs(val.hashCode() % size)];
    }
}