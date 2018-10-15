package interfaz.gráfica.usuario.tareas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenúTaqueria extends JFrame {
    
    private JMenuBar menú;
    private JMenu menúPlatillos, menúGuisados, menúExtras, menúPago;
    
    public MenúTaqueria() {
        crear();
        propiedades();
        armar();
    }

    private void crear() {
        menú = new JMenuBar();
        menúPlatillos = new JMenu("Platillos");
        menúGuisados = new JMenu("Guisados");
        menúExtras = new JMenu("Extras");
        menúPago = new JMenu("Formas de pago");
    }

    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Menú taquería");
        setSize(400, 400);
        
        setJMenuBar(menú);
    }

    private void armar() {
        menú.add(menúPlatillos);
        menú.add(menúGuisados);
        menú.add(menúExtras);
        menú.add(menúPago);
    }
    
    public static void main(String[] args) {
        new MenúTaqueria().setVisible(true);
    }
}
