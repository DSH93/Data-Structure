package il.ac.telhai.ds;

public class MinHeap<T extends Comparable<T>> {
    T[] data;
    int size;

    public MinHeap(int length) {
        data = (T[]) new Comparable[length];
        data[0] = null;
        this.size = 0;
    }

    public MinHeap(T[] arr) {
        for (int i = 0; i < size; i++) arr[i] = data[i];
        this.size = arr.length - 1;
        Heapify();

    }

    public boolean isFull() {
        return !(size < data.length - 1);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void insert(T element) {
        if (isFull()) throw new IllegalStateException();
        data[size + 1] = element;
        size++;
        upHeapify(size, size);
    }

    public T getMin() {
        if (isEmpty()) throw new IllegalStateException();
        return data[1];
    }

    public T deleteMin() {
        T result;
        result = data[1];
        data[1] = data[size + 1];
        size--;
        downHeapify(1, size);
        return result;
    }

    public void upHeapify(int i, int heapSize) {
        int even = i / 2;
        int odd = (i - 1) / 2;
        if (i % 2 == 0) {
            if (data[even].compareTo(data[i]) > 0 && i < heapSize) {
                swap(i / 2, i);
                upHeapify(even, heapSize);
            }
        } else {
            if (data[odd].compareTo(data[i]) > 0) {
                swap(odd, i);
                upHeapify(odd, heapSize);
            }
        }
    }


    public void downHeapify(int i, int heapSize) {
        int left = i * 2;
        int right = i * 2 + 1;
        int largest = i;

        if (left < heapSize && data[left].compareTo(data[largest]) > 0) largest = left;
        if (right < heapSize && data[right].compareTo(data[largest]) > 0) largest = right;
        if (largest != i) {
            swap(largest, i);
            downHeapify(largest, heapSize);
        }

    }

    public void swap(int graterValueIndex, int index2) {
        T tmp = data[graterValueIndex];
        data[graterValueIndex] = data[index2];
        data[index2] = tmp;
    }



        /**
         * return a string represents the heap. The order of the elements are according
         * to The string starts with "[", ends with "]", and the values are seperated
         * with a comma
         */
        public String toString () {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for(int i = 0 ; i < size ; i++){
                stringBuilder.append(data[i]).append(",");
            }
            if(!isEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(']');
            return stringBuilder.toString();
        }

        public void Heapify(){
            int until;
            until = (size % 2 == 0) ? size / 2 : size / 2 + 1;
            for (int i = 1; i < until; i++) {
                if (data[i].compareTo(data[(i * 2) + 1]) > 0) {
                    swap(i, (i * 2) + 1);
                }
            }
        }
    }


