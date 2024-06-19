package autocomplete;

import java.util.ArrayList;
import java.util.List;

public class MemoryWordRepository implements WordRepository {

    private final List<AutoCompletionInfo> words = new ArrayList<>();

    @Override
    public void save(AutoCompletionInfo word) {
        words.add(word);
    }

    @Override
    public List<String> find(String decomposed) {
        return words.stream()
                    .filter(word -> word.contains(decomposed))
                    .map(AutoCompletionInfo::word)
                    .toList();
    }
}
