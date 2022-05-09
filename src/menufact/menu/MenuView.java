package menufact.menu;

import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

public class MenuView {
    /**
     *
     * @return description du contenu du menu
     */
    private static MenuView instance;
    private MenuView(){}

    public static MenuView getInstance() {
        if(instance == null){
            instance = new MenuView();
        }
        return instance;
    }

    public String printDetails(String description, int courant, ArrayList<PlatAuMenu> plat) {
        return "Menu{" +
                "description='" + description +
                ", courant=" + courant +
                ", plat=" + plat +
                '}';
    }
}
