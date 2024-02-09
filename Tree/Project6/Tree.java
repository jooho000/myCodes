package Tree.Project6;

class Tree {
    public Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current.data.getId() != key) {
            if (key < current.data.getId())
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(Student item) {
        Node newNode = new Node();
        newNode.data = item;
        int id = newNode.data.getId();
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.data.getId()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void traverse() {
        inOrder(root);
    }

    private void inOrder(Node localRoot) {
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data.toString());
            inOrder(localRoot.rightChild);
        }
    }

}