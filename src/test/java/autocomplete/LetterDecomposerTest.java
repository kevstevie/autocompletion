package autocomplete;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LetterDecomposerTest {

    private final LetterDecomposer letterDecomposer = new LetterDecomposer();

    @Test
    void 종성이_있는_글자_분리() {
        final var result = letterDecomposer.decompose('갓');

        assertThat(result).containsExactly("ㄱ","ㅏ","ㅅ");
    }

    @Test
    void 종성이_없는_경우_리스트에_추가하지_않는다() {
        final var result = letterDecomposer.decompose('무');

        assertThat(result).containsExactly("ㅁ", "ㅜ");
    }

    @Test
    void 이중_모음_글자_분리() {
        final var result = letterDecomposer.decompose('쿼');

        assertThat(result).containsExactly("ㅋ", "ㅝ");
    }
}
