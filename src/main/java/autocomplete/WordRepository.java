package autocomplete;

public interface WordRepository<T> {

    void save(T data);

    void clear();
}
