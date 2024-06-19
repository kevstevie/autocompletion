package autocomplete;

import java.util.List;

public interface WordRepository {

    void save(WordWithDecomposed word);

    List<String> find(String decomposed);

}
