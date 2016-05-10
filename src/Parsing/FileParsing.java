package Parsing;

/**
 * Parsing
 * <p/>
 * Created by a_pan on 09.05.2016.
 */
public class FileParsing {
    static String startPos = "/**";
    static String finishPos = "*/";
    static String currentStatus = finishPos;
    static String nameClass;
    static String nameMethod = "";
    static NamePartFile nameBlock = NamePartFile.HEAD;

    /**
     * Analysis of each income line and choice reaction
     *
     * @param line
     * @param report
     */
    public static void linesSeparator(String line, Report report) {
        if (line.contains(startPos) || line.contains(finishPos)) {
            currentStatus = line;
        }

        if (line.contains(" class ")) {
            getNameClass(line, report);
        }
        if (line.contains("(") && line.contains(")") && accessoryToClass(line) && line.contains("{")) {
            getMethodName(line, report);
        }
        if (currentStatus.contains(startPos) && !line.contains(startPos)) {
            report.setText(nameBlock, line);

        }

    }

    /**
     * Parsing line for getting class's name
     *
     * @param line
     * @param report
     */
    private static void getNameClass(String line, Report report) {
        nameClass = line.substring(line.indexOf("class") + 6, line.indexOf("{"));
        report.setClassName(nameClass);
        nameBlock = NamePartFile.METHOD;
    }

    /**
     * Parsing line for getting method's name
     *
     * @param line
     * @param report
     */
    private static void getMethodName(String line, Report report) {
        nameMethod = line.substring(line.lastIndexOf(" ", line.indexOf("(")) + 1, line.indexOf("("));
        report.setNameMethod(nameMethod);
    }

    /**
     * control: access modifiers is present
     *
     * @param line
     * @return
     */
    private static boolean accessoryToClass(String line) {
        String[] modificators = new String[]{
                "public", "protected", "private", "abstract", "static", "final", "synchronized", "native", "strictfp"
        };
        for (int i = 0; i < modificators.length; i++) {
            if (line.contains(modificators[i])) {
                return true;
            }

        }
        return false;
    }
}
