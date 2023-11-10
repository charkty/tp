package essenmakanan.command;

import essenmakanan.exception.EssenFormatException;
import essenmakanan.exception.EssenOutOfRangeException;
import essenmakanan.ingredient.Ingredient;
import essenmakanan.ingredient.IngredientList;
import essenmakanan.ingredient.IngredientUnit;
import essenmakanan.parser.IngredientParser;
import essenmakanan.parser.ShortcutParser;
import essenmakanan.shortcut.Shortcut;
import essenmakanan.shortcut.ShortcutList;
import essenmakanan.ui.Ui;

public class UseShortcutCommand extends Command {
    
    private ShortcutList shortcuts;
    private IngredientList ingredients;
    private String input;

    public UseShortcutCommand(ShortcutList shortcuts, IngredientList ingredients, String input) {
        this.shortcuts = shortcuts;
        this.ingredients = ingredients;
        this.input = input;
    }

    @Override
    public void executeCommand() {
        Ui.drawDivider();

        try {
            Shortcut shortcut = ShortcutParser.getSpecificShortcut(shortcuts, input);
            String ingredientName = shortcut.getIngredientName();
            double quantity = shortcut.getQuantity();

            int ingredientIndex = IngredientParser.getIngredientIndex(ingredients, ingredientName);
            IngredientUnit unit = ingredients.getIngredient(ingredientIndex).getUnit();

            ingredients.updateIngredient(new Ingredient(ingredientName, quantity, unit));
        } catch (EssenOutOfRangeException exception) {
            exception.handleException();
        } catch (EssenFormatException exception) {
            exception.handleException();
        }
    }
}
