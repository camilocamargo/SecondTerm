/*
 * monk and order of phoenix problem HackerEarth
 */
package monk_and_order_of_phoenix;

import dataStructures.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import dataStructures.Node;
import dataStructures.Stack;

/**
 *
 * @author Camilo Camargo
 */
public class _main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int N, X, Q, size, i;
        boolean canUseWand;

        N = Integer.parseInt(br.readLine());
        List listOfStacks = new List();

        for (i = 0; i < N; i++) { //checked
            Stack stack = new Stack();
            input = br.readLine();
            size = Integer.parseInt(input.split(" ")[0]); //the size of the new stack
            for (int j = 1; j <= size; j++) { //push the items in the stack
                stack.push(new Node(Integer.parseInt(input.split(" ")[j])));
            }
            listOfStacks.insertAtEnd(new Node(stack));
        }

        Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            input = br.readLine();
            if (input.equals("2")) {
                canUseWand = false;
                size = listOfStacks.size() - 1;
                for (int k = size; k > 0; k--) {
                    i = 0;
                    for (int j = 0; j < listOfStacks.getNode(size - 1).stack.size(); j++) {
                        if (listOfStacks.getNode(size).stack.getNode(i).number > listOfStacks.getNode(size - 1).stack.getNode(j).number) {
                            canUseWand = true;
                            break;
                        }
                    }
                    i++;
                    if (canUseWand) {
                        size--;
                        if (size == 0) {
                            break;
                        }
                        canUseWand = false;
                    } else {
                        bw.write("NO\n");
                        bw.flush();
                        break;
                    }
                }
                if (canUseWand) {
                    bw.write("YES\n");
                    bw.flush();
                }
            } else if (input.split(" ")[0].equals("1")) { //push item
                listOfStacks.getNode(Integer.parseInt(input.split(" ")[1]) - 1).stack.push(new Node(Integer.parseInt(input.split(" ")[2])));
            } else if (input.split(" ")[0].equals("0")) { //pop item
                listOfStacks.getNode(Integer.parseInt(input.split(" ")[1]) - 1).stack.pop();
            }
        }
    }
}
