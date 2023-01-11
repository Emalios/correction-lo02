import java.util.Observable;

public class RobotEmballeur extends Observable implements Runnable {

    private Jouet current;
    private Thread thread;

    public RobotEmballeur(Jouet current) {
        this.current = current;
    }

    public void fabriquer() {
        this.thread = new Thread(this);
        this.thread.start();
    }


    @Override
    public void run() {
        while (true) {
            if(this.current.getNbJouets() == Jouet.MAX_JOUETS) return;
            try {
                this.current.emballerJouet();
                notifyObservers();
                this.thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Jouet getJouet() {
        return this.current;
    }
}
