import javax.swing.*;

/**
 * Clase piso con las variables que van a compartir los hilos
 * @author cristian
 * @version 1.0
 */
public class Piso {

    /**
     * Variables privadas de la clase piso
     */
    private int numPisoActual = 1;
    private final int minPiso = 1;
    private final int maxPiso = 20;
    private boolean parado = true;

    /**
     * Metodo para usar el ascensor
     * @throws InterruptedException lanzamos la excepcion InterruptedException en el caso de que ocurra algún error en el proceso de hilos
     */
    public synchronized void cogerAscensor() throws InterruptedException {

        //si el ascensor está parado, mostramos mensaje y esperamos
        if(!parado) {
            JOptionPane.showMessageDialog(null, "Ascensor en movimiento, espere");
            wait();
        }
        else{
            try{
                /*
                  Explicación:
                  1. Si no está parado, introducimos un numero para llamar al ascensor
                  2. comprobamos que el numero introducido no es mayor que 20 o menor que 1
                  3. también comprobamos que lo introducido no es algo diferente de un numero
                  4. si el numero introducido es mayor que el numero actual de piso, se muestra un mensaje de subida y esperamos 2 segundos para simular la subida del ascensor
                  5. si el numero introducido es menor que el numero actual de piso, se muestra un mensaje de bajada y esperamos 2 segundos para simular la subida del ascensor
                  6. en ambos casos se iguala la variable pisoActual al piso que selecciono el usuario
                  7. si completó el recorrido, parado vuelve a ser true y notificamos al resto de hilos
                 */
                int numPisoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog("Introduce un piso(1 al 20): "));
                while(numPisoSeleccionado < minPiso || numPisoSeleccionado > maxPiso) {
                    numPisoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog("Piso inexistente, Introduce un piso: "));
                }
                while(numPisoSeleccionado == numPisoActual) {
                    numPisoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog("Ya estás en la planta seleccionada: "));
                }

                if(numPisoSeleccionado > numPisoActual) {
                    parado = false;
                    JOptionPane.showMessageDialog(null, "Piso seleccionado es: " + numPisoSeleccionado + " subiendo...");
                    Thread.sleep(2000);
                    numPisoActual = numPisoSeleccionado;
                } else {
                    parado = false;
                    JOptionPane.showMessageDialog(null, "Piso seleccionado es: " + numPisoSeleccionado + " bajando...");
                    Thread.sleep(2000);
                    numPisoActual = numPisoSeleccionado;
                }
                JOptionPane.showMessageDialog(null, "Ha llegado a su destino");
                parado = true;
                notifyAll();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Piso invalido");
            }
        }

    }
}
