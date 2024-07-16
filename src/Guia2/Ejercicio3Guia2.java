package Guia2;

import java.util.Scanner;

public class Ejercicio3Guia2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();

        int[] sueldos = new int[numEmpleados];

        for (int i = 0; i < numEmpleados; i++) {
            int sueldo;
            do {
                System.out.print("Ingrese el sueldo del empleado " + (i + 1) + ": ");
                sueldo = scanner.nextInt();
                if (sueldo < 0) {
                    System.out.println("Error: No se permiten sueldos negativos. Intente de nuevo.");
                }
            } while (sueldo < 0);

            sueldos[i] = sueldo;
        }

        int suma = 0;
        for (int sueldo : sueldos) {
            suma += sueldo;
        }

        System.out.println("Total de sueldos: " + suma);

        scanner.close();
    }
}