package dataStructures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo Camargo
 */
public class Node {

    // Attributes:
    public int number, school, index;
    public Stack stack;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node() {}

    //nodo:
    public Node(int number) {
        this.number = number;
    }
    
    public Node(Stack stack){
        this.stack = stack;
    }
    
    public Node(int school, int number){
        this.school = school;
        this.number = number;
    }
    
    // metodo to string
    public String print() {
        return this.school +" "+this.number;
    }

    public Node clone() {
        Node clone = new Node(this.school, this.number);
        return clone;
    }
    
    public Node cloneDecremented(){
        Node clone;
        if (this.number == 0){
           clone = new Node(this.school, this.number); 
        }else{
           clone = new Node(this.school, (this.number-1));
        }
        return clone;
    }
    
}
