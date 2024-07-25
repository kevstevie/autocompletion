package autocomplete;

import java.util.function.Function;

public class WordComposer {

    private static final char KOREAN_UNICODE = 0xAC00;
    private static final int VOWEL_MULTIPLIER = 28;
    private static final int FIRST_CONSONANT_MULTIPLIER = 21;

    private final Elements elements = Elements.getInstance();

    public String extractElements(String word) {
        return iterateFunction(word, this::decomposeKoreanLetter);
    }

    public String decomposeKoreanLetter(char letter) {
        final var result = new StringBuilder();
        final var unicode = letter - KOREAN_UNICODE;

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

    public String extractConsonants(String word) {
        return iterateFunction(word, this::extractConsonantsLetter);
    }

    public String extractConsonantsLetter(char letter) {
        final var unicode = letter - KOREAN_UNICODE;

        int result = (unicode) / VOWEL_MULTIPLIER / FIRST_CONSONANT_MULTIPLIER;

        return elements.getFirstConsonantAt(result);
    }

    private String iterateFunction(String word, Function<Character, String> function) {
        final var result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (letter == ' ') {
                continue;
            }
            if (letter >= '가' && letter <= '힣') {
                result.append(function.apply(letter));
                continue;
            }
            result.append(letter);
        }

        return result.toString();
    }
}
