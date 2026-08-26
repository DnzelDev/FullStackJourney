## Qué es un array

Estructura que guarda varios valores del MISMO tipo, con tamaño FIJO
definido al crearlo (no crece ni se achica después).

Declaración: tipo[] nombre = new tipo[tamaño];
Ejemplo: int[] edades = new int[5];  // 5 espacios vacíos

## Índices empiezan en 0

Un array de tamaño N tiene índices válidos de 0 a N-1.
Ejemplo: int[4] → índices válidos: 0, 1, 2, 3 (NUNCA existe el 4).

Acceder/asignar: nombre[indice] = valor;
Leer: nombre[indice]

## Valores por defecto al crear el array vacío

- int, double → 0
- boolean → false
- String / objetos → null (no hay nada, ni texto vacío)

## Error típico: ArrayIndexOutOfBoundsException

Ocurre al intentar acceder a un índice que no existe
(ej. numeros[4] en un array de tamaño 4). Es el error más común
al trabajar con arrays — cuidado con el "menos 1".

## Recorrer un array con .length (no un número fijo)

for(int i = 0; i < array.length; i++) { ... }

Usar .length en vez de escribir el tamaño a mano hace que el código
funcione sin importar cuántos elementos tenga el array. Con <= en vez
de < se produciría ArrayIndexOutOfBoundsException en la última vuelta.

Nota: en arrays, length es una PROPIEDAD (sin paréntesis).
En Strings, length() es un MÉTODO (con paréntesis). No confundir.

## Rellenar un array con Scanner + for

for(int i = 0; i < array.length; i++) {
    array[i] = sw.nextInt();
}
Cada vuelta usa un i distinto automáticamente, así una sola línea
llena todas las posiciones (a diferencia de repetir Scanner a mano
para cada índice).

## Acumular sobre un array (suma, promedio)

int suma = 0;
for(int i = 0; i < array.length; i++) { suma += array[i]; }

Para promedio con decimales: castear ANTES de dividir.
double promedio = (double) suma / array.length;   // correcto
double promedio = (double) (suma / array.length); // INCORRECTO,
   trunca primero como int y recién después convierte (pierde decimales)
   

## Buscar máximo o mínimo en un array

Estrategia: arrancar el candidato con el PRIMER valor real del array
(array[0]), nunca con un número inventado (como 0), porque si todos
los valores son negativos, un candidato inventado en 0 "ganaría" sin
ser un dato real.

int max = array[0];
for (int i = 1; i < array.length; i++) {   // arranca en 1, no en 0
    if (array[i] > max) { max = array[i]; }
}

Para mínimo: misma lógica pero con < en vez de >.
Se puede buscar máximo Y mínimo en el MISMO for (una sola pasada),
en vez de recorrer el array dos veces por separado.


## Arrays de double

Misma sintaxis que arrays de int, cambiando el tipo:
double[] numeros = new double[4];

Para leer con Scanner: sw.nextDouble() (equivalente a nextInt()
pero para decimales).

## El índice de un array SIEMPRE es int

Sin excepción. No importa si el array es de int, double, String, etc.
— la posición dentro del array siempre se cuenta con enteros
(0, 1, 2, 3...), porque no existen "posiciones intermedias".

Error común: declarar "for (double i = 0; ...)" pensando que el tipo
del índice debe coincidir con el tipo del array. Son cosas
independientes: tipo del CONTENIDO ≠ tipo del ÍNDICE.

## Nombre del índice (i)

"i" no es palabra reservada, es solo convención (viene de notación
matemática de sumatorias). Se puede usar cualquier nombre, pero se
recomienda mantener "i" por legibilidad y porque todo el mundo lo
espera así. En bucles anidados: "i" para el externo, "j" para el
interno (para no chocar nombres).


## Matrices (arrays de 2 dimensiones)

Declaración: tipo[][] nombre = new tipo[filas][columnas];
Ejemplo: int[][] matriz = new int[2][3]; // 2 filas, 3 columnas

Una matriz es un array de arrays: cada fila (matriz[i]) es en sí
misma un array independiente.

- matriz.length       → número de FILAS
- matriz[i].length    → número de COLUMNAS de la fila i específica

Acceso a una celda: matriz[fila][columna]
Ejemplo: matriz[0][0] = 10;  // primera fila, primera columna

## Recorrer una matriz: dos for anidados

for (int i = 0; i < matriz.length; i++) {         // recorre filas
    for (int j = 0; j < matriz[i].length; j++) {  // recorre columnas
        // usar matriz[i][j]
    }
}

El for externo (i) controla la fila; el for interno (j) recorre
TODAS las columnas de esa fila antes de que i avance a la siguiente.
Convención de nombres: i para el bucle externo, j para el interno.


## Error típico: =+ vs +=

suma =+ numeros[i][j];   // INCORRECTO: esto es "asignar" seguido de
                          // "más unario", equivale a suma = numeros[i][j]
                          // (sobrescribe, no acumula)

suma += numeros[i][j];   // CORRECTO: operador de acumulación,
                          // equivale a suma = suma + numeros[i][j]

Son visualmente parecidos pero hacen cosas completamente distintas.
Revisar con cuidado el orden de los caracteres al escribir += .


## Sumar por fila vs sumar por columna (índices invertidos)

Ambas tareas usan dos for anidados, pero con los roles de i y j
intercambiados según qué se quiere recorrer:

Sumar POR FILA (i afuera, j adentro):
for (int i = 0; i < numeros.length; i++) {
    int sumaFila = 0;                    // se reinicia por cada fila
    for (int j = 0; j < numeros[i].length; j++) {
        sumaFila += numeros[i][j];
    }
    // imprimir sumaFila aquí, antes de que i avance
}

Sumar POR COLUMNA (j afuera, i adentro — orden invertido):
for (int j = 0; j < numeros[0].length; j++) {
    int sumaColumna = 0;                 // se reinicia por cada columna
    for (int i = 0; i < numeros.length; i++) {
        sumaColumna += numeros[i][j];
    }
    // imprimir sumaColumna aquí, antes de que j avance
}

Idea clave: "i" y "j" no tienen un orden fijo obligatorio — el
bucle EXTERNO es "la unidad grande que proceso una por una"
(fila o columna, según el caso), y el INTERNO recorre dentro de
esa unidad. Se elige según qué dimensión se quiere aislar.

Nota: en el for de columnas se usa numeros[0].length (cantidad de
columnas), no numeros.length (que da cantidad de FILAS) — habría
sido un error usar el segundo ahí.


## Cosas importantes a tener en el radar (no urgente, pero bueno saberlo)

- Arrays de String/objetos: el valor por defecto es null (no "").
  Usar un método sobre una posición null (ej. texto[0].length())
  causa NullPointerException.

- Los arrays son de tamaño FIJO para siempre. No se puede "agregar"
  un elemento más después de crearlo — hay que crear uno nuevo y
  copiar los datos. Este límite es la razón por la que existe
  ArrayList (se ve en POO/Colecciones).

- Al pasar un array como parámetro a un método, se pasa por
  REFERENCIA: si el método modifica el array adentro, el cambio
  afecta al array original (distinto a int/double/boolean, que se
  copian y no se ven afectados fuera del método). Relevante cuando
  empecemos a combinar Arrays con Métodos.

- Existe el for-each (for (int numero : numeros) {...}) para
  recorrer un array sin usar índice ni .length — más simple, pero
  solo sirve para LEER, no para modificar ni saber la posición.