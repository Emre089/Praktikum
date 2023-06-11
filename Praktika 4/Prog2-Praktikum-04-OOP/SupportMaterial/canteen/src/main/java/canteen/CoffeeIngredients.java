package canteen;

public enum CoffeeIngredients {
    FROTHED_MILK(1.5),
    FROTHED_MILK_XXL(2.0),
    MILK(1.0),
    SUGAR(0.0),
    HAZELNUT_SYRUP(0.8),
    VANILLA_SYRUP(1.2),
    CARAMEL_SYRUP(0.8),
    CHOCOLATE(1.0),
    CHOCOLATE_POWDER(0.0),
    ESPRESSO_SHOT(1.2),
    HOT_WATER(0.0);

    private double price;

    CoffeeIngredients(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
