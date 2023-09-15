import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String line = scanner.nextLine();

        while (!line.equals("print")) {

            if (line.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledDocument = printerQueue.poll();
                    System.out.println("Canceled " + canceledDocument);
                }
            } else {
                printerQueue.offer(line);
            }

            line = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }

    }

}
