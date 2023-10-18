package Project2;

public class stack {

    private deque dq;

    public stack(int size) { dq = new deque(size);}

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.isFull();
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            dq.insertRight(item);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        } else {
            return dq.deleteRight();
        }
    }

    public int peek() {
        return dq.peekRight();
    }
}
