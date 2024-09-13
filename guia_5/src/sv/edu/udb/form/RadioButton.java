package sv.edu.udb.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame {
    private JRadioButton rbtOpcion1;
    private JRadioButton rbtOpcion2;
    private JRadioButton rbtOpcion3;
    private JLabel lblTitulo;
    private JLabel lblImagen1;
    private JLabel lblImagen2;
    private JLabel lblImagen3;
    private JPanel pnlImg;
    private ButtonGroup buttonGroupImg;

    public RadioButton(String title) {
        super(title);

        // Inicialización del panel y de los componentes
        pnlImg = new JPanel();
        lblTitulo = new JLabel("Seleccione una imagen");
        lblTitulo.setFont(new Font("Segoe Print", Font.BOLD, 22));
        lblImagen1 = new JLabel();
        lblImagen2 = new JLabel();
        lblImagen3 = new JLabel();
        rbtOpcion1 = new JRadioButton("Opcion1");
        rbtOpcion2 = new JRadioButton("Opcion2");
        rbtOpcion3 = new JRadioButton("Opcion3");

        buttonGroupImg = new ButtonGroup();
        buttonGroupImg.add(rbtOpcion1);
        buttonGroupImg.add(rbtOpcion2);
        buttonGroupImg.add(rbtOpcion3);

        // Agregar componentes al panel
        pnlImg.setLayout(new GridLayout(5, 1));
        pnlImg.add(lblTitulo);
        pnlImg.add(rbtOpcion1);
        pnlImg.add(rbtOpcion2);
        pnlImg.add(rbtOpcion3);
        pnlImg.add(lblImagen1);
        pnlImg.add(lblImagen2);
        pnlImg.add(lblImagen3);

        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlImg);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);

        // Listener para el primer botón de opción
        rbtOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImagen1.setIcon(new ImageIcon(getClass().getResource("/sv/edu/udb/img/img1.png")));
                lblImagen2.setIcon(null);
                lblImagen3.setIcon(null);
            }
        });

        // Listener para el segundo botón de opción
        rbtOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImagen1.setIcon(null);
                lblImagen2.setIcon(new ImageIcon(getClass().getResource("/sv/edu/udb/img/img2.png")));
                lblImagen3.setIcon(null);
            }
        });

        // Listener para el tercer botón de opción
        rbtOpcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImagen1.setIcon(null);
                lblImagen2.setIcon(null);
                lblImagen3.setIcon(new ImageIcon(getClass().getResource("/sv/edu/udb/img/img3.jpg")));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new RadioButton("Seleccione una Imagen");
            frame.setVisible(true);
        });
    }
}
