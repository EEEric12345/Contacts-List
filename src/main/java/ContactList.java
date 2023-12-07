package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Class for modifying the contacts list, including downloading and uploading the contact list
public class ContactList implements Serializable {
    private static List<Contact> contacts;
    // Constructor
    public ContactList() {
        contacts = new ArrayList<>();
    }

    // add another contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // list all the contact's first name, last name, nickname
    public void listContacts() {
        System.out.printf("%-25s%-25s%-25s\n", "First Name", "Last Name", "Nickname");
        System.out.println("----------------------------------------------------------");
        for (Contact contact : contacts) {
            System.out.printf("%-25s%-25s%-25s\n", contact.getFirstName(), contact.getLastName(), contact.getNickname());
        }
    }

    // Search for a specific string in a contact's information
    public void searchContact(String toSearch) {
        boolean found = false;
        for (Contact contact : contacts) {
            String namePrefix = contact.getNamePrefix();
            String firstName = contact.getFirstName();
            String middleName = contact.getMiddleName();
            String lastName = contact.getLastName();
            String nameSuffix = contact.getNameSuffix();
            String nickname = contact.getNickname();
            List<String> phoneNumbers = contact.getPhoneNumbers();
            List<String> emails = contact.getEmails();
            List<String> groups = contact.getGroups();
            List<String> addresses = contact.getAddresses();
            List<String> importantDates = contact.getimportantDates();
            String relationship = contact.getRelationship();
            String notes = contact.getNotes();
            // Check everything not in an array
            if (namePrefix.contains(toSearch) || firstName.contains(toSearch) || 
                middleName.contains(toSearch) || lastName.contains(toSearch) || 
                namePrefix.contains(toSearch) || nameSuffix.contains(toSearch) || 
                nickname.contains(toSearch) || relationship.contains(toSearch) || 
                notes.contains(toSearch)) {
                found = true;
            } else {
                // Checks everything in an array
                for (String phoneNumber : phoneNumbers) {
                    if (phoneNumber.contains(toSearch)) {
                        found = true;
                        break;
                    }
                }
                for (String email : emails) {
                    if (email.contains(toSearch)) {
                        found = true;
                        break;
                    }
                }
                for (String group : groups) {
                    if (group.contains(toSearch)) {
                        found = true;
                        break;
                    }
                }
                for (String address : addresses) {
                    if (address.contains(toSearch)) {
                        found = true;
                        break;
                    }
                }
                for (String importantDate : importantDates) {
                    if (importantDate.contains(toSearch)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                contact.displayInfo();
            }
        }
        if (!found) { // display contact's info after found
            System.out.println("Contact NOT Found!!!");
        }
    }

    // Update a specific information for a specified contact
    public void updateContact(String firstName, String lastName) {
        Scanner scanner = new Scanner(System.in);
        
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && 
                contact.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Contact Found!");
                contact.displayInfo();

                while (true) {
                    System.out.println("What do you want to update?");
                    System.out.println("1. Prefix");
                    System.out.println("2. First Name");
                    System.out.println("3. Middle Name");
                    System.out.println("4. Last Name");
                    System.out.println("5. Suffix");
                    System.out.println("6. Nickname");
                    System.out.println("7. Phone Numbers");
                    System.out.println("8. Emails");
                    System.out.println("9. Groups");
                    System.out.println("10. Addresses");
                    System.out.println("11. Important Dates");
                    System.out.println("12. Relationship");
                    System.out.println("13. Notes");
                    System.out.println("14. Remove this Contact");
                    System.out.println("15. Quit Updating");

                    String option = scanner.next();

                    switch (option) {
                        // update prefix
                        case "1": 
                            System.out.println("Enter new prefix (press Enter to skip):");
                            contact.updateNamePrefix(scanner.next());
                            System.out.println("Successfully changed prefix!");
                            break;
                        // update first name
                        case "2":
                            System.out.println("Enter new first name:");
                            contact.updateFirstName(scanner.next());
                            System.out.println("Successfully changed first name!");
                            break;
                        // update middle name
                        case "3":
                            System.out.println("Enter new middle name (press Enter to skip):");
                            contact.updateMiddleName(scanner.next());
                            System.out.println("Successfully changed middle name!");
                            break;
                        // update last name
                        case "4":
                            System.out.println("Enter new last name:");
                            contact.updateLastName(scanner.next());
                            System.out.println("Successfully changed last name!");
                            break;
                        // update suffix
                        case "5":
                            System.out.println("Enter new suffix (press Enter to skip):");
                            contact.updateNameSuffix(scanner.next());
                            System.out.println("Successfully changed suffix!");
                            break;
                        // update nickname
                        case "6":
                            System.out.println("Enter new nickname (press Enter to skip):");
                            contact.updateNickname(scanner.next());
                            System.out.println("Successfully changed  nickname!");
                            break;
                        // update phone numbers
                        case "7":
                            System.out.println("Enter new phone numbers (comma-separated(no space in between), press Enter to skip):");
                            contact.updatePhoneNumbers(Arrays.asList(scanner.next().split("\\s*,\\s*")));
                            System.out.println("Successfully changed phone numbers!");
                            break;
                        // update emails
                        case "8":
                            System.out.println("Enter new emails (comma-separated(no space in between), press Enter to skip):");
                            contact.updateEmails(Arrays.asList(scanner.next().split("\\s*,\\s*")));
                            System.out.println("Successfully changed emails!");
                            break;
                        // update groups
                        case "9":
                            System.out.println("Enter new groups (comma-separated(no space in between), press Enter to skip):");
                            contact.updateGroups(Arrays.asList(scanner.next().split("\\s*,\\s*")));
                            System.out.println("Successfully changed groups!");
                            break;
                        case "10":
                        // update adresses
                            System.out.println("Enter new addresses (comma-separated(no space in between), press Enter to skip):");
                            contact.updateAddresses(Arrays.asList(scanner.next().split("\\s*,\\s*")));
                            System.out.println("Successfully changed address!");
                            break;
                        // update important dates
                        case "11":
                            System.out.println("Enter new important dates (comma-separated(no space in between), press Enter to skip):");
                            contact.updateimportantDates(Arrays.asList(scanner.next().split("\\s*,\\s*")));
                            System.out.println("Successfully changed important dates!");
                            break;
                        // update relationship
                        case "12":
                            System.out.println("Enter new relationship (press Enter to skip):");
                            contact.updateRelationship(scanner.next());
                            System.out.println("Successfully changed relationship!");
                            break;
                        // update notes
                        case "13":
                            System.out.print("Enter new notes (press Enter to skip):");
                            contact.updateNotes(scanner.next());
                            System.out.println("Successfully changed notes!");
                            break;
                        // remove contact
                        case "14":
                            System.out.println("You are about to remove " + firstName + " " + lastName + 
                            " from your contacts, type yes to continue, press Enter to cancel:");
                            String choice = scanner.next();
                            if ("yes".equalsIgnoreCase(choice)) {
                                contacts.remove(contact);
                                System.out.println("Contact removed successfully!");
                                return;
                            } else {
                                break;
                            }
                        // quit updating
                        case "15":
                            return;
                        default: 
                            System.out.println("Invalid option, please try again.");
                }
            }
            }
        }
        // First Name / Last Name Mismatch
        System.out.println("Contact not found!");
    }

    // Save all the contacts to a file
    public void saveContactsToFile(String filename) {
        filename += ".bin";
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(contacts);
            System.out.println("Contacts saved to " + filename);
        } catch (IOException ioe) {
            System.err.println("Error saving to file!: " + ioe.getMessage());
        }
    }

    // Load all contacts from a file
    public void loadContactsFromFile(String filename) {
        filename += ".bin";
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("File does not exist!: " + filename);
            return;
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
            List<Contact> loadedContacts = (List<Contact>) input.readObject();
            contacts = loadedContacts;
            System.out.println("Contacts loaded from " + filename);
        } catch (IOException ioe) {
            System.err.println("Error opening file!: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("File is not a valid contact file!: " + cnfe.getMessage());
        }
    }
}