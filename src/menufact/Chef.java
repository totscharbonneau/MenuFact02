package menufact;

import ingredients.IngredientClient;
import ingredients.exceptions.IngredientException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.List;

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
        if(plat.getEtatString() != "ImpossibleDeServir"){
            addPlat(plat);
        }
    }
    private void addPlat(PlatChoisi plat){
        platEnCuisine.add(plat);
    }

    public void startCooking(PlatChoisi plat){
        plat.startCooking();
    }

    public void finishCooking(PlatChoisi plat) throws IngredientException {
        plat.finishCooking();
        if(plat.getEtatString() == "Termine"){
            List<IngredientClient> ingredients = plat.getPlat().getIngredients();

            for (IngredientClient ingredient : ingredients) {
                ingredient.setQuantiteIntrinsic(ingredient.getIngredientIntrinsicQuantite()-ingredient.getQuantiteRecette()*plat.getQuantite());
            }
        }
    }

    public void removePlat(PlatChoisi plat){
        platEnCuisine.remove(plat);
    }
}
