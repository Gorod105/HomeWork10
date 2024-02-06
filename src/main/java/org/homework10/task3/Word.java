package org.homework10.task3;



public class Word implements Comparable<Word> {
    private final String WORD;
    private int counter;

    public Word(String WORD, int counter) {
        this.WORD = WORD;
        this.counter = counter;
    }

    public String getWORD() {
        return WORD;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return  WORD + ' ' + counter;
    }

    @Override
    public int compareTo(Word word2) {
        if (counter>word2.counter){
            return 1;
        } else if (counter< word2.counter) {
            return -1;
        }
        return 0;
    }
}
