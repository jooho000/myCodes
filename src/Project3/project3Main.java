package Project3;

public class project3Main {
    public static void main(String[] args){
        circularLinked list = new circularLinked();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        System.out.println("\nsearching for key value 3...");
        System.out.println(list.search(3));
        System.out.println("searching for key value 5...");
        System.out.println(list.search(5));
        list.delete();
        System.out.println("list after deletion: ");
        list.display();
    }
}
