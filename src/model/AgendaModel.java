package model;

import java.io.FileReader;
import java.io.FileWriter;
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

    public static Contact get(String telefone) throws JsonIOException, IOException {
        for (Contact contact : allContacts()) {
            if (contact.getTelefone().equals(telefone)) {
                return contact;
            }
        }

        return null;
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

    private static boolean writer(List<Contact> contacts) throws IOException {
        try (FileWriter writer = new FileWriter(path.toString())) {
            gson.toJson(contacts, writer);

        } catch (IOException e) {
            throw new IOException("Error: Ao escrever na file, " + path);
        } catch (JsonIOException e) {
            throw new JsonIOException("Error: transformar em salvar em json na file, " + path);
        }
        return true;
    }

    public static boolean save(Contact contact) throws JsonIOException, IOException {

        List<Contact> contacts = allContacts();
        contacts.add(contact);

        writer(contacts);

        return true;
    }

    public static boolean delete(String telefone) throws JsonIOException, IOException {
        List<Contact> contacts = allContacts();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getTelefone().equals(telefone)) {
                contacts.remove(i);
                writer(contacts);
                return true;
            }
        }

        return false;

    }

    public static boolean update(String telefone, Contact contact) throws JsonIOException, IOException {

        List<Contact> contacts = allContacts();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getTelefone().equals(telefone))
                contacts.set(i, contact);
        }

        writer(contacts);

        return true;
    }
}
