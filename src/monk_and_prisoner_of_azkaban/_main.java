/*
 * monk and prisioner of azkaban problem HackerEarth
 */
package monk_and_prisoner_of_azkaban;

/**
 *
 * @author Camilo Camargo
 */
import dataStructures.List;
import dataStructures.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List list = new List();
        Node temp;
        String input;
        int N, x, y, i, j;

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        for (i = 0; i < N; i++) {
            list.insertAtEnd(new Node(Integer.parseInt(input.split(" ")[i])));
        }

        temp = list.head;

        /**is needed the index not the number.**/
        for (i = 0; i < N; i++) {
            x = 0;
            /*backward*/
            for (j = i; j >= 0; j--) {
                if (list.getNode(j).number > list.getNode(i).number) {
                    x = j + 1;
                    break;
                }
            }
            if (x == 0) {
                x = -1;
            }
            /*fordward*/
            y = 0;
            for (j = i + 1; j < N; j++) {
                if (list.getNode(j).number > list.getNode(i).number) {
                    y = j + 1;
                    break;
                }
            }
            if (y == 0) {
                y = -1;
            }
            bw.write((x + y) + "\n");
            bw.flush();
        }
    }
}
