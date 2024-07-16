package ejercicio2;


import java.util.*;

public class CapturaDatos {
    public static void main(String[] argumentos)
    {
        Scanner reader = new Scanner(System.in);
        String nombre= "";
        int edad;

        //System.out.print("practica 1 de POO404");
        System.out.println("Bienvenido a IntelliJ IDEA IDE");
        System.out.println("Ingrese su nombre: ");
        nombre= reader.nextLine();
        System.out.print("ingrese su edad");
        edad=reader.nextInt();
        System.out.println("usted se llama "+nombre+" y tiene "+edad+"años");

}
}