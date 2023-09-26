import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAgeWithMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(", ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Map.Entry<String, Integer>> filter = createFilter(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        people.entrySet().stream()
                .filter(filter)
                .forEach(printer);
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        if (format.equals("name")) {
            return e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            return e -> System.out.println(e.getValue());
        }

        return e -> System.out.println(e.getKey() + " - " + e.getValue());
    }

    private static Predicate<Map.Entry<String, Integer>> createFilter(String condition, int age) {
        if (condition.equals("younger")) {
            return e -> e.getValue() <= age;
        }

        return e -> e.getValue() >= age;
    }


}
