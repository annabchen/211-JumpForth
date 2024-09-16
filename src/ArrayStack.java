public class ArrayStack implements Stack{
    int size = 10;
    int[] aStack = new int[10];
    public ArrayStack(){

    }
    @Override
    public int size() {
        // return size of array
        return size;
    }

    @Override
    public void push(int toPush) {
         // call isaRoom and then push
        //if(aStack[size-1] == null){ }


    }

    @Override
    public int pop() {
        // return popped num

        return 0;
    }

    @Override
    public void print() {
        // for debugging :3

    }
    public void isRoom(){
        // check if there is room in the array
        // if not, double the current size

    }
    public int peek(int n){
        // n = how many layers deep to peek, 0 = top one
        return 0;
    }
}
