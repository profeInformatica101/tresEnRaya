package com;

import java.util.Scanner;

public class Main {
	 
	
	  
    public static void main(String[] args) {
    	
        int opcion;
        do {
            TresEnRaya.mostrarMenu();
            System.out.print("Elige una opción: ");
            while (!TresEnRaya.sc.hasNextInt()) {
                System.out.println("Introduce un número válido (1-3).");
                TresEnRaya.sc.next();
            }
            opcion = TresEnRaya.sc.nextInt();

            switch (opcion) {
                case 1 ->  TresEnRaya.jugar();
                case 2 ->  TresEnRaya.mostrarInstrucciones();
                case 3 -> System.out.println("Saliendo del juego...");
                default -> {
                    System.out.println("Opción no válida.");
                    System.out.println("Pulsa ENTER para continuar...");
                    sc.nextLine();
                    sc.nextLine();
                }
            }
        } while (opcion != 3);
    }

}
