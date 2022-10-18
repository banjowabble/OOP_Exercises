import java.util.ArrayList;
import java.util.List;

public class Week10 {
    List<String> getAllFunctions(String fileContent) {
        List<String> result = new ArrayList<>();
        int staticIndex;
        int endIndex;
        String file = fileContent;
        while (file.contains("static")) {
            staticIndex = file.indexOf("static");
            if (checkMethod(file, staticIndex)) {
                file = file.substring(staticIndex);
                result.add(newMethod(file, staticIndex));
            } else {
                endIndex = file.indexOf(';');
                file = file.substring(endIndex);
            }
        }
        return result;
    }

    private String newMethod(String file, int staticIndex) {
        String result;
        int startIndex = staticIndex + 7;
        int endIndex;
        if (file.indexOf("final") == startIndex) {
            startIndex = file.indexOf("final") + 6;
        }
        endIndex = file.indexOf('}');
        result = file.substring(startIndex, endIndex);
        return result;
    }

    private boolean checkMethod(String file, int staticIndex) {
        int indexImport = file.indexOf("import");
        int indexEqual = file.indexOf('=');
        int indexParenthesis = file.indexOf('(');
        return indexEqual >= indexParenthesis && indexImport >= staticIndex;
    }
}
