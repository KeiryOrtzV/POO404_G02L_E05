package Guia2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class UtilesEscolares {
    public static void main(String[] args) {
//Declarando HashMap
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
//Agregando elementos
hmap.put(12, "Crayolas");
hmap.put(2, "Lápices");
hmap.put(7, "Borradores");
hmap.put(49, "Colores");
hmap.put(3, "Boligrafos");
////Mostrando contenido usando Iterator
System.out.println("Contenido de HashMap:");
Set set = hmap.entrySet();
Iterator iterador = set.iterator();
while(iterador.hasNext()) {
Map.Entry mentry = (Map.Entry)iterador.next();
System.out.println("Clave: " + mentry.getKey() + " - Valor: " + mentry.getValue());
}
////Obtener valor en base a clave
String var= hmap.get(2);
System.out.println("\nValor asociado a clave 2: " + var);
////Remover elementos en base a clave
hmap.remove(3);
System.out.println("\nHashMap después de eliminar elemento con clave 3:");
Set set2 = hmap.entrySet();
Iterator iterador2 = set2.iterator();
while(iterador2.hasNext()) {
Map.Entry mentry2 = (Map.Entry)iterador2.next();
System.out.println("Clave: " + mentry2.getKey() + " - Valor: " + mentry2.getValue());
} }}