package Project4;
import java.util.*;

public class project4main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("type message: ");
        String message = sc.nextLine();
        huffmanCode huffman = new huffmanCode(message);
        huffman.buildTree();
        huffman.buildCodeTable();
        System.out.println("type message to encode:");
        String encodeThis = sc.nextLine();
        System.out.println("encoded message for '" + encodeThis + "' is " + huffman.encode(encodeThis));
        System.out.println("type message to decode: ");
        String decodeThis = sc.nextLine();
        System.out.println("decoded message for '" + decodeThis + "' is '" + huffman.decode(decodeThis) +"'");
        sc.close();
    }
}
