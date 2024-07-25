package autocomplete;

public class DefaultAutoCompletionData {

    private final String word;
    private String decomposed;
    private String consonants;

    public DefaultAutoCompletionData(String word) {
        this.word = word;
    }

    public String decomposed() {
        return decomposed;
    }

    public String word() {
        return word;
    }
}
