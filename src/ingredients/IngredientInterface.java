package ingredients;

import ingredients.exceptions.IngredientException;

public interface IngredientInterface {
    /**
     *
     * @return interface du flyweight de l'ingrédient
     */
    public double getQuantite();
    public void setQuantite(double quantite) throws IngredientException;
    public String getIngredientNom();
    public String getIngredientDescription();
    public TypeIngredient getIngredientTypeIngredient();
}
