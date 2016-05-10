package FileHandler;

import Parsing.FileParsing;
import Parsing.Report;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class for reading file
 * Created by a_pan on 09.05.2016.
 */
public class FReader {

    /**
     * Read file every line and send line for parsing
     * @param path
     */
    public static void reader(String path) {
        Report report = new Report();
        BufferedReader br;
        try {
            br = new BufferedReader(new java.io.FileReader(path));
            String currentString;
            while ((currentString = br.readLine()) != null) {
                FileParsing.linesSeparator(currentString, report);
            }
            report.writer();
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}
