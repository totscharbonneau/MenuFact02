package menufact.facture;

import menufact.facture.FactureEtat;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class OUVERTE implements FactureEtat {

    private Facture facture;

    OUVERTE(Facture facture){
        this.facture = facture;
    }

    @Override
    public void payer(){
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
