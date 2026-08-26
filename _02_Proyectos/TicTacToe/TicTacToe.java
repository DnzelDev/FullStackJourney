import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sw = new Scanner(System.in);
        char[][] tablero = new char[3][3];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
        System.out.println("\nBienvenidos a TicTacToe");
        imprimirTablero(tablero);
        boolean hayGanador = false;
        char turno = 'X';
        int cont = 0;
        do {
            int fila;
            int columna;
            do {
                do {
                    System.out.println("\n¿A qué fila desesas acceder? (0, 1 o 2)");
                    fila = sw.nextInt();
                } while (fila < 0 || fila > 2);
                do {
                    System.out.println("\n¿En qué columna desea jugar? (0, 1 o 2)");
                    columna = sw.nextInt();
                } while (columna < 0 || columna > 2);
            } while (tablero[fila][columna] != '-');

            tablero[fila][columna] = turno;

            imprimirTablero(tablero);

            for (int i = 0; i < 3; i++) {
                if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != '-') {
                    hayGanador = true;
                }
            }

            for (int j = 0; j < 3; j++) {
                if (tablero[j][0] == tablero[j][1] && tablero[j][1] == tablero[j][2] && tablero[j][0] != '-') {
                    hayGanador = true;
                }
            }

            if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != '-') {
                hayGanador = true;
            }

            if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != '-') {
                hayGanador = true;
            }
            if (!hayGanador) {
                if (turno == 'X') {
                    turno = 'O';
                } else {
                    turno = 'X';
                }
            }
            cont++;
        } while (!hayGanador && cont != 9);

        if (hayGanador) {
            System.out.println("El jugador <" + turno + "> ha ganado!!");
        } else {
            System.out.println("Empate. Buena suerta la próxima...");
        }
        sw.close();
    }

    public static void imprimirTablero(char tablero[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
}