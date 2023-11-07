package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactList contactList = new ContactList();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to Contact List:");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Find a Contact by Name");
            System.out.println("4. Save Contacts to File");
            System.out.println("5. Load Contacts from File");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    contactList.listContacts();
                    break;
                case 3:
                    findContact();
                    break;
                case 4:
                    saveContacts();
                    break;
                case 5:
                    loadContacts();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting Contact List. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    private static void addContact() {
        System.out.print("Enter name prefix: ");
        String namePrefix = scanner.nextLine();
        
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter middle name (or press Enter to skip): ");
        String middleName = scanner.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter name suffix (or press Enter to skip): ");
        String nameSuffix = scanner.nextLine();
        
        System.out.print("Enter nickname (or press Enter to skip): ");
        String nickname = scanner.nextLine();
        
        System.out.print("Enter phone numbers (comma-separated): ");
        List<String> phoneNumbers = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter emails (comma-separated): ");
        List<String> emails = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter groups (comma-separated, or press Enter to skip): ");
        List<String> groups = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter addresses (comma-separated, or press Enter to skip): ");
        List<String> addresses = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter important dates (comma-separated, format YYYY-MM-DD, or press Enter to skip): ");
        List<String> importantDates = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter relationship (or press Enter to skip): ");
        String relationship = scanner.nextLine();
        
        System.out.print("Enter notes (or press Enter to skip): ");
        String notes = scanner.nextLine();
        
        Contact newContact = new Contact(namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
        contactList.addContact(newContact);
        System.out.println("Contact added successfully!");
    }

    private static void findContact() {
        System.out.print("Enter name to search for: ");
        String nameToSearch = scanner.nextLine();
        // Assuming you have a method to search by name
        // You would implement search logic in the ContactList class
        contactList.searchContact(nameToSearch);
    }

    private static void saveContacts() {
        System.out.print("Enter filename to save contacts: ");
        String filename = scanner.nextLine();
        contactList.saveContactsToFile(filename);
    }

    private static void loadContacts() {
        System.out.print("Enter filename to load contacts from: ");
        String filename = scanner.nextLine();
        contactList.loadContactsFromFile(filename);
    }
}
