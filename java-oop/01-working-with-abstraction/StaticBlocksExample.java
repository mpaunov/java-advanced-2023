public class StaticBlocksExample {
    public static void main(String[] args) {

        System.out.println("I am main " + System.getProperties().getProperty("java.runtime.version"));
    }

    static {
        System.out.println("I am static block 1");
    }

    static {
        System.out.println("I am static block 2");
    }
}
