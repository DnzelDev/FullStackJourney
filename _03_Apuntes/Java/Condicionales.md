## ¿Qué son los Condicionales?
Estructuras que permiten que el programa tome decisiones y ejecute
distintos bloques de código según si una condición es verdadera o
falsa (if/else) o según un valor específico (switch). Sin
condicionales, un programa siempre haría exactamente lo mismo sin
importar los datos que reciba.


## if/else if encadenado vs if anidado

- Cadena if/else if: bloques al mismo nivel. Cada condición se evalúa
  solo si la anterior fue falsa. Sirve para descartar rangos progresivamente
  sin necesidad de anidar.
- If anidado: un if dentro de otro. El interno solo se evalúa si el
  externo fue verdadero (ambas condiciones deben cumplirse).

## Error típico: límites de rango mal cerrados

Al encadenar else if para rangos, cuidado con la última condición.
Si ya se descartaron todos los rangos anteriores, usar "else" simple
(sin condición) es más seguro que repetir una comparación que podría
excluir casos por error de signo (ej. usar <= en vez de > por descuido).