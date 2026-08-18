import java.util.Scanner;
public class ArrayRecorrido01 {
    public static void main(String[] args) {
        int [] numeros = new int[5];
        Scanner sw = new Scanner(System.in);
        
        for (int i = 0; i < numeros.length; i++){
            System.out.print("Ingrese un número para la posición " + i + ": ");
            numeros[i] = sw.nextInt();
        }

        for(int i = 0; i<numeros.length; i++){
            System.out.println("Posición "+i+": "  +numeros[i]);
        }
    }
}
