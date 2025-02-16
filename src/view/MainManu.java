package view;

import java.util.Scanner;

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

}