package lab_13;

public class NaturalStudent extends AbstractStudent {
    public NaturalStudent(int creditsRequired, int money) {
        super("Природничный", creditsRequired, money);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
