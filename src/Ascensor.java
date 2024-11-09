/**
 * Clase Ascensor para simular el funcionamiento
 * @author cristian
 * @version 1.0
 */
public class Ascensor implements Runnable{

    //variables privadas de piso y numPersonas
    private Piso piso;
    private int numPersonas;

    /**
     * Constructor del hilo
     * @param piso el objeto piso con las variables compartidas
     * @param numPersonas el numero de personas que usarán el ascensor
     */
    public Ascensor(Piso piso, int numPersonas) {
        this.piso = piso;
        this.numPersonas = numPersonas;
    }

    @Override
    public void run() {

        /**
         * Recoremos un for del mismo tamaño que el numero de personas que usen el ascensor
         * llamamos al metodo de la clase piso para usar el ascensor
         */
            try {
                for(int i = 0; i < numPersonas; i++){
                    piso.cogerAscensor();
                }
            } catch (InterruptedException e) {
                System.out.println("Ups, ha ocurrido un error en el ascensor, nos vamos morir!!");
            }
        }
    }

