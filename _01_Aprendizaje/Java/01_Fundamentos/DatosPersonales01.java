import java.time.LocalDate;

public class DatosPersonales01 
{
    public static void main(String[] args) 
    {
        String nombre = "Denzel";
        int edad = 18;
        boolean esEstudiante = true;
        LocalDate hoy = LocalDate.now();
        int anio = hoy.getYear();
        int anioNacimiento = anio - edad;

        System.out.println("Hola, soy " + nombre + ", tengo " + edad + " años y nací en el año " + anioNacimiento + "." + "¿Soy estudiante? " + esEstudiante);
    }
}
