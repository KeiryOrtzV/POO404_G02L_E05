package comparaciones;
import javax.swing.JOptionPane;// genera cuadros de dialogo para usuario

public class Comparacion {public static void main(String[] args) {
    // declaracion de 3 variables de tipo String
    String primernumero, segundonumero, resultado;
    int numero1, numero2; //almacena numeros dados por usuario
    System.out.println("Programa para usar operadores relacionales en Java");
    //captura como String a numeros solicitados a usuario
    primernumero = JOptionPane.showInputDialog("Escriba el primer entero:");
    segundonumero = JOptionPane.showInputDialog("Escriba el Segundo Entero:");
    //convierte a numeros enteros a String recibidos del usuario
    numero1= Integer.parseInt(primernumero);
    numero2 = Integer.parseInt(segundonumero);
    resultado= "";
    //utiliza operadores relacionales para comparar 2 numeros recibidos
    if (numero1 == numero2) {
        resultado= resultado + numero1 + " igual que " + numero2;
    }
    if (numero1 != numero2) {
        resultado= resultado + numero1 + " distinto de " + numero2;
    }
    if (numero1 < numero2) {
        resultado= resultado + "\n" + numero1 + " < " + numero2;
    }
    if (numero1 > numero2)
        resultado= resultado + "\n" + numero1 + " > " + numero2;
    if (numero1 <= numero2)
        resultado= resultado + "\n" + numero1 + " <=" + numero2;
    if (numero1 > numero2)
        resultado= resultado + "\n" + numero1 + " >= " + numero2;
    JOptionPane.showConfirmDialog(null, resultado,
            "Resultado de la comparación",JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
}

}
