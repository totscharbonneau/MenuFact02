package menufact.plats.EtatPossible;

import menufact.Chef;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class EnPreparation implements PlatChoisiEtat {
    private PlatChoisi plat;
    public EnPreparation(PlatChoisi plat){
        this.plat = plat;
    }

    @Override
    public String toString(){
        return "EnPreparation";
    }

    @Override
    public void startCooking(){
    }

    @Override
    public void finishCooking(){
        plat.setEtat(new Termine(plat));
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
