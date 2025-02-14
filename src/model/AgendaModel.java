package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

public class AgendaModel {
    static Gson gson = new Gson();
    static Path  path = Paths.get("").toAbsolutePath().resolve("./src/db.json");


    public static void createFile() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    // public static List<Contact> allContacts () {

    // }


}
