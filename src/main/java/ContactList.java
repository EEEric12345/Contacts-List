package main.java;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\n", "Prefix", "First Name", "Middle Name", "Last Names", "Suffix", "Nickname");
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
            if (namePrefix.contains(toSearch) || firstName.contains(toSearch) || middleName.contains(toSearch) || lastName.contains(toSearch) || namePrefix.contains(toSearch) || nameSuffix.contains(toSearch) || nickname.contains(toSearch) || relationship.contains(toSearch) || notes.contains(toSearch)) {
                System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-25s Notes: ", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
            } else {
                for (String phoneNumber : phoneNumbers) {
                    if (phoneNumber.contains(toSearch)) {
                        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-20s Notes: ", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
                        break;
                    }
                }
                for (String email : emails) {
                    if (email.contains(toSearch)) {
                        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-20s Notes: ", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
                        break;
                    }
                }
                for (String group : groups) {
                    if (group.contains(toSearch)) {
                        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-20s Notes: ", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
                        break;
                    }
                }
                for (String address : addresses) {
                    if (address.contains(toSearch)) {
                        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-20s Notes: ", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
                        break;
                    }
                }
                for (String importantDate : importantDates) {
                    if (importantDate.contains(toSearch)) {
                        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-20s Notes: ", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
                        break;
                    }
                }
            }
        }
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