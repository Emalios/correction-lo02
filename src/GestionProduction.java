import java.util.List;

public class GestionProduction {

    private int coutTotalProduction;
    private List<Jouet> jouets;


    public void calculCoutTotal() throws CoutProductionTropEleveException {
        for (Jouet jouet : this.jouets) {
            this.coutTotalProduction += jouet.getCoutProduction();
        }
        if(this.coutTotalProduction > 150) throw new CoutProductionTropEleveException();
    }

}
