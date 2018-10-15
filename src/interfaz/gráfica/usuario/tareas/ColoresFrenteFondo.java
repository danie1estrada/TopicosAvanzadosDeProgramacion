package interfaz.gráfica.usuario.tareas;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class ColoresFrenteFondo extends JFrame {
    
    private int frenteR, frenteG, frenteB, fondoR, fondoG, fondoB;
    private JSlider sliderFrenteR, sliderFrenteG, sliderFrenteB,
                    sliderFondoR, sliderFondoG, sliderFondoB;
    private JLabel texto;
    private JPanel panel;
    
    public ColoresFrenteFondo() {
        crear();
        propiedades();
        escuchas();
        armar();
    }
    
    private void crear() {
        texto = new JLabel("Texto de muestra");
        frenteR = frenteG = frenteB = 255;
        fondoR = fondoG = fondoB = 0;
        panel = new JPanel();
        
        sliderFrenteR = new JSlider(JSlider.VERTICAL, 0, 255, frenteR);
        sliderFrenteG = new JSlider(JSlider.VERTICAL, 0, 255, frenteG);
        sliderFrenteB = new JSlider(JSlider.VERTICAL, 0, 255, frenteB);
        
        sliderFondoR = new JSlider(JSlider.VERTICAL, 0, 255, fondoR);
        sliderFondoG = new JSlider(JSlider.VERTICAL, 0, 255, fondoG);
        sliderFondoB = new JSlider(JSlider.VERTICAL, 0, 255, fondoB);
    }
    
    private void propiedades() {
        setTitle("Colores de frente y fondo (JSlider)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        
        sliderFrenteR.setBackground(Color.RED);
        sliderFrenteG.setBackground(Color.GREEN);
        sliderFrenteB.setBackground(Color.BLUE);
        
        sliderFondoR.setBackground(Color.RED);
        sliderFondoG.setBackground(Color.GREEN);
        sliderFondoB.setBackground(Color.BLUE);
        
        panel.setBackground(Color.BLACK);
        texto.setForeground(Color.WHITE);
    }
    
    private void armar() {
        add(panel);
        
        panel.add(sliderFrenteR);
        panel.add(sliderFrenteG);
        panel.add(sliderFrenteB);
        
        panel.add(texto);
        
        panel.add(sliderFondoR);
        panel.add(sliderFondoG);
        panel.add(sliderFondoB);
    }
    
    private void escuchas() {
        sliderFrenteR.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                frenteR = sliderFrenteR.getValue();
                texto.setForeground(new Color(frenteR, frenteG, frenteB));
            }
        });
        
        sliderFrenteG.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                frenteG = sliderFrenteG.getValue();
                texto.setForeground(new Color(frenteR, frenteG, frenteB));
            }
        });
        
        sliderFrenteB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                frenteB = sliderFrenteB.getValue();
                texto.setForeground(new Color(frenteR, frenteG, frenteB));
            }
        });
        
        sliderFondoR.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                fondoR = sliderFondoR.getValue();
                panel.setBackground(new Color(fondoR, fondoG, fondoB));
            }
        });
        
        sliderFondoG.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                fondoG = sliderFondoG.getValue();
                panel.setBackground(new Color(fondoR, fondoG, fondoB));
            }
        });
        
        sliderFondoB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                fondoB = sliderFondoB.getValue();
                panel.setBackground(new Color(fondoR, fondoG, fondoB));
            }
        });
    }
    
    public static void main(String[] args) {
        new ColoresFrenteFondo().setVisible(true);
    }
}
