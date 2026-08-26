import java.util.Scanner;

public class ArrayOperaciones01 {
    public static void main(String[] args) {
        int[] numeros = new int[5];
        Scanner sw = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese un número para la posición " + i + ": ");
            numeros[i] = sw.nextInt();
        }

        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        double promedio = (double) suma / numeros.length;
        System.out.println("La suma de los números es: " + suma);
        System.out.println("El promedio de los números es: " + promedio);
        sw.close();
    }
}
