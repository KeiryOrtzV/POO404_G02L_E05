package sv.edu.udb.form;

import sv.edu.udb.datos.PersonasDatos;
import sv.edu.udb.datos.OcupacionesDatos;
import sv.edu.udb.beans.PersonaBeans;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Persona extends JFrame {

    // Instancias de los objetos
    PersonasDatos personaDatos = new PersonasDatos();
    OcupacionesDatos ocupacionesDatos = new OcupacionesDatos();
    PersonaBeans personaBeans;
    DefaultTableModel modelo;

    // Componentes gráficos
    private JTextField txtId, txtNombre, txtEdad, txtTelefono, txtFechaNacimiento;
    private JComboBox<String> cmbSexo, cmbOcupacion;
    private JButton btnObtenerDatos, btnEliminar, btnLimpiar;
    private JTable tblDatos;
    private JPanel pnlPersona;
    private JLabel lblNombre;
    private JLabel lblId;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JLabel lblOcupacion;
    private JLabel lblFechaNacimiento;

    public Persona() {
        initComponents(); // Inicializa los componentes visuales

        // Configuraciones del JFrame
        setSize(800, 600); // Ajusta el tamaño del JFrame
        setTitle("Gestión de Personas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicialización de los datos en la tabla y combobox
        modelo = personaDatos.selectPersona();
        tblDatos.setModel(modelo);
        cmbOcupacion.setModel(ocupacionesDatos.selectOcupaciones());

        // Configuración de acciones para los botones
        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminarDatos();
            }
        });

        // Configuración del MouseListener para la tabla
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblObtenerDato(e);
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });
    }

    private void initComponents() {
    }

    private void btnObtenerDatos() {
        int id;
        String nombres;
        int edad;
        String telefono;
        String sexo;
        int idOcupacion;
        String fechaNacimiento;

        if (txtId.getText().isEmpty()) {
            id = 0;
        } else {
            id = Integer.parseInt(txtId.getText());
        }

        nombres = txtNombre.getText();
        edad = Integer.parseInt(txtEdad.getText());
        telefono = txtTelefono.getText();
        sexo = cmbSexo.getSelectedItem().toString();
        idOcupacion = ocupacionesDatos.getIdOcupacion(cmbOcupacion.getSelectedItem().toString());
        fechaNacimiento = txtFechaNacimiento.getText();

        personaBeans = new PersonaBeans(id, nombres, edad, telefono, sexo, idOcupacion, fechaNacimiento);

        if (btnObtenerDatos.getText().equals("Guardar")) {
            personaDatos.insert(personaBeans);
        } else if (btnObtenerDatos.getText().equals("Editar")) {
            personaDatos.update(personaBeans);
        }

        modelo = personaDatos.selectPersona();
        tblDatos.setModel(modelo);
    }

    private void btnEliminarDatos() {
        if (!txtId.getText().isEmpty()) {
            int idPersona = Integer.parseInt(txtId.getText());
            personaDatos.delete(idPersona);

            modelo = personaDatos.selectPersona();
            tblDatos.setModel(modelo);
            btnLimpiar(); // Limpiar los campos después de eliminar
        }
    }

    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        cmbOcupacion.setSelectedIndex(0);
        txtFechaNacimiento.setText("");
        btnObtenerDatos.setText("Guardar");
    }

    private void tblObtenerDato(MouseEvent e) {
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)) {
            txtId.setText(modelo.getValueAt(fila, 0).toString());
            txtNombre.setText(modelo.getValueAt(fila, 1).toString());
            txtEdad.setText(modelo.getValueAt(fila, 2).toString());
            txtTelefono.setText(modelo.getValueAt(fila, 3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila, 4).toString());
            cmbOcupacion.setSelectedItem(modelo.getValueAt(fila, 5).toString());
            txtFechaNacimiento.setText(modelo.getValueAt(fila, 6).toString());
            btnObtenerDatos.setText("Editar");
        }
    }

    public static void main(String[] args) {
        Persona frame = new Persona();
        frame.setVisible(true);
    }
}
