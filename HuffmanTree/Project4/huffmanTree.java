package Project4;

public class huffmanTree {
    public Node root;
    private char[] treeCharacters;
    private String[] treeCodes;
    private int count = 0;


    public huffmanTree(char character, int frequency) {
        root = new Node();
        root.frequency = frequency;
        root.character = character;
    }

    public huffmanTree(huffmanTree leftChild, huffmanTree rightChild) {
        root = new Node();
        root.left = leftChild.root;
        root.right = rightChild.root;
    }

    private void preorder(Node localroot, String code) {
        if (localroot != null) {
            System.out.println("character: " + localroot.character + ", with frequency: " + localroot.frequency + ", with code: " + code);
            treeCharacters[count] = localroot.character;
            treeCodes[count] = code;
            count++;
            preorder(localroot.left, code + "0");
            preorder(localroot.right, code + "1");
        }

    }

    public void inorder(int size) {
        treeCharacters = new char[size * 2];
        treeCodes = new String[size * 2];
        System.out.println("displaying the tree contents: ");
        String code = "";
        inorder(root, code);
    }

    private void inorder(Node localroot, String code) {
        if (localroot != null) {
            System.out.println("character: " + localroot.character + ", with frequency: " + localroot.frequency + ", with code: " + code);
            treeCharacters[count] = localroot.character;
            treeCodes[count] = code;
            count++;
            preorder(localroot.left, code + "0");
            preorder(localroot.right, code + "1");
        }
    }

    public char[] getTreeCharacters() {
        return treeCharacters;
    }

    public String[] getTreeCodes() {
        return treeCodes;
    }
}
