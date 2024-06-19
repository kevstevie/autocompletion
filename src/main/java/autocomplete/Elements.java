package autocomplete;

import java.util.List;

public class Elements {

    private Elements() {

    }

    private static final Elements instance = new Elements();

    public static Elements getInstance() {
        return instance;
    }

    private final List<String> firstConsonants = List.of(
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ",
            "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ");

    private final List<String> middleVowels = List.of(
            "ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ",
            "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ");

    private final List<String> lastConsonants = List.of("", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ",
            "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ",
            "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ");

    public String getFirstConsonantAt(final int index) {
        return firstConsonants.get(index);
    }

    public String getMiddleVowelAt(final int index) {
        return middleVowels.get(index);
    }

    public String getLastConsonantAt(final int index) {
        return lastConsonants.get(index);
    }

    public int getIndexOfFirstConsonant(final String element) {
        return firstConsonants.indexOf(element);
    }

    public int getIndexOfMiddleVowel(final String element) {
        return middleVowels.indexOf(element);
    }

    public int getIndexOfLastConsonant(final String element) {
        return lastConsonants.indexOf(element);
    }
}
