package Guia3;
import java.util.ArrayList;
import java.util.Scanner;
public class Ejercicio1 {
}
class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;
    private String grado;
    private ArrayList<String> materias;

    public Estudiante(String nombre, String apellido, int edad, String grado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.grado = grado;
        this.materias = new ArrayList<>();
    }

    public void ingresarMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

    public String obtenerInformacion() {
        String materiasStr = String.join(", ", materias);
        return "Nombre: " + nombre + " " + apellido + "\nEdad: " + edad + "\nGrado: " + grado + "\nMaterias: " + materiasStr;
    }
}

