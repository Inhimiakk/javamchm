package lab_13;

public interface Student {
    void accept(Visitor visitor);

    boolean hasDiploma();
}
