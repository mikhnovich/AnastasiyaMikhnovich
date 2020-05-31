package hw9.parser;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import hw9.dto.SpellerData;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class JsonFileParser {

    @SuppressWarnings("UnstableApiUsage")
    public static List<SpellerData> parseFile(String path) {
        String data = null;
        try {
            data = readLinesFromFileByPath(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // a bit of unstable code...
        // https://stackoverflow.com/questions/5554217/google-gson-deserialize-listclass-object-generic-type
        Type listType = new TypeToken<ArrayList<SpellerData>>() {
        }.getType();

        return new Gson().fromJson(data, listType);
    }

    private static String readLinesFromFileByPath(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.lines(Paths.get(filePath))
                .forEach(sb::append);
        return sb.toString();
    }
}
