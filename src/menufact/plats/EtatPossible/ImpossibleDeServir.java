package menufact.plats.EtatPossible;

import menufact.plats.PlatChoisi;
import menufact.plats.PlatChoisiEtat;

public class ImpossibleDeServir implements PlatChoisiEtat {
    PlatChoisi plat;

    ImpossibleDeServir(PlatChoisi plat){
        this.plat = plat;
    }
}
