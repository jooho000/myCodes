
package Project5;

/**
 * @author juneja_u
 */
public class Test234Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree234 t = new Tree234();
        t.insert(40);
        t.insert(50);
        t.insert(70);
        t.insert(35);
        t.insert(60);
        t.insert(10);
        t.insert(25);
        t.root.displayNode();
        t.inorderTraverse();
    }

}
