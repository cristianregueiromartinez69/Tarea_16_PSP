public class Ascensor {

    private boolean parado;
    Piso pisoObject;

    public Ascensor(boolean parado, Piso piso) {
        this.parado = parado;
        this.pisoObject = piso;
    }


    public synchronized void subir(int piso, int idPersona) throws InterruptedException {
        if(!parado){
            System.out.println("persona numero " + idPersona + " espera por ascensor");
            wait();
        }
        else{
            if(piso > pisoObject.getNumPiso()){
                parado = false;
                pisoObject.addPiso(piso);
                System.out.println("Persona numero " + idPersona + " ha pulsado el boton " + piso);
                System.out.println("Subiendo...");
                System.out.println("Piso: " + piso + "/20");
            }
            parado = true;
            notifyAll();
        }




    }

    public synchronized void bajar(int piso, int idPersona) throws InterruptedException {
        if(!parado){
            System.out.println("persona numero " + idPersona + " espera por ascensor");
            wait();
        }else{
            if(piso < pisoObject.getNumPiso()){
                parado = false;
                pisoObject.addPiso(piso);
                System.out.println("Persona numero " + idPersona + " ha pulsado el boton " + piso);
                System.out.println("bajando...");
                System.out.println("Piso: " + piso + "/20");
            }
            parado = true;
            notifyAll();
        }


    }



}
