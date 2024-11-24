package lab_13;

public abstract class AbstractStudent implements Student {
    protected String specialty;
    protected int creditsRequired;
    protected int creditsEarned;
    protected int money;
    protected boolean expelled;

    public AbstractStudent(String specialty, int creditsRequired, int money) {
        this.specialty = specialty;
        this.creditsRequired = creditsRequired;
        this.creditsEarned = 0;
        this.money = money;
        this.expelled = false;
    }

    public boolean hasDiploma() {
        return !expelled && creditsEarned >= creditsRequired;
    }

    public boolean isExpelled() {
        return expelled;
    }

    public void pay(int amount) {
        if (money >= amount) {
            money -= amount;
        } else {
            expelled = true;
        }
    }

    public void earnCredits(int credits) {
        creditsEarned += credits;
    }
}
