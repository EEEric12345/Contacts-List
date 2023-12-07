package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactList contactList = new ContactList();

    public static void main(String[] args) {
        boolean exit = true;
        while (exit) {
            System.out.println("\nWelcome to Contact List:");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Lookup a Contact");
            System.out.println("4. Modify/Remove a Contact");
            System.out.println("5. Save Contacts to File");
            System.out.println("6. Load Contacts from File(WARNING: Save current progress before loading another file)");
            System.out.println("7. Exit");
            System.out.println("Select an option:");
            String option = scanner.next();
            scanner.nextLine();

            switch (option) {
                // add another contact
                case "1":
                    addContact();
                    break;
                // list all the contacts
                case "2":
                    contactList.listContacts();
                    break;
                // search for a contract
                case "3":
                    System.out.println("Enter the info to lookup for:");
                    String nameToSearch = scanner.nextLine();
                    contactList.searchContact(nameToSearch);
                    break;
                // modify/remove a contract.
                case "4":
                    System.out.println("Enter the first name of the contact to update:");
                    String firstNameToUpdate = scanner.nextLine();
                    System.out.println("Enter the last name of the contact to update:");
                    String lastNameToUpdate = scanner.nextLine();
                    contactList.updateContact(firstNameToUpdate, lastNameToUpdate);
                    break;
                // save contracts to a file
                case "5":
                    System.out.println("Enter the filename for saving contacts(WARNING: Newly saved files with same filename will overwrite the existing file):");
                    String filename = scanner.nextLine();
                    contactList.saveContactsToFile(filename);
                    break;
                // load contracts from a file
                case "6":
                    System.out.println("Enter the filename to load contacts from:");
                    String name = scanner.nextLine();
                    contactList.loadContactsFromFile(name);
                    break;
                // quit
                case "7":
                    exit = false;
                    System.out.println("Exiting Contact List. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Asks user basic info for contact
    public static void addContact() {
        System.out.println("Enter name prefix (press Enter to skip):");
        String namePrefix = scanner.nextLine();
        
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter middle name (press Enter to skip):");
        String middleName = scanner.nextLine();
        
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter name suffix (press Enter to skip):");
        String nameSuffix = scanner.nextLine();
        
        System.out.println("Enter nickname (press Enter to skip):");
        String nickname = scanner.nextLine();
        
        System.out.println("Enter phone numbers (comma-separated(no space in between), press Enter to skip):");
        List<String> phoneNumbers = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.println("Enter emails (comma-separated(no space in between), press Enter to skip):");
        List<String> emails = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.println("Enter groups (comma-separated(no space in between), press Enter to skip):");
        List<String> groups = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.println("Enter addresses (comma-separated(no space in between), press Enter to skip):");
        List<String> addresses = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.println("Enter important dates (comma-separated(no space in between), recommended format YYYY-MM-DD,  press Enter to skip):");
        List<String> importantDates = Arrays.asList(scanner.nextLine().split("\\s*,\\s*"));
        
        System.out.println("Enter relationship (press Enter to skip):");
        String relationship = scanner.nextLine();
        
        System.out.println("Enter notes (press Enter to skip):");
        String notes = scanner.nextLine();
        
        Contact newContact = new Contact(namePrefix, firstName, middleName, lastName, 
                                        nameSuffix, nickname, phoneNumbers, emails, groups, 
                                        addresses, importantDates, relationship, notes);
        contactList.addContact(newContact);
        System.out.println("Contact added successfully!");
    }
}