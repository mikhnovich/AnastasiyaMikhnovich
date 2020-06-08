package hw9.dto;

import hw9.parser.options.SpellerLanguages;
import hw9.parser.options.SpellerOptions;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SpellerData {

    private int id;

    private String textRequest;
    private List<String> suggestionsTexts;
    private SpellerSuggestion[] suggestions;
    private SpellerOptions options;
    private SpellerLanguages lang;
    private String code;

    public String getCodes() {
        return Arrays.stream(suggestions)
                .map(s -> s.getCode())
                .collect(Collectors.joining(", "));
    }

    public String getRows() {
        return Arrays.stream(suggestions)
                .map(s -> s.getRow())
                .collect(Collectors.joining(", "));
    }

    public String getCols() {
        return Arrays.stream(suggestions)
                .map(s -> s.getCol())
                .collect(Collectors.joining(", "));
    }

    public String getPos() {
        return Arrays.stream(suggestions)
                .map(s -> s.getPos())
                .collect(Collectors.joining(", "));
    }

    public String getLen() {
        return Arrays.stream(suggestions)
                .map(s -> s.getLen())
                .collect(Collectors.joining(", "));
    }

    public String getWords() {
        return Arrays.stream(suggestions)
                .map(s -> s.getWord())
                .collect(Collectors.joining(", "));
    }
}
