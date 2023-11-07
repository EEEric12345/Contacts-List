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
            System.out.println("3. Lookup a Contact");
            System.out.println("4. Save Contacts to File");
            System.out.println("5. Load Contacts from File");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                // Add another contact
                case 1:
                    addContact();
                    break;
                // List all the contacts
                case 2:
                    contactList.listContacts();
                    break;
                // Search for a contract
                case 3:
                    System.out.print("Enter name to search for: ");
                    String nameToSearch = scanner.nextLine();
                    contactList.searchContact(nameToSearch);
                    break;
                // Save contracts to a file
                case 4:
                    System.out.print("Enter filename to save contacts: ");
                    String filename = scanner.nextLine();
                    contactList.saveContactsToFile(filename);
                    break;
                // Load contracts from a file
                case 5:
                    System.out.print("Enter filename to load contacts from: ");
                    String name = scanner.nextLine();
                    contactList.loadContactsFromFile(name);
                    break;
                // Quit
                case 6:
                    exit = true;
                    System.out.println("Exiting Contact List. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Asks user basic info for contact
    private static void addContact() {
        System.out.print("Enter name prefix (press Enter to skip): ");
        String namePrefix = scanner.nextLine();
        
        System.out.print("Enter first name (press Enter to skip): ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter middle name (press Enter to skip): ");
        String middleName = scanner.nextLine();
        
        System.out.print("Enter last name (press Enter to skip): ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter name suffix (press Enter to skip): ");
        String nameSuffix = scanner.nextLine();
        
        System.out.print("Enter nickname (press Enter to skip): ");
        String nickname = scanner.nextLine();
        
        System.out.print("Enter phone numbers (comma-separated, press Enter to skip): ");
        List<String> phoneNumbers = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter emails (comma-separated, press Enter to skip): ");
        List<String> emails = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter groups (comma-separated, press Enter to skip): ");
        List<String> groups = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter addresses (comma-separated, press Enter to skip): ");
        List<String> addresses = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter important dates (comma-separated, recommended format YYYY-MM-DD,  press Enter to skip): ");
        List<String> importantDates = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.print("Enter relationship (press Enter to skip): ");
        String relationship = scanner.nextLine();
        
        System.out.print("Enter notes (press Enter to skip): ");
        String notes = scanner.nextLine();
        
        Contact newContact = new Contact(namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
        contactList.addContact(newContact);
        System.out.println("Contact added successfully!");
    }
}