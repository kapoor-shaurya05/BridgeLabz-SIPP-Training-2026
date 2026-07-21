package AdressBook;

import java.util.*;

public class AdressBookData {
    static ArrayList<Contacts> contact=new ArrayList<>();
    static HashMap<String,Contacts> contactMap=new HashMap<>();
    static HashSet<String> phoneNumber=new HashSet<>();


    public void addContact(String name, String number, String Email){
        if(phoneNumber.contains(number)){
            System.out.println("USER ALREADY EXISTS!!!!!");
            return;
        }

        Contacts user=new Contacts(name,number,Email);
        contact.add(user);
        contactMap.put(name,user);
        phoneNumber.add(number);
        System.out.println("CONTACT ADDED SUCCESSFULLY");
    }
    public void search(String name) {
        Contacts c = contactMap.get(name);
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("CONTACT WITH NAME " + name + " NOT FOUND!!!!!!!!!");
        }
    }
    public void delete(String name) {
        Contacts c=contactMap.get(name);
        if(c!=null){
                contactMap.remove(name);
                contact.remove(c);
                phoneNumber.remove(c.getPhoneNumber());

        }
        else{
                System.out.println("CONTACT WITH NAME"+name+"NOT FOUND");
        }

    }
    public void display(){
        Collections.sort(contact);
        for(Contacts contact:contact){
            System.out.println(contact);
        }
    }
}
