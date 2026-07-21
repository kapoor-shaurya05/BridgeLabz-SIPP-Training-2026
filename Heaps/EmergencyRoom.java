import java.util.PriorityQueue;

class Patient{
    String name;
    int severity;

    Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }
}

public class EmergencyRoom{

    PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(Patient patient){
        triageQueue.offer(patient);
    }

    public Patient treatNext(){
        return triageQueue.poll();
    }

    public Patient peekNext(){
        return triageQueue.peek();
    }

    public static void main(String[] args){
        EmergencyRoom er = new EmergencyRoom();

        er.addPatient(new Patient("John", 5));
        er.addPatient(new Patient("Alice", 9));
        er.addPatient(new Patient("Bob", 7));

        while (!er.triageQueue.isEmpty()){
            Patient p = er.treatNext();
            System.out.println(p.name + " " + p.severity);
        }
    }
}