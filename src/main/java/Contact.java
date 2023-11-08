package main.java;

import java.util.List;
import java.io.*;

class Contact implements Serializable {
    // variables storing basic information of the contact
    private String namePrefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nameSuffix;
    private String nickname;
    private List<String> phoneNumbers;
    private List<String> emails;
    private List<String> groups;
    private List<String> addresses;
    private List<String> importantDates;
    private String relationship;
    private String notes;

    // Constructor
    public Contact(String namePrefix, String firstName, String middleName, String lastName, String nameSuffix, String nickname,
                   List<String> phoneNumbers, List<String> emails, List<String> groups, List<String> addresses,
                   List<String> importantDates, String relationship, String notes) {
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nameSuffix = nameSuffix;
        this.nickname = nickname;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.groups = groups;
        this.addresses = addresses;
        this.importantDates = importantDates;
        this.relationship = relationship;
        this.notes = notes;
    }

    // get prifix
    public String getNamePrefix() {
        return namePrefix;
    }
    // get first name
    public String getFirstName() {
        return firstName;
    }
    // get middle name
    public String getMiddleName() {
        return middleName;
    }
    // get last name
    public String getLastName() {
        return lastName;
    }
    // get suffix
    public String getNameSuffix() {
        return nameSuffix;
    }
    // get nickname
    public String getNickname() {
        return nickname;
    }
    // get all phone numbers
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    // get all emails
    public List<String> getEmails() {
        return emails;
    }
    // get groups the contact is in
    public List<String> getGroups() {
        return groups;
    }
    // get adresses of the contact
    public List<String> getAddresses() {
        return addresses;
    }
    // get important dates
    public List<String> getimportantDates() {
        return importantDates;
    }
    // get relationship
    public String getRelationship() {
        return relationship;
    }
    // get notes
    public String getNotes() {
        return notes;
    }
    // update prefix
    public void updateNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }
    // update first name
    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }
    // update middle name
    public void updateMiddleName(String middleName) {
        this.middleName = middleName;
    }
    // update last name
    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }
    // update suffix
    public void updateNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }
    // update nickname
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
    // update phone numbers
    public void updatePhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    // update emails
    public void updateEmails(List<String> emails) {
        this.emails = emails;
    }
    // update groups
    public void updateGroups(List<String> groups) {
        this.groups = groups;
    }
    // update addresses
    public void updateAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
    // update important dates
    public void updateimportantDates(List<String> importantDates) {
        this.importantDates = importantDates;
    }
    // update relationship
    public void updateRelationship(String relationship) {
        this.relationship = relationship;
    }
    // update notes
    public void updateNotes(String notes) {
        this.notes = notes;
    }
    // displays all the info of the contact
    public void displayInfo() {
        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\n", "Prefix", "First Name", "Middle Name", "Last Name", "Suffix", "Nickname");
        System.out.printf("%-10s%-25s%-20s%-25s%-10s%-25s\nPhone Numbers: %s\nEmails: %s\nGroups: %s\nAdresses: %s\nImportant Dates: %s\nRelationship: %-20s Notes: %s\n", namePrefix, firstName, middleName, lastName, nameSuffix, nickname, phoneNumbers, emails, groups, addresses, importantDates, relationship, notes);
    }
}