public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        Validator.validateString(name, "A name should not be empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        validateSkillPoint(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateSkillPoint(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateSkillPoint(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateSkillPoint(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateSkillPoint(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.00;
    }

    private void validateSkillPoint(int skillPoint, String statusName) {
        if (skillPoint < 0 || skillPoint > 100) {
            throw new IllegalArgumentException(statusName + " should be between 0 and 100.");
        }
    }
}
