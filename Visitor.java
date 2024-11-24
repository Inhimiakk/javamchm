package lab_13;

public interface Visitor {
    void visit(HumanitarianStudent student);

    void visit(NaturalStudent student);

    void visit(MixedStudent student);
}
