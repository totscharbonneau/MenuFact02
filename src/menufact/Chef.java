package menufact;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Chef implements EventListener {

    private static Chef instance = null;


    private ArrayList<PlatChoisi> platEnCuisine = new ArrayList<PlatChoisi>();

    private Chef(){

    }

    public static Chef getInstance(){
        if(instance == null){
            instance = new Chef();
        }
        return instance;
    }

    public int getTaille(){
        return platEnCuisine.size();
    }
    @Override
    public void update(PlatChoisi plat){
        addPlat(plat);
    }
    private void addPlat(PlatChoisi plat){
        platEnCuisine.add(plat);
    }

}
