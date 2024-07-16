package Guia2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Ejercicio4Guia2Va230394 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> alumnos = new HashMap<>();
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ingreso de estudiante");
            System.out.println("2. Ver estudiante");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    ingresarEstudiante(alumnos, scanner);
                    break;
                case 2:
                    verEstudiantes(alumnos);
                    break;
                case 3:
                    buscarEstudiante(alumnos, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
        scanner.close();
    }



    private static void ingresarEstudiante(Map<String, String> alumnos, Scanner scanner) {
        System.out.print("Ingrese el carnet del estudiante: ");
        String carnet = scanner.nextLine();
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        alumnos.put(carnet, nombre);
        System.out.println("Estudiante ingresado correctamente.");
    }


    private static void verEstudiantes(Map<String, String> alumnos) {
        System.out.println("\nLista de estudiantes:");
        for (Map.Entry<String, String> entry : alumnos.entrySet()) {
            System.out.println("Carnet: " + entry.getKey() + ", Nombre: " + entry.getValue());
        }
    }




    private static void buscarEstudiante(Map<String, String> alumnos, Scanner scanner) {
        System.out.print("Ingrese el carnet del estudiante a buscar: ");
        String carnet = scanner.nextLine();
        if (alumnos.containsKey(carnet)) {
            String nombre = alumnos.get(carnet);
            System.out.println("Estudiante encontrado:");
            System.out.println("Carnet: " + carnet + ", Nombre: " + nombre);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}