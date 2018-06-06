/*
 * monk and chamber of secret HackerEarth
 */
package monk_and_chamber_of_secrets;

import dataStructures.Queue;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue spiders = new Queue();
        Queue dequeuedSpiders = new Queue();
        Node copy, temp, poweriest;
        String input;
        int N, X, i, XSpidersToRemove;
        
        input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        X = Integer.parseInt(input.split(" ")[1]);
        
        input = br.readLine();
        
        for (i = 0; i < N; i++) {
            spiders.enqueue(new Node(i+1, Integer.parseInt(input.split(" ")[i])));
        }
        
        for (int j = 0; j < X; j++) {
            if (X > spiders.size()) {
                XSpidersToRemove = spiders.size();
            }else{
                XSpidersToRemove = X;
            }
            for (i = 0; i < XSpidersToRemove; i++) {
                dequeuedSpiders.enqueue(spiders.dequeue().clone());
            }
            poweriest = dequeuedSpiders.head;
            for (i = dequeuedSpiders.size() - 1; i >= 0; i--) {
                if (dequeuedSpiders.getNode(i).number > poweriest.number) {
                    poweriest = dequeuedSpiders.getNode(i).clone();//<---this is the initial index
                }
            }
            bw.write(poweriest.school + " ");//<---the index of the spider.
            bw.flush();
            /**Enque back**/
            while(!dequeuedSpiders.isEmpty()){
                copy = dequeuedSpiders.dequeue();
                if(copy.school == poweriest.school){
                    continue;
                }else{
                    spiders.enqueue(copy.cloneDecremented());
                }
            }
        }
    }
}
