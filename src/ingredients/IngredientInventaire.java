package ingredients;

import ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private Ingredient Ingredient;
    private double quantite;

    public IngredientInventaire(Ingredient Ingredient, double quantite) {
        this.Ingredient = Ingredient;
        this.quantite = quantite;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
