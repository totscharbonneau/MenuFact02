package menufact.plats;

import ingredients.Ingredient;
import ingredients.IngredientClient;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.List;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;



    private List<IngredientClient> ingredients;

    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        ingredients = new ArrayList<IngredientClient>();
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public List<IngredientClient> getIngredients() {
        return ingredients;
    }

    public void ajoutIngredient(IngredientClient nouvIngredient){ingredients.add(nouvIngredient);}

    public void retirerIngredient(IngredientClient oldIngredient){
        if(ingredients.contains(oldIngredient)){
            ingredients.remove(oldIngredient);
        }
    }

    public void retirerQuantiteRecette() throws IngredientException {
        for(IngredientClient ingredient : ingredients)
        {
            ingredient.retirerQuantiteRecette();
        }
    }
}
