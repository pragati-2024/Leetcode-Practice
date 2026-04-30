import java.util.*;

public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element to back of queue
    public void push(int x) {
        // Step 1: s1 -> s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Step 2: push new element in s1
        s1.push(x);

        // Step 3: s2 -> s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Remove front element
    public int pop() {
        if (s1.isEmpty()) return -1;
        return s1.pop();
    }

    // Get front element
    public int peek() {
        if (s1.isEmpty()) return -1;
        return s1.peek();
    }

    // Check if empty
    public boolean empty() {
        return s1.isEmpty();
    }

    // testing
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.peek()); // 1
        System.out.println(q.pop());  // 1
        System.out.println(q.peek()); // 2
        System.out.println(q.empty()); // false
    }
}