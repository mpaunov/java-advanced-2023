import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        UnaryOperator<String> priceWithVAT =
                s -> String.format("%.2f", Double.parseDouble(s) * 1.2);

        Arrays.stream(scanner.nextLine().split(", "))
                .map(priceWithVAT)
                .forEach(System.out::println);
    }
}
