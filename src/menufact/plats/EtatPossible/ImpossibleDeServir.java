package menufact.plats.EtatPossible;

import menufact.Chef;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class ImpossibleDeServir implements PlatChoisiEtat {
    PlatChoisi plat;

    public ImpossibleDeServir(PlatChoisi plat){
        this.plat = plat;
    }

    @Override
    public String toString(){
        return "ImpossibleDeServir";
    }
    @Override
    public void startCooking(){
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
