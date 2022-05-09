package menufact.plats.EtatPossible;

import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class Termime implements PlatChoisiEtat {
    private PlatChoisi plat;
    Termime(PlatChoisi plat){
        this.plat = plat;
    }
}
