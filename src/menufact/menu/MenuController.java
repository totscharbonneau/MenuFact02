package menufact.menu;

import menufact.menu.Menu;
import menufact.menu.MenuView;
import menufact.menu.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class MenuController {
    private Menu model;
    private MenuView view;
    /**
     *
     * @return cree une instance du Controller en singleton
     */
    private static MenuController instance;

    private MenuController(Menu model, MenuView view){
        this.model = model;
        this.view = view;
    }

    public static MenuController getInstance(Menu model, MenuView view) {
        if(instance == null){
            instance = new MenuController(model, view);
        }
        return instance;
    }

    public String getModelDescription(){return model.getDescription();}

    public int getModelCourant(){return model.getCourant();}

    public ArrayList<PlatAuMenu> getModelPlat(){return model.getPlat();}
    public void modelAjoute(PlatAuMenu plat){model.ajoute(plat);}

    public void modelPosition(int i){model.position(i);}

    public PlatAuMenu modelPlatCourant(){return model.platCourant();}

    public void modelPositionSuivante() throws MenuException {model.positionSuivante();}

    public void modelPositionPrecedente() throws MenuException {model.positionPrecedente();}

    public String viewPrintDetails(){return view.printDetails(model.getDescription(),model.getCourant(),model.getPlat());}
}
