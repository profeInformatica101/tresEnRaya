package com;

import java.util.Scanner;

public class TresEnRaya {

    private static char[][] tablero = new char[3][3];

    public static final char JUGADOR1 = 'O';
    public static final char JUGADOR2 = 'X';
    public static final char VACIO = '_';
    public static char turno = JUGADOR1;

    public static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("############################");
        System.out.println("#       MENÚ               #");
        System.out.println("############################");
        System.out.println("# 1) Jugar                 #");
        System.out.println("# 2) Mostrar Instrucciones #");
        System.out.println("# 3) Salir                 #");
        System.out.println("############################");
    }

    public static void mostrarInstrucciones() {
        System.out.println("INSTRUCCIONES:");
        System.out.println("- El jugador O empieza.");
        System.out.println("- Introduce fila y columna entre 0 y 2.");
        System.out.println("- Gana quien consigue 3 en raya.");
        System.out.println();
        System.out.println("Pulsa ENTER para volver al menú...");
        sc.nextLine(); // por si queda un salto pendiente
        sc.nextLine();
    }

    public static void jugar() {
        inicializarTablero();
        turno = JUGADOR1;

        while (true) {
            System.out.println("Turno de: " + turno);
            mostrarTablero();

            if (tableroLleno()) {
                System.out.println("Empate. No hay más movimientos posibles.");
                break;
            }

            pedirMovimiento();
            
            if (hayGanador()) {
                System.out.println("¡Ha ganado " + turno + "!");
                break;
            }
            
            cambiarTurno();
        }

        System.out.println("Pulsa ENTER para volver al menú...");
        sc.nextLine(); // limpiar buffer
        sc.nextLine();
    }

    public static void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    public static void mostrarTablero() {
        System.out.println("  0 1 2");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void pedirMovimiento() {
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce fila (0-2): ");
                int fila = sc.nextInt();
                System.out.print("Introduce columna (0-2): ");
                int col = sc.nextInt();

                if (fila < 0 || fila > 2 || col < 0 || col > 2) {
                    System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
                } else if (tablero[fila][col] != VACIO) {
                    System.out.println("Esa casilla ya está ocupada. Intenta de nuevo.");
                } else {
                    tablero[fila][col] = turno;
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Usa números 0, 1 o 2.");
                sc.nextLine(); // limpiar entrada incorrecta
            }
        }
    }

    public static void cambiarTurno() {
        turno = (turno == JUGADOR1) ? JUGADOR2 : JUGADOR1;
    }

    public static boolean hayGanador() {
        // Comprobamos siempre en función del símbolo que haya en el tablero,
        // no de la variable turno, para evitar líos al alternar.

        // Filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != VACIO &&
                tablero[i][0] == tablero[i][1] &&
                tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }

        // Columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != VACIO &&
                tablero[0][j] == tablero[1][j] &&
                tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }

        // Diagonal principal
        if (tablero[0][0] != VACIO &&
            tablero[0][0] == tablero[1][1] &&
            tablero[1][1] == tablero[2][2]) {
            return true;
        }

        // Diagonal secundaria
        if (tablero[0][2] != VACIO &&
            tablero[0][2] == tablero[1][1] &&
            tablero[1][1] == tablero[2][0]) {
            return true;
        }

        return false;
    }

    public static boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == VACIO) return false;
            }
        }
        return true;
    }

   
}
