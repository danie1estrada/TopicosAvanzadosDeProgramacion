package interfaz.gráfica.usuario.gridbaglayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayoutDemo extends JFrame {
    
    private GridBagConstraints gbc;
    private GridBagLayout gbl;
    private JPanel mainPanel;
    private JButton btnAccept, btnCancel;
    
    public GridBagLayoutDemo() {
        create();
        properties();
        build();
    }
    
    private void create() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        mainPanel = new JPanel(gbl);
        btnAccept = new JButton("Aceptar");
        btnCancel = new JButton("Cancelar");
    }
    
    private void properties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);
        
        gbc.weightx = 1;
        gbc.weighty = 1;
    }
    
    private void build() {
        add(mainPanel);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(btnAccept, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(btnCancel, gbc);
        pack();
    }
    
    public static void main(String[] args) {
        new GridBagLayoutDemo().setVisible(true);
    }
}
