package ingredients;

import ingredients.IngredientInterface;
import ingredients.Ingredient;

public class IngredientFactory {
    private static IngredientInterface INGREDIENT;

    public static IngredientInterface getIngredient(){
        if(INGREDIENT==null)
        {
            INGREDIENT = new IngredientInventaire();
        }
        return INGREDIENT;
    }
}
