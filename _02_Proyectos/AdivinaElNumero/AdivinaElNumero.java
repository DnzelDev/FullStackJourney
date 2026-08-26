import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;

        int intentos = 3;

        int numero;

        do {

            System.out.println("Adivina el número!!");
            System.out.println("Ingresa tu número: ");
            numero = sw.nextInt();

            if (numero < numeroSecreto) {
                System.out.println("El número secreto es mas alto.");
                intentos--;
            } else if (numero > numeroSecreto) {
                System.out.println("El número secreto es mas bajo.");
                intentos--;
            } else {
                System.out.println("Número acertado!!");
            }

        } while (numero != numeroSecreto && intentos > 0);

        if (numero != numeroSecreto) {
            System.out.println("Perdiste, el número secreto era " + numeroSecreto);
        }
        sw.close();
    }
}
