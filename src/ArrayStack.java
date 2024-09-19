public class ArrayStack implements Stack{
    int size = 0;
    int[] stack = new int[10];
    public ArrayStack(){

    }
    @Override
    public int size() {
        // return size of array
        return size;
    }

    @Override
    public void push(int toPush) {
        // call isRoom and then push
        //if(aStack[size-1] == null){ }
        isRoom();
        int[] temp = new int[stack.length];
        if (size + 1 - 1 >= 0) System.arraycopy(stack, 0, temp, 1, size + 1 - 1);
        temp[0] = toPush;
        stack = temp;
        size ++;
    }

    @Override
    public int pop() {
        // return popped num
        int num = stack[0];
        int[] temp = new int[stack.length];
        System.arraycopy(stack, 1, temp, 0, stack.length - 1);
        stack = temp;
        size --;
        // check if array is too big
        if(size >10 && size < stack.length/2){
            int[] temp2 = new int[stack.length/2];
            System.arraycopy(stack, 0, temp2, 0, temp2.length);
            stack = temp2;
        }
        return num;
    }

    @Override
    public void print() {
        // for debugging :3, starts from bottom
        for (int i = size; i >= 1; i--) {
            System.out.print((stack[i-1] + " -> "));
        }
        System.out.println();
    }
    public void isRoom(){
        // check if there is room in the array
        // if not, double the current size
        if (size + 1 >= stack.length) {
            // resize
            int[] temp = new int[stack.length*2];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = temp;
        }
    }
    public int peek(){
        return stack[0];
    }

    @Override
    public String output() {
        String str = "";
        return str+=stack[0];
    }

    @Override
    public void insertBottom(int toInsert) {
        // adds a new item to the bottom of the stack (like pushing but onto the bottom rather than the top)
        isRoom();
        stack[size] = toInsert;
        size++;
    }

    @Override
    public int extractBottom() {
        // removes and returns the bottom item (like popping but from the bottom rather than the top).
        int num = stack[size-1];
        int[] temp = new int[stack.length];
        System.arraycopy(stack, 0, temp, 0, size);
        stack = temp;
        size--;
        return num;
    }
}
