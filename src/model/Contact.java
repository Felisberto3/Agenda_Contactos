package model;

public class Contact {
    private String telefone;
    private String firstName;
    private String surname;
    private String email;

    public Contact(String telefone, String firstName, String surname, String email) {
        this.telefone = telefone;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "telefone: " + telefone + " \nNome: " + firstName + " " + surname + ",\nemail: " + email;
    }

}
