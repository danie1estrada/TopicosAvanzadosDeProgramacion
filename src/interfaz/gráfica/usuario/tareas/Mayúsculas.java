package interfaz.gráfica.usuario.tareas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mayúsculas extends JFrame {
    
    private JPanel panel;
    private JTextField texto;
    
    public Mayúsculas() {
        crear();
        propiedades();
        escuchas();
        armar();
    }
    
    private void crear() {
        texto = new JTextField();
        panel = new JPanel();
    }
    
    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Mayúsculas");
        setSize(400, 400);
        
        texto.setBounds(100, 50, 200, 35);
        panel.setLayout(null);
    }
    
    private void armar() {
        add(panel);
        panel.add(texto);
    }
    
    private void escuchas() {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                ke.setKeyChar(
                    Character.toString(ke.getKeyChar()).toUpperCase().charAt(0)
                );
            }
        });
    }
    
    public static void main(String[] args) {
        new Mayúsculas().setVisible(true);
    }
}
