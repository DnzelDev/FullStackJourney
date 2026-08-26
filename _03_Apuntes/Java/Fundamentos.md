## ¿Qué son los Fundamentos en programación?
Los bloques más básicos de cualquier lenguaje: cómo declarar datos
(variables), qué tipos de datos existen (números, texto, verdadero/
falso), y cómo convertir un tipo de dato en otro (casting). Es la
base sobre la que se construye todo lo demás.


## LocalDate vs Scanner para obtener el año actual

`LocalDate` es una clase de Java (paquete `java.time`) para trabajar con fechas.
A diferencia de `Scanner`, no depende de que el usuario escriba un dato:
`LocalDate.now()` obtiene la fecha directamente del sistema.

- `LocalDate.now()` → devuelve la fecha actual del sistema.
- `.getYear()` → extrae solo el año como int, a partir de un LocalDate.

Por qué no usar Scanner para esto: si le pides al usuario que escriba
el año actual manualmente, podría ingresar cualquier valor (un año
futuro, uno incorrecto, texto inválido). LocalDate.now() siempre es
confiable porque lo saca del reloj del sistema, no de una entrada humana.

Ejemplo:
import java.time.LocalDate;

LocalDate hoy = LocalDate.now();
int anioActual = hoy.getYear();


## Conversión implícita vs explícita (casting)

- int → double: conversión automática (widening). Un entero siempre
  cabe dentro de un double sin perder información (equivale a agregar
  decimales en cero), así que Java no exige casting.

- double → int: conversión explícita obligatoria (narrowing),
  usando (int). Trunca los decimales, no redondea.
  Ejemplo: 19.99 → 19 (no 20).

Java obliga al casting explícito solo cuando hay riesgo real de
perder datos — es su forma de forzarte a confirmar que sabes lo
que estás haciendo.

