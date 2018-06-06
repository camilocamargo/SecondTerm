/*
 * URI online judge problem 1191 
 */
package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import classes.*;
/**
 *
 * @author Camilo Camargo Convers
 */
public class treeRecovery {
    public static void main(String[] args) throws IOException {
        
        while(true){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Tree tree = new Tree();
            String preOrder, inOrder;
            int lenght;
            
            String input = br.readLine().toUpperCase();
            
            preOrder = input.split(" ")[0];
            inOrder = input.split(" ")[1];
            
            Node rootOfRecoveryTree = Tree.recoveryTree(preOrder, inOrder);
            
            tree.traversalPostOrderCharacter(rootOfRecoveryTree);
            
            bw.newLine();
            bw.flush();
        }
    }
}
