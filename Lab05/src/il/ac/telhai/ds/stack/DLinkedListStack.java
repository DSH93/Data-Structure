package il.ac.telhai.ds.stack;

public class DLinkedListStack<T> implements Stack<T> {
    
    private DLinkedList<T> stack;
    
    public DLinkedListStack() {
        stack = new DLinkedList<T>();
        
    }

    @Override
    public void push(T item) {
        stack.goToEnd();
        stack.insert(item);

    }

    @Override
    public T pop() {
        if(stack.isEmpty()) return null;
        stack.goToEnd();
        T item = stack.remove();
        return item;
    }

    @Override
    public T top() {
        if(stack.isEmpty()) return null;
        stack.goToEnd();
        T item = stack.getCursor();
        return item;
    }

    @Override
    public boolean isEmpty() {
        return (stack.isEmpty());
    }
    public String toString(){
        if(stack.isEmpty()) return "[]";
        String stackStr = "[";
        stack.goToEnd();
        stackStr+=stack.getCursor().toString();
        if(stack.hasPrev()) stackStr += ", ";

        while(stack.hasPrev()){
            stackStr += stack.getPrev().toString();
            if(stack.hasPrev()) stackStr += ", ";
        }
        stackStr+="]";
        return stackStr;
    }
}

