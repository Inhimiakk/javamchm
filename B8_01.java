package lab_9;

public class B8_01<T> {
    private Node<T> top;
    
    private static class Node<T> {
        T value;
        Node<T> next;
        
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    
    public void push(T value) {
        top = new Node<>(value, top);
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пустой");
        }
        T value = top.value;
        top = top.next;
        return value;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пустой");
        }
        return top.value;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        B8_01<Integer> stack = new B8_01<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Очень грустный стек: " + stack);
        System.out.println("Верхний элементик: " + stack.peek());
        
        System.out.println("Ампутируем верхний элемент: " + stack.pop());
        System.out.println("Именно поэтому стек грустный, мы ампутировали часть его элементов(стек после удаления): " + stack);
    }
}
