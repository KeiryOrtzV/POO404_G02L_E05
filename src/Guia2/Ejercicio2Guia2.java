package Guia2;
import javax.swing.JOptionPane;
import java.util.Random;
public class Ejercicio2Guia2 {
    public static void main(String[] args) {
        String[] colores = {"roja", "verde", "blanca"};
        String colorBolita = colores[new Random().nextInt(colores.length)];
        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda. ¡Es hora de sacar una bolita!");
        switch (colorBolita) {
            case "roja":
                aplicarDescuento(10);
                break;
            case "verde":
                aplicarDescuento(5);
                break;
            case "blanca":
                JOptionPane.showMessageDialog(null, "Gracias por participar. No tiene descuento en esta ocasión.");
                break;
        }
    }
    private static void aplicarDescuento(int descuento) {
        double totalCompra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el total de la compra:"));
        double descuentoAplicado = totalCompra * (descuento / 100.0);
        double totalConDescuento = totalCompra - descuentoAplicado;
        JOptionPane.showMessageDialog(null, "Descuento aplicado: " + descuento + "%");
        JOptionPane.showMessageDialog(null, "Total de la compra con descuento: " + totalConDescuento);
    }
}