import java.io.IOException;
import com.google.gson.JsonIOException;

import model.Contact;
import view.MainManu;

public class App {
    public static void main(String[] args) throws JsonIOException, IOException {
        new MainManu().firstMenu();
    }
}
