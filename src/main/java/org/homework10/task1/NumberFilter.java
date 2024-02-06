package org.homework10.task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NumberFilter {
    public static void main(String[] args) throws IOException {
        String fileName = "file.txt";
        List<String> fileLines = new ArrayList<>();
        String firstTypeNumber = "\\d{3}[-]\\d{3}[-]\\d{4}";
        String secondTypeNumber = "[(]\\d{3}[)][ ]\\d{3}[-]\\d{4}";
        try {
            fileLines = Files.readAllLines(Path.of(fileName));
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        for (String number: fileLines) {
            if (number.matches(firstTypeNumber) || number.matches(secondTypeNumber)){
                System.out.println(number);
            }
        }
    }
}
