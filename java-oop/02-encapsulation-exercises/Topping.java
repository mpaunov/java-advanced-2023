import java.util.Map;

public class Topping {

    private static final Map<String, Double> TOPPINGS_DATA =
            Map.of(
                    "Meat", 1.2,
                    "Veggies", 0.8,
                    "Cheese", 1.1,
                    "Sauce", 0.9
            );

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!TOPPINGS_DATA.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * TOPPINGS_DATA.get(toppingType);
    }

}
