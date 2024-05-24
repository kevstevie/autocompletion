package autocomplete;

import java.util.ArrayList;
import java.util.List;

public class LetterDecomposer {

    private final Elements elements = new Elements();

    private static final char KOREAN_UNICODE = 0xAC00;
    private static final int VOWEL_MULTIPLIER = 28;
    private static final int FIRST_CONSONANT_MULTIPLIER = 21;

    public List<String> decompose(char ch) {
        final var result = new ArrayList<String>();
        final var unicode = ch - KOREAN_UNICODE;

        int firstConsonantValue = (unicode) / VOWEL_MULTIPLIER / FIRST_CONSONANT_MULTIPLIER;
        int middleVowelValue = (unicode) / VOWEL_MULTIPLIER % FIRST_CONSONANT_MULTIPLIER;
        int lastConsonantValue = (unicode) % VOWEL_MULTIPLIER;

        result.add(elements.getFirstConsonantAt(firstConsonantValue));
        result.add(elements.getMiddleVowelAt(middleVowelValue));
        if (lastConsonantValue != 0) {
            result.add(elements.getLastConsonantAt(lastConsonantValue));
        }

        return result;
    }
}
