import java.util.Scanner;
import java.util.Random;

public class PiedraPapelTijera {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] jugadas = { "Piedra", "Papel", "Tijeras" };

        int jugadaUsuario;
        int opcion;

        do {
            System.out.println("\n---Piedra-Papel-Tijeras---");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int jugadaMaquina = random.nextInt(3);

                    System.out.println("\nIgualdades");
                    System.out.println("\n0 = Piedra \n1 = Papel \n2 = Tijera");

                    do {
                        System.out.println("\nIngresa tu jugada:");
                        jugadaUsuario = scanner.nextInt();

                        if (jugadaUsuario >= 0 && jugadaUsuario <= 2) {

                            int resultado = (jugadaUsuario - jugadaMaquina);

                            if (resultado == 0) {
                                System.out.println("\n" + jugadas[jugadaMaquina]);
                                System.out.println("\nEmpate hermano, mejor suerte la proxima..");
                            } else if (resultado == -2 || resultado == 1) {
                                System.out.println("\n" + jugadas[jugadaMaquina]);
                                System.out.println("\nFelicidades!! GANASTE");
                            } else if (resultado == 2 || resultado == -1) {
                                System.out.println("\n" + jugadas[jugadaMaquina]);
                                System.out.println("\nPerdiste buuu");
                            }

                        } else {
                            System.out.println("\nJugada inválida, intenta de nuevo.");
                        }

                    }

                    while (jugadaUsuario < 0 || jugadaUsuario > 2);

                    break;

                case 2:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Ingresar una opción válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 2);

        scanner.close();
    }
}