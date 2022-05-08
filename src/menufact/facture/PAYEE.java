package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class PAYEE implements FactureEtat{

    private Facture facture;

    PAYEE(Facture facture){
        this.facture = facture;
    }

    @Override
    public void payer(){}

    @Override
    public void fermer(){}

    @Override
    public void ouvrir() throws FactureException{
        throw new FactureException("La facture ne peut pas être reouverte.");
    }

    @Override
    public void ajoutePlat(PlatChoisi p) throws FactureException{
        throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

}
