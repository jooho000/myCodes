package Project2;

public class project2Main {
    public static void main(String[] args) {

        deque deque = new deque(10);
        stack stack = new stack(10);

        deque.insertLeft(10);
        deque.insertLeft(11);
        deque.insertLeft(12);
        deque.insertLeft(13);
        deque.insertLeft(14);
        deque.insertLeft(15);
        deque.insertLeft(16);
        deque.insertRight(20);
        deque.insertRight(21);
        deque.insertRight(22);
        deque.insertRight(23);
        deque.popLeft();
        deque.popRight();
        System.out.println("peeking right: " + deque.peekRight());
        System.out.println("peeking left: " + deque.peekLeft());

        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        System.out.println("peeking stack: " + stack.peek());
        stack.pop();
        System.out.println("peeking stack after pop: " + stack.peek());


    }
}
