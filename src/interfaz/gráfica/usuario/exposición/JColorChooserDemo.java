package interfaz.gráfica.usuario.exposición;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.Color;

public class JColorChooserDemo extends JFrame {
    
    private JPanel mainPanel, colorPanel;
    private Color bgColor;
    
    public JColorChooserDemo() {
        create();
        properties();
        build();
        listeners();
    }
    
    private void create() {
        colorPanel = new JPanel();
        mainPanel = new JPanel();
        bgColor = Color.BLACK;
    }
    
    private void properties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("JColorChooser Demo");
        setLocationRelativeTo(null);
        setSize(600, 200);
        
        colorPanel.setBorder(BorderFactory.createEtchedBorder());
        colorPanel.setBounds(200, 20, 200, 50);
        colorPanel.setBackground(bgColor);
        
        mainPanel.setLayout(null);
    }
    
    private void build() {
        add(mainPanel);
        mainPanel.add(colorPanel);
    }
    
    private void listeners() {
        colorPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colorPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                bgColor = JColorChooser.showDialog(null, "Select a color", bgColor);
                colorPanel.setBackground(bgColor != null ? bgColor : Color.BLACK);
            }
        });
    }
    
    public static void main(String[] args) {
        new JColorChooserDemo().setVisible(true);
    }
}