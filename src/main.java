import java.util.Objects;

public class main {
    // main takes input

    // run or begin or while method which contains all calls to other methods so main is clean :>
    // at beginning, start tracking runtime
    // at end, print runtime
    public void programStart(){
        long start = System.nanoTime();

        ArrayStack aStack = new ArrayStack();

        System.out.println("Runtime: " + (System.nanoTime()-start));
    }
    // stringInterpreter method which interprets input string word by word, then separates them into:
    // use ascii 97-122 to detect strings
    // for negatives: check how many characters there are when seeing - to check if its the operator or a negative number
    public void inputInterpreter(String[] input, ArrayStack aStack){
        for (String s : input) {
            if (97 <= s.charAt(0) || s.charAt(0) >= 122) {
                // call instructions method
            } else if (s.charAt(0) == '-') {
                if (s.length() > 1) {
                    // call integer method to push negative number to stack
                } else {
                    // push minus sign to instructions method
                }
            } else {
                // push remaining ints to stack
            }
        }
    }
    // 1. a constants method to process the integer constants, call method in list/arraystack
    // use try/catch?
    public void intPusher(int num){

    }
    // 2. an instructions method to process the instructions with access to the stack
    // use try/catch
    public void instructions(String command, ArrayStack aStack){
        try{
            if(Objects.equals(command, "+")){
                int a = aStack.pop();
                int b = aStack.pop();
                aStack.push(a+b);
            }
            if(Objects.equals(command, "-")){
                int a = aStack.pop();
                int b = aStack.pop();
                aStack.push(a-b);
            }
            if(Objects.equals(command, "*")){
                int a = aStack.pop();
                int b = aStack.pop();
                aStack.push(a*b);
            }
            if(Objects.equals(command, "/")){
                if(aStack.pop()==0){
                    aStack.pop();
                    aStack.push(0);
                } else {
                    int a = aStack.pop();
                    int b = aStack.pop();
                    aStack.push(a / b);
                }
            }
            if(Objects.equals(command, "dup")){
                aStack.push(aStack.peek(0));
            }
            if(Objects.equals(command, "drop")){
                aStack.pop();
            }
            if(Objects.equals(command, "swap")){
                int a = aStack.pop();
                int b = aStack.pop();
                aStack.push(a);
                aStack.push(b);
            }
            if(Objects.equals(command, "rot")){
                int a = aStack.pop();
                int b = aStack.pop();
                int c = aStack.pop();
                aStack.push(b);
                aStack.push(a);
                aStack.push(c);
            }
            if(Objects.equals(command, "=")){
                int a = aStack.pop();
                int b = aStack.pop();
                if(a==b){
                    aStack.push(1);
                } else {
                    aStack.push(0);
                }
            }
            if(Objects.equals(command, "<")){
                int a = aStack.pop();
                int b = aStack.pop();
                if(b<a){
                    aStack.push(1);
                } else {
                    aStack.push(0);
                }
            }
            if(Objects.equals(command, "<")){
                int a = aStack.pop();
                int b = aStack.pop();
                if(b>a){
                    aStack.push(1);
                } else {
                    aStack.push(0);
                }
            }

        }
        catch(Exception e){
            // if not enough inputs to execute
        }
    }

}
