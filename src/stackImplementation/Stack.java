package stackImplementation;

public class Stack {

    private int maximumStackSize;
    private int[] stackArray;
    private int topOfStack;

    public Stack(int size) {
        this.maximumStackSize = size;
        stackArray = new int[size];
        topOfStack = - 1;
    }

    public int getMaximumStackSize() {

        return maximumStackSize;
    }

    public void push(int itemToAdd) throws Exception {
        if (!isFull()) {
            stackArray[topOfStack + 1] = itemToAdd;
            topOfStack++;
        }else {
            throw new Exception("Stack is currently full and cannot push more items");
        }
    }

    public int size() {
        return topOfStack + 1;
    }

    public boolean isFull (){
        int maximumIndexAttainable = maximumStackSize - 1;
        if (topOfStack == maximumIndexAttainable){
            return  true;
        }
        return false;
    }

    public int pop() throws Exception{
        if (!isEmpty())
        {
            int itemToPop = stackArray[topOfStack];
            stackArray[topOfStack] = 0;
            topOfStack --;
            return itemToPop;
        }else {
            throw new Exception("Stack is currently empty and cannot pop items off");
        }

    }

    public boolean isEmpty() {

        if (topOfStack == -1){
            return true;
        }
        return false;
    }

    public int peek() {
        return stackArray[topOfStack];
    }

    public int search(int itemToSearch){

        boolean stackItemFound = false;

        int [] stackArrayReversed = reverseArray(stackArray,stackArray.length);
        int index = -1;

        for (int i = 0; i < stackArrayReversed.length; i++) {
            if (stackArrayReversed[i] == itemToSearch){
                index = i;
                stackItemFound = true;
            }
        }
        if (stackItemFound == true){
            return index += 1;
        }else {
            return index;
        }
    }

    private int [] reverseArray(int []array, int arrayLength){

        int [] reveredArray = new int[arrayLength];
        int limit = array.length;

        for (int i = 0; i < arrayLength; i++) {
            reveredArray[limit-1] = array[i];
            limit -= 1;
        }
        return reveredArray;
    }

}
