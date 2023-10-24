import java.util.HashMap;
import java.util.Map;

public class StudentRepository {

    private final Map<String, Student> studentsByName;


    public StudentRepository() {
        this.studentsByName = new HashMap<>();
    }

    public void create(Student student) {
        studentsByName.putIfAbsent(student.getName(), student);
    }

    public Student get(String name) {
        return studentsByName.get(name);
    }
}
