package _02_Proyectos.BatallaPorTurnos;

public class Heroe extends Personaje {
    public Heroe(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public void mostrarAtaque(Personaje objetivo) {
        System.out.println(this.getNombre() + " infringió un ataque magico de " + getAtaque()
                + " puntos mágicos de daño a " + objetivo.getNombre());
    }
}
