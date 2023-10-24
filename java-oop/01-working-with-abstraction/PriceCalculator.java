public class PriceCalculator {
    private final double pricePerDay;
    private final int numberOfDays;
    private final Season season;
    private final DiscountType discountType;


    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculatePrice() {
        return pricePerDay * numberOfDays * season.getFactor() * discountType.getDiscount();
    }

}
