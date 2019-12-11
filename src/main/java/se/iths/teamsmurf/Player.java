package se.iths.teamsmurf;

public class Player {
    private int health;
    private Gender gender;
    boolean Excaliber;
    boolean GoldenShield;
    boolean HolyKnightArmor;
    boolean HolyKnightBoots;

    public Player(int health) {
        this.health = health;
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



