package Guia3;

class Clase {
    static int contador;
    Clase() { //Constructor
        contador++;
    }
    int getContador() { //Obtenemos el valor de contador
        return contador;
    }
}
public class Codigo {
    public static void main(String[] args) {
        Clase uno = new Clase();
        Clase dos = new Clase();
        Clase tres = new Clase();
        Clase cuatro = new Clase();
        System.out.println("Hemos declarado " + dos.getContador() + " objetos.");
    }
}
