package menufact.facture;

import menufact.facture.FactureEtat;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class OUVERTE implements FactureEtat {

    private Facture facture;

    OUVERTE(Facture facture){
        this.facture = facture;
    }

    @Override
    public void payer(){
        for (PlatChoisi plat: facture.platchoisi) {
            plat.close();
        }
    }

    @Override
    public void fermer(){

        facture.setEtat(new FERMEE(facture));
    }

    @Override
    public void ouvrir()throws FactureException {

    }

    @Override
    public void ajoutePlat(PlatChoisi p) throws FactureException{
        facture.platchoisi.add(p);
    }

}
