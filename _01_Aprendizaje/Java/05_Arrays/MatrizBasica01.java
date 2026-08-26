import java.util.Scanner;
public class MatrizBasica01{
    public static void main(String [] args){
        Scanner sw = new Scanner(System.in);

        int[][] numeros = new int[2][3];

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){
                System.out.print("Ingresa el valor para ["+i+"]["+j+"]: ");
                numeros[i][j]= sw.nextInt();
            }
        }

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){
                System.out.println("Fila "+i+", Columna "+j+": "+numeros[i][j]);
            }
        }

        sw.close();
    }   
}