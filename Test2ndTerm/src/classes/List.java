package classes;



public class List {

    public List() {}

    public Node head = null;//Empty List
    public int size = 0;

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void insertAtEnd(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        size++;
    }

    public void insertAtIndex(Node newNode, int Index) {
        Node temp;
        Node pre = head;
        for (int i = 0; i < Index - 1; i++) {
            pre.next = pre;
        }
        temp = pre.next;
        newNode.next = temp;
        pre.next = newNode;
        size++;
    }

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void deleteAtBegin() {
        Node temp = head;
        head = head.next;
        temp = null;
        size--;
        System.gc();
    }

    public void deleteAtEnd() {
        Node temp;
        Node pre = head;
        while (pre.next.next != null) {
            pre = pre.next;
        }
        temp = pre.next;
        pre.next = null;
        temp = null;
        size--;
        System.gc();
    }
    
    public void deleteIndex(int index){
        if(!isEmpty()){
            Node temp = head;
            Node pre = temp;
            if(index == 0){
                deleteAtBegin();
            } else {
                while (index-- > 0) {
                    pre = temp;
                    temp = temp.next;
                }
                pre.next = temp.next;
                temp = null;
                size--;
            }
        }
    }

    public Node getNode(int index) {
        if (size < index) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp;
        }
    }
    
    public void DeleteNodeValue(int value){
        if(!isEmpty()){
            Node temp = head;
            int index = 0;
            while(temp != null){
                if(temp.getValue() == value)
                    break;
                temp = temp.next;
                index++;
            }
            deleteIndex(index);
        }
    }
    
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.getValue() + " ");
            temp = temp.next;
        }
    }
}
