import java.util.List;

import com.google.gson.Gson;

import model.AgendaModel;
import model.Contact;

public class App {
    public static void main(String[] args) throws Exception {
        List<Contact> contact = AgendaModel.allContacts();

        System.out.println(contact);

    }
}
