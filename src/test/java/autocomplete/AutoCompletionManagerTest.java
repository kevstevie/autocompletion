package autocomplete;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoCompletionManagerTest {

    private final AutoCompletionManager<DefaultAutoCompletionData> autoCompletionManager =
            AutoCompletionManager.useMemory();

    List<String> dummy = List.of(
            "겪다", "격기", "고라니", "골목", "나라", "다리미", "달빛", "달리기", "앉아", "안기다",
            "아싸", "앗다", "위기", "울다", "무서움", "뭐라고"
    );
    List<DefaultAutoCompletionData> l = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<DefaultAutoCompletionData> l = dummy.stream()
                                                 .map(DefaultAutoCompletionData::new)
                                                 .toList();
        autoCompletionManager.save(l);
    }

    @AfterEach
    void afterAll() {
        autoCompletionManager.clear();
    }

    @Test
    void 시작_단어() {

        List<String> result = autoCompletionManager.findStartWith("고");

        assertThat(result).hasSize(2);
    }

    @Test
    void 받침이_다음_단어로_넘어가서_검색() {
        List<String> result = autoCompletionManager.findStartWith("달");

        assertThat(result).hasSize(3);
    }

    @Test
    void 겹받침_분리() {
        List<String> result = autoCompletionManager.findStartWith("안");

        assertThat(result).hasSize(2);
    }

    @Test
    void 겹받침_분리2() {
        List<String> result = autoCompletionManager.findStartWith("겪");

        assertThat(result).hasSize(2);
    }

    @Test
    void 겹모음_분리() {
        List<String> result = autoCompletionManager.findStartWith("앗");

        assertThat(result).hasSize(2);
    }

    @Test
    void 겹모음_분리2() {
        List<String> result = autoCompletionManager.findStartWith("무");

        assertThat(result).hasSize(2);
    }
}
