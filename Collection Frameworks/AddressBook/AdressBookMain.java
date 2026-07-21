package AdressBook;

import java.util.Scanner;

public class AdressBookMain {

    public void choices() {

        System.out.println("---------------------------------------");
        System.out.println("WELCOME TO ADDRESS BOOK");

        AdressBookData adressBook = new AdressBookData();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add New Contact\n2. Search Contact\n3. Delete Contact\n4. Display Sorted Contacts\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Contact Name: ");
                    String name = sc.next();

                    System.out.print("Enter Phone Number: ");
                    String number = sc.next();

                    System.out.print("Enter Email Address: ");
                    String email = sc.next();

                    adressBook.addContact(name, number, email);
                    break;
                }

                case 2: {
                    System.out.print("Enter Contact Name: ");
                    String name = sc.next();

                    adressBook.search(name);
                    break;
                }

                case 3: {
                    System.out.print("Enter Contact Name: ");
                    String name = sc.next();

                    adressBook.delete(name);
                    break;
                }

                case 4: {
                    adressBook.display();
                    break;
                }

                case 5:
                    System.out.println("Thank you for using Address Book!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void main(String[] args) {
        AdressBookMain obj = new AdressBookMain();
        obj.choices();
    }
}