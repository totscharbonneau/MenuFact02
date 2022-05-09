package menufact.plats;
import menufact.Chef;
import menufact.plats.EtatPossible.Commande;
import menufact.plats.PlatAuMenu;

public class PlatChoisi {

    Chef chef = Chef.getInstance();
    private PlatAuMenu plat;
    private int quantite;

    private PlatChoisiEtat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        etat = new Commande(this);
        notityChef();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    private void notityChef(PlatChoisi this){
        chef.update(this);
    }
}
