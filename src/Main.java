/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        //instanciamos el objeto de tipo piso
        Piso piso = new Piso();
        //numero de personas que usarán el ascensor
        int numPersonas = 10;
        //instanciamos 4 hilos
        Thread hiloAscensor1 = new Thread(new Ascensor(piso, numPersonas));
        Thread hiloAscensor2 = new Thread(new Ascensor(piso, numPersonas));
        Thread hiloAscensor3 = new Thread(new Ascensor(piso, numPersonas));
        Thread hiloAscensor4 = new Thread(new Ascensor(piso, numPersonas));

        //los iniciamos
        hiloAscensor1.start();
        hiloAscensor2.start();
        hiloAscensor3.start();
        hiloAscensor4.start();


    }
}