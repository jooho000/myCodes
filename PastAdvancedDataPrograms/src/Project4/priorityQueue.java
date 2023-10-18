package Project4;

public class priorityQueue {
    private huffmanTree[] array;
    private int nitems;

    public priorityQueue(int size) {
        array = new huffmanTree[size];
        nitems = 0;
    }

    public boolean isEmpty() {
        return nitems == 0;
    }

    public boolean isFull() {
        return nitems == array.length;
    }

    public huffmanTree delete() {
        if (!isEmpty()) {
            huffmanTree temp = array[nitems-1];
            nitems--;
            return temp;

        } else {
            return null;
        }
    }

    public void insert(huffmanTree item) {
        int i;
        if (!isFull()) {
            if (nitems == 0) {
                array[nitems++] = item;
            } else {
                for (i = nitems - 1; i >= 0; i--) {
                    if (item.root.frequency > array[i].root.frequency)
                        array[i + 1] = array[i];
                    else
                        break;
                }
                array[i + 1] = item;
                nitems++;
            }
        }
    }
}
