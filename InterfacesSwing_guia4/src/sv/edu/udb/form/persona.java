package sv.edu.udb.form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class persona extends JFrame {
    private JPanel pnlPersona;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblbSexo;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox<String> cmbSexo;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JTable table1;
    private DefaultTableModel model;

    public persona(String title) {
        super(title);

        // Configuración de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        // Inicializar el modelo de la tabla
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nombres");
        model.addColumn("Edad");
        model.addColumn("Teléfono");
        model.addColumn("Sexo");
        table1.setModel(model); // Asignar el modelo a la tabla

        // Inicialización de JComboBox
        cmbSexo.addItem("Masculino");
        cmbSexo.addItem("Femenino");

        // Evento para obtener datos
        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });

        // Evento para limpiar campos
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Agregar MouseListener para detectar clics en la tabla
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblObtenerDatos(e);  // Llamamos al método tblObtenerDatos cuando se hace clic en la tabla
            }
        });
    }

    private void btnObtenerDatos() {
        // Obtener los datos del formulario
        String id = txtId.getText();
        String nombres = txtNombre.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String sexo = (String) cmbSexo.getSelectedItem();

        // Mostrar los datos en un cuadro de diálogo
        JOptionPane.showMessageDialog(this, "Datos Obtenidos: " +
                "\n ID: " + id +
                "\n Nombres: " + nombres +
                "\n Edad: " + edad +
                "\n Teléfono: " + telefono +
                "\n Sexo: " + sexo);

        // Agregar los datos a la tabla
        model.addRow(new Object[]{id, nombres, edad, telefono, sexo});
    }

    private void limpiarCampos() {
        // Limpiar los campos del formulario
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
    }

    // Método para obtener los datos de la tabla al hacer clic en una fila
    private void tblObtenerDatos(MouseEvent e) {
        int fila = table1.rowAtPoint(e.getPoint());
        int columna = table1.columnAtPoint(e.getPoint());

        if (fila >= 0 && columna >= 0) {
            // Actualizar los campos de texto con los datos de la fila seleccionada
            txtId.setText(model.getValueAt(fila, 0).toString());
            txtNombre.setText(model.getValueAt(fila, 1).toString());
            txtEdad.setText(model.getValueAt(fila, 2).toString());
            txtTelefono.setText(model.getValueAt(fila, 3).toString());
            cmbSexo.setSelectedItem(model.getValueAt(fila, 4).toString());
        }
    }

    public static void main(String[] args) {
        // Crear la instancia del frame
        JFrame frame = new persona("Ingreso de Datos");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // Custom creation code para JTable si es necesario
        table1 = new JTable();
    }
}
