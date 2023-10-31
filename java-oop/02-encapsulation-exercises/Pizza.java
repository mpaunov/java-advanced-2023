import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppingsCount) {
        setName(name);
        setToppings(toppingsCount);
    }

    private void setName(String name) {
        if (name == null || name.isBlank() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int toppingsCount) {
        if (toppingsCount < 0 || toppingsCount > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppingsCount);
    }

   public String getName() {
        return name;
   }

   public void addTopping(Topping topping) {
        toppings.add(topping);
   }

   public double getOverallCalories() {
        return dough.calculateCalories() + toppings.stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();

   }

}
