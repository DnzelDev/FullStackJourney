import java.util.Scanner;

public class MatrizSumaPorFilaYColumna01 {
    public static void main(String[] Args){
    Scanner sw = new Scanner(System.in);

        int[][] numeros = new int[3][3];

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){
                System.out.print("Ingresa el valor para ["+i+"]["+j+"]: ");
                numeros[i][j]= sw.nextInt();
            }
        }

        for(int i = 0; i < numeros.length; i++){
            int sumaFila = 0;
            for(int j = 0; j < numeros[i].length; j++){
                sumaFila += numeros[i][j];
            }
            System.out.println("Suma de la "+i+" fila: "+sumaFila);
        }

        for(int j = 0; j < numeros[0].length; j++){
            int sumaColumna = 0;
            for(int i = 0; i < numeros.length; i++){
                sumaColumna += numeros[i][j];
            }
            System.out.println("Suma columna " + j + ": " + sumaColumna);
        }
    }
}
