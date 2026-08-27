import java.util.Scanner;

public class ArraysDoubles01 {
    public static void main(String[] args) {
        double[] numeros = new double[4];
        Scanner sw = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese un valor para la posición [" + i + "]: ");
            numeros[i] = sw.nextDouble();

        }

        double suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        System.out.print("La suma de los numeros ingresados es de: " + suma);
        sw.close();
    }
}
