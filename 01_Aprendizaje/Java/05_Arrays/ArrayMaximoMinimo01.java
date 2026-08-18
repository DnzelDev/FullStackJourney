import java.util.Scanner;

public class ArrayMaximoMinimo01 {
    public static void main(String [] args) {
        int [] numeros = new int[5];
        Scanner sw = new Scanner(System.in);
        
        for (int i = 0; i < numeros.length; i++){
            System.out.print("Ingrese un número para la posición " + i + ": ");
            numeros[i] = sw.nextInt();
        }
        int min = numeros[0];
        int max = numeros[0];
        for (int i = 1; i <numeros.length; i++){
            if(numeros[i]>max){
                max = numeros[i];
            }
            if(numeros[i]<min){
                min = numeros[i];
            }
        }
        System.out.println("El valor maximo es: "+max);
        System.out.println("El valor minimo es: "+min);
    }
}
