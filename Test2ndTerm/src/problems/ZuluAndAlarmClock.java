package problems;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * HackerEart Zulu and alarm clock*
 * Este programa primero almacena los N relojes y luego las K alarmas en matrices de 3 x 3 luego procede a hacer las comparaciones
 * entre el primer reloj con la primera alarma, luego el primer reloj con la segunda alarma...asi hasta llegar al ultimo reloj con
 * la ultima alarma.
 * El procesos realizado es buscar la distancia mas corta (por derecha o por izquierda) para llegar al valor deseado y esa distancia
 *¨se suma a la variable "operation" que posteriormente se guardara en una matrix de N * K posiciones.
 * finalmente se sumaran los K menores valores y se imprimira dicho resultado.
 */
public class ZuluAndAlarmClock {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        /*T test cases N numbers of clocks K number of alarms, operation for the number of operations for each clock configuration
          temp for save temporally the number to increase or decrease.*/
        int T, N, K, operation = 0, temp[] = new int[3];
        /*smallers for the configuration of alarm with less steps, smaller for the comparision to find the smaller value.*/
        int smallers[], smaller = 0;
        /*index for the loops*/
        int i, j, m = 0;
        /*this matrix for the clocks and alarms, operations for the counters of the operations of each alarm configuration.*/
        int clocks[][], alarms[][], operations[][];
        /**/
        int distanceLeft, distanceRight;
        T = Integer.parseInt(br.readLine());
        input = br.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        K = Integer.parseInt(input.split(" ")[1]);

        clocks = new int[N][3]; //3 is for the units of time.
        alarms = new int[K][3];//3 is for the units of time.
        operations = new int[N][K]; // a counter for each clock configuration to set alarm
        smallers = new int[K];

        for (i = 0; i < N; i++) { //for save the clocks
            input = br.readLine();
            for (j = 0; j < 3; j++) {
                clocks[i][j] = Integer.parseInt(input.split(":")[j]);
            }
        }

        for (i = 0; i < K; i++) { //for save the alarms
            input = br.readLine();
            for (j = 0; j < 3; j++) {
                alarms[i][j] = Integer.parseInt(input.split(":")[j]);
            }
        }

        while (T-- > 0) {
            for (i = 0; i < N; i++) { //the clocks
                for (j = 0; j < K; j++) { //the alarms
                    temp = clocks[i].clone();
                    for (m = 2; m >= 0; m--) { //units of time
                        if(temp[m] != alarms[j][m]){
                            if(m == 0){
                                if(temp[m] < alarms[j][m]){
                                    distanceLeft = Math.abs(23 - alarms[j][m] + temp[m] + 1);
                                    distanceRight = Math.abs(alarms[j][m] - temp[m]);
                                    if(distanceRight < distanceLeft){
                                        operation += distanceRight;
                                    }else{
                                        operation += distanceLeft;
                                    }
                                }else{
                                    distanceLeft = Math.abs(temp[m] - alarms[j][m]);
                                    distanceRight = Math.abs(23 - temp[m] + alarms[j][m] + 1);
                                    if(distanceLeft < distanceRight){
                                        operation += distanceLeft;
                                    }else{
                                        operation += distanceRight;
                                    }
                                }
                            }else{
                                if(temp[m] < alarms[j][m]){
                                    distanceLeft = Math.abs(59 - alarms[j][m] + temp[m] + 1);
                                    distanceRight = Math.abs(alarms[j][m] - temp[m]);
                                    if(distanceRight < distanceLeft){
                                        operation += distanceRight;
                                    }else{
                                        operation += distanceLeft;
                                        temp[m - 1]--;
                                    }
                                }else{
                                    distanceLeft = Math.abs(temp[m] - alarms[j][m]);
                                    distanceRight = Math.abs(59 - temp[m] + alarms[j][m] + 1);
                                    if(distanceLeft < distanceRight){
                                        operation += distanceLeft;
                                    }else{
                                        operation += distanceRight;
                                        temp[m - 1]++;
                                    }
                                }
                            }
                        }
                    }
                    operations[i][j] = operation;
                    operation = 0;
                }
            }
            /**find the smaller values*/
            for (j = 0; j < K; j++) {
                smaller = operations[0][j];
                for (i = 0; i < N; i++) {
                    if(operations[i][j] < smaller){
                        smaller = operations[i][j];
                    }
                }
                smallers[j] = smaller;
            }
            
            smaller = 0;
            for (j = 0; j < K; j++) {
                smaller += smallers[j];
            }

            bw.write(smaller + "\n");
            bw.flush();
        }
    }
}
