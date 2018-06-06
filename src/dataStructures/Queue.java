package dataStructures;

/*
 * class queue

/**
 *
 * @author Camilo Camargo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Queue {

    public Node head = null;//Empty List

    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }
    
    public int size() {
        int size = 0;
        Node temp = head;
        if (isEmpty()) {
            return size = 0;
        }
        while (temp.next != null) {
            size += 1;
            temp = temp.next;
        }

        return ++size;
    }
    
    public void enqueue(Node newNode) {
        if(isEmpty()){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public Node dequeue() {
        if (!isEmpty()) {
            Node temp = head;
            if (size() > 1) {
                head = head.next;
                temp.next = null;
            } else if(size() == 1){
                head = null;
            }
            return temp;
        }
        return null;
    }
    
    //borrar
    public void printList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        while (temp != null) {
            bw.write(temp.print()+"\n");
            bw.flush();
            temp = temp.next;
        }
    }
    
    public Node getNode(int index) {
        if (size() < index) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }
}
