package autocomplete;

import java.util.ArrayList;
import java.util.List;

public class MemoryWordRepository implements WordRepository {

    private final List<WordWithDecomposed> words = new ArrayList<>();

    @Override
    public void save(WordWithDecomposed word) {
        words.add(word);
    }

    @Override
    public List<String> find(String decomposed) {
        return words.stream()
                    .filter(word -> word.contains(decomposed))
                    .map(WordWithDecomposed::word)
                    .toList();
    }
}
