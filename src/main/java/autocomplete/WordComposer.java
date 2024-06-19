package autocomplete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordComposer {

    private static final char KOREAN_UNICODE = 0xAC00;
    private static final int VOWEL_MULTIPLIER = 28;
    private static final int FIRST_CONSONANT_MULTIPLIER = 21;

    private final Elements elements = Elements.getInstance();

    public String compose(final List<Character> decomposed) {
        return String.valueOf(composeKoreanLetter(decomposed));
    }

    private char composeKoreanLetter(final List<Character> chs) {
        final var firstIndex = elements.getIndexOfFirstConsonant(String.valueOf(chs.get(0)));
        final var secondIndex = elements.getIndexOfMiddleVowel(String.valueOf(chs.get(1)));

        int letterWithoutLastConsonant = (firstIndex * FIRST_CONSONANT_MULTIPLIER + secondIndex * VOWEL_MULTIPLIER) + KOREAN_UNICODE;
        if (chs.size() == 3) {
            final var thirdIndex = elements.getIndexOfLastConsonant(String.valueOf(chs.get(2)));
            return (char) (letterWithoutLastConsonant + thirdIndex);
        }
        return (char) letterWithoutLastConsonant;
    }

    public List<String> decompose(final String word) {
        final var result = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            List<String> letter = decomposeKoreanLetter(word.charAt(i));
            result.addAll(letter);
        }

        return Collections.unmodifiableList(result);
    }

    public List<String> decomposeKoreanLetter(char ch) {
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
