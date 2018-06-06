package problems;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * HackerEarth MicroHouse*
 * 
 * Primero se recibe por la entrada estandar un tamaño de una matriz N * M luego el usuario ingresara, los numeros de suerte
 * asociados con cada posicion de la matriz, el programa consiste en buscar el numero de suerte mas grande que resulta al hacer
 * xOR a las subparcelas de la parcela inicial, entre esos valor se almacena el mas grande y finalmente es impreso.
 * 
 * @author Camilo Camargo Convers.
 * 
 */
public class MicroHouse {

    public static int[] resultOfXor(int[][] matrix) {
        int result;
        int[] arrayResults = new int[matrix.length + matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            result = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                result ^= matrix[i][j];
            }
            arrayResults[k++] = result;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            result = 0;
            for (int i = 1; i < matrix.length; i++) {
                result ^= matrix[i][j];
            }
            arrayResults[k++] = result;
        }
        return arrayResults;
    }

    public static int findMaximumValue(int array[]) {
        int maximum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, plot[][];
        String tempMatrix[][];
        String input;

        input = br.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        plot = new int[N][M];
        tempMatrix = new String[N][M];

        for (int i = 0; i < N; i++) {
            tempMatrix[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                plot[i][j] = Integer.parseInt(tempMatrix[i][j]);
            }
        }
        bw.write(findMaximumValue(resultOfXor(plot)) + "\n");
        bw.flush();
    }
}
