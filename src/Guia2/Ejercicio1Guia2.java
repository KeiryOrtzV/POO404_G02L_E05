package Guia2;
import javax.swing.JOptionPane;
public class Ejercicio1Guia2 {

    public static void main(String[] args) {
        String notaStr = JOptionPane.showInputDialog("Ingrese la nota del alumno:");
        double nota = Double.parseDouble(notaStr);
        if (nota >= 7.0) {
            JOptionPane.showMessageDialog(null, "El alumno aprobó la materia.");
        } else if (nota >= 6.5 && nota < 7.0) {
            int opcion = JOptionPane.showConfirmDialog(null, "La nota está entre 6.50 y 6.99. ¿Desea realizar el examen de suficiencia?");
            if (opcion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "El alumno aprobó mediante el examen de suficiencia.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no aprobó la materia.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no aprobó la materia.");
        }
    }
}