package acceso.datos.tareas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexiónBD extends JFrame {
    
    private JTable tablaResultados;
    private JComboBox cmboxTablas;
    private JButton btnConsultar;
    private JScrollPane scroll;
    private JPanel panel;
    
    private ResultSetMetaData metadatos;
    private ResultSet resultados;
    private Connection conexión;
    private Statement consulta;
    private final String url;
    
    public ConexiónBD() {
        url = "";
        crear();
        propiedades();
        armar();
    }
    
    private void crear() {
        panel = new JPanel();
        tablaResultados = new JTable(new DefaultTableModel());
        scroll = new JScrollPane(tablaResultados);
    }
    
    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(600, 400);
        
        panel.setLayout(null);
        scroll.setBounds(20, 100, 560, 255);
    }
    
    private void armar() {
        add(panel);
        panel.add(scroll);
    }
    
    private void crearConexión() throws SQLException {
        conexión = DriverManager.getConnection(url);
    }
    
    private void consultar(String tabla) throws SQLException {
        conexión = DriverManager.getConnection(url);
        Statement st = conexión.createStatement();
        ResultSet rs = st.executeQuery("");
        ResultSetMetaData rsmd = rs.getMetaData();
    }
    
    public static void main(String[] args) {
        new ConexiónBD().setVisible(true);
    }
}
