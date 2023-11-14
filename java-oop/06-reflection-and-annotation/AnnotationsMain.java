import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationsMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<MyAnnotationExample> clazz = MyAnnotationExample.class;

        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();

        Subject annotation = clazz.getAnnotation(Subject.class);

        String[] categories = annotation.categories();

        MyAnnotationExample myAnnotationExample = new MyAnnotationExample();

        Field field = clazz.getDeclaredField("dbEndpoint");
        field.setAccessible(true);
        FieldValue annotationOfField = field.getAnnotation(FieldValue.class);
        field.set(myAnnotationExample, annotationOfField.value());

        Class<Reflection> reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .filter(m -> m.getAnnotation(Author.class) != null)
                .forEach(m -> System.out.println(m.getAnnotation(Author.class).value()
                + ": " + m.getName()));

    }
}
