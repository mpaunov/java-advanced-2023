import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());

        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> i : interfaces) {
            System.out.println(i);
        }

        Constructor<Reflection> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Reflection reflection = constructor.newInstance();

        System.out.println(reflection);

    }

}
