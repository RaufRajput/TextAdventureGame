package se.iths.teamsmurf;

public class Player {
    private int health;
    private Gender gender;

    public Player(int health, Gender gender) {
        this.health = health;
        this.gender = gender;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}



