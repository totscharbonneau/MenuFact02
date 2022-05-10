package menufact.plats.EtatPossible;

import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class Termine implements PlatChoisiEtat {
    private PlatChoisi plat;
    public Termine(PlatChoisi plat){
        this.plat = plat;
    }
    @Override
    public String toString(){
        return "Termine";
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
        plat.setEtat(new Servi(plat));
    }
    @Override
    public void close(){

    }
}
