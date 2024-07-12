package coursework_assignment2;
import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        return list.pollFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
