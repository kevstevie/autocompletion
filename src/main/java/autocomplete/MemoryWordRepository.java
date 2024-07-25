package autocomplete;

import java.util.HashSet;
import java.util.Set;

public class MemoryWordRepository implements WordRepository<DefaultAutoCompletionData> {

    private final Set<DefaultAutoCompletionData> words = new HashSet<>();

    @Override
    public void save(DefaultAutoCompletionData data) {
        words.add(data);
    }

    @Override
    public void clear() {
        words.clear();
    }
}
