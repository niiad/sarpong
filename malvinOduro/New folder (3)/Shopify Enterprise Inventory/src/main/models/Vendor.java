package main.models;

public class Vendor {
    String id;
    String name;
    String contact;

    String type;

    public Vendor(String id, String name, String contact, String type) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
