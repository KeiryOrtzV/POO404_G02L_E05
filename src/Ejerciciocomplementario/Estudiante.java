package Ejerciciocomplementario;
import javax.swing.JOptionPane;
public class Estudiante {
    private String nombre;
    private int edad;
    private String carrera;
    private String[] materias;
    public Estudiante(String nombre, int edad, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.materias = new String[5];
    }
    public void ingresarMaterias() {
        for (int i = 0; i < 5; i++) {
            materias[i] = JOptionPane.showInputDialog("Ingrese la materia " + (i + 1) + ":");
        }
    }
    public void mostrarInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Nombre: ").append(nombre).append("\n");
        info.append("Edad: ").append(edad).append("\n");
        info.append("Carrera: ").append(carrera).append("\n");
        info.append("Materias: ");
        for (String materia : materias) {
            info.append(materia).append(" ");
        }
        JOptionPane.showMessageDialog(null, info.toString());
    }public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante:"));
        String carrera = JOptionPane.showInputDialog("Ingrese la carrera del estudiante:");
        Estudiante estudiante = new Estudiante(nombre, edad, carrera);
        estudiante.ingresarMaterias();
        estudiante.mostrarInformacion();
    }
}
