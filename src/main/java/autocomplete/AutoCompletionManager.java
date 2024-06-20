package autocomplete;

import java.util.Collection;
import java.util.List;

public class AutoCompletionManager<T> {

    private final WordRepository<T> wordRepository;

    public AutoCompletionManager(WordRepository<T> wordRepository) {
        this.wordRepository = wordRepository;
    }

    public static AutoCompletionManager<DefaultAutoCompletionData> useMemory() {
        return new AutoCompletionManager<>(new MemoryWordRepository());
    }

    public void save(Collection<T> dataCollection) {
        for (T data : dataCollection) {
            wordRepository.save(data);
        }
    }

    public List<String> findStartWith(String word) {
        return wordRepository.findStartWith(word);
    }

    public List<String> findByConsonants(String consonants) {
        return wordRepository.findByConsonants(consonants);
    }

    public void clear() {
        wordRepository.clear();
    }
}
