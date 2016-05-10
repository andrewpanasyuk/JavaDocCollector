package FolderAnalitic;

import FileHandler.FReader;
import java.io.File;

/**
 * Created by a_pan on 09.05.2016.
 * Class got a way and search Java-file
 * send file for reading
 */
public class FolderReader {

    /**
     * Method lock all files in the Folder
     * Send Java-files on reading
     *
     * @param path
     */
    public static void getPach(String path) {
        String[] fileNameArrays;
        File way = new File(path);
        if (way.exists()) {
            fileNameArrays = way.list();
            for (int i = 0; i < fileNameArrays.length; i++) {
                if (selectJavaFile(fileNameArrays[i])) {
                    FReader.reader(way + System.getProperty("file.separator") + fileNameArrays[i]);
                }

            }
        }

    }

    /**
     * Control Jav-file or not Java-file
     *
     * @param nameFile
     * @return
     */
    private static boolean selectJavaFile(String nameFile) {
        if (nameFile.substring(nameFile.length() - 4).equals("java")) {
            return true;
        }
        return false;
    }

}
