import java.util.Random;

public class Hilo implements Runnable{

    private int idPiso;
    private Ascensor ascensor;
    private Random rand;

    public Hilo(int idPiso) {
        this.idPiso = idPiso;
    }


    @Override
    public void run() {
        try{
            ascensor.subir(rand.nextInt(1)+10, idPiso);
        } catch (InterruptedException e) {
            System.out.println("Ups, ha ocurrido un error en la ejecucion");
        }
    }
}
