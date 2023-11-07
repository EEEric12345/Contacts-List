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
        // Finish this method
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