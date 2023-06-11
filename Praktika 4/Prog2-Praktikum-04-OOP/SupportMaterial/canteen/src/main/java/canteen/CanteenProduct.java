package canteen;
import java.util.Objects;

public abstract class CanteenProduct {
    private String name;
    private CanteenProduct baseProduct;

    public CanteenProduct(String name, CanteenProduct baseProduct) {
        if (name != null) {
            this.name = name.trim();
            if (this.name.length() < 4) {
                throw new IllegalArgumentException("Name must be at least four characters long");
            }
        } else {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.baseProduct = baseProduct;
    }

    public CanteenProduct(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public CanteenProduct getBaseProduct() {
        return baseProduct;
    }

    public abstract double getPrice();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CanteenProduct other = (CanteenProduct) obj;
        return Objects.equals(name, other.name) && Objects.equals(baseProduct, other.baseProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseProduct);
    }
}