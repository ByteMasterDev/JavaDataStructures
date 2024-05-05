package queue;

import java.util.stream.IntStream;

public class QueueUsingArray {

    public static void main(String[] args) {
        //Naive Solution Examples

        QueueOperationsNaive queue = new QueueOperationsNaive(5);

        // Demonstrating enqueue operation
        System.out.println("Enqueuing elements:");
        for (int i = 1; i <= 5; i++) {
            try {
                queue.enqueue(i);
                System.out.println("Enqueued: " + i);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        // Demonstrating dequeue operation
        System.out.println("\nDequeuing elements:");
        while (!queue.isEmpty()) {
            try {
                int value = queue.dequeue();
                System.out.println("Dequeued: " + value);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        // Trying to dequeue from an empty queue
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("\nAttempted to dequeue from an empty queue: " + e.getMessage());
        }

        CircularQueueOperations circularQueue = new CircularQueueOperations(5); // Create a queue with capacity 5

        // Enqueue elements
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        System.out.println("After enqueue: 1, 2, 3");

        // Dequeue elements
        System.out.println("Dequeued: " + circularQueue.dequeue()); // Should print 1
        System.out.println("Dequeued: " + circularQueue.dequeue()); // Should print 2

        // Enqueue more elements
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        System.out.println("After enqueue: 4, 5");

        // Check if full
        System.out.println("Is queue full? " + circularQueue.isFull()); // Expected: false

        // Continue to enqueue and check capacity handling
        circularQueue.enqueue(6);
        System.out.println("Is queue full? " + circularQueue.isFull()); // Expected: true
        System.out.println("Attempting to enqueue on full queue.");
        try {
            circularQueue.enqueue(7); // This should cause an exception
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Expected: Queue is full.
        }
    }

}

class QueueOperationsNaive {

    int[] array;
    int capacity;

    int rear;

    QueueOperationsNaive(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        rear = -1;
    }

    void enqueue(int value){
        if(isFull()) throw new RuntimeException("Queue is Full.");
        rear++;
        array[rear] = value;
    }

    int dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty.");
        int front = array[0];

        IntStream.range(0, rear).forEach(i -> {
            array[i] = array[i+1];
        });
        rear--;
        return front;
    }

    boolean isEmpty(){
        return rear == -1;
    }

    boolean isFull(){
        return rear == capacity - 1;
    }

    int peek(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty");
        return array[0];
    }
}

/**
 * Efficient Solution - Utilizes a mathematical trick to identify an empty spot,
 * eliminating the need to shift elements when removing.
 * The position of 'rear' is determined by the formula: rear = (rear + 1) % capacity
 */
class CircularQueueOperations {
    int[] array;
    int capacity;
    int front;
    int rear;

    /**
     * Constructor for creating a circular queue with a specific capacity.
     * @param capacity the maximum number of elements the queue can hold
     */
    CircularQueueOperations(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * Adds an element to the rear of the queue.
     * @param value the element to be added
     * @throws RuntimeException if the queue is full
     */
    void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        array[rear] = value;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * @return the front element of the queue
     * @throws RuntimeException if the queue is empty
     */
    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        int result = array[front];
        if (rear == front) {
            rear = front = -1; // Reset the queue to empty
        } else {
            front = (front + 1) % capacity;
        }
        return result;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    /**
     * Checks if the queue is full.
     * @return true if the queue is full, false otherwise
     */
    boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
