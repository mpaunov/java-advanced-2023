import java.lang.reflect.Method;
import java.util.Comparator;

public class MethodComparator implements Comparator<Method> {

    @Override
    public int compare(Method f, Method s) {
        return f.getName().compareTo(s.getName());
    }

}
