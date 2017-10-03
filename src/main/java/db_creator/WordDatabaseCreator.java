package db_creator;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordDatabaseCreator {

    public List<WordEntry> getListWordsFromFile(String filepath) {

        List<WordEntry> wordEntryList = null;

        try (BufferedReader bReader = Files.newBufferedReader(Paths.get(filepath))) {
            wordEntryList = new ArrayList<>();
            String wordLine;
            WordEntryBuilder builder = new WordEntryBuilder();

            while ((wordLine = bReader.readLine()) != null) {
                WordEntry newEntry = builder.setNewWord(wordLine)
                        .setNewSortedChars()
                        .setNewScore()
                        .createWordEntry();
                wordEntryList.add(newEntry);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordEntryList;
    }

    public void createDatabase(String filepath) throws Exception {
        List<WordEntry> entryList = getListWordsFromFile(filepath);

        for (WordEntry entry : entryList) {
            if (!WordEntryRepository.addWordEntry(entry)) {
                throw new Exception();
            }
        }
    }


}
