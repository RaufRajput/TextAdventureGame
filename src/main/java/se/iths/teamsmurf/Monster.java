package se.iths.teamsmurf;

public class Monster implements CreatureManager {
    private int Health;
    private Gender gen;
    private Race race;
    public Monster(int Health,Race race){
        Health(Health);
    //    gender(gen);
        Race(race);
    }


    @Override
    public void Health(int a) {
    this.Health=a;
    }

    @Override
    public void gender(Gender gender) {
    this.gen=gender;
    }

    @Override
    public void Race(Race race) {
        this.race=race;
    }

    public String getMonsterName(){
        return this.race.name();
    }
}