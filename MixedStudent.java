package lab_13;

public class MixedStudent extends AbstractStudent {
    public MixedStudent(int creditsRequired, int money) {
        super("Половинчатый", creditsRequired, money);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
