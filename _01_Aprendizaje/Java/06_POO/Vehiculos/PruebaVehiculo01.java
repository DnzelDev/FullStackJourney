import java.nio.channels.Pipe.SourceChannel;

public class PruebaVehiculo01 {
    public static void main(String[] args) {
        Vehiculo auto = new Vehiculo(-2, 4);
        System.out.println("El auto tiene " + auto.getAsientos() + " asientos.");
        Convertible c1 = new Convertible(2, 3);
        System.out.println("el convertible tiene :" + c1.getVentanas());
    }
}
