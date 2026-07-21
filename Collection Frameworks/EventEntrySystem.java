import java.util.HashSet;

public class EventEntrySystem {

    static HashSet<String> participants = new HashSet<>();

    public static void registerParticipant(String email) {

        if (participants.add(email)) {
            System.out.println(email + " Registered Successfully.");
        }
        else {
            System.out.println("Duplicate Registration Rejected.");
        }
    }

    public static void displayParticipants() {

        System.out.println("\nRegistered Participants:");

        for (String email : participants)
            System.out.println(email);

        System.out.println("Total Attendees : " + participants.size());
    }

    public static void main(String[] args) {

        registerParticipant("abc@gmail.com");
        registerParticipant("xyz@gmail.com");
        registerParticipant("abc@gmail.com");

        displayParticipants();
    }
}