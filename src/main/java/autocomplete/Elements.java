package autocomplete;

import java.util.List;

public class Elements {

    private Elements() {}

    private static final List<String> FIRST_CONSONANTS = List.of(
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ",
            "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ");

    private static final List<String> MIDDLE_VOWELS = List.of(
            "ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ",
            "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ");

    private static final List<String> LAST_CONSONANTS = List.of("", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ",
            "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ",
            "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ");

    public static String getFirstConsonantAt(final int index) {
        return FIRST_CONSONANTS.get(index);
    }

    public static String getMiddleVowelAt(final int index) {
        return MIDDLE_VOWELS.get(index);
    }

    public static String getLastConsonantAt(final int index) {
        return LAST_CONSONANTS.get(index);
    }
}
