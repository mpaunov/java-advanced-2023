import java.util.Map;
import java.util.function.Function;

public class CommandRepository {
    private Map<String, Function<String[], String>> commandByName;
    private StudentRepository studentRepository;

    public CommandRepository(StudentRepository studentRepository) {
        this.commandByName = setUpCommands();
        this.studentRepository = studentRepository;
    }

    private Map<String, Function<String[], String>> setUpCommands() {

        Function<String[], String> create = arr -> {
            String name = arr[1];
            int age = Integer.parseInt(arr[2]);
            double grade = Double.parseDouble(arr[3]);

            Student student = new Student(name, age, grade);

            studentRepository.create(student);
            return "Student with " + name + " created";
        };

        Function<String[], String> show = arr -> {
            String name = arr[1];

            Student student = studentRepository.get(name);
            return student == null
                    ? "No student with name " + name + " found"
                    : student.toString();
        };

        return Map.of("Create", create, "Show", show, "Exit", arr -> "false" );

    }

    public Function<String[], String> get(String command) {
        return commandByName.get(command);
    }
}
