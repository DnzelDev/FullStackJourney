import java.util.Scanner;

public class ContadorRangos01 {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);

        System.out.print("Ingrese el valor limite: ");
        int n = sw.nextInt();

        int par = 0;
        int impar = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println(i);

            if (i % 2 == 0) {
                par++;
            } else {
                impar++;
            }
        }

        System.out.println("Cantidad de numeros pares: " + par);
        System.out.println("Cantidad de numeros impares: " + impar);
        sw.close();
    }
}
