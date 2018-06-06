package dataStructures;

/*
 * Class stack
 */

/**
 *
 * @author Camilo Camargo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack {

    public Node head = null;//Empty List

    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }

    public void push(Node newNode) {
        if(isEmpty())
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public Node pop() {
        Node temp = head;
        head = head.next;
        return temp;
    }
    
    public int size(){
        int cont = 0;
        if(isEmpty())
            return cont;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            cont++;
        }
        return ++cont;
    }
    
    public Node getNode(int index){
        if(isEmpty())
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    
    public void printList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        while (temp != null) {
            bw.write(temp.print()+"\n");
            temp = temp.next;
        }
        bw.flush();
    }
}
