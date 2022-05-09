package menufact.plats.EtatPossible;

import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class Commande implements PlatChoisiEtat {
    private PlatChoisi plat;

    public Commande(PlatChoisi plat){
        this.plat = plat;
    }

}
