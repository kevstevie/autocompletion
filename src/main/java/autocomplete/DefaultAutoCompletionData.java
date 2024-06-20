package autocomplete;

public class DefaultAutoCompletionData {

    private final String word;
    private String decomposed;
    private String consonants;

    public DefaultAutoCompletionData(String word) {
        this.word = word;
    }

    public boolean startWith(String decomposed) {
        return this.decomposed.startsWith(decomposed);
    }

    public DefaultAutoCompletionData setDecomposed(String decomposed) {
        this.decomposed = decomposed;
        return this;
    }

    public DefaultAutoCompletionData setConsonants(String consonants) {
        this.consonants = consonants;
        return this;
    }

    public String decomposed() {
        return decomposed;
    }

    public String word() {
        return word;
    }
}
