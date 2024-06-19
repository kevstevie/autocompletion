package autocomplete;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WordComposerTest {

    private WordComposer wordComposer = new WordComposer();

    @Test
    void 종성이_있는_글자_분리() {
        final var result = wordComposer.decomposeKoreanLetter('갓');

        assertThat(result).isEqualTo("ㄱㅏㅅ");
    }

    @Test
    void 종성이_없는_경우_리스트에_추가하지_않는다() {
        final var result = wordComposer.decomposeKoreanLetter('무');

        assertThat(result).isEqualTo("ㅁㅜ");
    }

    @Test
    void 이중_모음_글자_분리() {
        final var result = wordComposer.decomposeKoreanLetter('쿼');

        assertThat(result).isEqualTo("ㅋㅝ");
    }

    @Test
    void 문자열_합성() {
        final var chs = List.of('ㄱ', 'ㅏ', 'ㄱ');
        final var wordComposer = new WordComposer();

        final var result = wordComposer.compose(chs);

        assertThat(result).isEqualTo("각");
    }

    @Test
    void 문자열_합성2() {
        final var chs = List.of('ㄱ', 'ㅏ');
        final var wordComposer = new WordComposer();

        final var result = wordComposer.compose(chs);

        assertThat(result).isEqualTo("가");
    }


    @Test
    void 단어_음성_분리() {
        final var result = wordComposer.decompose("감자");

        assertThat(result).isEqualTo("ㄱㅏㅁㅈㅏ");
    }

    @Test
    void 단어_음성_분리_2() {
        final var result = wordComposer.decompose("나락");

        assertThat(result).isEqualTo("ㄴㅏㄹㅏㄱ");
    }

    @Test
    void 영어_분리() {
        final var result = wordComposer.decompose("asda");

        assertThat(result).isEqualTo("asda");
    }

    @Test
    void 띄어쓰기_생략() {
        final var result = wordComposer.decompose("가 락");

        assertThat(result).isEqualTo("ㄱㅏㄹㅏㄱ");
    }
}
