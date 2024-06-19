package autocomplete;

public class WordWithDecomposed {

    private final String decomposed;
    private final String word;

    public WordWithDecomposed(String decomposed, String word) {
        this.decomposed = decomposed;
        this.word = word;
    }

    public boolean contains(String decomposed) {
        return this.decomposed.contains(decomposed);
    }

    public String decomposed() {
        return decomposed;
    }

    public String word() {
        return word;
    }
}
