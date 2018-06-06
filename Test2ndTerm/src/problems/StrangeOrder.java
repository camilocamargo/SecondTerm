package problems;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import classes.*;

/**HackerEarth StrangeOrder
 * Este programa fue solucionado utilizando una lista enlazada, consiste en crear un arreglo de n posiciones con los numeros
 * de 1 hasta n, luego se insertan estos numeros en una lista para asi simplificar la tarea de eliminar y agregar elementos
 * se empieza tomando el numero mayor entre esa lista, este numero se conocera como X y luego en el resto de la lista se busca
 * un numero con el cual el MCD de X y Y sea distito de 1. Finalmente se agrega X y Y a la lista final, si no se encuentra un
 * Y simplemente se agregara X.
 * Por ultimo se imprime la lista Final.
 * 
 * @author Camilo Camargo Convers
 *
 */

public class StrangeOrder {

    public static int gcd(int x, int y) {
        if (x > y) {
            for (int i = x; i > 0; i--) {
                if (x % i == 0 && y % i == 0) {
                    return i;
                }
            }
        } else {
            for (int i = y; i > 0; i--) {
                if (x % i == 0 && y % i == 0) {
                    return i;
                }
            }
        }
        return 1;
    }

    public static int[] antecesors(int number) {
        int[] tempArray = new int[number];
        int[] antecesors = new int[number];
        int j = number - 1, i = 0;
        for (i = 0; i < number; i++) {
            tempArray[i] = i + 1;
        }
        for (i = 0; i < number; i++) {
            antecesors[i] = tempArray[j--];
        }
        return antecesors;
    }

    public static int getMaxValue(List list) {
        int maximum = 0;
        Node temp = list.head;
        while(temp != null){
            if(temp.getValue() > maximum){
                maximum = temp.getValue();
            }
            temp = temp.next;
        }
        return maximum;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, array[], x, y, gcd, j = 0;
        List list = new List();
        List finalList = new List();
        n = Integer.parseInt(br.readLine());
        array = antecesors(n);

        for (int i = 0; i < n; i++) {
            list.insertAtEnd(new Node(array[i]));
        }
        while(!list.isEmpty()){
            y = 0;
            x = getMaxValue(list);
            for (int i = 1; i < list.size; i++) {
                if(gcd(x,list.getNode(i).getValue()) != 1){
                    y = list.getNode(i).getValue();
                    break;
                }
            }
            finalList.insertAtEnd(new Node(x));
            list.DeleteNodeValue(x);
            j = 0;
            if(y != 0){
                finalList.insertAtEnd(new Node(y));
                list.DeleteNodeValue(y);
            }
        }
        finalList.printList();
    }
}
