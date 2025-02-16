package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonIOException;

import controller.AgendaController;
import model.AgendaModel;
import model.Contact;

public class MainManu {
    AgendaController agendaController = new AgendaController();
    Scanner scan = new Scanner(System.in);

    public void firstMenu() throws JsonIOException, IOException {
        System.out.println("================= MENU =================");
        System.out.println("1. Lista Telefonica");
        System.out.println("2. Adicionar Contactos");
        System.out.println("3. Actualizar Contactos");
        System.out.println("4. Deletar Contactos");
        System.out.println("0. Sair da App");
        int choose = scan.nextInt();

        if (choose == 1) {
            agendaController.showLista();
        } else if (choose == 2) {
            agendaController.addContact(scan);
        } else if (choose == 3) {
            // agendaController.
        }
    }

}