package menufact.plats;
import ingredients.IngredientClient;
import menufact.Chef;
import menufact.facture.Facture;
import menufact.plats.EtatPossible.*;
import menufact.plats.PlatAuMenu;

import java.util.List;

public class PlatChoisi {

    Chef chef = Chef.getInstance();
    private PlatAuMenu plat;
    private int quantite;

    private PlatChoisiEtat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        if(checkIngredientAvailability() == true){
            etat = new Commande(this);
        }
        else{
            etat = new ImpossibleDeServir(this);
        }

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

    public PlatChoisiEtat getEtat(){
        return etat;
    }
    public void setEtat(PlatChoisiEtat etat){
        this.etat = etat;
    }

    private Boolean checkIngredientAvailability(){

        boolean ok = true;

        List<IngredientClient> ingredients = plat.getIngredients();

        for (IngredientClient ingredient : ingredients) {
            if(ingredient.getQuantiteRecette()*quantite > ingredient.getIngredientIntrinsicQuantite()){
                ok = false;
            }
        }


        return ok;
    }
    public String getEtatString(){
        return etat.toString();
    }

    public void startCooking(){
        etat.startCooking();
    }
    public void finishCooking(){
        etat.finishCooking();
    }
    public void servir(){
        etat.servir();
    }
    public void close(){
        etat.close();
    }
}
