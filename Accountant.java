package lab_13;

public class Accountant implements Visitor {
    private int scholarshipAmount;

    public Accountant(int scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        student.money += scholarshipAmount;
        System.out.println("Гуманитарный студент получил стипендию " + scholarshipAmount + " грн.");
    }

    @Override
    public void visit(NaturalStudent student) {
        student.money += scholarshipAmount;
        System.out.println("Природничный студент получил стипендию " + scholarshipAmount + " грн.");
    }

    @Override
    public void visit(MixedStudent student) {
        student.money += scholarshipAmount;
        System.out.println("Половинчатый студент получил стипендию " + scholarshipAmount + " грн.");
    }
}
