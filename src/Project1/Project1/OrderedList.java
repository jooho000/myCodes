package Project1.Project1;

public class OrderedList {
    private int[] myArray;
    private int numberOfElements;
    private int mergedElements;
    private int[] mergedArrayFinal;

    public OrderedList(int size){
        myArray = new int[size];
        numberOfElements = 0;
    }
    public int binarySearch(int item){
        int low = 0 ;
        int high = numberOfElements -1;

        while(true){
            int mid = (low + high)/2;
            if(myArray[mid] == item)
                return mid;
            else if(low > high)
                return -1;
            else{
                if(item > myArray[mid])
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }
    }

    public void insert(int item){

            int index;
            index = binarySearch(item);

            if(index == -1) {
                for (index = 0; index < numberOfElements; index++) {
                    if (myArray[index] > item)
                        break;
                }
            }
            for(int i = numberOfElements; i > index ; i--){
                myArray[i] = myArray[i-1];
            }
            myArray[index] = item;
            numberOfElements++;
    }

    public boolean delete(int item){
        //find the item
        int i = binarySearch(item);

        //didnt find it
        if(i == -1){
            return false;
        }
        else{
            for(int j = i ; j < numberOfElements ; j++){
                myArray[j] = myArray[j+1];
            }
            numberOfElements--;
            return true;
        }

    }
    public void display(){
        for(int i = 0 ; i < numberOfElements ; i++){
            System.out.print(myArray[i] + " ");
        }
    }

    public void mergedDisplay(){
        for(int i = 0 ; i < mergedElements ; i++){
            System.out.print(mergedArrayFinal[i] + " ");
        }
    }

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    public void merge(OrderedList secondArray) {

        int mergedArray[] = new int[this.myArray.length + secondArray.myArray.length];
        int elementCount = 0;

        for (int i = 0 ; i < numberOfElements ; i++) {
            mergedArray[i] = this.myArray[i];
            elementCount++;
        }

        for (int i = 0 ; i < secondArray.numberOfElements ; i++) {
            mergedArray[elementCount] = secondArray.myArray[i];
            elementCount++;
        }

        mergedElements = elementCount;
        mergedArray = sort(mergedArray);

        mergedArrayFinal = mergedArray;
    }
}