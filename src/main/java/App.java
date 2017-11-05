import algorithm.PowerSet;
import model.WordEntry;
import db_repository.WordEntryRepository;
import java.util.*;

public class App {

    public static void main(String[] args) {

        char[] charArr = {'i', 'm', 'p', 'r', 'a', 's', 'ł'};

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> subsets = PowerSet.powerSet(input);

        List<WordEntry> wordsByChars = WordEntryRepository.findWordsByChars(subsets);

        if (!wordsByChars.isEmpty()) {
            for (WordEntry entry : wordsByChars) {
                System.out.println(entry.toString());
            }
        }

    }

}