package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import constants.Constant;

public class InputFile {

	public List<String> getFileLines(String pathFile) throws IOException {
		try {
			Path path = Paths.get(pathFile);
			return Files.readAllLines(path, Constant.CHARSET_UTF_8);
		} catch (IOException ex) {
			throw ex;
		}
	}
}
