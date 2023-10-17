public class Fibonacci {

    public static long[] memory;

    public static void main(String[] args) {

//        fib(x) = fib(x - 1) + fib(x - 2);
//        x = 10
//        55

        long prev = 0;
        long current = 1;
        long result = 0;

        int x = 100;

        memory = new long[x + 1];

        long beforeLoop = System.currentTimeMillis();

        for (int i = 1; i < x; i++) {
            result = current + prev;
            prev = current;
            current = result;
        }

        long afterLoop = System.currentTimeMillis();

        System.out.println(result + " -> " + (afterLoop - beforeLoop));

        long beforeRecur = System.currentTimeMillis();

        long fib = fib(x);

        long afterRecur = System.currentTimeMillis();

        System.out.println(fib + " -> " + (afterRecur - beforeRecur));
    }

    public static long fib(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        if (memory[x] != 0) {
            return memory[x];
        }

        return memory[x] = fib(x - 1) + fib(x - 2);
    }

}
