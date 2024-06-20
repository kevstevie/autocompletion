package autocomplete;

import java.util.List;

public abstract class WordRepository<T> {

    protected final WordComposer wordComposer = new WordComposer();

    public abstract void save(T data);

    public abstract List<String> findStartWith(String decomposed);

}
