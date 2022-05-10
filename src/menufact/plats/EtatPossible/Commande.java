package menufact.plats.EtatPossible;

import menufact.Chef;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class Commande implements PlatChoisiEtat {
    private PlatChoisi plat;

    public Commande(PlatChoisi plat){
        this.plat = plat;
    }

    @Override
    public String toString(){
        return "Commande";
    }

    @Override
    public void startCooking(){
        plat.setEtat(new EnPreparation(plat));
    }

    @Override
    public void finishCooking(){

    }
    @Override
    public void servir(){

    }
    @Override
    public void close(){
     plat.setEtat(new Termine(plat));
     var chef1 = Chef.getInstance();
     chef1.removePlat(plat);
    }
}
