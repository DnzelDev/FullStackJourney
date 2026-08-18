public class PruebaEncapsulamiento01 {
    public static void main (String [] Args){
        Personaje p1 = new Personaje("Juan", 13, 45, 99);

        p1.setDinero(-30);
        System.out.println(p1.getDinero()+" es el dinero.");

        p1.setDinero(500);
        System.out.print(p1.getDinero()+" es el dinero.");
    }
}
