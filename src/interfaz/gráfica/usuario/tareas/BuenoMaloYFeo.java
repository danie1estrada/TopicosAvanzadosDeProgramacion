package interfaz.gráfica.usuario.tareas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BuenoMaloYFeo extends JFrame {
    
    private JButton btnBueno, btnMalo, btnFeo;
    private JPanel panel;
    
    public BuenoMaloYFeo() {
        crear();
        propiedades();
        escuchas();
        armar();
    }
    
    private void crear() {
        btnBueno = new JButton("Bueno");
        btnMalo = new JButton("Malo");
        btnFeo = new JButton("Feo");
        
        panel = new JPanel();
    }
    
    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("El bueno, el malo y el feo");
        setLocationRelativeTo(null);
        setSize(400, 400);
        
        btnBueno.setBounds(150, 30, 100, 25);
        btnMalo.setBounds(150, 130, 100, 25);
        btnFeo.setBounds(150, 230, 100, 25);
        
        panel.setLayout(null);
    }
    
    private void escuchas() {
        EscuchaClic ec = new EscuchaClic();
        
        btnBueno.addMouseListener(ec);
        btnMalo.addMouseListener(ec);
        btnFeo.addMouseListener(ec);
    }
    
    private void armar() {
        add(panel);
        panel.add(btnBueno);
        panel.add(btnMalo);
        panel.add(btnFeo);
    }
    
    private class EscuchaClic extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent me) {
            String mensaje = "";
            
            if (me.getSource().equals(btnBueno)) {
                mensaje = "Yo soy el bueno";
            } else if (me.getSource().equals(btnMalo)) {
                mensaje = "Soy malo";
            } else if (me.getSource().equals(btnFeo)) {
                mensaje = "Yo no soy feo, tú eres el feo";
            }
            
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
    
    public static void main(String[] args) {
        new BuenoMaloYFeo().setVisible(true);
    }
}
