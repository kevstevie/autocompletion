package autocomplete;

import java.util.Collection;
import java.util.List;

public class AutoCompletionManager {

    private final WordRepository wordRepository;
    private final WordComposer wordComposer = new WordComposer();

    public AutoCompletionManager(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public static AutoCompletionManager useMemory() {
        return new AutoCompletionManager(new MemoryWordRepository());
    }

    public void save(Collection<String> words) {
        for (String word : words) {
            String decomposed = wordComposer.decompose(word);
            wordRepository.save(new WordWithDecomposed(decomposed, word));
        }
    }

    public List<String> find(String decomposed) {
        return wordRepository.find(decomposed);
    }

}
