public class Ascensor {

    private boolean parado = true;
    Piso pisoObject = new Piso();

    public synchronized void subir(int piso, int idPersona) throws InterruptedException {
        if(!parado){
            wait();
        }
        if(piso > pisoObject.getNumPiso()){
            parado = false;
            System.out.println("Persona numero " + idPersona + " ha pulsado el boton " + piso);
            System.out.println("Subiendo...");
            System.out.println("Piso: " + piso + "/20");
            parado = true;
            notifyAll();
        }

    }

    public synchronized void bajar(int piso, int idPersona) throws InterruptedException {
        if(!parado){
            wait();
        }
        if(piso < pisoObject.getNumPiso()){
            parado = false;
            System.out.println("Persona numero " + idPersona + " ha pulsado el boton " + piso);
            System.out.println("bajando...");
            System.out.println("Piso: " + piso + "/20");
            parado = true;
            notifyAll();
        }
    }


}
