package autocomplete;

import java.util.ArrayList;
import java.util.List;

public class MemoryWordRepository extends WordRepository<DefaultAutoCompletionData> {

    private final List<DefaultAutoCompletionData> words = new ArrayList<>();

    @Override
    public void save(DefaultAutoCompletionData data) {
        String decomposed = wordComposer.decompose(data.word());
        String consonants = wordComposer.extractConsonants(data.word());
        words.add(data.setDecomposed(decomposed).setConsonants(consonants));
    }

    @Override
    public List<String> findStartWith(String search) {
        String decomposed = wordComposer.decompose(search);
        return words.stream()
                    .filter(word -> word.startWith(decomposed))
                    .map(DefaultAutoCompletionData::word)
                    .toList();
    }

    @Override
    public List<String> findByConsonants(String consonants) {
        return words.stream()
                    .filter(word -> word.matchConsonants(consonants))
                    .map(DefaultAutoCompletionData::word)
                    .toList();
    }

    @Override
    public void clear() {
        words.clear();
    }
}
