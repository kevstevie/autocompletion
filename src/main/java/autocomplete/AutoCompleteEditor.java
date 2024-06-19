package autocomplete;

public class AutoCompleteEditor {

    private final WordRepository wordRepository;
    private final WordComposer wordComposer = new WordComposer();

    public AutoCompleteEditor(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public static AutoCompleteEditor useMemory() {
        return new AutoCompleteEditor(new MemoryWordRepository());
    }
}
