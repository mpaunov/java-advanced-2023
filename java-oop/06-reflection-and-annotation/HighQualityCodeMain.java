import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class HighQualityCodeMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> !m.getName().equals("toString"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(HighQualityCodeMain::filterByType)
                .forEach(m -> System.out.println(formatPrint(m)));

    }

    private static String formatPrint(Method m) {
        String postfix = m.getName().startsWith("get") ? "public!" : "private!";
        return m.getName() + " have to be " + postfix;
    }

    private static boolean filterByType(Method method) {
        return (method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers()))
                || (method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers()));
    }

}
