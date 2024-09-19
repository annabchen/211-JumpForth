import java.util.Objects;

public class Main {
    // consulted classmates: Yurii Sulima, Olivia Fann
    // s is program counter
    static int s;
    // main takes input
    static ArrayStack stack = new ArrayStack();
    //static ListStack stack = new ListStack();
    public static void main(String[] args) {
        programStart(args);
        // final output of "1 dup dup 1 + dup 100000 < -10 swap if jump drop 100 > -7 swap if jump drop":
        // 99 for both implementations
        // final output of "1 dup dup 1 + dup 5 shove yank drop 100000 < -15 swap if jump drop 100 > -7 swap if jump drop":
        // 99 for both implementations
    }

    // run or begin or while method which contains all calls to other methods so main is clean :>
    // at beginning, start tracking runtime
    // at end, print runtime
    public static void programStart(String[] args){
        long start = System.nanoTime();
        inputInterpreter(args, stack);
        //stack.print();
        System.out.println("Output: " + stack.output());
        System.out.println("Runtime: " + (System.nanoTime()-start));
    }
    // stringInterpreter method which interprets input string word by word, then separates them into:
    // for negatives: check how many characters there are when seeing - to check if its the operator or a negative number
    public static void inputInterpreter(String[] input, Stack stack){
        s = 0;
        while( s < input.length){
            //stack.print();
            if (Character.isAlphabetic(input[s].charAt(0))) {
                // call instructions method
                instructions(input[s], stack);
            } else if (input[s].charAt(0) == '-') {
                if (input[s].length() > 1) {
                    // call integer method to push negative number to stack
                    int num = Integer.parseInt(input[s]);
                    intPusher(num, stack);
                    //stack.print();
                } else {
                    // push minus sign to instructions method
                    instructions(input[s], stack);
                }
            } else if (input[s].charAt(0) == '+' || input[s].charAt(0) == '*' || input[s].charAt(0) == '/' ||
                    input[s].charAt(0) == '=' || input[s].charAt(0) == '<' || input[s].charAt(0) == '>'){
                instructions(input[s], stack);
            }
            else {
                // push remaining ints to stack
                int num = Integer.parseInt(input[s]);
                intPusher(num,stack);
            }
            s++;
        }
    }
    // 1. a constants method to process the integer constants, call method in list/arraystack
    public static void intPusher(int num, Stack stack){
        stack.push(num);
    }
    // 2. an instructions method to process the instructions with access to the stack
    public static void instructions(String command, Stack stack) {
        if (stack.size() >= 1) {
            if (Objects.equals(command, "dup")) {
                stack.push(stack.peek());
            }
            else if (Objects.equals(command, "drop")) {
                stack.pop();
            }
            else if (Objects.equals(command, "jump")){
                // pop one item and add it to the program counter
                int num = stack.pop();
                s += num;
            }
            else if(Objects.equals(command, "if")){
                // pop 1 and do nothing if its grater than 0
                // if 0 or negative then add one to the program counter, which has the effect of skipping the next instruction
                int top = stack.pop();
                if(top <= 0){
                    s+=1;
                }
            }
            else if(Objects.equals(command, "yank")){
                // extract the bottom item and push it on top
                stack.push(stack.extractBottom());
            }
            else if(Objects.equals(command, "shove")){
                // pop the top item and insert it at the bottom
                stack.insertBottom(stack.pop());
            }
        } if (stack.size() >= 2) {
            if (Objects.equals(command, "+")) {

                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
            else if (Objects.equals(command, "-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (Objects.equals(command, "*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }
            else if (Objects.equals(command, "/")) {
                if (stack.peek() == 0) {
                    stack.pop();
                    stack.pop();
                    stack.push(0);
                } else {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }
            }
            else if (Objects.equals(command, "=")) {
                int a = stack.pop();
                int b = stack.pop();
                if (a == b) {
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            }
            else if (Objects.equals(command, "<")) {
                int a = stack.pop();
                int b = stack.pop();
                if (b < a) {
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            }
            else if (Objects.equals(command, ">")) {
                int a = stack.pop();
                int b = stack.pop();
                if (b > a) {
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            }
            else if (Objects.equals(command, "swap")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a);
                stack.push(b);
            }
        } if (stack.size()>=3){
            if (Objects.equals(command, "rot")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }
        }
        else{
            // pass
        }
    }

}
