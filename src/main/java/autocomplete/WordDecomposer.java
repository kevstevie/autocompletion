package autocomplete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordDecomposer {

    private final LetterDecomposer letterDecomposer = new LetterDecomposer();

    public List<String> decompose(final String word) {
        final var result = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            List<String> letter = letterDecomposer.decompose(word.charAt(i));
            result.addAll(letter);
        }

        return Collections.unmodifiableList(result);
    }
}
