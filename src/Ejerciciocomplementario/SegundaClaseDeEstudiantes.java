package Ejerciciocomplementario;
import javax.swing.JOptionPane;
public class SegundaClaseDeEstudiantes {
    private Estudiante estudiante;

    public void crearEstudiante(String nombre, int edad, String carrera) {
        estudiante = new Estudiante(nombre, edad, carrera);}
    public void ingresarMateriasEstudiante() {
        if (estudiante != null) {
            estudiante.ingresarMaterias();
        } else {
            JOptionPane.showMessageDialog(null, "Debes crear un estudiante primero.");
        }}
    public void mostrarInformacionEstudiante() {
        if (estudiante != null) {
            estudiante.mostrarInformacion();
        } else {
            JOptionPane.showMessageDialog(null, "Debes crear un estudiante primero.");
        }
    }
    public static void main(String[] args) {
        SegundaClaseDeEstudiantes gestor = new SegundaClaseDeEstudiantes();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante:"));
        String carrera = JOptionPane.showInputDialog("Ingrese la carrera del estudiante:");
        gestor.crearEstudiante(nombre, edad, carrera);
        gestor.ingresarMateriasEstudiante();
        gestor.mostrarInformacionEstudiante();
    }
}
