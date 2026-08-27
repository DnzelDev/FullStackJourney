public class Vehiculo {
    private int ventanas;
    private int asientos;

    public Vehiculo(int asientos, int ventanas) {
        setAsientos(asientos);
        setVentanas(ventanas);
    }

    public int getAsientos() {
        return asientos;
    }

    public int getVentanas() {
        return ventanas;
    }

    public void setAsientos(int asientos) {
        if (asientos < 0) {
            System.out.println("Los asientos no pueden ser un número negativo.");
        } else {
            this.asientos = asientos;
        }
    }

    public void setVentanas(int ventanas) {
        if (ventanas < 2) {
            System.out.println("Las ventanas no pueden ser menores a 2");
        } else {
            this.ventanas = ventanas;
        }
    }

    protected void modificarVentanas(int nuevoValor) {
        ventanas = nuevoValor;
    }

    public void hacerSonido() {
        System.out.println("Vehículo genérico haciendo ruido.");
    }
}
