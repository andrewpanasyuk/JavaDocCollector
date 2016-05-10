package FileHandler;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class for writing data in file
 * Created by a_pan on 09.05.2016.
 */
public class FWriter {
    public static void FileWrite(String line){
        File file = new File("Report.info");
        RandomAccessFile randomAccessFile = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }

        try {
            randomAccessFile = new RandomAccessFile(file,"rw");
            String tempString;
            while ((tempString = randomAccessFile.readLine()) != null) {
                randomAccessFile.seek(randomAccessFile.getFilePointer());
            }

            randomAccessFile.writeBytes(line + "\n");

        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            if (randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException ex){
                    ex.printStackTrace();
                }

            }
        }

    }

}
