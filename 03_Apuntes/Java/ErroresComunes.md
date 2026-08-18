# Errores comunes — Java

## ArrayIndexOutOfBoundsException
Ocurre al acceder a un índice que no existe en un array.
Ejemplo: array de tamaño 4 → índices válidos son 0,1,2,3.
array[4] ya está fuera de rango.
Causa típica: usar <= en vez de < en la condición del for
(ej. for(i=0; i<=array.length; i++) es incorrecto).

## Identificadores no pueden empezar con número
Java no permite nombres de clase/variable que empiecen con dígito.
Incorrecto: 01_DatosPersonales
Correcto: DatosPersonales01
(el número puede ir, pero nunca al inicio)

## =+ vs += (operador de acumulación)
suma =+ valor;   // INCORRECTO: equivale a suma = valor (sobrescribe)
suma += valor;   // CORRECTO: equivale a suma = suma + valor (acumula)
Son visualmente parecidos, revisar con cuidado el orden de caracteres.

## Casting: orden de paréntesis importa
(double) suma / cantidad;     // CORRECTO: castea antes de dividir
(double) (suma / cantidad);   // INCORRECTO: divide como int primero
                                // (trunca), y recién después convierte
                                // el resultado ya truncado a double.

## length vs length() — arrays vs Strings
array.length      // arrays: PROPIEDAD, sin paréntesis
texto.length()    // Strings: MÉTODO, con paréntesis
Confundir uno con el otro da error de compilación.

## El índice de un array siempre es int
No importa si el array es de int, double, String, etc. — el índice
que recorre posiciones (i) siempre se declara como int. El tipo del
contenido del array y el tipo del índice son cosas independientes.

## for(double i = 0; ...) para recorrer arrays — INCORRECTO
El contador de un for que recorre por índice siempre debe ser int,
sin importar el tipo de dato que guarde el array.