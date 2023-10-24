public class Rectangle {

    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeft = new Point(bottomLeftX, bottomLeftY);
        this.topRight = new Point(topRightX, topRightY);
    }

    public boolean contains(Point point) {
        return point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()
                && point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
    }

}
