package ingredients;

import ingredients.exceptions.IngredientException;
import ingredients.Ingredient;

public class IngredientInventaire implements IngredientInterface{
    private Ingredient ingredient;
    private double quantite;

    public IngredientInventaire(Ingredient ingredient, double quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public IngredientInventaire() {
        this.ingredient = null;
        this.quantite = 0;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    public String getIngredientNom() {
        return ingredient.getNom();
    }

    public String getIngredientDescription() {
        return ingredient.getDescription();
    }

    public TypeIngredient getIngredientTypeIngredient() {
        return ingredient.getTypeIngredient();
    }
}
