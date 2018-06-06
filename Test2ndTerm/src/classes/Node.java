package classes;



public class Node {

    public Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
}
