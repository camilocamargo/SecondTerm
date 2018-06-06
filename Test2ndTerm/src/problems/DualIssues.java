package problems;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * HackerEarth Dual Issues:
 * Este programa primero recibe por la entrada estandar el los valores del arreglo, posteriormente separa unicamente los 
 * numero primos, luego empieza a multiplicarlos el i-esimo numero con el j-esimo (todos con todos) almacenando a la vez 
 * el mayor producto, finalmente imprime el mayor producto logrado entre los numeros primos del arreglo.
 * 
 * 
 * 
 * @author Camilo Camargo Convers
 */
public class DualIssues {

    public static boolean isPrime(int x) {

        int C = 0;

        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                C += 1;
            }
        }
        return C == 2 ? true : false;
    }

    public static int[] savePrimes(int[] array) {
        int[] temp = new int[array.length];
        int[] primes;
        int cont = 0, j = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                temp[j++] = array[i];
                cont++;
            }
        }

        primes = new int[cont];
        for (int i = 0; i < cont; i++) {
            primes[i] = temp[i];
        }

        return primes;
    }

    public static int biggerProductPossible(int[] array) {
        if (array.length == 0) {
            return -1;
        } else {
            int bigger = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] * array[j] > bigger) {
                        bigger = array[i] * array[j];
                    }
                }
            }
            return bigger;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t,n,a[];
        String temp[];
        t = Integer.parseInt(br.readLine());
        
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            a = new int[n];
            temp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }
            bw.write(biggerProductPossible(savePrimes(a)) + "\n");
            bw.flush();
        }
    }
}
