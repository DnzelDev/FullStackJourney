## ¿Qué es la Programación Orientada a Objetos (POO)?

Forma de organizar código agrupando datos y comportamiento relacionados
dentro de una misma unidad llamada clase. Permite modelar "cosas" del
mundo real (o de un dominio, como un juego) como una sola entidad con
características (datos) y acciones (comportamiento).

## ¿Para qué sirve?
Evita el caos de tener todo suelto en main a medida que un programa
crece. Divide un sistema en piezas organizadas, cada una responsable
de su propia parte.

## Clase vs Objeto

- Clase: el "molde" o descripción de cómo debe ser algo (ej. Personaje:
  tiene nombre, vida, velocidad, dinero).
- Objeto: una instancia REAL creada a partir de ese molde, con sus
  propios valores (ej. p1 con nombre="Denzel", vida=100).

Se pueden crear muchos objetos de la misma clase, cada uno con datos
independientes entre sí.

## Nivel de abstracción: qué incluir en una clase

No se modela TODO lo que existe en la realidad, solo lo que el
programa realmente necesita usar. Ejemplo: Personaje en un RPG no
necesita datos irrelevantes para el juego, solo lo que afecta su
comportamiento/mecánicas (nombre, vida, velocidad, dinero, etc).

## Sintaxis básica

public class Personaje {
    String nombre;
    int vida;
}

Estos datos dentro de la clase se llaman ATRIBUTOS (o campos/propiedades).

Crear y usar un objeto:
Personaje p1 = new Personaje();
p1.nombre = "Denzel";     // acceso con punto, igual que sw.nextInt()
                            // o numeros.length

## Regla: public class y nombre de archivo

Un archivo .java puede tener varias clases, pero SOLO UNA puede ser
public, y esa debe tener el MISMO nombre que el archivo.
Las demás clases del archivo van sin "public" (clases secundarias,
solo visibles dentro del mismo archivo/paquete).


## Encapsulamiento

## ¿Qué es?
Restringir el acceso directo a los atributos de una clase, obligando
a que cualquier lectura o modificación pase por métodos controlados
(getters y setters), en vez de tocar el atributo directamente desde
fuera de la clase.

## ¿Para qué sirve?
Permite validar datos antes de que se asignen (ej. evitar que vida
o dinero sean negativos), protegiendo la integridad del objeto.
Sin encapsulamiento, cualquier código externo podría asignar
valores absurdos sin ningún control.

## Sintaxis

private int vida;   // ya no accesible directamente como objeto.vida

// Getter: solo lee
public int getVida() {
    return vida;
}

// Setter: modifica CON validación
public void setVida(int vida) {
    if (vida < 0) {
        System.out.println("Error: la vida no puede ser negativa.");
    } else {
        this.vida = vida;
    }
}

## Atributos sin setter (solo getter)

Un atributo puede tener SOLO getter si se decide que no debe poder
cambiar después de creado el objeto (ej. nombre, en este diseño).
Es una decisión de diseño, no una regla obligatoria de Java.

## Patrón de validación en setters

Revisar la condición inválida PRIMERO (ej. valor negativo), mostrar
mensaje de error específico mencionando qué atributo falló, y solo
asignar this.atributo = valor cuando la validación pasa. Si falla,
el atributo se queda con su valor anterior (no se sobrescribe con
el valor inválido).


## Mini-sistema aplicado: Sistema Bancario (repaso POO completo)

Ejercicio de repaso aplicando Clase, Objeto, Atributos, Constructor,
this, y Encapsulamiento juntos en un solo contexto real:

CuentaBancaria: titular (String), saldo (double)
- Atributos private
- Constructor con this
- Getters para ambos atributos
- Setter de saldo con validación (rechaza negativos)

Patrón reutilizable para cualquier clase similar: atributo sensible
(saldo, vida, dinero, stock, etc.) → private + setter con validación
antes de asignar.

## Uso de package en mini-proyectos

A diferencia de los ejercicios sueltos en 01_Aprendizaje (sin package),
un mini-sistema con su propia subcarpeta SÍ usa package consistente
en todos sus archivos — refleja mejor cómo se organiza un proyecto
real. VS Code lo agrega automáticamente al crear archivos dentro de
una subcarpeta.


## Herencia

## ¿Qué es?
Permite que una clase (hija) reutilice atributos y métodos de otra
clase (padre/base), sin copiar y pegar código. La hija hereda todo
lo del padre automáticamente, y puede agregar sus propios atributos
o comportamientos exclusivos.

## ¿Para qué sirve?
Evita duplicar código cuando varias clases comparten una base común
pero tienen diferencias específicas. Ejemplo: CuentaAhorros y
CuentaCorriente comparten titular/saldo (de CuentaBancaria), pero
cada una tiene algo propio (tasaInteres, limiteSobregiro).

## Sintaxis: extends

public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;   // exclusivo de esta clase hija
}

## super — llamar al constructor del padre

Los atributos private del padre no son accesibles directamente
desde la clase hija. super(...) llama al constructor del padre para
inicializarlos correctamente, respetando el encapsulamiento.

public CuentaAhorros(String titular, double saldo, double tasaInteres) {
    super(titular, saldo);          // inicializa lo heredado
    this.tasaInteres = tasaInteres; // inicializa lo propio
}


## Método propio en una clase hija, usando herencia + encapsulamiento

Una clase hija puede tener métodos EXCLUSIVOS que no existen en el
padre, y esos métodos pueden modificar atributos heredados privados
usando los getters/setters heredados (no accediendo directamente).

Ejemplo: CuentaAhorros.aplicarInteres()
public void aplicarInteres() {
    double interes = getSaldo() * (tasaInteres / 100);
    double nuevoSaldo = getSaldo() + interes;
    setSaldo(nuevoSaldo);
}

- getSaldo()/setSaldo() son heredados de CuentaBancaria, no
  reescritos en CuentaAhorros.
- tasaInteres/100 convierte un porcentaje (ej. 5) a su forma
  decimal (0.05) para poder multiplicar correctamente.


  ## protected — tercer modificador de acceso

- private: solo accesible dentro de la MISMA clase.
- protected: accesible dentro de la misma clase Y desde clases hijas
  (que hereden con extends), pero no desde clases externas sin
  relación de herencia.
- public: accesible desde cualquier lugar.

Útil cuando una clase padre necesita dar a sus hijas más libertad
que al resto del programa, sin perder el control de acceso completo
que tendría un atributo/método public.

## Conflicto entre setter heredado y regla de negocio distinta en la
## clase hija

Un setter con validación estricta (ej. setSaldo() que rechaza
negativos) puede no servir para una clase hija con reglas distintas
(ej. CuentaCorriente permite saldo negativo hasta un límite).
Solución: agregar un método protected en la clase padre que modifique
el atributo SIN esa validación específica, para que las hijas lo usen
cuando su propia lógica ya validó correctamente el caso.