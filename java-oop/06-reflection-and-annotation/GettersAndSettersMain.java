import java.lang.reflect.*;
import java.util.Arrays;

public class GettersAndSettersMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(m -> System.out.println(formatMethodInfo(m)));
    }

    public static String formatMethodInfo(Method m) {
        if (m.getName().startsWith("get")) {
            return m.getName() + " will return class " + m.getReturnType().getName();
        }

        return m.getName() + " and will set field of class " + m.getParameterTypes()[0].getName();
    }

}
