package org.homework10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FormatFromTxtToJson  {
    public static void main(String[] args) throws IOException {
        String fileName = "file2.txt";
        List<String> fileLines = new ArrayList<>();
        try {
            fileLines = Files.readAllLines(Path.of(fileName));
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        List arrayUser = new ArrayList<>();
        for (int i = 1; i < fileLines.size(); i++) {
            String[] var = fileLines.get(i).split(" ");
            User newUser = new User(var[0], var[1]);
            arrayUser.add(newUser);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonText = gson.toJson(arrayUser);
        System.out.println(jsonText);
        File jsonFile = new File("user.json");
        try (FileWriter writer = new FileWriter(jsonFile)){
            writer.write(jsonText);
            writer.flush();
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }
}
