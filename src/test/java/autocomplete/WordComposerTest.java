package autocomplete;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(result).isEqualTo("ㅋㅜㅓ");
    }

    @Test
    void 단어_음성_분리() {
        final var result = wordComposer.extractElements("감자");

        assertThat(result).isEqualTo("ㄱㅏㅁㅈㅏ");
    }

    @Test
    void 단어_음성_분리_2() {
        final var result = wordComposer.extractElements("나락");

        assertThat(result).isEqualTo("ㄴㅏㄹㅏㄱ");
    }

    @Test
    void 영어_분리() {
        final var result = wordComposer.extractElements("asda");

        assertThat(result).isEqualTo("asda");
    }

    @Test
    void 띄어쓰기_생략() {
        final var result = wordComposer.extractElements("가 락");

        assertThat(result).isEqualTo("ㄱㅏㄹㅏㄱ");
    }

    @Test
    void 초성_추출() {
        final var result = wordComposer.extractConsonants("가나라다");

        assertThat(result).isEqualTo("ㄱㄴㄹㄷ");
    }

    @Test
    void 초성_추출2() {
        final var result = wordComposer.extractConsonants("물고기");

        assertThat(result).isEqualTo("ㅁㄱㄱ");
    }

    @Test
    void 초성_추출3() {
        final var result = wordComposer.extractConsonants("쌍쌍바");

        assertThat(result).isEqualTo("ㅅㅅㅅㅅㅂ");
    }
}
