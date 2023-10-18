package Project4;

public class huffmanCode {

    private priorityQueue priorityQueue;
    private String message;
    private int count;
    private huffmanTree finalTree;
    private char[] treeCharFinal;
    private String[] treeCodesFinal;
    private int codeTableCount = 0;

    public huffmanCode(String message) {
        this.message = message;
        priorityQueue = new priorityQueue(message.length());
        treeCharFinal = new char[message.length()];
        treeCodesFinal = new String[message.length()];
    }

    public void displayTree() {
        finalTree.inorder(message.length());
    }

    public void buildTree() {
        insertIntoQ();
        for (int i = 0; i < count - 1; i++) {

            huffmanTree parent = new huffmanTree(priorityQueue.delete(), priorityQueue.delete());
            parent.root.frequency = parent.root.left.frequency + parent.root.right.frequency;

            priorityQueue.insert(parent);
        }
        finalTree = priorityQueue.delete();
        displayTree();
    }

    public void insertIntoQ() {
        char[] characters = new char[message.length()];
        int insertCount = 0;
        for (int i = 0; i < message.length(); i++) {
            if (!isRepeated(message.charAt(i), i)) {
                characters[insertCount] = message.charAt(i);
                insertCount++;
            }
        }
        for (int i = insertCount - 1; i >= 0; i--) {
            huffmanTree tree = new huffmanTree(characters[i], getFrequency(characters[i]));
            priorityQueue.insert(tree);
            count++;
        }
    }

    public int getFrequency(char c) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public boolean isRepeated(char c, int index) {
        for (int i = index + 1; i < message.length(); i++) {
            if (message.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public boolean isInMessage(char key) {
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == key) {
                return true;
            }
        }
        return false;
    }

    public void buildCodeTable() {
        String[] treeCodes = finalTree.getTreeCodes();
        char[] treeChar = finalTree.getTreeCharacters();

        System.out.println("code table: ");

        for (int i = 0; i < treeCodes.length; i++) {
            if (isInMessage(treeChar[i])) {
                System.out.println("character: " + treeChar[i] + ", has a code of: " + treeCodes[i]);
                treeCharFinal[codeTableCount] = treeChar[i];
                treeCodesFinal[codeTableCount] = treeCodes[i];
                codeTableCount++;
            }
        }
    }

    public int getCharacterIndex(char key) {
        for (int i = 0; i < treeCharFinal.length; i++) {
            if (key == treeCharFinal[i]) {
                return i;
            }
        }
        return -1;
    }

    public int getCodeIndex(String key) {
        for (int i = 0; i < codeTableCount; i++) {
            if (treeCodesFinal[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isInCodeArray(String key) {
        for (int i = 0; i < codeTableCount; i++) {
            if (treeCodesFinal[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public String encode(String message) {
        String encodedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            if (isInMessage(message.charAt(i))) {
                encodedMessage = encodedMessage + treeCodesFinal[getCharacterIndex(message.charAt(i))];
            } else {
                System.out.println("character " + message.charAt(i) + " is not in tree");
                encodedMessage = "impossible to encode";
                break;
            }
        }
        return encodedMessage;
    }

    public String decode(String message) {
        String decodedMessage = "";
        String temp = "";

        for (int i = 0; i < message.length(); i++) {
            temp = temp + message.charAt(i);
            if (isInCodeArray(temp)) {
                decodedMessage = decodedMessage + treeCharFinal[getCodeIndex(temp)];
                temp = "";
            }
        }

        if (temp.length() == message.length()) {
            decodedMessage = "impossible to decode";
        }

        return decodedMessage;
    }
}
