import java.util.*;
public class EjemploList{
    public static void main(String[] args) {
        ArrayList <String> listaPersona = new ArrayList();
//Agregando elementos
        listaPersona.add("Marie Curie");
        listaPersona.add("Benjamin Franklin");
        listaPersona.add("Marco Antonio");
        listaPersona.add(1, "Juan Murillo");
//Mostrar contenido de ArrayList
        System.out.println("USO DE ARRAYLIST");
        System.out.println("Contenido de listaPersona: " + listaPersona + "\n");
//Obteniendo posición de un elemento
        int pos = listaPersona.indexOf("Benjamin Franklin");
        System.out.println("El indice de Benjamin Franklin es: " + pos);
//Verificando si lista está vacía
        boolean check = listaPersona.isEmpty();
        System.out.println("Verificando si ArrayList está vacío: " + check);
//Obteniendo tamaño de lista
        int size = listaPersona.size();
        System.out.println("El tamaño de listaPersona es: " + size);
//Verificando si un elemento está incluido en la lista
        boolean elemento = listaPersona.contains("Marco Antonio");
        System.out.println("Verificando si 'Marco Antonio' está incluido en listaPersona: " +
                elemento);
//Obteniendo elemento de una posición específica
        String item = listaPersona.get(0);
        System.out.println("El elemento con indice 0 es: " + item);
//Recuperando elementos del ArrayList
//Primera forma: Usando lazo for
        System.out.println("\nRecuperando elementos del ArrayList con FOR");
        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("Indice: " + i + " - Elemento: " +
                    listaPersona.get(i));
        }
//Segunda forma: Usando lazo foreach
        System.out.println("\nRecuperando elementos del ArrayList con FOREACH");
        for (String persona : listaPersona) {
            System.out.println("Elemento: " + persona);
        }
//Tercera forma: Usando Iterator
//hasNext(): devuelve true si hay mas elementos
//next(): devuelve el siguiente elemento
        System.out.println("\nRecuperando elementos del ArrayList con ITERATOR");
        for (Iterator<String> it = listaPersona.iterator(); it.hasNext();)
        {
            System.out.println("Elemento: " + it.next());
        }
//Reemplazando un elemento
        listaPersona.set(1, "Nikola Tesla");
        System.out.println("\nArrayList después de reemplazo: " + listaPersona);
//Eliminando elemento en posicion 0
        listaPersona.remove(0);
        System.out.println("\nArrayList después de eliminar elemento 0: " + listaPersona);
//Convirtiendo ArrayList en Array
        String[] simpleArray = listaPersona.toArray(new String[listaPersona.size()]);
        System.out.println("\nEl objeto Array creado es: " + Arrays.toString(simpleArray));
    }
}