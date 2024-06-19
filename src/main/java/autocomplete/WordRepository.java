package autocomplete;

import java.util.List;

public interface WordRepository {

    void save(String... word);

    List<String> find(char[] decompsed);

}
