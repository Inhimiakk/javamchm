package l4dz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Patient {
    private String name;
    private String phone;
    private int number;
    private String diagnose;

    public Patient(String name, String phone, int number, String diagnose) {
        this.name = name;
        this.phone = phone;
        this.number = number;
        this.diagnose = diagnose;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumber() {
        return number;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public String toString() {
        return "Пациент {" + "Полное имя: " + name + ", " + "Телефон: " + phone + ", " + "Его номерочек: " + number + ", "+ "Название болячки: " + ", " + diagnose + "}\n";
    }
    
    public static List<Patient> findPatbyDiagnose(List<Patient> patients, String diagnose) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getDiagnose().equalsIgnoreCase(diagnose)) {
                result.add(patient);
            }
        }
        return result;
    }

    public static List<Patient> findPatientbyIntervalNumber(List<Patient> patients, int minCard, int maxCard) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getNumber() >= minCard && patient.getNumber() <= maxCard) {
                result.add(patient);
            }
        }

        result.sort(Comparator.comparing(Patient::getName));
        return result;
    }
}
