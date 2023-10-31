import java.util.ArrayList;

public class MyBrokenList extends ArrayList<Integer> {

    @Override
    public Integer remove(int index) {
        throw new IllegalArgumentException("This class is a joke!");
    }
}
