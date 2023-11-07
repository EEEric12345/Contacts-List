package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ContactList {
    private List<Contact> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the list.");
        } else {
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getFirstName() + " " +
                        (contact.getMiddleName() != null ? contact.getMiddleName() + " " : "") +
                        contact.getLastName());
                System.out.println("Nickname: " + contact.getNickname());
                System.out.println("Phones: " + String.join(", ", contact.getPhoneNumbers()));
                System.out.println("Emails: " + String.join(", ", contact.getEmails()));
                System.out.println("Groups: " + String.join(", ", contact.getGroups()));
                System.out.println("Addresses: " + String.join(", ", contact.getAddresses()));
                System.out.println("Important Dates: " + String.join(", ", contact.getimportantDates()));
                System.out.println("Relationship: " + contact.getRelationship());
                System.out.println("Notes: " + contact.getNotes());
                System.out.println("----------------------------------");
            }
        }
    }
    

    public void saveContactsToFile(String filename) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(contacts);
            System.out.println("Contacts saved to " + filename);
        } catch (IOException ioe) {
            System.err.println("Error saving to file!");
        }
    }

    public void loadContactsFromFile(String filename) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
            List<Contact> loadedContacts = (List<Contact>) input.readObject();
            contacts = loadedContacts;
            System.out.println("Contacts loaded from " + filename);
        } catch (IOException ioe) {
            System.err.println("Error opening file!");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("File is not a valid contact file!");
        }
    }
}