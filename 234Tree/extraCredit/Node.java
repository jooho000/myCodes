package extraCredit;

public class Node {

    private final int myConstant = 3;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[myConstant];
    private dataItem itemArray[] = new dataItem[myConstant - 1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }

    public int getNumItems() {
        return numItems;
    }

    public dataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return (numItems == myConstant - 1) ? true : false;
    }

    public int findItem(int key) {
        for (int i = 0; i < myConstant; i++) {
            if (itemArray[i] == null) {
                break;
            } else if (itemArray[i].dData == key) {
                return i;
            }
        }
        return -1;
    }

    public int insertItem(dataItem newItem) {
        numItems++;
        int newKey = newItem.dData;
        for (int i = myConstant - 2; i >= 0 ; i--) {
            if (itemArray[i] == null) {
                continue;
            } else {
                long itsKey = itemArray[i].dData;
                if (newKey < itsKey) {
                    itemArray[i+1] = itemArray[i];
                } else {
                    itemArray[i+1] = newItem;
                    return i+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public dataItem removeItem() {
        dataItem temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
    }

}
