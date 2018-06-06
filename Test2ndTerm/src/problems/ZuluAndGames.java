package problems;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * HackerEarth Zulu and games
 * 
 * en este programa se utiliza el metodo "areIntersecting()" para conocer si los poderes de los niveles se cruzan y se usa
 * el metodo "bigger()" para concer el valor mas grande entre los poderes de cada nivel, el poder mas grande es sumado a la 
 *  variable maximumEnergy despues de que se hayan analizado todos los niveles finalmente se imprimira el valor resultante 
 *  en la variable maximumEnergy.
 * 
 * @author Camilo Andres Camargo Convers.
 */
public class ZuluAndGames {
    
    public static boolean areIntersecting(int qi, int qf, int pi, int pf){
        if((pi >= qi && pi <= qf) || (qf >= pi && qf <= pf) || (qi >= pi && qi <= pf) || (pf >= qi && pf <= qf)){
            return true;
        }
        return false;
    }
    
    public static int bigger(int a, int b, int c, int d){
        if(a >= b && a>= c && a >= d){
            return a;
        }else if(b >= a && b >= c && b >= d){
            return b;
        }else if(c >= a && c >= b && c >= d){
            return c;
        }else{
            return d;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, L[], H[], maximumEnergy = 0;
        int i, j;
        String input;
        
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        H = new int[N];
        input = br.readLine();
        for (i = 0; i < N; i++) {
            L[i] = Integer.parseInt(input.split(" ")[i]);
        }
        
        input = br.readLine();
        for (i = 0; i < N; i++) {
            H[i] = Integer.parseInt(input.split(" ")[i]);
        }
        
        for (i = 0; i < N; i++) {
            for (j = i; j < N; j++) {
                if (j == i) {
                    continue;
                } else {
                    if (!areIntersecting(L[i], H[i], L[j], H[j])) {
                        maximumEnergy += bigger(L[i], H[i], L[j], H[j]);
                    }
                }
            }
        }
        
        maximumEnergy %= 1000000007;
        bw.write(maximumEnergy + "\n");
        bw.flush();
        
    }
}
