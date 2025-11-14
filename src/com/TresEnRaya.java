package com;

import java.util.Scanner;

public class TresEnRaya {
	// Tablero de Jueg
	private static char[][] tablero = new char[3][3];
	
	
	//Posibilidades
	private static final char JUGADOR_1 = '☔';
	private static final char JUGADOR_2 = '✋';
	private static final char VACIO = '#';
	
	//Gestión de los turnos
	public static char turno = JUGADOR_1;

	public static Scanner sc = new Scanner(System.in);
	
	public static void mostrarMenu() {
			System.out.println("##################################");
			System.out.println("#          MENÚ                  #");
			System.out.println("##################################");
			System.out.println("# 1) Jugar                       #");
			System.out.println("# 2) Mostrar instrucciones       #");
			System.out.println("# 3) Salir                       #");
			System.out.println("##################################");
	}
	public static void mostrarInstrucciones() {
		System.out.println("INSTRUCIONES:");
		System.out.println("- El jugador O empieza.");
		System.out.println("- Introduce fila y columna entre 0 y 2");
		System.out.println("- Gana quién consigue 3 en raya");
		System.out.println();
		System.out.println("Pulsa ENTER	 para volver al menú");
		sc.nextLine(); //
		sc.nextLine();
	}
	public static void jugar() {
		inicializarTablero();
		turno = JUGADOR_1;
		
		
		while(true) {
			System.out.println("Turno de : "+ turno);
			mostrarTablero();
			
			if(tableroLleno()) {
				System.out.println("Empate. No hay más movimientos");
				break;
			}
			
			pedirMovimiento();
			if(hayGanador()) {
				System.out.println("¡Hay ganado " +  turno);
				break;
			}
			
			
			cambiarTurnos();
		}
		
	}
	
	private static boolean tableroLleno() {
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length; j++ ) {
				if(tablero[i][j] == VACIO) {
					return false;
				}
			}
		}
		return true;
		
	}
	public static void inicializarTablero() {
		for(int i=0; i<tablero.length; i++) {
			for(int j=0; j<tablero[i].length;j++) {
				tablero[i][j]=VACIO;
			}
		}
	}
	public static void mostrarTablero() {
		//System.out.println(Arrays.deepToString(tablero));
		System.out.println("0\t1\t2");
		for(int i=0; i<tablero.length;i++) {
			System.out.print(i + " " );
			for(int j=0; j<tablero[i].length; j++) {
				System.out.print(tablero[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	/***
	 * 
	 */
	 public static void pedirMovimiento() {
		 boolean valido = false;
		 
		 while(!valido) {
			 try {
			 System.out.println("Introduce fila (0-2)");
			 int fila = sc.nextInt();
			 
			 System.out.println("Introduce columna (0-2)");
			 int columna = sc.nextInt();
			 
			 if(fila < 0 || fila>2 || columna<0 || columna>2) {
				 System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
			 }else if(tablero[fila][columna] != VACIO) {
				 System.out.println("Esa casilla ya esta ocupada. Intentalo de nuevo");
			 }else {
				 tablero[fila][columna] = turno;
				 valido = true;
			 }
			 }catch(Exception ex) {
				 System.out.println("Entrada no válida");
				 sc.nextLine();
			 }
		 }
		 
		 
		 
		 
	 }
	 public static void tableroPruebaNoGanador() {
		 tablero[0][0] = JUGADOR_1;
		 tablero[0][1] = VACIO;
		 tablero[0][2] = JUGADOR_1;
		 tablero[1][0] = JUGADOR_2;
		 tablero[1][1] = JUGADOR_2;
		 tablero[1][2] = VACIO;
		 tablero[2][0] = VACIO;
		 tablero[2][1] = VACIO;
		 tablero[2][2] = VACIO;
	 }
	 public static void tableroPruebaGanadorJugador1() {
		 tablero[0][0] = JUGADOR_1;
		 tablero[0][1] = JUGADOR_1;
		 tablero[0][2] = JUGADOR_1;
		 tablero[1][0] = JUGADOR_2;
		 tablero[1][1] = JUGADOR_2;
		 tablero[1][2] = VACIO;
		 tablero[2][0] = VACIO;
		 tablero[2][1] = VACIO;
		 tablero[2][2] = VACIO;
	 }
	 public static void cambiarTurnos() {
		 turno = (turno == JUGADOR_1) ? JUGADOR_2 : JUGADOR_1;
	 }
	 public static boolean hayGanador() { 
	 
		 // filas
		 for(int i=0; i<tablero.length; i++) {
			 if(tablero[i][0] != VACIO 
					 && tablero[i][0] == tablero[i][1] 
					 && tablero[i][1] == tablero[i][2])
				 return true;
		 }
		 //Columnas
		 for(int j=0; j<3; j++) {
			 if(tablero[0][j] != VACIO
					&& tablero[0][j] == tablero[1][j]
					&& tablero[1][j] == tablero[2][j])
				 return true;
		 }	 
		//Diagonales
			 if(tablero[0][0] != VACIO
				 && tablero[0][0] == tablero[1][1] 
			     && tablero[1][1] == tablero[2][2]) 
				 return true;
			 
			 if(tablero[0][2] != VACIO
				 && tablero[1][1] == tablero[0][2]	
				 && tablero[2][0] == tablero[1][1]	 )
				 return true;
		
				 
			return false;	 
		 }
		 
	 }

