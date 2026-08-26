## ¿Qué son los Métodos?
Bloques de código reutilizables que agrupan una tarea específica
bajo un nombre. Permiten evitar repetir el mismo código varias veces,
y pueden recibir datos (parámetros) y devolver un resultado (return).


## Clase vs Método

- Clase: el contenedor completo (ej. "public class Calculadora").
  Un archivo .java normalmente tiene una clase pública.
- Método: una acción específica dentro de la clase (ej. "sumar",
  "dividir"). Un método NUNCA existe fuera de una clase.
  Una clase puede tener muchos métodos adentro.

## Un método puede llamar a otro método

Ejemplo: desde main() se puede llamar a esDivisionValida(), y
según su resultado (true/false), decidir si llamar o no a dividir().

## Orden de ejecución importa (prevención vs reacción)

Error típico: ejecutar la operación riesgosa (ej. dividir) ANTES
de validar, y solo revisar el resultado después. Eso ya causó el
problema si iba a ocurrir.
Correcto: validar PRIMERO (if esDivisionValida), y solo si pasa
la validación, ejecutar la operación riesgosa dentro de ese bloque.