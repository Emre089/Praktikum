package canteen;

import java.util.Arrays;
import java.util.Comparator;

public class Sandwich extends CanteenProduct implements Ratable{
    private SandwichIngredients[] ingredients;
    private int[] ratings;
    private int numberOfRatings;
    public Sandwich(String name, SandwichIngredients... ingredients) throws SandwichHasNoBreadException, SandwichHasTooFewIngredientsException {
        super(name);
        if (ingredients.length < 2) {
            throw new SandwichHasTooFewIngredientsException("Sandwich must have at least 2 ingredients.");
        }
        this.ingredients = ingredients;
        this.ratings = new int[20];
        this.numberOfRatings = 0;
        validateIngredients(); // Add this line to validate the ingredients
    }

    private void validateIngredients() throws SandwichHasNoBreadException, SandwichHasTooFewIngredientsException {
        boolean hasBread = false;
        if (ingredients.length < 2) {
            throw new SandwichHasTooFewIngredientsException("A sandwich must have at least two ingredients");
        }

        for (SandwichIngredients ingredient : ingredients) {
            if (ingredient == SandwichIngredients.BREAD || ingredient == SandwichIngredients.WHOLE_GRAIN_BREAD) {
                hasBread = true;
                break;  // Exit the loop once bread is found
            }
        }

        if (!hasBread) {
            throw new SandwichHasNoBreadException("A sandwich must have bread");
        }
    }

    @Override
    public double getPrice() {
        SandwichIngredients[] sortedIngredients = Arrays.copyOf(ingredients, ingredients.length);
        Arrays.sort(sortedIngredients, Comparator.comparingDouble(SandwichIngredients::getPrice).reversed());

        double price = 0;
        int count = Math.min(sortedIngredients.length, 4);
        for (int i = 0; i < count; i++) {
            price += sortedIngredients[i].getPrice();
        }
        return price;
    }

    public int getKcal() {
        int kcal = 0;
        for (SandwichIngredients ingredient : ingredients) {
            kcal += ingredient.getKcal();
        }
        return kcal;
    }

    @Override
    public String toString() {
        return getName() + "(" + getKcal() + " kcal)\t\t\t\t" + getPrice();
    }

    @Override
    public void rateProduct(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating should be between 1 and 5.");
        }

        if (numberOfRatings == ratings.length) {
            throw new IllegalStateException("Maximum number of ratings reached.");
        }

        ratings[numberOfRatings] = rating;
        numberOfRatings++;
    }

    @Override
    public double getAvgRating() {
        if (numberOfRatings == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int i = 0; i < numberOfRatings; i++) {
            sum += ratings[i];
        }

        return (double) sum / numberOfRatings;
    }

    @Override
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public class SandwichHasNoBreadException extends RuntimeException {
        public SandwichHasNoBreadException(String message) {
            super(message);
        }
    }

    public class SandwichHasTooFewIngredientsException extends RuntimeException {
        public SandwichHasTooFewIngredientsException(String message) {
            super(message);
        }
    }
}