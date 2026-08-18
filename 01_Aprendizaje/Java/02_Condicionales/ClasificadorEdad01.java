import java.util.Scanner;

public class ClasificadorEdad01 
{
    public static void main(String[] args)
    {
        Scanner sw = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int edad = sw.nextInt();

        if(edad < 13)
        {
            System.out.print("Niño");
        }
        else if(edad >= 13 && edad <= 17)
        {
            System.out.print("Adolescente");
        }
        else if(edad >= 18 && edad <= 64)
        {
            System.out.print("Adulto");
        }
        else
        {
            System.out.print("Adulto mayor");
        }

        sw.close();
    }    
}
