public class AutoElectrico extends Vehiculo implements Electrico {
    public AutoElectrico(int asientos, int ventanas) {
        super(asientos, ventanas);
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando bateria...");
    }
}
