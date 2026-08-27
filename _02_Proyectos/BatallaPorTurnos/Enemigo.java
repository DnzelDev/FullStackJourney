package _02_Proyectos.BatallaPorTurnos;

public class Enemigo extends Personaje {
    public Enemigo(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public void mostrarAtaque(Personaje objetivo) {
        System.out.println(getNombre() + " realizó un daño venenoso de " + getAtaque() + " puntos de daño a "
                + objetivo.getNombre());
    }
}
