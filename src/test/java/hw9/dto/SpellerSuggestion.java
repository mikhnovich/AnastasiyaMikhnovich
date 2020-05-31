package hw9.dto;


import lombok.Data;

import java.util.List;

@Data
public class SpellerSuggestion {

    private String code;
    private String pos;
    private String row;
    private String col;
    private String len;
    private String word;
    private List<String> s;

    public SpellerSuggestion(List<String> s) {
        this.s = s;
    }

    public String getSuggestions() {
        return String.join(" ", s);
    }
}
