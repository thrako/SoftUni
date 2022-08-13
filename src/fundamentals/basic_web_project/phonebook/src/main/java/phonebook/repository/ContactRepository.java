package phonebook.repository;

import org.springframework.stereotype.Repository;
import phonebook.entity.Contact;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class ContactRepository {
    private final Map<String, Contact> contacts = new TreeMap<>();

    public ContactRepository() {
        this.add("Alexander", "+359 88 111 111");
        this.add("Betty", "+359 89 222 222");
        this.add("Christian", "+359 87 333 333");
    }

    public void add(String name, String number) {
        Contact contact = new Contact(name, number);
        this.contacts.put(name, contact);
    }

    public void add(Contact contact) {
        this.contacts.put(contact.getName(), contact);
    }

    public void update(Contact contact) {
        this.contacts.values().stream()
                .filter(c -> c.getName().equals(contact.getName()))
                .findFirst()
                .ifPresent(c -> c.setNumber(contact.getNumber()));
    }

    public void delete(String name) {
        this.contacts.values().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .ifPresent(present -> this.contacts.remove(name));
    }

    public ArrayList<Contact> getAllAsList() {
        return new ArrayList<>(this.contacts.values());
    }

    public AbstractList<String> getNamesAsList() {
        return new ArrayList<>(this.contacts.keySet());
    }
}
