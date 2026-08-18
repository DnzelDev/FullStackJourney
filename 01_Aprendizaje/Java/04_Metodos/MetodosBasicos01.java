public class MetodosBasicos01 
{
    public static void main(String[] args) 
    {
        int resultado = sumar(5, 10);
        System.out.println("El resultado de la suma es: " + resultado);

        int numero = 7;
        if(esPar(numero))
        {
            System.out.println(numero + " es un número par.");
        }
        else
        {
            System.out.println(numero + " es un número impar.");
        }
    }

    public static int sumar(int a, int b)
    {
        return a + b;
    }

    public static boolean esPar(int n)
    {
        return n % 2 == 0;
    }
}
