package _02_Proyectos.BatallaPorTurnos;

public class PruebaBatalla01 {
    public static void main(String[] args) {
        Enemigo e1 = new Enemigo("Mordekaiser", 100, 20);
        Heroe h1 = new Heroe("Arturo", 100, 25);

        System.out.println("La batalla empezará");
        System.out.println("Vida de " + h1.getNombre() + ": " + h1.getVida());
        System.out.println("Vida de " + e1.getNombre() + ": " + e1.getVida());
        System.out.println();
        do {
            h1.atacar(e1);
            if (e1.getVida() > 0) {
                e1.atacar(h1);
            }
            System.out.println(h1.getNombre() + ": Vida restante = " + h1.getVida());
            System.out.println(e1.getNombre() + ": Vida restante = " + e1.getVida());
        } while (h1.getVida() > 0 && e1.getVida() > 0);

        if (h1.getVida() > 0) {
            System.out.println(h1.getNombre() + " es el ganador!");
        } else if (e1.getVida() > 0) {
            System.out.println(e1.getNombre() + " es el ganador!");

        }
    }
}
