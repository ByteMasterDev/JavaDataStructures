package queue;

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        QueueUsingLinkedListOperations linkedListQueue = new QueueUsingLinkedListOperations();

        // Demonstrating enqueue operation
        System.out.println("Enqueuing elements: 10, 20, 30");
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);

        // Demonstrating top operation
        System.out.println("The front element is: " + linkedListQueue.top());

        // Demonstrating dequeue operation
        System.out.println("Dequeued: " + linkedListQueue.dequeue());
        System.out.println("The front element after one dequeue is: " + linkedListQueue.top());

        // Demonstrating handling of empty queue
        System.out.println("Dequeue all elements");
        System.out.println("Dequeued: " + linkedListQueue.dequeue());
        System.out.println("Dequeued: " + linkedListQueue.dequeue());

        try {
            // Trying to dequeue from an empty queue to show the exception message
            System.out.println("Attempting to dequeue from an empty queue:");
            linkedListQueue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Trying to get the front from an empty queue
        try {
            System.out.println("Checking front element of an empty queue:");
            linkedListQueue.top();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

class QueueUsingLinkedListOperations {

    QueueNode head = null;
    QueueNode tail = null;

    void enqueue(int value){
        QueueNode node = new QueueNode(value);
        if(tail == null){
            tail = head = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    int dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty.");
        int front = head.data;

        // When there is only one element i.e head == tail, in that case we need to make tail null as well.
        if(head == tail){
            tail = null;
        }

        head = head.next;
        return front;
    }

    boolean isEmpty(){
        return head == null && tail == null;
    }

    int top(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty.");
        return head.data;
    }
}

class QueueNode {
    QueueNode next;
    int data;

    QueueNode(int data){
        this.data = data;
    }
}