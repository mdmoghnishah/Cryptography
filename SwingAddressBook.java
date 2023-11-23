package cns;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.toString().toLowerCase().contains(name.toLowerCase())) {
                return contact;
            }
        }
        return null;
    }

    public ArrayList<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}

class AddressBookUI extends JFrame {
    private AddressBook addressBook = new AddressBook();

    private JTextField nameField = new JTextField(20);
    private JTextField phoneField = new JTextField(20);
    private JTextField emailField = new JTextField(20);
    private JTextArea resultArea = new JTextArea(10, 30);

    public AddressBookUI() {
        setTitle("Address Book System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton = new JButton("Add Contact");
        JButton removeButton = new JButton("Remove Contact");
        JButton searchButton = new JButton("Search Contact");
        JButton displayButton = new JButton("Display All Contacts");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();

                Contact newContact = new Contact(name, phone, email);
                addressBook.addContact(newContact);

                clearFields();
                displayResult("Contact added: " + newContact);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Contact contactToRemove = addressBook.searchContact(name);

                if (contactToRemove != null) {
                    addressBook.removeContact(contactToRemove);
                    clearFields();
                    displayResult("Contact removed: " + contactToRemove);
                } else {
                    displayResult("Contact not found: " + name);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Contact foundContact = addressBook.searchContact(name);

                if (foundContact != null) {
                    clearFields();
                    displayResult("Contact found: " + foundContact);
                } else {
                    displayResult("Contact not found: " + name);
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
                displayResult("All Contacts:\n" + addressBook.getAllContacts());
            }
        });

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchButton);
        panel.add(displayButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    private void displayResult(String result) {
        resultArea.setText(result);
    }
}

public class SwingAddressBook {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddressBookUI addressBookUI = new AddressBookUI();
            addressBookUI.pack();
            addressBookUI.setVisible(true);
        });
    }
}

