package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonIOException;

import model.AgendaModel;
import model.Contact;

public class MainManu {

    static public int menu(Scanner scan) {
        System.out.println("================= MENU =================");
        System.out.println("1. Lista Telefonica");
        System.out.println("2. Adicionar Contactos");
        System.out.println("3. Actualizar Contactos");
        System.out.println("4. Deletar Contactos");
        System.out.println("0. Sair da App");
        return scan.nextInt();

    }

    static public void showLista() throws JsonIOException, IOException {
        System.out.println("============= Lista Telefonica ================");
        List<Contact> contacts = AgendaModel.allContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }

    }

}