import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);
        double tipoCambio = 3.75;
        int op;
        double sol;
        double dolar;
        double aDolar;
        double aSol;
        do {
            System.out.println("\n---Menu-de-Conversiones---");
            System.out.println("1. Sol a dólar");
            System.out.println("2. Dólar a sol");
            System.out.println("3. Salir");
            op = sw.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Ingresa la cantidad de soles.");
                    sol = sw.nextDouble();
                    aDolar = sol / tipoCambio;
                    System.out.println("S/" + sol + " a dólares es: $" + aDolar);
                    break;
                case 2:
                    System.out.println("Ingresa la cantidad de dólares");
                    dolar = sw.nextDouble();
                    aSol = dolar * tipoCambio;
                    System.out.println("$" + dolar + " a soles es: S/" + aSol);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("\nPor favor ingresa una opción válida.");
                    break;
            }
        } while (op != 3);
        sw.close();
    }
}
