/*Problem of monk a philosopher´s stone HackerEarth*/
package monk_and_philosophers_stone;

import dataStructures.Stack;
import dataStructures.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Camilo Camargo
 */
public class _main {

    public static void main(String[] args) throws IOException {
        Stack harry = new Stack();
        Stack monk = new Stack();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int N, Q, X, i, worthOfCoins = 0;
        int temp[];

        input = br.readLine();
        N = Integer.parseInt(input);
        temp = new int[N];
        
        input = br.readLine(); //read the coins of harry´s bag
        for (i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(input.split(" ")[i]);
        }
        for (i = temp.length - 1; i >= 0; i--) {
            harry.push(new Node(temp[i]));
        }

        input = br.readLine();
        Q = Integer.parseInt(input.split(" ")[0]);
        X = Integer.parseInt(input.split(" ")[1]);

        while (worthOfCoins != X && Q-- > 0) {
            input = br.readLine();
            if(input.equals("Harry")){
                worthOfCoins += harry.head.number;
                monk.push(harry.pop().clone());
            } else if(input.equals("Remove")){
                worthOfCoins -= monk.head.number;
                monk.pop();
            }
            if (worthOfCoins == X) {
                bw.write(monk.size() + "\n");
                bw.flush();
                System.exit(0);
            }
            if (monk.isEmpty() && harry.isEmpty()) {
                break;
            }
        }
        bw.write("-1\n");
        bw.flush();
    }
}
