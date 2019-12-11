package se.iths.teamsmurf;

public class Item {
    private String name;
    private int damage;
    private int health;

    public Item(String name, int damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

}
