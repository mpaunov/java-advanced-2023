import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    public static class Person {
        String name;
        int age;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(", ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person();
            person.name = name;
            person.age = age;
            people.add(person);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> filter = createFilter(condition, age);
        Consumer<Person> printer = createPrinter(format);

        people.stream()
                .filter(filter)
                .forEach(printer);
    }

    private static Consumer<Person> createPrinter(String format) {
        if (format.equals("name")) {
            return p -> System.out.println(p.name);
        } else if (format.equals("age")) {
            return p -> System.out.println(p.age);
        }

        return p -> System.out.println(p.name + " - " + p.age);
    }

    private static Predicate<Person> createFilter(String condition, int age) {
        if (condition.equals("younger")) {
            return p -> p.age <= age;
        }

        return p -> p.age >= age;
    }


}
