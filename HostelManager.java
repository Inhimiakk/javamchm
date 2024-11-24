package lab_13;

public class HostelManager implements Visitor {
    private int hostelFee;

    public HostelManager(int hostelFee) {
        this.hostelFee = hostelFee;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        student.pay(hostelFee);
        System.out.println("Гуманитарный студент оплатил общежитие на сумму " + hostelFee + " грн.");
    }

    @Override
    public void visit(NaturalStudent student) {
        student.pay(hostelFee);
        System.out.println("Природничный студент оплатил общежитие на сумму " + hostelFee + " грн.");
    }

    @Override
    public void visit(MixedStudent student) {
        student.pay(hostelFee);
        System.out.println("Половинчатый студент оплатил общежитие на сумму " + hostelFee + " грн.");
    }
}
