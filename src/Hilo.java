public class Hilo implements Runnable{

    private final int idPiso;
    private final Ascensor ascensor;
    private final boolean parado;

    public Hilo(int idPiso, Ascensor ascensor, boolean parado) {
        this.idPiso = idPiso;
        this.ascensor = ascensor;
        this.parado = parado;
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
