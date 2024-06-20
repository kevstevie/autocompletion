package autocomplete;

import java.util.List;
import java.util.Map;

public class Elements {

    private static final Elements instance = new Elements();

    private final List<String> firstConsonants = List.of(
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ",
            "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ");

    private final Map<String, String> doubleConsonants = Map.of(
            "ㄲ", "ㄱㄱ",
            "ㄸ", "ㄷㄷ",
            "ㅃ", "ㅂㅂ",
            "ㅆ", "ㅅㅅ",
            "ㅉ", "ㅈㅈ"
    );

    private final List<String> middleVowels = List.of(
            "ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ",
            "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ");

    private final Map<String, String> combinationVowels = Map.of(
            "ㅘ", "ㅗㅏ",
            "ㅙ", "ㅗㅐ",
            "ㅚ", "ㅗㅣ",
            "ㅝ", "ㅜㅓ",
            "ㅞ", "ㅜㅔ",
            "ㅟ", "ㅜㅣ",
            "ㅢ", "ㅡㅣ"
    );

    private final List<String> lastConsonants = List.of("", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ",
            "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ",
            "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ");

    private final Map<String, String> combinationConsonants = Map.of(
            "ㄳ", "ㄱㅅ",
            "ㄵ", "ㄴㅈ",
            "ㄶ", "ㄴㅎ",
            "ㄺ", "ㄹㄱ",
            "ㄻ", "ㄹㅁ",
            "ㄽ", "ㄹㅅ",
            "ㄿ", "ㄹㅍ",
            "ㅀ", "ㄹㅎ",
            "ㅄ", "ㅂㅅ",
            "ㄼ", "ㄹㅂ"
    );

    private Elements() {

    }

    public static Elements getInstance() {
        return instance;
    }

    public String getFirstConsonantAt(final int index) {
        String result = firstConsonants.get(index);
        return doubleConsonants.getOrDefault(result, result);
    }

    public String getMiddleVowelAt(final int index) {
        String result = middleVowels.get(index);
        return combinationVowels.getOrDefault(result, result);
    }

    public String getLastConsonantAt(final int index) {
        String result = lastConsonants.get(index);
        if (doubleConsonants.containsKey(result)) {
            return doubleConsonants.get(result);
        }
        if (combinationConsonants.containsKey(result)) {
            return combinationConsonants.get(result);
        }
        return result;
    }
}
