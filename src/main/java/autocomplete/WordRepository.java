package autocomplete;

import java.util.List;

public interface WordRepository {

    void save(AutoCompletionInfo word);

    List<String> find(String decomposed);

}
