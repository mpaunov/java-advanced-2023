import java.util.Collections;

public class CountingSort {
    public static void main(String[] args) {

        int[] numbers = new int[]{13, 73, 42, 69, 13, 42, 99, 69, 13};

        int[] sorting = new int[100];

        for (int n : numbers) {
            sorting[n]++;
        }

        for (int index = 0; index < sorting.length; index++) {
            if (sorting[index] != 0) {
                for (int i = 0; i < sorting[index]; i++) {
                    System.out.print(index + " ");
                }
            }
        }

    }
}
