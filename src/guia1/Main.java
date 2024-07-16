package Guia3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresar el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresar el apellido del estudiante: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingresar la edad del estudiante: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingresar el grado del estudiante: ");
        String grado = scanner.nextLine();

        ArrayList<String> materias = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingresar el nombre de la materia " + (i + 1) + ": ");
            materias.add(scanner.nextLine());
        }

        Estudiante estudiante = new Estudiante(nombre, apellido, edad, grado);
        estudiante.ingresarMaterias(materias);

        System.out.println("\nInformación sobre el estudiante dada:\n" + estudiante.obtenerInformacion());

    }
}
