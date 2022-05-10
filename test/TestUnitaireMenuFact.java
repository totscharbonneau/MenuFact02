import menufact.Menu.*;
import menufact.Chef;
import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import org.junit.jupiter.api.Test;


import static  org.junit.jupiter.api.Assertions.*;
public class TestUnitaireMenuFact {

//    PlatAuMenu p1 = new PlatAuMenu(0,"PlatAuMenu0",10);
//    PlatAuMenu p2 = new PlatAuMenu(1,"PlatAuMenu1",20);
//    PlatAuMenu p3 = new PlatAuMenu(2,"PlatAuMenu2",30);
//    PlatAuMenu p4 = new PlatAuMenu(3,"PlatAuMenu3",40);
//    PlatAuMenu p5 = new PlatAuMenu(4,"PlatAuMenu4",50);
//
//
//    PlatSante ps1 = new PlatSante(10,"PlatSante0",10,11,11,11);
//    PlatSante ps2 = new PlatSante(11,"PlatSante1",20,11,11,11);
//    PlatSante ps3 = new PlatSante(12,"PlatSante2",30,11,11,11);
//    PlatSante ps4 = new PlatSante(13,"PlatSante3",40,11,11,11);
//    PlatSante ps5 = new PlatSante(14,"PlatSante4",50,11,11,11);
//
//
//    Menu m1 = new Menu("menufact.Menu 1");
//    Menu m2 = new Menu("menufact.Menu 2");
//
//    Facture f1 = new Facture("Ma facture");
//
//    Client c1 = new Client(1,"Mr Client","1234567890");

    @Test
    void CreateMenu() {
        Menu m1 = Menu.getInstance("Menu 1");
        assertEquals("Menu 1" ,m1.getDescription());
    }
    @Test
    void testSingletonMenu(){
        Menu m1 = Menu.getInstance("Menu 1");
        m1 = Menu.getInstance("Menu 2");
        assertEquals("Menu 1" ,m1.getDescription());
    }
    @Test
    void testMenuMVC(){
        Menu m1 = Menu.getInstance("Menu 1");
        MenuView mv1 = MenuView.getInstance();
        MenuController mc1 = MenuController.getInstance(m1,mv1);
        assertEquals("Menu 1" ,mc1.getModelDescription());
    }
    @Test
    void CreatePlatNormal(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1,"Plat Normal",10);
        assertEquals("Plat Normal",p1.getDescription(), "Description pas bonne");
        assertEquals(1,p1.getCode(),"Code pas bon");
        assertEquals(10,p1.getPrix(),"Prix pas bon");
    }
    @Test
    void PlatNormaltoString(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1,"Plat Normal",10);
        assertEquals("menufact.plats.PlatAuMenu{" +
                "code=" + 1 +
                ", description='" + "Plat Normal" + '\'' +
                ", prix=" + 10.0 +
                "}\n",p1.toString(),"toString brokey");
    }
    @Test
    void setCodePlatNormal(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1,"Plat Normal",10);
        p1.setCode(2);
        assertEquals(2,p1.getCode());
    }
    @Test
    void createPlatEnfant(){
        PlatEnfant p1 = PlatFactory.getPlatEnfant(1,"Plat Enfant",5,0.5);
        assertEquals("Plat Enfant",p1.getDescription(), "Description pas bonne");
        assertEquals(1,p1.getCode(),"Code pas bon");
        assertEquals(5,p1.getPrix(),"Prix pas bon");
        assertEquals(0.5,p1.getProportion(),"Proportion pas bonne");
    }
    @Test
    void createPlatSante(){
        PlatSante p1 = PlatFactory.getPlatSante(1,"Plat Sante",15,0,0.3,0.6);
        assertEquals("Plat Sante",p1.getDescription(), "Description pas bonne");
        assertEquals(1,p1.getCode(),"Code pas bon");
        assertEquals(15,p1.getPrix(),"Prix pas bon");
        assertEquals(0.0,p1.getKcal(),"Kcal pas bon");
        assertEquals(0.3,p1.getChol(),"Chol pas bon");
        assertEquals(0.6,p1.getGras(),"Gras pas bon");
    }
    @Test
    void ObserveurChef(){
        PlatSante p1 = PlatFactory.getPlatSante(1,"Plat Sante",15,0,0.3,0.6);
        PlatChoisi pc1 = new PlatChoisi(p1,1);
        Chef chef1 = Chef.getInstance();
        assertEquals(1,chef1.getTaille());
    }


//    @Test
//    void TestPlatAuMenuToString(){
//        assertEquals(p1.toString(),"menufact.plats.PlatAuMenu{code=0, description='PlatAuMenu0', prix=10.0}\n");
//    }
//    @Test
//    void addPlatToFacture() throws FactureException {
//        f1.ajoutePlat(new PlatChoisi(p1,1));
//        assertEquals(f1.sousTotal(),10);
//    }
//    @Test
//    void CreatePlatNormalAuMenu(){
//
//    }
}
