package autocomplete;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordDecomposerTest {

    private final WordDecomposer wordDecomposer = new WordDecomposer();

    @Test
    void 단어_음성_분리() {
        final var result = wordDecomposer.decompose("감자");

        assertThat(result).containsExactly("ㄱ", "ㅏ", "ㅁ", "ㅈ", "ㅏ");
    }

    @Test
    void 단어_음성_분리_2() {
        final var result = wordDecomposer.decompose("나락");

        assertThat(result).containsExactly("ㄴ", "ㅏ", "ㄹ", "ㅏ", "ㄱ");
    }
}
