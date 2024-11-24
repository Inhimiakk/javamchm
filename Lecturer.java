package lab_13;

public class Lecturer implements Visitor {
    private String profile;

    public Lecturer(String profile) {
        this.profile = profile;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        if (profile.equals("Гуманитарный")) {
            student.earnCredits(3);
            System.out.println("Гуманитарный студент получил 3 кредита.");
        }
    }

    @Override
    public void visit(NaturalStudent student) {
        if (profile.equals("Природничный")) {
            student.earnCredits(5);
            System.out.println("Природничный студент получил 5 кредитов.");
        }
    }

    @Override
    public void visit(MixedStudent student) {
        int credits = profile.equals("Гуманитарный") ? 3 : 5;
        student.earnCredits(credits);
        System.out.println("Смешанный студент получил " + credits + " кредитов.");
    }
}
