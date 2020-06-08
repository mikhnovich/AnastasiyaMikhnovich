package hw9.service;

import com.google.gson.Gson;
import hw9.dto.SpellerData;
import hw9.dto.SpellerSuggestion;
import hw9.utils.GetProperty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpellerActions {
    public GetProperty property = new GetProperty();

    public SpellerSuggestion[] checkText(SpellerData dataEntity) throws IOException {

        Map<String, Object> params = new HashMap<>();

        params.put("text", dataEntity.getTextRequest());

        if (dataEntity.getOptions() != null)
            params.put("options", dataEntity.getOptions().value);
        if (dataEntity.getLang() != null)
            params.put("lang", dataEntity.getLang().value);

        return new Gson().fromJson(
                new SpellerService()
                        .getWithParams(property.getProperty("checkTextUri"), params)
                        .getBody().asString(), SpellerSuggestion[].class);
    }
}
