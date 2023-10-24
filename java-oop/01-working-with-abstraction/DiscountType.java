public enum DiscountType {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1.00);

    private final double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public static DiscountType fromString(String discountType) {
        switch (discountType) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown discount type " + discountType);
        }
    }
}
