package Guia3;

public class Arboles {
    //Constructor sin parametros
    public Arboles() {
        System.out.println("Un árbol genérico");
    }
    //Constructors con un parámetro string
    public Arboles(String tipo) {
        System.out.println("Un árbol tipo " + tipo);
    }
    //Constructor con un parámetro int
    public Arboles(int altura) {
        System.out.println("Un árbol de " + altura + " metros");
    }
    //Constructor con dos parametros uno int y el otro string
    public Arboles(int altura,String tipo) {
        System.out.println("Un " + tipo + " de " + altura + " metros");
    }
    public static void main(String args[]) {
        Arboles arbol1 = new Arboles(4);//Objeto1
        Arboles arbol2 = new Arboles("Roble");//Objeto2
        Arboles arbol3 = new Arboles();//Objeto3
        Arboles arbol4 = new Arboles(5,"Pino");//Ojeto4
    }
}
