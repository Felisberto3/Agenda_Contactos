import java.util.List;

import com.google.gson.Gson;

import model.AgendaModel;
import model.Contact;

public class App {
    public static void main(String[] args) throws Exception {
        // List<Contact> contact = AgendaModel.allContacts();

        // AgendaModel.save(null);

        // AgendaModel.delete("955371762");
        // System.out.println(contact);

        AgendaModel.update("925795149", new Contact("925795149", "Jose Goncalves", "Canoquena", "ganca@gmail.com"));

    }
}
