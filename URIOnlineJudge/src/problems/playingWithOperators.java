/*
 * URI online judge problem 1696.
 */
package problems;

/**
 *
 * @author Camilo Camargo C.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import classes.*;

public class playingWithOperators {
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, N, Q, i, change, result;//T test case, N number of numbers to operate, Q number of replacements
        int temp[];                   //change for the value to change and restult for the result of the operation.
        boolean turn = true;//for the turn if is false is turn un Rusa else is turn of Sanchez.
        String input;
        
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            turn = !turn; // change the turn
            input = br.readLine();
            N = Integer.parseInt(input.split(" ")[0]);
            Q = Integer.parseInt(input.split(" ")[1]);
            temp = new int[N];
            Tree tree = new Tree();
            Tree.flushIndex();
            Tree.flushLevel();
            tree.insert(0);// only for the correct work of the createTree method.
            tree.createTree(N);//create the tree for N leafs
            input = br.readLine();
            for (i = 0; i < N; i++) {
                temp[i] = Integer.parseInt(input.split(" ")[i]);//pass the string to an integer array.
            }
            tree.fillLeafs(tree.root, temp); //fill the leafs of the tree with the number of the user input.
            result = tree.operate(tree.root); //capture the result 
            if (result % 2 != 0) {
                if (!turn) {
                    bw.write(result + " Rusa");
                } else {
                    bw.write(result + " Sanchez");
                }
            } else {
                if (!turn) {
                    bw.write(result + " Sanchez");
                } else {
                    bw.write(result + " Rusa");
                }
            }
            bw.newLine();
            bw.flush();
            while (Q-- > 0) {
                input = br.readLine();
                i = Integer.parseInt(input.split(" ")[0]) - 1;
                change = Integer.parseInt(input.split(" ")[1]);
                temp[i] = change;
                Tree.flushIndex();
                tree.fillLeafs(tree.root, temp);
                result = tree.operate(tree.root);
                if(result % 2 != 0){
                    if(!turn){
                        bw.write(result + " Rusa");
                    }else{
                        bw.write(result + " Sanchez");
                    }
                }else{
                    if(!turn){
                        bw.write(result + " Sanchez");
                    }else{
                        bw.write(result + " Rusa");
                    }
                }
                bw.newLine();
                bw.flush();
            }
        }
        
    }
}
