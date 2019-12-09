
public class Player implements PlayerManager {

    private Gender gender;

    @Override
    public void Health(int a) {

    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
