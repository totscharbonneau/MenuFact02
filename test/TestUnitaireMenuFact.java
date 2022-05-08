import menufact.Client;
import menufact.Menu;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;
import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.*;
public class TestUnitaireMenuFact {

    PlatAuMenu p1 = new PlatAuMenu(0,"PlatAuMenu0",10);
    PlatAuMenu p2 = new PlatAuMenu(1,"PlatAuMenu1",20);
    PlatAuMenu p3 = new PlatAuMenu(2,"PlatAuMenu2",30);
    PlatAuMenu p4 = new PlatAuMenu(3,"PlatAuMenu3",40);
    PlatAuMenu p5 = new PlatAuMenu(4,"PlatAuMenu4",50);


    PlatSante ps1 = new PlatSante(10,"PlatSante0",10,11,11,11);
    PlatSante ps2 = new PlatSante(11,"PlatSante1",20,11,11,11);
    PlatSante ps3 = new PlatSante(12,"PlatSante2",30,11,11,11);
    PlatSante ps4 = new PlatSante(13,"PlatSante3",40,11,11,11);
    PlatSante ps5 = new PlatSante(14,"PlatSante4",50,11,11,11);


    Menu m1 = new Menu("menufact.Menu 1");
    Menu m2 = new Menu("menufact.Menu 2");

    Facture f1 = new Facture("Ma facture");

    Client c1 = new Client(1,"Mr Client","1234567890");

    @Test
    void firstTest() {
        assertEquals(p1.getPrix(),10);
    }
    @Test
    void TestPlatAuMenuToString(){
        assertEquals(p1.toString(),"menufact.plats.PlatAuMenu{code=0, description='PlatAuMenu0', prix=10.0}\n");
    }
    @Test
    void addPlatToFacture() throws FactureException {
        f1.ajoutePlat(new PlatChoisi(p1,1));
        assertEquals(f1.sousTotal(),10);
    }

}
