package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ContactList {
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
        System.out.println("--------------------------------------------------------");
        for (Contact contact : contacts) {
            System.out.printf("%-25s%-25s%-25s\n", contact.getFirstName(), contact.getLastName(), contact.getNickname());
        }
    }

    // Save all the contacts to a file
    public void saveContactsToFile(String filename) {
        filename += ".bin";
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(contacts);
            System.out.println("Contacts saved to " + filename);
        } catch (IOException ioe) {
            System.err.println("Error saving to file!");
        }
    }

    // Load all contacts from a file
    public void loadContactsFromFile(String filename) {
        filename += ".bin";
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