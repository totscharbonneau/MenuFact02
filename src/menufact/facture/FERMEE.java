package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class FERMEE implements FactureEtat{
    private Facture facture;

    FERMEE(Facture facture){
        this.facture = facture;
    }

    @Override
    public void payer(){
        facture.setEtat(new PAYEE(facture));
    }

    @Override
    public void fermer(){

    }

    @Override
    public void ouvrir() throws FactureException {
        facture.setEtat(new OUVERTE(facture));
    }

    @Override
    public void ajoutePlat(PlatChoisi p) throws FactureException{
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }
}
