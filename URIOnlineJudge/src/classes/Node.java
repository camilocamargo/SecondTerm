package classes;

/*
 * Node class for binary tree.
 */

/**
 *
 * @author Camilo Camargo Convers
 */
public class Node {
    public int value;
    public int level = 0;
    public char character;
    public char operation;
    Node left = null;
    Node right = null; 
    
    Node(){}
    
    Node(int value){
        this.value = value;
    }
    
    Node(char character){
        this.character = character;
    }
    
    Node(char operation, int value){
        this.operation = operation;
        this.value = value;
    }
    
    Node(int value, int level){
        this.value = value;
        this.level = level;
    }
    
    public String toString(){
        return "Valor: " + this.value;
    }
    
    public char getCharacter(){
        return this.character;
    }
    
    public Node clone(){
        Node newNode = new Node(this.value);
        return newNode;
    }
    
}
