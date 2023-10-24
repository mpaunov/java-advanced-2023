import java.util.Scanner;

public class StudentSystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        while (studentSystem.isRunning()) {
            String[] input = scanner.nextLine().split(" ");
            studentSystem.parseCommand(input);
        }
    }
}
