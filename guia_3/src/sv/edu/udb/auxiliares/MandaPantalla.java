package sv.edu.udb.auxiliares;

import sv.edu.udb.escritura.*; //Importamos la clase Pantalla
public class MandaPantalla {
    public static void main(String args[]) {
        Pantalla primera = new Pantalla();
        primera.conSalto("Esto es un renglon CON salto de linea");
        primera.conSalto("Esta línea tambien tiene salto");
        primera.sinSalto("Linea Continua");
        primera.sinSalto("Linea Continua");
        primera.conSalto("Esta linea si tiene salto!");
        primera.sinSalto("Termina sin salto");
        System.out.println(" Se termina el uso de funciones");
    }
}