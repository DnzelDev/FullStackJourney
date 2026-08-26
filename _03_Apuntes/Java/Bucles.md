## ¿Qué son los Bucles?
Estructuras que repiten un bloque de código varias veces, sin tener
que escribirlo manualmente cada vez. Se usan cuando se necesita
recorrer datos, repetir una acción un número determinado de veces,
o repetir algo hasta que se cumpla una condición.


## Operador módulo (%) para par/impar

numero % 2 == 0 → par (no sobra resto al dividir entre 2)
numero % 2 != 0 (o simplemente el "else") → impar, por descarte lógico

No hace falta verificar explícitamente el caso impar con una condición
propia — si ya se descartó que sea par, no hay otra opción con enteros.

## Orden de instrucciones dentro de un for

La posición de una línea dentro del bucle cambia el comportamiento:
- Antes del if → se ejecuta SIEMPRE en cada vuelta, sin condición.
- Dentro de una rama del if/else → se ejecuta SOLO si esa condición 
  se cumple, filtrando el resultado en vez de recorrer todo.

Ejemplo real: imprimir cada número del rango exige la instrucción
antes del if; si se pone dentro de una rama, solo se imprimirían
los pares o los impares, no el recorrido completo.