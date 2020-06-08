package hw9;

import hw9.dto.SpellerSuggestion;
import lombok.AllArgsConstructor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class SpellerFluentAssertions {

    private final SpellerSuggestion[] results;

    public SpellerFluentAssertions verifySuggestion(List<String> expectedSuggestions) {
        for (int i = 0; i < expectedSuggestions.size(); i++) {
            assertThat(expectedSuggestions.get(i)).isEqualTo(results[i].getSuggestions());
        }
        return this;
    }

    public SpellerFluentAssertions verifySuggestion(SpellerSuggestion[] expectedSuggestions) {
        assertThat(results).isEqualTo(expectedSuggestions);
        return this;
    }

    public SpellerFluentAssertions verifyEmptyResponse() {
        assertThat(results).isEmpty();
        return this;
    }

    public SpellerFluentAssertions verifyNotEmptyResponse() {
        assertThat(results).isNotEmpty();
        return this;
    }

    public SpellerFluentAssertions verifyCode(String code) {
        for (SpellerSuggestion spellerSuggestion : results) {
            assertThat(spellerSuggestion.getCode()).isEqualTo(code);
        }
        return this;
    }

    public SpellerFluentAssertions verifyPos(String pos) {
        for (SpellerSuggestion spellerSuggestion : results) {
            assertThat(spellerSuggestion.getPos()).isEqualTo(pos);
        }
        return this;
    }

    public SpellerFluentAssertions verifyRow(String row) {
        for (SpellerSuggestion spellerSuggestion : results) {
            assertThat(spellerSuggestion.getRow()).isEqualTo(row);
        }
        return this;
    }

    public SpellerFluentAssertions verifyCol(String col) {
        for (SpellerSuggestion spellerSuggestion : results) {
            assertThat(spellerSuggestion.getCol()).isEqualTo(col);
        }
        return this;
    }

    public SpellerFluentAssertions verifyLen(String len) {
        for (SpellerSuggestion spellerSuggestion : results) {
            assertThat(spellerSuggestion.getLen()).isEqualTo(len);
        }
        return this;
    }

    public SpellerFluentAssertions verifyWords(String word) {
        for (SpellerSuggestion spellerSuggestion : results) {
            assertThat(spellerSuggestion.getWord()).isEqualTo(word);
        }
        return this;
    }

}

