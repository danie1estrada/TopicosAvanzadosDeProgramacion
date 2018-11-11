package programación.concurrente.tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongPapas {
    
    private static String sig = "Ping";
    private static int nVeces;
    
    private synchronized static void imprimir(String nombre, String siguiente) {
        if (sig.equals(nombre)) {
            System.out.printf("%d.- %s\n", nVeces, nombre);
            sig = siguiente;
            nVeces++;
        } else {
            Thread.yield();
        }
    }
    
    static class Hilo implements Runnable {
        
        private final String nombre, siguiente;

        public Hilo(String nombre, String siguiente) {
            this.nombre = nombre;
            this.siguiente = siguiente;
        }
        
        @Override
        public void run() {
            while (nVeces < 100) {
                imprimir(nombre, siguiente);
            }
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Hilo a, b, c, d;
        
        a = new Hilo("Ping", "  Pong");
        b = new Hilo("  Pong", "      Papas");
        c = new Hilo("      Papas", "Ping");
        d = new Hilo("Ping", "  Pong");
        
        Thread hiloA = new Thread(a);
        Thread hiloB = new Thread(a);
        Thread hiloC = new Thread(a);
        Thread hiloD = new Thread(a);
        Thread hiloE = new Thread(a);
        Thread hiloF = new Thread(b);
        Thread hiloG = new Thread(b);
        Thread hiloH = new Thread(c);
        Thread hiloI = new Thread(c);
        Thread hiloJ = new Thread(d);
        
        exec.execute(hiloA);
        exec.execute(hiloB);
        exec.execute(hiloC);
        exec.execute(hiloD);
        exec.execute(hiloE);
        exec.execute(hiloF);
        exec.execute(hiloG);
        exec.execute(hiloH);
        exec.execute(hiloI);
        exec.execute(hiloJ);
        
        exec.shutdown();
    }
}
 