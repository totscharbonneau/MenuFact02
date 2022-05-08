package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public interface FactureEtat {

    void payer();
    void fermer();
    void ouvrir() throws FactureException;

    void ajoutePlat(PlatChoisi p) throws FactureException;
}
