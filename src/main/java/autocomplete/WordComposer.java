package autocomplete;

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

    public String decompose(final String word) {
        final var result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (letter == ' ') {
                continue;
            }
            if (letter >= '가' && letter <= '힣') {
                result.append(decomposeKoreanLetter(letter));
                continue;
            }
            result.append(letter);
        }

        return result.toString();
    }

    public String decomposeKoreanLetter(char ch) {
        final var result = new StringBuilder();
        final var unicode = ch - KOREAN_UNICODE;

        int firstConsonantValue = (unicode) / VOWEL_MULTIPLIER / FIRST_CONSONANT_MULTIPLIER;
        int middleVowelValue = (unicode) / VOWEL_MULTIPLIER % FIRST_CONSONANT_MULTIPLIER;
        int lastConsonantValue = (unicode) % VOWEL_MULTIPLIER;

        result.append(elements.getFirstConsonantAt(firstConsonantValue));
        result.append(elements.getMiddleVowelAt(middleVowelValue));
        if (lastConsonantValue != 0) {
            result.append(elements.getLastConsonantAt(lastConsonantValue));
        }

        return result.toString();
    }
}
