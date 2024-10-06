package students;

import java.io.*;

public class Main {

    public static void processStudents(String inputFilename, int targetCourse, String courseOutputFilename,
            String countOutputFilename) throws IOException {
        int[] courseCounts = new int[11];
        BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
        BufferedWriter courseWriter = new BufferedWriter(new FileWriter(courseOutputFilename));
        BufferedWriter countWriter = new BufferedWriter(new FileWriter(countOutputFilename));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String name = parts[0];
                String surname = parts[1];
                int course = Integer.parseInt(parts[2]);

                Student student = new Student(name, surname, course);

                if (student.getCourse() == targetCourse) {
                    courseWriter.write(student.toString());
                    courseWriter.newLine();
                }
                if (course >= 1 && course <= 11) {
                    courseCounts[course - 1]++;
                }
            }
        }

        for (int i = 0; i < courseCounts.length; i++) {
            countWriter.write("Класс: " + (i + 1) + " - " + courseCounts[i] + " учеников");
            countWriter.newLine();
        }

        reader.close();
        courseWriter.close();
        countWriter.close();
    }

    public static void main(String[] args) {
        try {
            processStudents("students.txt", 3, "students_in_3nd_course.txt", "course_counts.txt");
            System.out.println("все выполнено ура");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
