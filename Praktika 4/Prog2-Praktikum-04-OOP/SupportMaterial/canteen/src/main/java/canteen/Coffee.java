package canteen;
import java.util.Arrays;


public class Coffee extends CanteenProduct {
    private CoffeeIngredients[] ingredients;

    public Coffee(String name, Coffee baseProduct, CoffeeIngredients... ingredients) {
        super(name, baseProduct);
        this.ingredients = ingredients;
        validateIngredients();
    }

    public Coffee(String name, CoffeeIngredients... ingredients) {
        this(name, null, ingredients);
    }

    private void validateIngredients() {
        if (ingredients.length == 0) {
            throw new IllegalArgumentException("At least one ingredient should be specified");
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (getBaseProduct() != null) {
            price += getBaseProduct().getPrice();
        }
        for (CoffeeIngredients ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return getName() + "\t\t\t\t" + getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coffee)) {
            return false;
        }
        Coffee other = (Coffee) obj;
        return this.getName().equals(other.getName())
                && Arrays.equals(this.getIngredients(), other.getIngredients()); // Consider ingredient order
    }

    public CoffeeIngredients[] getIngredients() {
        return ingredients;
    }
}