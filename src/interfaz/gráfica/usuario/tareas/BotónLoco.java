package interfaz.gráfica.usuario.tareas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotónLoco extends JFrame {
    
    private JPanel panel;
    private JButton botónLoco;
    
    public BotónLoco() {
        crear();
        propiedades();
        escuchas();
        armar();
    }
    
    private void crear() {
        botónLoco = new JButton("Hazme clic");
        panel = new JPanel();
    }
    
    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Botón Loco");
        setSize(400, 400);
        
        botónLoco.setBounds(150, 150, 100, 30);
        panel.setLayout(null);
    }
    
    private void escuchas() {
        botónLoco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                int posX = (int) (Math.random() * (getWidth() - 100));
                int posY = (int) (Math.random() * (panel.getHeight() - 30));
                
                botónLoco.setBounds(posX, posY, 100, 30);
            }
            
            @Override
            public void mousePressed(MouseEvent me) {
                JOptionPane.showMessageDialog(null, "Está bien, tú ganas.");
            }
        });
    }
    
    private void armar() {
        add(panel);
        panel.add(botónLoco);
    }
    
    public static void main(String[] args) {
        new BotónLoco().setVisible(true);
    }
}
