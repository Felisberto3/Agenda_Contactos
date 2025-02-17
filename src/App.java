import java.io.IOException;
import com.google.gson.JsonIOException;

import controller.AgendaController;
import view.MainManu;

public class App {
    public static void main(String[] args) throws JsonIOException, IOException {
        new MainManu().firstMenu();
        // boolean answer = new AgendaController().validarCampos("telefone",
        // "@gmail.com");
        // System.out.println(answer + " resposta");
    }
}
