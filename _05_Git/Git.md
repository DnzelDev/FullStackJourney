## ¿Qué es Git?

## Definición
Git es un sistema de control de versiones: un programa que guarda un
historial de todos los cambios hechos a tu código a lo largo del
tiempo, permitiéndote "retroceder" o ver qué cambió y cuándo. Corre
en tu computadora, de forma local.

## ¿Qué es GitHub?
Una plataforma web donde se aloja una copia de tu repositorio Git en
la nube — permite tener respaldo, mostrar tu código a otros (portafolio),
y en el futuro colaborar con otras personas en el mismo proyecto.

## Analogía
Git es como el historial de versiones de un documento (guarda cada
"punto en el tiempo" de tu código). GitHub es como Google Drive: el
lugar en internet donde esa carpeta con historial vive respaldada y
accesible desde cualquier lado.

---

## Flujo práctico usado (VS Code — Source Control)

## Definición
El ciclo de trabajo estándar para guardar avances y subirlos a GitHub,
repetido cada vez que se termina un proyecto o avance importante.

## Pasos
1. Abrir el panel de Source Control en VS Code (ícono de rama en la
   barra lateral izquierda).
2. Escribir un mensaje corto describiendo qué se hizo (ej. "Tic-Tac-Toe
   completo") en la cajita de arriba.
3. Dar clic al ✓ (Commit) — guarda ese "punto en el tiempo" en tu
   computadora (todavía NO está en GitHub).
4. Dar clic a "Sync Changes" o "Push" — recién ahí sube el cambio a
   GitHub.

---

## Comandos equivalentes por terminal

## Definición
Los mismos 4 pasos de arriba, pero escritos como comandos en vez de
usar los botones de VS Code. Hacen exactamente lo mismo por debajo.

## Sintaxis

git init                    // inicializa un repositorio nuevo en la
                             // carpeta actual (solo se hace UNA vez
                             // por proyecto)

git add .                   // prepara TODOS los archivos modificados
                             // para el próximo commit

git commit -m "mensaje"     // guarda el punto en el tiempo, con un
                             // mensaje describiendo el cambio

git push                    // sube los commits guardados hacia GitHub

## Ejemplo aplicado
git add .
git commit -m "Proyecto Validador de contraseñas completo"
git push

---

## Conectar un repo local con GitHub (primera vez)

## Cuándo se usa
Solo la primera vez que se crea un repositorio nuevo y se quiere
enlazar con GitHub — pasos posteriores ya no lo necesitan.

## Sintaxis
git remote add origin https://github.com/usuario/NombreRepo.git
git push -u origin main

Nota: en VS Code, esto se resuelve automáticamente al usar el botón
"Publish to GitHub" — no hace falta escribirlo a mano si se usa la
interfaz visual.

---

## Mini-glosario

- **Repositorio (repo):** una carpeta de proyecto bajo control de Git
  (tiene una carpeta oculta ".git" adentro).
- **Commit:** un "punto guardado" del código, con un mensaje que
  describe qué cambió. Se queda guardado en la computadora local.
- **Push:** subir los commits guardados localmente hacia GitHub.
- **Pull:** el proceso contrario — traer cambios desde GitHub hacia
  la computadora local (útil cuando se trabaja desde dos
  computadoras distintas, o en equipo).
- **Clone:** descargar una copia completa de un repositorio que ya
  existe en GitHub, hacia la computadora local.

---

## Pendiente para una sesión futura (no bloqueante ahora)

Temas de Git que aún no se han tocado — no son necesarios mientras
se trabaje solo, en un único repositorio, sin colaborar con nadie más:

- **Branches (ramas):** trabajar en una versión paralela del código
  sin afectar la versión principal, útil para probar cosas sin
  arriesgar lo que ya funciona.
- **Merge:** unir los cambios de una rama con otra.
- **Resolver conflictos:** cuando dos cambios chocan entre sí al
  intentar unirlos.

## Nota sobre repos independientes

Cada carpeta de proyecto separada (ej. FullStackJourney,
ExercismPractice) tiene su PROPIO repositorio Git independiente —
correr "git init" dentro de una no afecta a la otra. Si se corre
"git init" por accidente en un lugar no deseado, se puede deshacer
borrando solo la carpeta oculta ".git" de esa ubicación (sin borrar
el código, solo el registro de Git).