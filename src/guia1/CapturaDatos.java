package ejercicio2;
import java.util.*;

public class CapturaDatos {
    public static void main(String[] argumentos) {
        Scanner reader = new Scanner(System.in);
        String nombre = "";
        int edad;

        System.out.println("Bienvenido a IntelliJ IDEA IDE");
        System.out.print("Ingrese su nombre: ");
        nombre = reader.nextLine();
        System.out.print("Ingrese su edad: ");
        edad = reader.nextInt();
        System.out.println("Usted se llama " + nombre + "y tiene" + edad + "anaos");
    }
}


