package lab_13;

public class HumanitarianStudent extends AbstractStudent {
    public HumanitarianStudent(int creditsRequired, int money) {
        super("Гуманитарный", creditsRequired, money);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
