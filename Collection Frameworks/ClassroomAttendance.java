import java.util.ArrayList;
import java.util.HashMap;

public class ClassroomAttendance {

    static HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public static void markAttendance(String subject, String student) {

        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (!students.contains(student)) {
            students.add(student);
            System.out.println(student + " marked present in " + subject);
        }
        else {
            System.out.println(student + " already marked in " + subject);
        }
    }

    public static void displayAttendance() {

        System.out.println("\nAttendance Report");

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject : " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String student : students)
                System.out.println(student);

            System.out.println("Total Students : " + students.size());
        }
    }

    public static void main(String[] args) {

        markAttendance("Java", "Shaurya");
        markAttendance("Java", "Rohit");
        markAttendance("Java", "Shaurya");

        markAttendance("DBMS", "Aman");
        markAttendance("DBMS", "Shaurya");

        displayAttendance();
    }
}