import ingredients.exceptions.IngredientException;
import menufact.menu.Menu;
import menufact.menu.MenuView;
import menufact.menu.MenuController;
import ingredients.*;
import menufact.plats.PlatAuMenu;
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
    void testInventaireIngredient(){
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        assertEquals("des patates",patateInventaire.getIngredientDescription());
        assertEquals("patate",patateInventaire.getIngredientNom());
        assertEquals(TypeIngredient.FRUIT,patateInventaire.getIngredientTypeIngredient());
        assertEquals(10,patateInventaire.getQuantite());
    }

    @Test
    void testClientIngredient(){
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);

        assertEquals("des patates",patateRagout.getIngredientIntrinsicDescription());
        assertEquals("patate",patateRagout.getIngredientIntrinsicNom());
        assertEquals(TypeIngredient.FRUIT,patateRagout.getIngredientIntrinsicTypeIngredient());
        assertEquals(10,patateRagout.getIngredientIntrinsicQuantite());
        assertEquals(2,patateRagout.getQuantiteRecette());
    }

    @Test
    void testDeuxClientIngredient(){
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);

        IngredientClient patateSalade = new IngredientClient(patateInventaire,4);

        assertNotEquals(patateSalade.getQuantiteRecette(),patateRagout.getQuantiteRecette());
        assertEquals(patateRagout.getIngredientIntrinsic(),patateSalade.getIngredientIntrinsic());
    }

    @Test
    void test1Plat2Ingredient(){
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);

        Ingredient poivre = new Epice();
        poivre.setDescription("du poivre");
        poivre.setNom("poivre");

        IngredientInventaire poivreInventaire = new IngredientInventaire(poivre, 0.5);

        IngredientClient poivreRagout = new IngredientClient(poivreInventaire,0.1);

        PlatAuMenu ragout = new PlatAuMenu(1,"ragout de patate",10);
        ragout.ajoutIngredient(patateRagout);
        ragout.ajoutIngredient(poivreRagout);

        assertEquals(ragout.getIngredients().get(0),patateRagout);
        assertEquals(ragout.getIngredients().get(1),poivreRagout);

        ragout.retirerIngredient(patateRagout);

        assertEquals(ragout.getIngredients().get(0),poivreRagout);
    }

    @Test
    void test2Plats1Ingredient() throws IngredientException {
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);

        IngredientClient patateSalade = new IngredientClient(patateInventaire,4);

        PlatAuMenu ragout = new PlatAuMenu(1,"ragout de patate",10);
        ragout.ajoutIngredient(patateRagout);

        PlatAuMenu salade = new PlatAuMenu(2,"salade de patate",8);
        salade.ajoutIngredient(patateSalade);

        ragout.retirerQuantiteRecette();

        assertEquals(8,ragout.getIngredients().get(0).getIngredientIntrinsic().getQuantite());
        assertEquals(8,salade.getIngredients().get(0).getIngredientIntrinsic().getQuantite());
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
