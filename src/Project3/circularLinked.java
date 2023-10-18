package Project3;

public class circularLinked {
    private int count = 0;
    circularList current;


    public circularLinked() {
        current = null;
    }


    public void insert(int data) {

        circularList newLink = new circularList(data);


        if (current == null) {

            newLink.next = newLink;
            newLink.prev = newLink;
            count++;

        } else if (current.next == null && current.prev == null && current != null) {

            newLink.next = current;
            newLink.prev = current;
            current.prev = newLink;
            current.next = newLink;
            count++;

        } else if (current != null) {

            newLink.next = current.next;
            newLink.prev = current;
            current.next.prev = newLink;
            current.next = newLink;
            ++count;
        }
        current = newLink;

    }


    public int search(int key) {

        circularList tempCurr = current;

        if (tempCurr.data == key) {
            return key;
        } else {
            tempCurr = tempCurr.next;
        }

        while (tempCurr.data != current.data) {

            if (tempCurr.data == key) {
                System.out.print("Key value found: ");
                return key;
            } else {
                tempCurr = tempCurr.next;
            }
        }

        System.out.println("Key not found");

        return -1;

    }

    public void decreaseCount() {
        count--;
    }


    public void delete() {

        circularList tempCurr = current;
        current.next.prev = current.prev;
        current.prev.next = current.next;
        current = tempCurr.prev;
        decreaseCount();

    }

    public void display() {

        circularList tempLink = current;
        System.out.print("Linked List: ");

        for (int i = 0 ; i < count ; i++) {
            System.out.print(tempLink.getData() + ", ");
            tempLink = tempLink.next;
        }

    }
}
