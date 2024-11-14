public class Piso {

    private int numPiso = 0;

    public synchronized void addPiso(int numPiso) {
        this.numPiso += numPiso;
    }

    public synchronized int getNumPiso() {
        return numPiso;
    }
}
