package db_creator;

import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public class WordEntryBuilder {

    private String newWord;
    private String newSortedChars;
    private Integer newScore;

    public WordEntryBuilder setNewWord(String word) {
        this.newWord = word;
        return this;
    }

    public WordEntryBuilder setNewSortedChars() {
        char[] chars = newWord.toCharArray();
        Arrays.sort(chars);
        this.newSortedChars = new String(chars);
        return this;
    }

    public WordEntryBuilder setNewScore() {
        this.newScore = WordScoreCalculator.calcFinalScore(newWord);
        return this;
    }

    public WordEntry createWordEntry() {
        return new WordEntry(newWord, newSortedChars, newScore);
    }

}


