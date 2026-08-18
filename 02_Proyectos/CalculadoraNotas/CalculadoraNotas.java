import java.util.Scanner;

public class CalculadoraNotas {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);
        int opcion;
        double nota;
        int cantidad;
        double promedio;
        do {
            System.out.println("------Calculadora de Promedios------");
            System.out.println("1. Sacar promedio");
            System.out.println("2. Salir");
            opcion = sw.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuántas notas desea colocar?");
                    cantidad = sw.nextInt();
                    double suma = 0;
                    for (int i = 1; i <= cantidad; i++) {
                        System.out.println("Ingresar la nota n°" + i + ": ");
                        nota = sw.nextDouble();
                        suma += nota;
                    }
                    promedio = suma / cantidad;

                    System.out.println("El promedio de las notas es: " + promedio);
                    break;

                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Valor invalido. Intente de nuevo.");
                    break;
            }
        } while (opcion != 2);

        sw.close();
    }
}
