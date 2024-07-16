package sumanumeros;

import javax.swing.JOptionPane;



public class SumaEnteros {

    public static void main(String[] args) {
        //Declara a 2 variables de tipo cadena (String)
        String primernumero;
        String segundonumero;
        //Declara a 3 variables de tipo entero (int)
        int numero1, numero2, suma;

        System.out.println("aplicacion para sumar 2 muneros enteros\n");

        //genera cuadros de dialogo para ingresar numeros (como Sting)
        primernumero =JOptionPane.showInputDialog("digite el primer numero");
        segundonumero =JOptionPane.showInputDialog("digite el segundo numero");

        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        System.out.println("los numeros ingresados son "+numero1 + "y " + numero2);

        suma = numero1 + numero2;

        JOptionPane.showMessageDialog(null,"la suma de"
                        + numero1+ "y" +numero2+ "es de "  + suma,
                "resultado de la suma",JOptionPane.PLAIN_MESSAGE );

        System.exit(0);
    }
}



