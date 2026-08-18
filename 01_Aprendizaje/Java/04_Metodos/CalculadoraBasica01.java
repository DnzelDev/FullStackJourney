public class CalculadoraBasica01 
{
    public static void main(String[] args) 
    {
        int suma = sumar(8, 12);
        System.out.println("El resultado de la suma es: " + suma);

        int resta = restar(20, 5);
        System.out.println("El resultado de la resta es: " + resta);

        int multiplicacion = multiplicar(4, 6);
        System.out.println("El resultado de la multiplicación es: " + multiplicacion);

        
        if(esDivisionValida(3))
        {
            double division = dividir(15, 3);
            System.out.println("El resultado de la división es: " + division);
        }
        else
        {
            System.out.println("Error: División por cero no permitida.");
        }
    }

    public static int sumar(int a, int b)
    {
        return a + b;
    }

    public static int restar(int a, int b)
    {
        return a - b;
    }

    public static int multiplicar(int a, int b)
    {
        return a * b;
    }

    public static double dividir(int a, int b)
    {
        return (double) a / b;
    }

    public static boolean esDivisionValida(int divisor)
    {
        return divisor != 0;
    } 
}