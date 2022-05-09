package menufact.plats.EtatPossible;

import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class EnPreparation implements PlatChoisiEtat {
    private PlatChoisi plat;
    public EnPreparation(PlatChoisi plat){
        this.plat = plat;
    }
}
