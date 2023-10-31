public class Product implements Identity {

    private String name;
    private double cost;

    public Product(String name, double cost) {
       setName(name);
       setCost(cost);
    }

    private void setName(String name) {
        Validator.validateString(name);
        this.name = name;
    }

    private void setCost(double cost) {
        Validator.validateValueNonNegative(cost);
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
