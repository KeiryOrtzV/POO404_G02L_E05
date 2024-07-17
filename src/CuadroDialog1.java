import javax.swing.JOptionPane;
public class CuadroDialog1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here
        while (true){
            try{
                String nombre= JOptionPane.showInputDialog("Como te llamas?");
                String entrada= JOptionPane.showInputDialog("cuántos años tienes");
                int edad=Integer.parseInt(entrada);
                JOptionPane.showMessageDialog(null,"Hola, "+ nombre + ". El año que viene tendrás " +
                        (edad+1) + "años","Resultado",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e){
                System.out.println("Error en algun dato de entrada");
                JOptionPane.showMessageDialog(null,"Error en algun dato de entrada","Error",JOptionPane.ERROR_MESSAGE);
                        String seleccion=(String) JOptionPane.showInputDialog(
                                null,
                                "Desea Salir",
                                "Seleccione una opcion",
                                JOptionPane.QUESTION_MESSAGE,
                                null, // null para icono defecto
                                new Object[] { "Si", "No" },
                                "si");
                if (seleccion.equals("Si")){
                    System.exit(0);
                    break;
                }
            }//fin de catch
        }//fin de while
    }//fin del metodo main
}