package autocomplete;

public class DefaultAutoCompletionManager implements AutoCompletionManager<DefaultAutoCompletionData> {

    private final WordComposer wordComposer = new WordComposer();
    private final MemoryWordRepository memoryWordRepository = new MemoryWordRepository();


    @Override
    public void save(DefaultAutoCompletionData data) {
        String elements = wordComposer.extractElements(data.word());
        String consonants = wordComposer.extractConsonants(data.word());

        memoryWordRepository.save(
                data.setConsonants(consonants)
                        .setDecomposed(elements)
        );
    }
}
