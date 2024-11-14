/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Personas p = new Personas();
        Piso piso = new Piso();
        boolean parado = true;
        Ascensor asc = new Ascensor(parado, piso);


        for(int i = 1; i < p.getNumPersonas(); i++){
            new Thread(new Hilo(i, asc, parado)).start();
        }


    }
}