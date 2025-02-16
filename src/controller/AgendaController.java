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
}