package sv.edu.udb.form;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Persona extends JFrame {
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel pnlPersona;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblTelefono;
    private JTable tblDatos;
    DefaultTableModel modelo = null;

    public Persona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(800, 700));
        this.setLocationRelativeTo(getParent());

        Object[][] data = null;

        String[] columns = {
                "Id", "Nombres", "Edad", "Telefono", "Sexo"
        };

        modelo = new DefaultTableModel(data, columns);

        tblDatos.setModel(modelo);

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });

        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatos(e);
            }
        });


        cargarDatosDesdeCSV("datos.csv");
    }

    private void tblObtenerDatos(MouseEvent e) {
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());
        if ((fila > -1) && (columna > -1)) {
            txtId.setText(modelo.getValueAt(fila, 0).toString());
            txtNombre.setText(modelo.getValueAt(fila, 1).toString());
            txtEdad.setText(modelo.getValueAt(fila, 2).toString());
            txtTelefono.setText(modelo.getValueAt(fila, 3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila, 4).toString());
        }
    }

    private void btnObtenerDatos() {
        String id = txtId.getText();
        String nombres = txtNombre.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();


        Object[] newRow = {id, nombres, edad, telefono, sexo};
        modelo.addRow(newRow);


        guardarNuevaFilaEnCSV(id, nombres, edad, telefono, sexo);


        btnLimpiar();
    }

    private void guardarNuevaFilaEnCSV(String id, String nombres, String edad, String telefono, String sexo) {

        String archivoCSV = "datos.csv";

        try {

            FileWriter fileWriter = new FileWriter(archivoCSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

          
            printWriter.println(id + "," + nombres + "," + edad + "," + telefono + "," + sexo);


            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnLimpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
    }


    private void cargarDatosDesdeCSV(String archivoCSV) {
        try (Reader reader = Files.newBufferedReader(Paths.get(archivoCSV));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                String id = csvRecord.get("Id");
                String nombres = csvRecord.get("Nombres");
                String edad = csvRecord.get("Edad");
                String telefono = csvRecord.get("Telefono");
                String sexo = csvRecord.get("Sexo");

                modelo.addRow(new Object[]{id, nombres, edad, telefono, sexo});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new Persona("Ingreso de Datos");
        frame.setVisible(true);
    }
}
