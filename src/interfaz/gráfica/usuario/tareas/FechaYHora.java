package interfaz.gráfica.usuario.tareas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class FechaYHora extends JFrame {
    
    private JSpinner spinnerFecha, spinnerHora;
    private SpinnerDateModel dm, hm;
    private JPanel panel;
    
    public FechaYHora() {
        crear();
        propiedades();
        armar();
    }
    
    private void crear() {
        dm = new SpinnerDateModel();
        hm = new SpinnerDateModel();
        
        spinnerFecha = new JSpinner(hm);
        spinnerHora = new JSpinner(hm);
        panel = new JPanel();
    }
    
    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fecha y hora JSpinner");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(300, 100);
        
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/YYYY"));
        spinnerFecha.setBounds(25, 25, 100, 25);
        
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm:ss"));
        spinnerHora.setBounds(175, 25, 100, 25);
        panel.setLayout(null);
    }
    
    private void armar() {
        add(panel);
        panel.add(spinnerFecha);
        panel.add(spinnerHora);
    }
    
    public static void main(String[] args) {
        new FechaYHora().setVisible(true);
    }
}
