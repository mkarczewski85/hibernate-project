import algorithm.PowerSet;
import model.WordEntry;
import db_repository.WordEntryRepository;

import java.util.*;

public class App {

    public static void main(String[] args) {

        char start = 'a';
        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.nextLine();

            long startTime = System.currentTimeMillis();

            Set<String> subsets = PowerSet.powerSet(input);

            System.out.println(System.currentTimeMillis() - startTime);

            startTime = System.currentTimeMillis();

            List<WordEntry> wordsByChars = WordEntryRepository.findWordsByCharsAndLetter(subsets, start, false);

            if (!wordsByChars.isEmpty()) {
                for (WordEntry entry : wordsByChars) {
                    System.out.println(entry.toString());
                }
            }

            System.out.println(System.currentTimeMillis() - startTime);
        }



    }

}