import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Jouet {

    /*
    on choisit des attributs static pour la constante ainsi que le nombre de jouet
     */
    private static int NB_JOUETS = 0;
    public static final int MAX_JOUETS = 500;

    /*
    on choisit un Set car on ne doit avoir qu'un seul type de pièce par jouet
     */
    private Set<Piece> pieces;
    private int prices;

    public Jouet() {
        this.pieces = new HashSet<>();
    }

    private Jouet(Set<Piece> pieces) {
        this.pieces = pieces;
    }

    public void deposerUnePiece(Piece piece, int pos) throws InterruptedException {
        //on s'assure qu'on essai dans le bon ordre
        if(pos != this.pieces.size()) {
            System.out.println("pause de pos: " + pos);
            wait();
        }
        System.out.println("mise de la pièce à la pos " + pos);
        this.pieces.add(piece);
        Random random = new Random();
        int price = 5 + random.nextInt(11);
        this.prices += price;
        notifyAll();
    }

    public synchronized void emballerJouet() throws InterruptedException {
        //on s'assure qu'on essai dans le bon ordre
        if(this.pieces.size() != 5) {
            System.out.println("pause emballage");
            wait();
        }
        System.out.println("emballage");
        Jouet.NB_JOUETS++;
        //initialise collection de pièce
    }

    public int getNbJouets() {
        return NB_JOUETS;
    }

    public int getCoutProduction() {
        return this.prices;
    }
}
