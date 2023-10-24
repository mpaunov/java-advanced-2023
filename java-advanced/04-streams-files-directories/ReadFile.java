import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String dir = System.getProperty("user.dir");

        String path = dir + "/04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();

        while (oneByte >= 0) {
            System.out.println(Integer.toBinaryString(oneByte) + " ");
            oneByte = inputStream.read();
        }

    }
}
