package il.ac.telhai.ds.stack;


public class DLinkedList<T> implements List<T>  {

    private DNode head;
    private DNode tail;
    private DNode cursor;
    private class DNode {
        private T element;
        private DNode next;
        private DNode prev;
        public DNode(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setNext(DNode next) {
            this.next = next;
        }

        public DNode getNext() {
            return next;
        }

        public void setPrev(DNode prev) {
            this.prev = prev;
        }

        public DNode getPrev() {
            return prev;
        }
    } // d Class

    public DLinkedList() {
        head = new DNode(null);
        tail = new DNode(null);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        cursor = head;
    } //Constructor

    @Override
    public void insert(T newElement)  {
        if (newElement == null){
            throw new IllegalArgumentException();
        }
        DNode newNode = new DNode(newElement);
        newNode.next = cursor.next;
        newNode.prev = cursor;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        cursor = newNode;
    }

    @Override
    public T remove() {
        if (!isEmpty()) {
            T del = cursor.element;
            cursor.next.prev = cursor.prev;
            cursor.prev.next = cursor.next;
            if(hasNext()) {
                cursor = cursor.next;
            }
            else {
                if (head.next != tail) {
                    cursor = head.next;
                } else cursor = head;
            }
            return del;
        }
        return null;
    }

    @Override
    public T remove(T element) {
        if (!isEmpty()) {
            T del = null;
            DNode localCursor = head.next;
            while (localCursor.element != null) {
                if (localCursor.element == element) {
                    cursor = localCursor;
                    del = remove();
                }
                localCursor = localCursor.next;
            }
            return del;
        }
        return null;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        cursor = head;
    }

    @Override
    public void replace(T newElement) {
        if (!isEmpty() && newElement != null) {
            cursor.element = newElement;
        }
        else throw new IllegalArgumentException();

    }

    @Override
    public boolean isEmpty() {
        if (head.next == tail && tail.prev == head) return true;
        return false;
    }

    @Override
    public boolean goToBeginning() {
        if (!isEmpty()) {
            cursor = head.next;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToEnd() {
        if (!isEmpty()) {
            cursor = tail.prev;
            return true;
        }
        return false;
    }

    @Override
    public T getNext() {
        if (cursor.next != null && cursor.next != tail) {
            cursor = cursor.next;
            return cursor.element;
        }
        return null;
    }

    @Override
    public T getPrev() {
        if (cursor.prev != null && cursor.prev != head) {
            cursor = cursor.prev;
            return cursor.element;
        }
        return null;
    }

    @Override
    public T getCursor() {
        if (!isEmpty()) {
            return cursor.element;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (isEmpty()) return false;
        if (cursor.next != null && cursor.next != tail) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPrev() {
        if (isEmpty()) return false;
        if (cursor.prev != null && cursor.prev != head) {
            return true;
        }
        return false;
    }

}
// DS