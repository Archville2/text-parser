package by.kurlovich.textparser.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.kurlovich.textparser.exception.FileProblemException;

/**
 * read file with points for the shape
 * @param 	fileName	file name with path. Must be a txt file.
 * @return 				array of string lines.
 */

public class TextReader {
    private final static Logger LOGGER = Logger.getLogger(TextReader.class);

    public List<String> readFile(String fileName) throws FileProblemException {
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");

        if(Files.notExists(path)) {
           LOGGER.log(Level.FATAL, "file not found: " + fileName);
            throw new FileProblemException("file is not exist");
        }

        try {
            List<String> lines = Files.readAllLines(path, charset);

          LOGGER.log(Level.DEBUG, "read " + lines.size() + " lines from file " + fileName + " ok.");

            return lines;
        } catch (IOException e) {
            throw new FileProblemException("problem with reading file.", e);
        }
    }

}
