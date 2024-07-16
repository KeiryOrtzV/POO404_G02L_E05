package usoparametros;

public class LecturaParametros {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Debe proporcionar al menos dos parámetros.");
            return; 
        }

        System.out.println("Parametro 1: " + args[0]);
        System.out.println("Parametro 2: " + args[1]);
    }
}
