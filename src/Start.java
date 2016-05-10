import FolderAnalitic.FolderReader;

/**
 * Created by a_pan on 09.05.2016.
 * main class
 */
public class Start {
    /**
     * start method
     * @param args
     */
    public static void main(String[] args) {
        if (args[0].equals("scan")) {
            FolderReader.getPach(args[1]);
        }
    }

}
