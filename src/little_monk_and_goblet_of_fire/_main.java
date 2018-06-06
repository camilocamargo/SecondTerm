/*
 * little monk and goblet of fire problem HackerEarth
 */
package little_monk_and_goblet_of_fire;

//import dataStructures.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import dataStructures.Node;

/**
 *
 * @author Camilo Camargo
 */
public class _main {

    public static class Node {

        // Attributes:
        public int number, school, index;

        //int* ponter = &a; en c/c++
        public Node next;// <--- Este es el puntero

        public Node() {
        }

        //nodo:
        public Node(int number) {
            this.number = number;
        }

        public Node(int school, int number) {
            this.school = school;
            this.number = number;
        }

        // metodo to string
        public String print() {
            return this.school + " " + this.number;
        }

        public Node clone() {
            Node clone = new Node(this.school, this.number);
            return clone;
        }

    }

    public static class List {

        public Node head = null;//Empty List

        public boolean isEmpty() {
            // operador ternario.
            return head == null ? true : false;
        }

        public void reverse() {
            Stack tempList = new Stack();
            Node temp = head;

            while (temp != null) {
                tempList.push(temp.clone());
                temp = temp.next;
            }
            head = tempList.head;
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

        public void insertAtIndex(Node newNode, int Index) {
            Node temp;
            Node pre = head;
            for (int i = 0; i < Index - 1; i++) {
                pre.next = pre;
            }
            temp = pre.next;
            newNode.next = temp;
            pre.next = newNode;
        }

        public void insertAtBegin(Node newNode) {
            newNode.next = head;
            head = newNode;
        }

        public void deleteAtBegin() {
            Node temp = head;
            head = head.next;
            temp = null;
            System.gc();
        }
    }

    public static class Stack {

        public Node head = null;//Empty List

        public boolean isEmpty() {
            // operador ternario.
            return head == null ? true : false;
        }

        public void push(Node newNode) {
            if (isEmpty()) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        public Node pop() {
            Node temp = head;
            head = head.next;
            return temp;
        }

        public int size() {
            int cont = 0;
            if (isEmpty()) {
                return cont;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                cont++;
            }
            return ++cont;
        }

        public Node getNode(int index) {
            if (isEmpty()) {
                return null;
            }
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
                bw.write(temp.print() + "\n");
                temp = temp.next;
            }
            bw.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List students = new List();
        int Q, i, size, school, roll, index;
        boolean insertedAtIndex = false;
        String input;

        Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            input = br.readLine();
            insertedAtIndex = false;
            if (input.split(" ")[0].equals("E")) {
                school = Integer.parseInt(input.split(" ")[1]);
                roll = Integer.parseInt(input.split(" ")[2]);
                students.reverse();
                Node temp = students.head;
                index = 0;
                while (temp != null) {
                    if (temp.school == school && index != 0) {
                        students.insertAtIndex(new Node(school, roll), index);
                        insertedAtIndex = true;
                        break;
                    }
                    index++;
                    temp = temp.next;
                }
                students.reverse();
                if (!insertedAtIndex) {
                    students.insertAtEnd(new Node(school, roll));
                }
            } else if (input.equals("D")) {
                bw.write(students.getNode(0).print());
                bw.newLine();
                bw.flush();
                students.deleteAtBegin();
            }
        }
    }
}
