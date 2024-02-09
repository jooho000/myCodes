package Tree.Project6;

public class SeparateChaining {
    Tree[] array;

    public SeparateChaining(int size){
        array = new Tree[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = new Tree();
        }
    }
    public int hash(int id) {
        return id % array.length;
    }
    public void insert(Student s){
        int index = hash(s.getId());
        array[index].insert(s);
    }
    public Node search(int id){
        int index = hash(id);
        return array[index].find(id);
    }
    public void display(){
        for(int i = 1 ; i < array.length ; i++){
            System.out.print("key: " + i + " ");
            array[i].traverse();
            System.out.println("");
        }
    }
}
