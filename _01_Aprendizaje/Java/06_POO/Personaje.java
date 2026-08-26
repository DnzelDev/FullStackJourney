public class Personaje{
    private String nombre;
    private int vida;
    private int velocidad;
    private int dinero;

    public Personaje(String nombre, int vida, int velocidad, int dinero) {
        this.nombre = nombre;
        this.vida = vida;
        this.velocidad = velocidad;
        this.dinero = dinero;
    }


    public int getDinero(){
        return dinero;
    }

    public void setDinero(int dinero){
        if(dinero < 0){
            System.out.println("Error: el dinero no puede ser negativo.");
        }else{
            this.dinero = dinero;
        }
    }


    public int getVida(){
        return vida;
    }

    public void setVida(int vida){
        if(vida < 0){
            System.out.println("Error: la vida no puede ser negativa.");
        }else{
            this.vida = vida;
        }
    }


    public int getVelocidad(){
        return velocidad;
    }

    public void setVelocidad(int velocidad){
        if(velocidad < 0){
            System.out.println("Error: la velocidad no puede ser negativa.");
        }else{
            this.velocidad = velocidad;
        }
    }


    public String getNombre(){
        return nombre;
    }
}