package _02_Proyectos.BatallaPorTurnos;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;

    public Personaje(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        setVida(vida);
        setAtaque(ataque);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0 || vida > 100) {
            System.out.println("La vida no puede ser menor a 0 ni mayor a 100.");
        } else {
            this.vida = vida;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque < 0 || ataque > 25) {
            System.out.println("El ataque no puede ser menor a 0 ni mayor a 25.");
        } else {
            this.ataque = ataque;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void atacar(Personaje objetivo) {
        int nuevaVida = objetivo.getVida() - this.getAtaque();
        if (nuevaVida < 0) {
            nuevaVida = 0;
        }
        objetivo.setVida(nuevaVida);

        mostrarAtaque(objetivo);
    }

    public void mostrarAtaque(Personaje objetivo) {
        System.out.println(this.nombre + " realiza una acción sobre " + objetivo.getNombre());
    }
}
