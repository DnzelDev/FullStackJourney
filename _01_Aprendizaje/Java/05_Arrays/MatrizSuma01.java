import java.util.Scanner;

public class MatrizSuma01 {
    public static void main(String [] Args){
        Scanner sw = new Scanner(System.in);

        int[][] numeros = new int[3][3];

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){
                System.out.print("Ingresa el valor para ["+i+"]["+j+"]: ");
                numeros[i][j]= sw.nextInt();
            }
        }
        int suma = 0;
        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){
                suma += numeros[i][j];
            }
        }

        System.out.println("La suma es: "+suma);
    }
}
