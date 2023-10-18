package Project1.Project1;

import java.util.*;

public class OrderedListMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderedList array1 = new OrderedList(5);
        OrderedList array2 = new OrderedList(5);

        System.out.println("enter 5 numbers for array 1: ");
        for (int i = 0; i < 5; i++) {
            int input = sc.nextInt();
            array1.insert(input);
        }

        System.out.println("enter 5 numbers for array 2: ");
        for (int i = 0; i < 5; i++) {
            int input = sc.nextInt();
            array2.insert(input);
        }

        System.out.println("list 1: ");
        array1.display();
        System.out.println("\nlist 2: ");
        array2.display();
        array1.merge(array2);
        System.out.println("\nmerged list: ");
        array1.mergedDisplay();

    }
}
