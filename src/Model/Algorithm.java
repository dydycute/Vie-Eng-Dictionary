package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Algorithm {

    private String FILE_PATH = "dictionary.txt";
    private Map<String, String> dictionary;

    public Algorithm() {
        dictionary = new HashMap<>();
        loadData();
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    private void loadData() {
        try ( BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void updateDatabase() {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating database: " + e.getMessage());
        }
    }

    public boolean addWord(String eng, String vi) {
        if (!dictionary.containsKey(eng)) {
            dictionary.put(eng, vi);
            updateDatabase();
            return true;
        } else {
            System.out.println("Word already exists in the dictionary. Do you want to update its translation?");
            return false;
        }
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        } else {
            System.out.println("Word not found in the dictionary.");
            return false;
        }
    }

    public String translate(String eng) {
        return dictionary.get(eng);
    }
}
