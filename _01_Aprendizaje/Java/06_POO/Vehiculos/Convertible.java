public class Convertible extends Vehiculo {
    private int cantidadPuertas;

    public Convertible(int asientos, int cantidadPuertas) {
        super(asientos, 2);
        this.cantidadPuertas = cantidadPuertas;
        modificarVentanas(0);
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
        System.out.println("brrrrm brrrm!");
    }
}
