package Project4;

public class Node {

    public char character;
    public int frequency;
    public Node left;
    public Node right;

    public void displayNode()
    {
        System.out.print("{");
        System.out.print(frequency);
        System.out.print(", ");
        System.out.print(character);
        System.out.print("}");

    }

}
