public class PruebaConstructor01 {
    public static void main (String [] Args){
        Personaje p1 = new Personaje("Denzel", 100, 20, 19);
        Personaje p2 = new Personaje("Aizen", 75, 30, 45);
        System.out.println(p1.getNombre()+" tiene "+p1.getVida()+" de vida, "+p1.getVelocidad()+" de velocidad y "+p1.getDinero()+" monedas");
        System.out.println(p2.getNombre()+" tiene "+p2.getVida()+" de vida, "+p2.getVelocidad()+" de velocidad y "+p2.getDinero()+" monedas");

    }
}