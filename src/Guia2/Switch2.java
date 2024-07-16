package Guia2;

import javax.swing.JOptionPane;
public class Switch2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here
        int replaced = JOptionPane.showConfirmDialog(null,"Replace existing selection?");
        String result = "?";
        switch (replaced) {
            case JOptionPane.CANCEL_OPTION:
                result = "Canceled";
                break;
            case JOptionPane.CLOSED_OPTION:
                result = "Closed";
                break;
            case JOptionPane.NO_OPTION:
                result = "No";
                break;
            case JOptionPane.YES_OPTION:
                result = "Yes";
                break;
            default:
                ;
        }
        System.out.println("Replace? " + result);
    }
}