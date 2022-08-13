package pl.coderslab.beans;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileCustomerLogger implements CustomerLogger {

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileCustomerLogger(String filename) {
        this.filename = filename;
    }


    @Override
    public void log() {
        try {
            File logger =
                    new File(filename);
            if (!logger.exists()) {
                logger.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(logger);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write(LocalDateTime.now() + ": Customer operation \n");

        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }


    }
}
