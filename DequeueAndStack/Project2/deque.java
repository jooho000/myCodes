package Project2;

public class deque {
    private int[] array;
    private int right;
    private int left;
    private int nitems;

    public deque(int size) {
        array = new int[size];
        left = -1;
        right = 0;
        nitems = 0;
    }

    public boolean isEmpty() {
        return nitems == 0;
    }

    public boolean isFull() {
        return nitems == array.length;
    }

    public void insertLeft(int item) {

        if (isFull()) {
            System.out.println("deque full could not add: " + item);
        } else {
            if (left == -1) {
                left = array.length - 1;
                array[left] = item;
                nitems++;
            } else {
                array[--left] = item;
                nitems++;
            }
            System.out.println(item + " was added to the left");
        }
    }

    public void insertRight(int item) {
        if (isFull()) {
            System.out.println("deque full could not add: " + item);
        } else {
            if (right == array.length - 1) {
                right = 0;
                array[right] = item;
                nitems++;
            } else {
                array[right] = item;
                right++;
                nitems++;
            }
            System.out.println(item + " was added to the right");
        }
    }

    public int deleteLeft() {

        if (isEmpty()) {
            return -1;
        } else {
            int temp = array[left];
            left++;
            nitems--;
            return temp;
        }
    }

    public int deleteRight() {

        if (isEmpty()) {
            return -1;
        } else {
            int temp = array[right - 1];
            right--;
            nitems--;
            return temp;
        }
    }

    public int peekRight() {
        return array[right - 1];
    }

    public int peekLeft() {
        return array[left];
    }

    public void popLeft() {
        System.out.println("popped left which is:" + deleteLeft());
    }

    public void popRight() {
        System.out.println("popped right which is: " + deleteRight());
    }

}