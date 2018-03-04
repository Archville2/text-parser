package by.kurlovich.textparser.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kurlovich.textparser.exception.FileProblemException;

/**
 * read file with points for the shape
 * @param 	fileName	file name with path. Must be a txt file.
 * @return 				array of string lines.
 */

public class TextReader {
	private final static Logger LOGGER = LogManager.getLogger();

	public String readFile(String fileName) throws FileProblemException {
		Path path = Paths.get(fileName);

		if (Files.notExists(path)) {
			LOGGER.fatal("file not found: " + fileName);
			throw new FileProblemException("file is not exist");
		}

		try {
			String text = new String(Files.readAllBytes(path));

			LOGGER.debug("read " + text.length() + " bytes from file " + fileName + " done.");

			return text;
		} catch (IOException e) {
			throw new FileProblemException("problem with reading file.", e);
		}
	}

}
