package extraCredit;

public class Tree234 {
    private Node root = new Node();

    public void split(Node thisNode, dataItem newData) {
        dataItem item1, item2;
        Node parent;
        Node newRight = new Node();
        int itemIndex;

        if (newData.dData < thisNode.getItem(0).dData) {
            item2 = thisNode.removeItem();
            item1 = thisNode.removeItem();
            thisNode.insertItem(newData);
        } else if (newData.dData < thisNode.getItem(1).dData) {
            item2 = thisNode.removeItem();
            item1 = newData;
        } else {
            item2 = newData;
            item1 = thisNode.removeItem();
        }

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
            itemIndex = parent.insertItem(item1);
            parent.connectChild(itemIndex + 1, newRight);
            newRight.insertItem(item2);
        }
    }

    public Node getNextChild(Node myNode, long myValue) {
        int i;
        int numItems = myNode.getNumItems();

        for (i = 0; i < numItems; i++) {
            if (myValue < myNode.getItem(i).dData) {
                return myNode.getChild(i);
            }
        }
        return myNode.getChild(i);
    }

    public int find(int key) {
        Node curr = root;
        int childNum;
        while (true) {
            if ((childNum = curr.findItem(key)) != -1) {
                return childNum;
            } else if (curr.isLeaf()) {
                return -1;
            } else {
                curr = getNextChild(curr, key);
            }
        }
    }

    public void insert(int value) {
        Node curr = root;
        dataItem tempItem = new dataItem(value);

        while (true) {
            if (curr.isLeaf()) {
                break;
            } else {
                curr = getNextChild(curr, value);
            }
        }

        if (curr.isFull()) {
            if (curr != root && curr.getParent().isFull()) {
                System.out.println("cannot insert, parent and child full");
            } else {
                split(curr,tempItem);
            }
        } else {
            curr.insertItem(tempItem);
        }
    }

    public void displayTree() {
        DisplayTree(root, 0, 0);
    }

    private void DisplayTree(Node myNode, int level, int childNum) {
        System.out.print("tree level: " + level + " child: " + childNum + " data:");
        myNode.displayNode();
        System.out.print("\n");
        int numItems = myNode.getNumItems();

        for (int i = 0; i < numItems + 1; i++) {
            Node nextNode = myNode.getChild(i);

            if (nextNode != null) {
                DisplayTree(nextNode, level + 1, i);
            } else {
                return;
            }
        }
    }

}
