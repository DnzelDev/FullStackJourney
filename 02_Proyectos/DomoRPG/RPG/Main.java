import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("============================");
            System.out.println("         DomoRPG");
            System.out.println("============================");
            System.out.println();
            System.out.println("1. Crear personaje");
            System.out.println("2. Seleccionar personaje");
            System.out.println("3. Salir");
            System.out.println();
            System.out.print("Selecciona una opción: ");
            opcion = sw.nextInt();
            System.out.println("Seleccionaste la opción: " + opcion);
            switch (opcion) {
                case 1:
                    System.out.println("Creando personaje...");
                    break;
                case 2:
                    System.out.println("Seleccionando personaje...");
                    break;
                case 3:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 3);
    }
}
