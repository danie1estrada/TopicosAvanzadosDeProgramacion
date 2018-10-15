package interfaz.gráfica.usuario.tareas;

import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import java.io.File;

public class LeerArchivoATextArea extends JFrame {
    
    private String contenidoArchivo;
    private JTextArea txtArchivo;
    private JButton btnAbrir;
    private JFileChooser fc;
    private JScrollPane sp;
    private JPanel panel;

    public LeerArchivoATextArea() {
        crear();
        propiedades();
        escuchas();
        armar();
    }
    
    private void crear() {
        btnAbrir = new JButton("Abrir");
        txtArchivo = new JTextArea();
        sp = new JScrollPane(txtArchivo);
        fc = new JFileChooser();
        panel = new JPanel();
    }
    
    private void propiedades() {
        setTitle("Leer y cargar archivo JFileChooser y JTextArea");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(400, 400);
        
        btnAbrir.setBounds(150, 20, 100, 25);
        sp.setBounds(50, 60, 300, 280);
        panel.setLayout(null);
    }

    private void armar() {
        add(panel);
        panel.add(btnAbrir);
        panel.add(sp);
    }

    private void escuchas() {
        btnAbrir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                leerArchivo();
            }
        });
    }
    
    private void leerArchivo() {
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        contenidoArchivo = "";
        
        try {
            Scanner sc = new Scanner(archivo);
            while(sc.hasNext()) {
                contenidoArchivo += sc.nextLine() + "\n";
            }
            txtArchivo.setText(contenidoArchivo);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo.");
        }
        
    }
    
    public static void main(String[] args) {
        new LeerArchivoATextArea().setVisible(true);
    }
}
