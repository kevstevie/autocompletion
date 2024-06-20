package autocomplete;

public class DefaultAutoCompletionData {

    private final String word;
    private String decomposed;

    public DefaultAutoCompletionData(String word) {
        this.word = word;
    }

    public DefaultAutoCompletionData(String decomposed, String word) {
        this.decomposed = decomposed;
        this.word = word;
    }

    public boolean contains(String decomposed) {
        return this.decomposed.contains(decomposed);
    }

    public boolean startWith(String decomposed) {
        return this.decomposed.startsWith(decomposed);
    }

    public String decomposed() {
        return decomposed;
    }

    public String word() {
        return word;
    }
}
