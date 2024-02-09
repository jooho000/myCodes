
package Project5;

/**
 * @author juneja_u
 */
public class Node {

    private int[] dataArray;
    private Node[] childArray;
    private int numItems;
    private Node parent;

    public Node() {
        dataArray = new int[3];
        childArray = new Node[4];
    }

    public void connectChild(Node child, int index) {
        childArray[index] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public int getData(int index) {
        return dataArray[index];
    }

    public Node disconnectChild(int index) {
        Node temp = childArray[index];
        childArray[index] = null;
        return temp;
    }

    public int getNumItems() {
        return numItems;
    }

    public Node getParent() {
        return parent;
    }

    //assume that this is the node where we want to insert
//assume this is not full
    public int insertItem(int data) {
        numItems++;
        for (int i = 2; i >= 0; i--) {
            if (dataArray[i] == 0) {
                continue;
            } else {
                if (data < dataArray[i]) {
                    dataArray[i + 1] = dataArray[i];
                } else {
                    dataArray[i + 1] = data;
                    return i + 1;
                }
            }
        }
        dataArray[0] = data;
        return 0;
    }

    public int find(int data) {
        for (int i = 0; i < 3; i++) {
            if (data == dataArray[i])
                return i;
        }
        return -1;
    }

    public boolean isFull() {
        return numItems == 3;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int removeItem() {//remove rightmost item
        int temp = dataArray[numItems - 1];
        dataArray[numItems - 1] = 0;
        numItems--;
        return temp;

    }

    public Node getChild(int index) {
        return childArray[index];
    }

    public void displayNode() {
        System.out.print("node data: ");
        for (int i = 0; i < numItems; i++) {
            System.out.print(dataArray[i] + ", ");
        }
        System.out.print("\n");
    }
}
