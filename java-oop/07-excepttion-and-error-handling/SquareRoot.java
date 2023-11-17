import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int number = -1;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
        }

        if (number >= 0) {
            double sqrt = Math.sqrt(number);
            System.out.printf("%.2f%n", sqrt);
        } else {
            System.out.println("Invalid");
        }

        System.out.println("Goodbye");
    }
}
