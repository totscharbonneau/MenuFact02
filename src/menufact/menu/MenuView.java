package menufact.menu;

import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

public class MenuView {
    /**
     *
     * @return cree une instance du View en singleton
     */
    private static MenuView instance;
    private MenuView(){}

    public static MenuView getInstance() {
        if(instance == null){
            instance = new MenuView();
        }
        return instance;
    }
    /**
     *
     * @return description du contenu du menu
     */
    public String printDetails(String description, int courant, ArrayList<PlatAuMenu> plat) {
        return "Menu{" +
                "description='" + description +
                ", courant=" + courant +
                ", plat=" + plat +
                '}';
    }
}
