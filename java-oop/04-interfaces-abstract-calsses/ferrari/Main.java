package ferrari;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Car car = new Ferrari(name);

        System.out.println(car);

    }

}
