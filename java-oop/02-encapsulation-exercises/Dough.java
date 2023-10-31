import java.util.Map;

public class Dough {

    private static final Map<String, Double> FLOUR_TYPES =
            Map.of(
                    "White", 1.5,
                    "Wholegrain", 1.0
            );

    private static final Map<String, Double> BACKING_TECHNIQUES =
            Map.of(
                    "Crispy", 0.9,
                    "Chewy", 1.1,
                    "Homemade", 1.0
            );

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPES.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BACKING_TECHNIQUES.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
       return  2 * weight * FLOUR_TYPES.get(flourType) * BACKING_TECHNIQUES.get(bakingTechnique);
    }
}
