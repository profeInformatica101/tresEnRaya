package com;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		int opcion;
		do {
			TresEnRaya.mostrarMenu();
			System.out.println("Elige una opción: ");
			
			opcion = TresEnRaya.sc.nextInt();
			switch (opcion) {
			case 1 -> TresEnRaya.jugar();
			case 2 -> TresEnRaya.mostrarInstrucciones();
			case 3 -> System.out.println("Saliendo del juego...");
			default->{
				System.out.println("Opción no válida");
				System.out.println("Pulsa ENTER para continuar...");
				TresEnRaya.sc.nextLine();
				TresEnRaya.sc.nextLine();
				}
			}
			
			
		}while(opcion!=3);
		
	}
}
