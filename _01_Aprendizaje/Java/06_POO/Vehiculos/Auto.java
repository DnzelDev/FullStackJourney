public class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(int asientos, int ventanas, int cantidadPuertas) {
        super(asientos, ventanas);
        setPuertas(cantidadPuertas);
    }

    public int getPuertas() {
        return cantidadPuertas;
    }

    public void setPuertas(int cantidadPuertas) {
        if (cantidadPuertas < 0) {
            System.out.println(
                    "Las puertas no pueden ser un número negativo.");
        } else {
            this.cantidadPuertas = cantidadPuertas;
        }
    }

    @Override
    public void hacerSonido() {
        System.out.println("Beep beep!");
    }
}
