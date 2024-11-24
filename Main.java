package lab_13;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input01.txt"));
        String specialty = reader.readLine();
        int creditsRequired = Integer.parseInt(reader.readLine().trim());
        int money = Integer.parseInt(reader.readLine().trim());


        Student student;
        switch (specialty) {
            case "Humanitarian":
                student = new HumanitarianStudent(creditsRequired, money);
                break;
            case "Natural":
                student = new NaturalStudent(creditsRequired, money);
                break;
            default:
                student = new MixedStudent(creditsRequired, money);
        }

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String action = parts[0];

            switch (action) {
                case "teach":
                    Lecturer lecturer = new Lecturer(parts[1]);
                    student.accept(lecturer);
                    break;
                case "obtain":
                    Accountant accountant = new Accountant(Integer.parseInt(parts[2]));
                    student.accept(accountant);
                    break;
                case "pay":
                    HostelManager manager = new HostelManager(Integer.parseInt(parts[2]));
                    student.accept(manager);
                    break;
            }

            if (((AbstractStudent) student).isExpelled()) {
                System.out.println("Студент был отчислен.");
                return;
            }

        }

        System.out.println(student.hasDiploma() ? "Студент получил диплом." : "Студент не получил диплом.");
    }
}
