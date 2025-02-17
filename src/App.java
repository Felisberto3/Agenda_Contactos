import java.io.IOException;
import com.google.gson.JsonIOException;

import view.MainManu;

public class App {
    public static void main(String[] args) throws JsonIOException, IOException {
        new MainManu().firstMenu();
    }
}
