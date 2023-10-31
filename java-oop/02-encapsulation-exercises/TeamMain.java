import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TeamMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Team> teams = new LinkedHashMap<>();

        while (!line.equalsIgnoreCase("end")) {

            String[] tokens = line.split(";");

            String command = tokens[0];
            String teamName = tokens[1];

            if (command.equals("Team")) {
                teams.put(teamName, new Team(teamName));
            } else if (command.equals("Add")) {
                addPlayer(teams, tokens, teamName);
            } else if (command.equals("Remove")) {
                removePlayer(teams, tokens, teamName);
            } else {
                getStatistic(teams, teamName);
            }

            line = scanner.nextLine();
        }

    }

    private static void getStatistic(Map<String, Team> teams, String teamName) {
        if (!teamExists(teams, teamName)) {
            return;
        }

        System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
    }

    private static void removePlayer(Map<String, Team> teams, String[] tokens, String teamName) {
        Team team = teams.get(teamName);
        try {
            team.removePlayer(tokens[2]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens, String teamName) {
        if (!teamExists(teams, teamName)) {
            return;
        }

        Team team = teams.get(teamName);
        try {
            Player player = new Player(
                    tokens[2],
                    Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]),
                    Integer.parseInt(tokens[5]),
                    Integer.parseInt(tokens[6]),
                    Integer.parseInt(tokens[7])
            );
            team.addPlayer(player);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean teamExists(Map<String, Team> teams, String teamName) {
        Team team = teams.get(teamName);
        if (team == null) {
            System.out.println("Team " + teamName + " does not exist.");
            return false;
        }
        return true;
    }
}
