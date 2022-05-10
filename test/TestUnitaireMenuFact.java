import ingredients.exceptions.IngredientException;
import menufact.menu.Menu;
import menufact.menu.MenuView;
import menufact.menu.MenuController;
import ingredients.*;
import menufact.menu.*;
import menufact.Chef;
import menufact.Client;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import org.junit.jupiter.api.Test;


import static  org.junit.jupiter.api.Assertions.*;
public class TestUnitaireMenuFact {

    @Test
    void CreateMenu() {
        Menu m1 = Menu.getInstance("Menu 1");
        assertEquals("Menu 1", m1.getDescription());
    }

    @Test
    void testSingletonMenu() {
        Menu m1 = Menu.getInstance("Menu 1");
        m1 = Menu.getInstance("Menu 2");
        assertEquals("Menu 1", m1.getDescription());
    }

    @Test
    void testMenuMVC() {
        Menu m1 = Menu.getInstance("Menu 1");
        MenuView mv1 = MenuView.getInstance();
        MenuController mc1 = MenuController.getInstance(m1, mv1);
        assertEquals("Menu 1", mc1.getModelDescription());
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
    void PlatNormaltoString() {
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        assertEquals("menufact.plats.PlatAuMenu{" +
                "code=" + 1 +
                ", description='" + "Plat Normal" + '\'' +
                ", prix=" + 10.0 +
                "}\n", p1.toString(), "toString brokey");
    }

    @Test
    void setCodePlatNormal() {
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        p1.setCode(2);
        assertEquals(2, p1.getCode());
    }

    @Test
    void createPlatEnfant() {
        PlatEnfant p1 = PlatFactory.getPlatEnfant(1, "Plat Enfant", 5, 0.5);
        assertEquals("Plat Enfant", p1.getDescription(), "Description pas bonne");
        assertEquals(1, p1.getCode(), "Code pas bon");
        assertEquals(5, p1.getPrix(), "Prix pas bon");
        assertEquals(0.5, p1.getProportion(), "Proportion pas bonne");
    }

    @Test
    void createPlatSante() {
        PlatSante p1 = PlatFactory.getPlatSante(1, "Plat Sante", 15, 0, 0.3, 0.6);
        assertEquals("Plat Sante", p1.getDescription(), "Description pas bonne");
        assertEquals(1, p1.getCode(), "Code pas bon");
        assertEquals(15, p1.getPrix(), "Prix pas bon");
        assertEquals(0.0, p1.getKcal(), "Kcal pas bon");
        assertEquals(0.3, p1.getChol(), "Chol pas bon");
        assertEquals(0.6, p1.getGras(), "Gras pas bon");
    }

    @Test
    void ObserveurChef() {
        Chef chef1 = Chef.getInstance();
        var previoussize = chef1.getTaille();
        PlatSante p1 = PlatFactory.getPlatSante(1, "Plat Sante", 15, 0, 0.3, 0.6);
        PlatChoisi pc1 = new PlatChoisi(p1, 1);

        assertNotEquals(previoussize, chef1.getTaille());
    }

    @Test
    void CreationFactueWithDescription(){
        Facture f1 = new Facture("facture 1");
        assertNotNull(f1.getEtat());
    }

//    @Test
//    void FactureGenerer(){
//        Facture f1 = new Facture("facture 1");
//        Client c1 = new Client(1,"bob","12345678");
//        f1.associerClient(c1);
//        assertEquals("bruh",f1.genererFacture());
//    }
    @Test
    void PlatChoisiCreation(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        PlatChoisi pc1 = new PlatChoisi(p1,2);
        assertEquals("menufact.plats.PlatChoisi{" +
                "quantite=" + 2 +
                ", plat=" + p1 +
                '}', pc1.toString());
    }
    @Test
    void QuantiteIngredientAssez(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);

        p1.ajoutIngredient(patateRagout);

        PlatChoisi pc1 = new PlatChoisi(p1,1);

        assertEquals("Commande",pc1.getEtatString());
    }
    @Test
    void QuantiteIngredientPasAssez(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,6);

        p1.ajoutIngredient(patateRagout);

        PlatChoisi pc1 = new PlatChoisi(p1,2);

        assertEquals("ImpossibleDeServir",pc1.getEtatString());
    }

    @Test
    void changementEtatPlatChoisiChef(){
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        PlatChoisi pc1 = new PlatChoisi(p1,2);
        Chef chef1 = Chef.getInstance();
        chef1.startCooking(pc1);
        assertEquals("EnPreparation",pc1.getEtatString());
        chef1.startCooking(pc1);
        assertEquals("EnPreparation",pc1.getEtatString(),"EtatEnPreparation wrong changement");
    }
    @Test
    void finishCookingState() throws IngredientException {
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        PlatChoisi pc1 = new PlatChoisi(p1,2);
        Chef chef1 = Chef.getInstance();
        chef1.startCooking(pc1);
        chef1.finishCooking(pc1);
        assertEquals("Termine",pc1.getEtatString());
    }
    @Test
    void finishCookingChangeIngredientIntresic() throws IngredientException{
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");

        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);

        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);

        p1.ajoutIngredient(patateRagout);

        PlatChoisi pc1 = new PlatChoisi(p1,1);
        Chef chef1 = Chef.getInstance();
        chef1.startCooking(pc1);
        chef1.finishCooking(pc1);

        assertEquals(8,patateInventaire.getQuantite());
    }

    @Test
    void finishCookingNoChangeIngredientIntresic() throws IngredientException{
        PlatAuMenu p1 = PlatFactory.getPlatNormal(1, "Plat Normal", 10);
        Ingredient patate = new Fruit();
        patate.setDescription("des patates");
        patate.setNom("patate");
        IngredientInventaire patateInventaire = new IngredientInventaire(patate, 10);
        IngredientClient patateRagout = new IngredientClient(patateInventaire,2);
        p1.ajoutIngredient(patateRagout);
        PlatChoisi pc1 = new PlatChoisi(p1,7);
        Chef chef1 = Chef.getInstance();
        chef1.startCooking(pc1);
        chef1.finishCooking(pc1);
        assertEquals(10,patateInventaire.getQuantite());
    }
    @Test
    void StatePlatChoisiServi(){

    }

}
