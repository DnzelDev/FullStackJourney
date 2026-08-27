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

## Constructor reutilizando setters (evitar "puertas traseras")

## ¿Cuál es el problema?
Si el constructor asigna un atributo directamente (this.atributo =
parametro) y el setter valida ese mismo atributo por separado,
existen DOS caminos distintos para asignar el valor — pero solo uno
de ellos valida. Alguien podría crear un objeto con datos inválidos
usando el constructor, saltándose por completo la regla del setter.

## Solución
El constructor, en vez de asignar directo, LLAMA al setter — así
existe un solo lugar de verdad para cada regla de validación (mismo
principio DRY que ya usaste para no repetir código en métodos).

## Sintaxis

public class Vehiculo {
    private int asientos;

    public Vehiculo(int asientos) {
        setAsientos(asientos);   // llama al setter, no asigna directo
    }

    public void setAsientos(int asientos) {
        if (asientos < 0) {
            System.out.println("Los asientos no pueden ser negativos.");
        } else {
            this.asientos = asientos;
        }
    }
}

Con esto, un valor inválido es rechazado sin importar si llega por
el constructor (al crear el objeto) o por el setter (después, ya
creado el objeto) — la regla vive en un solo lugar.


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

## Qué va en el padre vs qué va en cada hija

Solo lo VERDADERAMENTE compartido por todas las hijas (presentes y
futuras) va en la clase padre. Un atributo que solo aplica a algunas
hijas debe declararse en cada hija que lo necesite, no forzarlo
arriba en el padre.

Ejemplo (Vehiculos): "cantidadPuertas" NO va en Vehiculo (el padre),
porque una futura clase Moto no tendría puertas. Auto y Convertible
(hijas que sí tienen puertas) lo declaran cada una por su cuenta,
aunque el atributo se repita conceptualmente entre ellas.


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
negativos, o setVentanas() que exige mínimo 2) puede no servir para
una clase hija con reglas distintas (ej. CuentaCorriente permite
saldo negativo hasta un límite; Convertible siempre tiene 0
ventanas). Solución: agregar un método protected en la clase padre
que modifique el atributo SIN esa validación específica, para que
las hijas lo usen cuando su propia lógica ya justifica el caso.

## Ejemplo aplicado (Vehiculos)

public class Vehiculo {
    private int ventanas;

    public void setVentanas(int ventanas) {
        if (ventanas < 2) {
            System.out.println("Las ventanas no pueden ser menores a 2");
        } else {
            this.ventanas = ventanas;
        }
    }

    // protected: solo Vehiculo y sus hijas pueden saltarse la regla
    protected void modificarVentanas(int nuevoValor) {
        ventanas = nuevoValor;
    }
}

public class Convertible extends Vehiculo {
    public Convertible(int asientos, int cantidadPuertas) {
        super(asientos, 2);       // pasa un valor VÁLIDO al padre
        this.cantidadPuertas = cantidadPuertas;
        modificarVentanas(0);     // luego lo pisa saltándose la regla
    }
    private int cantidadPuertas;
}

Truco clave: primero se le pasa al super(...) un valor que SÍ cumpla
la regla del padre, y recién después, dentro del propio constructor,
se usa el método protected para dejarlo en el valor real deseado.


## Polimorfismo

## ¿Qué es?
Un mismo método (mismo nombre, misma firma) se comporta distinto
según el tipo REAL del objeto que lo ejecuta — sin necesitar
preguntar "qué tipo eres" con if/switch. Cada clase hija puede
redefinir (sobrescribir) el comportamiento heredado del padre.

## Analogía
Como decir "haz ruido" a distintos animales — un perro ladra, un
gato maúlla. Mismo comando, ejecución distinta según quién lo recibe.

## ¿Para qué sirve?
Permite tratar objetos de distintas clases hijas de forma uniforme:
llamar el mismo método sobre cualquiera de ellas sin preguntar antes
qué tipo específico es. Se vuelve mucho más potente combinado con
Colecciones (listas mezcladas de distintos tipos de objetos, cada
uno respondiendo a su manera al mismo método).

## Sintaxis: @Override

// En la clase padre
public class Vehiculo {
    public void hacerSonido() {
        System.out.println("Vehículo genérico haciendo ruido.");
    }
}

