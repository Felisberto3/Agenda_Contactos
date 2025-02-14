package model;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class AgendaModel {
    static Gson gson = new Gson();
    static Path path = Paths.get("").toAbsolutePath().resolve("src/db.json");

    public static void createFile() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    public static List<Contact> allContacts() throws IOException, JsonIOException, IOException {
        createFile();
        ArrayList<Contact> contacts = new ArrayList<>();

        try (FileReader reader = new FileReader(path.toString())) {
            Contact[] contactList = gson.fromJson(reader, Contact[].class);

            if (contactList == null) {
                return contacts;
            }

            contacts = new ArrayList<>(Arrays.asList(contactList));
        } catch (JsonIOException e) {
            throw new JsonIOException("Error: Não conseguimos transformar os dados em json, " + path.toString());
        } catch (IOException e) {
            throw new IOException("Error: Não conseguimos ler o arquivo, " + path.toString());
        }

        return contacts;
    }

}
