package comparaciones;
import javax.swing.JOptionPane;

public class Comparacion {
    public static void main(String[] args){
        //declaracion de 3 variables tipo String
        String primernumero, segundonumero, resultado;
        int numero1, numero2;
        System.out.println("Programa para usar operadores relacionales en Java");
        //captura como String a numeros solicitados a usuario
        primernumero = JOptionPane.showInputDialog("Escriba el primer entero: ");
        segundonumero = JOptionPane.showInputDialog("Esriba el Segundo Entero: ");

        //convierte a numeros enteros a String recibidos del usuario
        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        resultado="";
        //utilixa operadores relacionales para comparar 2 numeris recibidos
        if (numero1 == numero2){
            resultado= resultado + numero1 + " igual que " + numero2;
        }
        if (numero1 != numero2){
            resultado= resultado + "\n" + numero1 + " distinto de " + numero2;
        }
        if (numero1 < numero2)
            resultado= resultado + "\n" + numero1 + " < " + numero2;

        if (numero1 > numero2)
            resultado= resultado + "\n" + numero1 + " > " + numero2;

        if (numero1 <= numero2)
            resultado= resultado + "\n" + numero1 + " <= " + numero2;

        if (numero1 >= numero2)
            resultado= resultado + "\n" + numero1 + " >= " + numero2;

        JOptionPane.showConfirmDialog(null, resultado, "resultado de la comparacion", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }

}