// En la clase hija, redefiniendo el comportamiento
public class Auto extends Vehiculo {
    @Override
    public void hacerSonido() {
        System.out.println("Beep beep!");
    }
}

public class Convertible extends Vehiculo {
    @Override
    public void hacerSonido() {
        System.out.println("Brrrrm brrrm!");
    }
}

Java siempre ejecuta la versión del método que corresponde al TIPO
REAL del objeto, no al tipo de la clase padre, aunque el método
exista en ambas.


## Interfaces

## ¿Qué es?
Un "contrato": una lista de métodos que una clase promete
implementar. La interfaz declara QUÉ métodos deben existir, pero no
dice CÓMO deben funcionar — eso lo decide cada clase que la usa.

## Analogía
Como un contrato de trabajo: dice "debes saber conducir, debes saber
cargar mercancía", pero no enseña CÓMO hacerlo. Cada persona que
firma (cada clase) llega con su propia forma de cumplir esas tareas.

## Diferencia clave con Herencia (extends)

- extends: una clase solo puede tener UNA clase padre (herencia
  simple). Hereda comportamiento YA implementado.
- implements: una clase puede implementar VARIAS interfaces a la
  vez. Solo hereda la obligación de implementar esos métodos, no
  código ya hecho.

Resuelve el problema de "¿qué pasa si una clase necesita comportarse
como varias cosas distintas a la vez, que no comparten una única
familia de herencia?".

## ¿Cuándo usar interfaz en vez de meterlo en la clase padre?

Cuando la capacidad NO es compartida por todas las clases hijas —
solo por algunas. Forzarlo en el padre obligaría a herederos que no
lo necesitan a cargar con algo que no les corresponde.

Ejemplo: no todos los Vehiculo son eléctricos, así que cargarBateria()
no pertenece a Vehiculo (el padre) — pertenece a una interfaz aparte
que solo algunos vehículos (los eléctricos) deciden implementar.

## Sintaxis

// Interfaz: solo declara, sin cuerpo, termina en ";"
public interface Electrico {
    void cargarBateria();
}

// Clase que hereda de Vehiculo Y cumple el contrato de Electrico
public class AutoElectrico extends Vehiculo implements Electrico {
    public AutoElectrico(int asientos, int ventanas) {
        super(asientos, ventanas);
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando batería...");
    }
}

Una interfaz puede declarar varios métodos a la vez — la clase que
la implementa debe darle cuerpo con @Override a TODOS, no solo a
algunos ("firmar el contrato completo").

## Reglas de archivo

Un archivo .java solo puede tener una clase o interfaz PUBLIC que le
dé nombre al archivo — por eso Electrico.java contiene
"public interface Electrico". Convención: una interfaz por archivo,
igual que las clases, para mantener todo ordenado.


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

## Mini-sistema aplicado: Vehículos (repaso Herencia + protected +
## Polimorfismo + Interfaces)

Vehiculo (padre): asientos, ventanas (private + getters/setters,
constructor reutilizando setters, método protected modificarVentanas,
método hacerSonido() con versión genérica)

- Auto extends Vehiculo → agrega cantidadPuertas propio,
  @Override de hacerSonido() ("Beep beep!")
- Convertible extends Vehiculo → agrega cantidadPuertas propio,
  usa modificarVentanas(0) para saltarse la regla mínima del padre,
  @Override de hacerSonido() ("Brrrrm brrrm!")
- Electrico (interfaz) → declara cargarBateria()
- AutoElectrico extends Vehiculo implements Electrico → hereda lo
  normal de Vehiculo Y cumple el contrato de Electrico

Patrón reutilizable: cuando falta una regla de validación distinta
en una hija → protected en el padre. Cuando falta un comportamiento
que solo ALGUNAS hijas necesitan, sin relación de "tipo de familia"
→ interfaz aparte, no meterlo en el padre.

## Uso de package en mini-proyectos

A diferencia de los ejercicios sueltos en 01_Aprendizaje (sin package),
un mini-sistema con su propia subcarpeta SÍ usa package consistente
en todos sus archivos — refleja mejor cómo se organiza un proyecto
real. VS Code lo agrega automáticamente al crear archivos dentro de
una subcarpeta (si da error de "expected package" y no se puede
resolver fácil, es válido dejar el archivo sin package también).
