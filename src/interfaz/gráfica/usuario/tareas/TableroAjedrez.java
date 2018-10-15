package interfaz.gráfica.usuario.tareas;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;

public class TableroAjedrez extends JFrame {
    
    private final int filas, columnas;
    private JPanel casillas[];
    private JPanel tablero;
    
    public TableroAjedrez(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        crear();
        propiedades();
        armar();
    }
    
    private void crear() {
        tablero = new JPanel(new GridLayout(filas, columnas));
        
        casillas = new JPanel [filas * columnas];
        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new JPanel();
        }
    }
    
    private void propiedades() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tablero de ajedrez");
        setLocationRelativeTo(null);
        setSize(400, 400);
        
        colorearTablero();
    }
    
    private void armar() {
        add(tablero);
        for (JPanel casilla : casillas) {
            tablero.add(casilla);
        }
    }
    
    private void colorearTablero() {
        int nCasilla = 0;
        Color color;
        
        for (int i = 0; i < filas; i++) {
            // Si la fila es par empezará en blanco, en negro de lo contrario.
            if (i % 2 == 0) {
                color = Color.WHITE;
            } else {
                color = Color.BLACK;
            }
                
            for (int j = 0; j < columnas; j++) {
                if (j == 0) {
                    nCasilla = i * columnas;
                }
                casillas[nCasilla].setBackground(color);
                nCasilla++;
                
                // Intercambia el color actual
                color = color == Color.WHITE ? Color.BLACK : Color.WHITE;
            }
        }
    }
    
    public static void main(String[] args) {
        new TableroAjedrez(8, 8).setVisible(true);
    }
}
