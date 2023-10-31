import java.util.Scanner;

public class BoxMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println(box.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
