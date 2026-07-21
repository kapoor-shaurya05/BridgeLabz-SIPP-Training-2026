import java.util.*;

class Patient {

    int priority;
    String name;

    Patient(int priority, String name) {

        this.priority = priority;
        this.name = name;
    }
}

public class HospitalER {

    PriorityQueue<Patient> triageQueue =
            new PriorityQueue<>((a, b) -> a.priority - b.priority);

    // Admit Patient
    public void admitPatient(Patient p) {

        triageQueue.offer(p);
    }

    // Serve Patient
    public Patient callNextPatient() {

        if (triageQueue.isEmpty()) {
            return null;
        }

        return triageQueue.poll();
    }

    public static void main(String[] args) {

        HospitalER er = new HospitalER();

        er.admitPatient(new Patient(3, "Rahul"));
        er.admitPatient(new Patient(1, "Aman"));
        er.admitPatient(new Patient(2, "Riya"));

        System.out.println(er.callNextPatient().name);
        System.out.println(er.callNextPatient().name);
    }
}