/*
 * BST operations I URI 1200
 */
package problems;

/**
 *
 * @author Camilo Camargo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import classes.*;

public class BSTOperationsI {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String input, option;
        boolean end = false;
        Node temp;
        Tree tree = new Tree();
        while(!end){
            input = br.readLine().toUpperCase();
            option = input.split(" ")[0];
            switch(option){
                case "I":
                    tree.insert(input.split(" ")[1].charAt(0));
                    break;
                case "P":
                    temp = tree.binarySearch(input.split(" ")[1].charAt(0));
                    if(temp != null){
                        bw.write(input.split(" ")[1] + " existe");
                        bw.flush();
                    }else{
                        bw.write(input.split(" ")[1] + " nao existe");
                        bw.flush();
                    }
                    break;
                case "INFIXA":
                    tree.traversalInOrderCharacter(tree.root);
                    bw.newLine();
                    bw.flush();
                    break;
                case "PREFIXA":
                    tree.traversalPreOrderCharacter(tree.root);
                    bw.newLine();
                    bw.flush();
                    break;
                case "POSFIXA":
                    tree.traversalPostOrderCharacter(tree.root);
                    bw.newLine();
                    bw.flush();
                    break;
                case "END":
                    end = true;
                    break;
            }
        }
    }
}
