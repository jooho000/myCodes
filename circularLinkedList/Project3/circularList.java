package Project3;


public class circularList {
    int data;

    circularList next;
    circularList prev;

    public circularList(int data){
        this.data = data;
        next = null;
        prev = null;
    }

    public int getData(){
        return data;
    }
}
