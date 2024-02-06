package org.homework10.task3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class WordsCounter {
    public static void main(String[] args) throws IOException {
        String fileName = "words.txt";
        String text ="";
        try {
            text = Files.readString(Path.of(fileName));
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        ArrayList<String> arrayAllWorlds = new ArrayList<>(List.of(text.split("\\W+")));
//        int counter = 0;
//        int counterSeter = 0;
//        ArrayList<Integer> arrayCount
//        for (int i = 0; i < arrayAllWorlds.size(); i++) {
//            for (int j = 0; j < arrayAllWorlds.size(); j++){
//                if (arrayAllWorlds.get(i).equals(arrayAllWorlds.get(j))){
//                    counter++;
//                    if (i != j) {
//                        arrayAllWorlds.set(j, "");
//                        counterSeter++;
//                    }
//                }
//            }
//            System.out.print(counter + " , ");
//            counter = 0;
//
//        }
        ArrayList<Word> arrayWords = new ArrayList<>();
        int i = 0;
        int counter = 0;
        while (!arrayAllWorlds.isEmpty()){
            arrayWords.add(new Word(arrayAllWorlds.get(0), 1));

            while (arrayAllWorlds.contains(arrayWords.get(i).getWORD())){
                arrayAllWorlds.remove(arrayWords.get(i).getWORD());
                counter++;
            }
            arrayWords.get(i).setCounter(counter);
            i++;
            counter = 0;
        }
        arrayWords.sort(new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                if (word1.getCounter()>word2.getCounter()){
                    return -1;
                } else if (word1.getCounter()< word2.getCounter()) {
                    return 1;
                }
                return 0;
            }
        });
        for (Word word: arrayWords) {
            System.out.println(word);
        }




    }
}
