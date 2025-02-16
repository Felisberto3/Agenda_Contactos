package controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonIOException;

import model.AgendaModel;
import model.Contact;

public class AgendaController {

    public void showLista() throws JsonIOException, IOException {
        System.out.println("============= Lista Telefonica ================");
        List<Contact> contacts = AgendaModel.allContacts();
        for (Contact contact : contacts) {
            System.out.println(contact + "\n");
        }
    }

    public void addContact(Scanner scan) throws JsonIOException, IOException {

        System.out.println("====== Adicionar Contactos ============");
        System.out.println("NOTA: Para adicionar contactos voçê, informe os seguintes dados. \n");
        System.out.print("Primeiro Nome: ");
        String firstNome = scan.next();
        System.out.println();

        System.out.print("Sobrenome: ");
        String surname = scan.next();
        System.out.println();

        System.out.print("Telefone: ");
        String contact = scan.next();
        System.out.println();

        System.out.print("Email: ");
        String email = scan.next();

        Contact newContact = new Contact(contact, firstNome, surname, email);

        if (AgendaModel.save(newContact))
            System.out.println("SALVO COM SUCESSO ✨✨✨");
    }

    public void deleteContact(Scanner scan) throws JsonIOException, IOException {

        System.out.println("====== Deletar Contacto ============");
        System.out.print("Informe o telefone:  \n");

        String telefone = scan.next();

        AgendaModel.delete(telefone);

        System.out.println("CONTACTO DELETADO COM SUCESSO ✨✨✨");
    }

    public void updateContacts(Scanner scan) throws JsonIOException, IOException {
        System.out.println("============= Actualizar a Lista Telefonica ===========");
        System.out.println("Nota: Informe os campas a actualizar, ");
        System.out.println("caso não houver necessidade basta clicar na tecla '.' e 'enter'");

        System.out.print("Telofone a ser actualizado: ");
        String telefone = scan.next();
        System.out.println();

        System.out.print("Primeiro Nome: ");
        String firstNome = scan.next();
        System.out.println();

        System.out.print("Sobrenome: ");
        String surname = scan.next();

        System.out.print("Telefone: ");
        String contact = scan.next();
        System.out.println();

        System.out.print("Email: ");
        String email = scan.next();

        Contact olderContact = AgendaModel.get(telefone);
        if (olderContact == null) {
            System.out.println(" 😥😭😭 Numero de Tefone não foi encontrado no nosso banco de dados. 😥😭😭");
            return;
        }

        firstNome = firstNome.trim().equals(".") ? olderContact.getFirstName() : firstNome.trim();
        surname = surname.trim().equals(".") ? olderContact.getSurname() : surname.trim();
        contact = (contact.trim().length() < 9 || contact.trim().equals(".")) ? olderContact.getTelefone()
                : contact.trim();
        email = email.trim().equals(".") ? olderContact.getEmail() : email.trim();

        Contact newContact = new Contact(contact, firstNome, surname, email);

        AgendaModel.update(telefone, newContact);

        System.out.println("SALVO COM SUCESSO ✨✨✨");

    }
}