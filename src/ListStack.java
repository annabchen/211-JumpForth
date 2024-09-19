public class ListStack implements Stack{
    Node head;
    static int length = 0;
    public ListStack(){

    }
    @Override
    public int size() {
        return length;
    }

    @Override
    public void push(int toPush) {
        // add new node to end
        if(head == null){
            head = new Node(toPush);
            head.next = null;
        }
        else{
            Node newNode = new Node(toPush);
            head.next = newNode;
            newNode.prev = head;
            newNode.next = null;
            head = newNode;
        }
        length ++;
    }

    @Override
    public int pop() {
        // delete node at end
        int returnValue = head.val;
        head = head.prev;
        if(head == null){
        }
        else{
            head.next = null;
        }
        length--;
        return returnValue;
    }

    @Override
    public void print() {
        // is for debugging :>
        // traverse nodes and put head and tail labels
        Node current = head;
        while(current!=null){
            System.out.print(current.val + "<-");
            current = current.prev;
        }
        System.out.println();
    }

    public int peek(){
        return head.val;
    }

    @Override
    public String output() {
        if(head == null){
            return "";
        }
        String str = "";
        return str+=head.val;
    }

    @Override
    public void insertBottom(int toInsert) {
        // adds a new item to the bottom of the stack (like pushing but onto the bottom rather than the top)
        Node end = head;
        while(end.prev != null){
            end = end.prev;
        }
        // end should be the very end now
        Node toAdd = new Node(toInsert);
        end.prev = toAdd;
        toAdd.next = end;
        length++;
    }

    @Override
    public int extractBottom() {
        // removes and returns the bottom item (like popping but from the bottom rather than the top).
        Node end = head;
        while(end.prev != null){
            end = end.prev;
        }
        int num = end.val;
        end = null;
        length--;
        return num;
    }
}
