public class Student {
    private static final double EXCELLENT_GRADE_LOWER_BOUND = 5.00;
    private static final double AVG_GRADE_LOWER_BOUND = 3.50;
    private final String name;
    private final int age;
    private final double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old.", name, age) + getGradeCommentary();
    }

    private String getGradeCommentary() {
        if (grade >= EXCELLENT_GRADE_LOWER_BOUND) {
            return " Excellent student.";
        } else if (grade < EXCELLENT_GRADE_LOWER_BOUND && grade >= AVG_GRADE_LOWER_BOUND) {
            return " Average student.";
        }

        return " Very nice person.";
    }
}
