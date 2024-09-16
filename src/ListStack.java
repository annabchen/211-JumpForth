public class ListStack implements Stack{
    Node head;
    int length;
    public ListStack(){

    }
    @Override
    public int size() {
        return length;
    }

    @Override
    public void push(int toPush) {
        // add new node to end
        Node newNode = new Node(toPush);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = null;
        head = newNode;

        length ++;
    }

    @Override
    public int pop() {
        // delete node at end
        int returnValue = head.val;
        head = head.prev;
        head.next = null;
        length--;
        return returnValue;
    }

    @Override
    public void print() {
        // is for debugging :>
        // traverse nodes and put head and tail labels
        String str = "Top: ";
        Node current = head;
        while(current!=null){
            str += " -> " + current.val;
            current = current.prev;
        }
        System.out.println(str);
    }

}
