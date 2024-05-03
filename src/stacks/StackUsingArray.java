package stacks;

public class StackUsingArray {

    public static void main(String[] args) {
        StackOperations stackOperations = new StackOperations(3);
        try {
            stackOperations.push(1);
            System.out.println("Pushed 1");
            stackOperations.push(2);
            System.out.println("Pushed 2");
            stackOperations.push(3);
            System.out.println("Pushed 3");

            // Attempt to push another element on a full stack
            stackOperations.push(4); // This will throw an error, "Stack is Full"
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Top element (Peek): " + stackOperations.peek());
            System.out.println("Popped " + stackOperations.pop());
            System.out.println("Top element after pop (Peek): " + stackOperations.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Is the stack empty? " + stackOperations.isEmpty());
    }
}

class StackOperations{

    int[] array;
    int capacity;
    int size;

    StackOperations(int capacity){
        this.capacity = capacity;
        size = -1;
        array = new int[capacity];
    }

    void push(int val){
        if(size == capacity - 1) throw new RuntimeException("Stack is Full");
        size++;
        array[size] = val;
    }

    int pop(){
        if(isEmpty()) throw new RuntimeException("Stack is Empty");
        int top = peek();
        size--;
        return top;
    }

    int peek(){
        if(isEmpty()) throw new RuntimeException("Stack is Empty");
        return array[size];
    }

    boolean isEmpty(){
        return size == -1;
    }
}
