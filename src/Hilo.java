import java.util.Random;

public class Hilo implements Runnable{

    private int idPiso;
    private Ascensor ascensor;

    public Hilo(int idPiso, Ascensor ascensor) {
        this.idPiso = idPiso;
        this.ascensor = ascensor;
    }


    @Override
    public void run() {
        try{
            while(true){
                ascensor.subir( getRandom(), idPiso);
                Thread.sleep(2000);
                ascensor.bajar(getRandom(), idPiso);
                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            System.out.println("Ups, ha ocurrido un error en la ejecucion");
        }
    }

    private int getRandom(){
       return (int) (Math.random() * 20) + 1;
    }
}
