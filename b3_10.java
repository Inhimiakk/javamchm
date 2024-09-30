package l4dz;

import java.util.List;
import java.util.ArrayList;


public class b3_10 {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Таня гав", "+380501234567", 1023, "Грип"));
        patients.add(new Patient("Катя мяу", "+380671234567", 1456, "Астма"));
        patients.add(new Patient("Рината ква", "+380931234567", 1234, "непереносимость программирования"));
        patients.add(new Patient("Віктор Середюк", "+380631234567", 1150, "++++++"));
        patients.add(new Patient("Ярослав Мусиенко", "+380991234567", 1400, "непереносимость программирования"));


        List<Patient> diagnosePatient = Patient.findPatbyDiagnose(patients, "непереносимость программирования");
        System.out.println("Пациенты с непереносимостью программирования: " + diagnosePatient);

        List<Patient> intervalPatients = Patient.findPatientbyIntervalNumber(patients, 1100, 1500);
        System.out.println("Пациенты с номерами 1100-1500 отсортированные по именам: " + intervalPatients);
    }
}
