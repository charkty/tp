package essenmakanan.command;

import essenmakanan.ingredient.Ingredient;
import essenmakanan.ingredient.IngredientList;

public class AddIngredientCommand extends Command{
    private String toAdd;
    private IngredientList ingredients;

    public AddIngredientCommand(String toAdd, IngredientList ingredients) {
        super();
        this.toAdd = toAdd;
        this.ingredients = ingredients;
    }

    public String parseIngredientTitle(String input) {
        return input.replace("i/", "");
    }

    @Override
    public void executeCommand() {
        String ingredientTitle = parseIngredientTitle(toAdd);
        Ingredient newIngredient = new Ingredient(ingredientTitle);
        ingredients.addIngredient(newIngredient);
        ui.showRecentAddedIngredient(ingredientTitle);
    }
}
