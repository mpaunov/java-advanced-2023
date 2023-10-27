public class Person {
    private static int MIN_NAME_LENGTH = 3;
    private static int MIN_AGE = 1;
    private static int BONUS_THRESHOLD = 30;
    private static double MIN_SALARY = 460;
    private String firstName;
	private String lastName;
    private int	age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("First name cannot be less than " + MIN_NAME_LENGTH + " symbols");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name cannot be less than " + MIN_NAME_LENGTH + " symbols");
        }

        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < MIN_SALARY) {
            throw new IllegalArgumentException("Salary cannot be less than " + MIN_SALARY + " leva");
        }

        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (age < BONUS_THRESHOLD) {
            bonus = bonus / 2;
        }

        salary = salary * (1 + (bonus / 100));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", firstName, lastName, salary);
    }
}
