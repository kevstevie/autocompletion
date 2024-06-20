package autocomplete;

import java.util.List;

public abstract class WordRepository<T> {

    protected final WordComposer wordComposer = new WordComposer();

    public abstract void save(T data);

    public abstract void saveConsonants(T data);

    public abstract List<String> findStartWith(String decomposed);

    public abstract List<String> findByConsonants(String consonants);

    public abstract void clear();
}
