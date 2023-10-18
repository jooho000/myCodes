
package Project5;

/**
 * @author juneja_u
 */
public class Tree234 {
    Node root;

    public Tree234() {
        root = new Node();
    }

    public int search(int key) {
        Node curr = root;
        int childNum;
        while (true) {
            childNum = curr.find(key);
            if (childNum != -1)
                return childNum;
            else if (curr.isLeaf())
                return -1;
            else
                curr = getNextLevelNode(key, curr);
        }

    }

    public Node getNextLevelNode(int key, Node curr) {
        int numItems = curr.getNumItems();
        int i;
        for (i = 0; i < numItems; i++) {
            if (key < curr.getData(i))
                return curr.getChild(i);
        }
        return curr.getChild(i);
    }

    public void insert(int value) {
        Node curr = root;
        while (true) {
            if (curr.isFull()) {
                split(curr);
                curr = curr.getParent();
                curr = getNextLevelNode(value, curr);
            } else if (curr.isLeaf()) {
                break;
            } else
                curr = getNextLevelNode(value, curr);
        }
        curr.insertItem(value);
    }

    public void split(Node n) {
        int C = n.removeItem();
        int B = n.removeItem();
        Node child2 = n.disconnectChild(2);
        Node child3 = n.disconnectChild(3);
        Node sibling = new Node();
        Node parent;
        if (n == root) {
            root = new Node();
            parent = root;
            root.connectChild(n, 0);
        } else
            //parent already exists
            parent = n.getParent();

        //deal with the parent
        int itemIndex = parent.insertItem(B);
        int numItems = parent.getNumItems();
        for (int i = numItems - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(temp, i + 1);
        }
        parent.connectChild(sibling, itemIndex + 1);

        sibling.insertItem(C);
        sibling.connectChild(child2, 0);
        sibling.connectChild(child3, 1);
    }

    public void inorderTraverse() {

        System.out.print("Inorder traversal:");
        inorderTraverse(root);

    }

    private void inorderTraverse(Node root) {
        if (root == null) {
            return;
        }
        int numItems = root.getNumItems();
        int i;
        for (i = 0; i < numItems; ++i) {
            inorderTraverse(root.getChild(i));
            System.out.print(root.getData(i) + ", ");
        }
        inorderTraverse(root.getChild(i));

    }
}
