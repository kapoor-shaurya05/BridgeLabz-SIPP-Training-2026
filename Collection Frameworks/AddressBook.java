import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name : " + name +
                "\nPhone : " + phone +
                "\nEmail : " + email + "\n";
    }
}

public class AddressBook {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, Contact> map = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();

    public static void addContact(String name, String phone, String email) {

        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number not allowed.\n");
            return;
        }

        Contact c = new Contact(name, phone, email);

        contacts.add(c);
        map.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added Successfully.\n");
    }

    public static void searchContact(String name) {

        if (map.containsKey(name)) {
            System.out.println(map.get(name));
        }
        else {
            System.out.println("Contact not found.\n");
        }
    }

    public static void deleteContact(String name) {

        Contact c = map.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact Deleted.\n");
        }
        else {
            System.out.println("Contact Not Found.\n");
        }
    }

    public static void displayContacts() {

        Collections.sort(contacts, (a, b) -> a.name.compareToIgnoreCase(b.name));

        for (Contact c : contacts)
            System.out.println(c);
    }

    public static void main(String[] args) {

        addContact("Shaurya", "9876543210", "s@gmail.com");
        addContact("Rohit", "9123456789", "r@gmail.com");
        addContact("Aman", "9876543210", "a@gmail.com");

        searchContact("Rohit");
        deleteContact("Shaurya");
        displayContacts();
    }
}