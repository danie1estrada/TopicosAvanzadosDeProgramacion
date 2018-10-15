package interfaz.gráfica.usuario.tareas;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColoresFrenteYFondoList extends JFrame {
    
    //private JList<ColoresFrente> coloresFrente;
    private JList<ColoresFondo> coloresFondo;
    private JPanel panel;
    
    public ColoresFrenteYFondoList() {
        crear();
        propiedades();
        armar();
    }
    
    private void crear() {
        coloresFondo = new JList(ColoresFondo.values());
        panel = new JPanel();
    }
    
    private void propiedades() {
        setTitle("Colores de frente y fondo (JList)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);
        
        coloresFondo.setBounds(100, 50, 200, 200);
        panel.setLayout(null);
    }
    
    private void armar() {
        add(panel);
        panel.add(coloresFondo);
    }
    
    private void escuchas() {
        coloresFondo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                
                panel.setBackground(coloresFondo.getSelectedValue().getColor());
                System.out.println("algo");
            }
        });
    }
    
    private enum ColoresFrente {
        
    }
    
    private enum ColoresFondo {
        
        Negro (25, 25, 25),
        Gris (85, 85, 85);
        
        private final int r, g, b;
        
        private ColoresFondo(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
        
        public Color getColor() {
            return new Color(r, g, b);
        }
    }
    
    public static void main(String[] args) {
        new ColoresFrenteYFondoList().setVisible(true);
    }
}
