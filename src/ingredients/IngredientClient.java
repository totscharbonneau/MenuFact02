package ingredients;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;

public class IngredientClient {

    private final double quantiteRecette;

    private IngredientInventaire ingredientIntrinsic;

    /**
     *
     * @param ingredientIntrinsic IngredientClient contient un IngredentInventaire, la partie intrinseque
     * @param quantiteRecette IngredientClient contient une quantite pour la recette, la partie extrinseque
     */
    public IngredientClient(IngredientInventaire ingredientIntrinsic, double quantiteRecette)
    {
        this.ingredientIntrinsic = ingredientIntrinsic;
        this.quantiteRecette = quantiteRecette;
    }

    public String getIngredientIntrinsicNom() {
        return ingredientIntrinsic.getIngredientNom();
    }

    public String getIngredientIntrinsicDescription() {
        return ingredientIntrinsic.getIngredientDescription();
    }

    public TypeIngredient getIngredientIntrinsicTypeIngredient() {
        return ingredientIntrinsic.getIngredientTypeIngredient();
    }

    public double getIngredientIntrinsicQuantite(){return ingredientIntrinsic.getQuantite();}

    public double getQuantiteRecette() {
        return quantiteRecette;
    }

    public void setQuantiteIntrinsic(double quantite) throws IngredientException {
        ingredientIntrinsic.setQuantite(quantite);
    }
}