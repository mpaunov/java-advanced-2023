public class StudentSystem {
    private StudentRepository studentRepository;
    private CommandRepository commandRepository;
    private boolean running;

    public StudentSystem() {
        this.studentRepository = new StudentRepository();
        this.commandRepository = new CommandRepository(studentRepository);
        this.running = true;
    }

    public void parseCommand(String[] args) {
        String command = args[0];
        String result = commandRepository.get(command).apply(args);

        if (command.equals("Show")) {
            System.out.println(result);
        } else if (command.equals("Exit")) {
            running = Boolean.parseBoolean(result);
        }
    }

    public boolean isRunning() {
        return running;
    }
}
