package menufact.plats.EtatPossible;

import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class Servi implements PlatChoisiEtat {
    PlatChoisi plat;
    Servi(PlatChoisi plat){
        this.plat = plat;
    }
}
