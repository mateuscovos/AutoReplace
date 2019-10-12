package business;

import java.io.IOException;
import java.util.List;

import io.InputFile;
import io.OutputFile;
import models.FileReplace;
import models.Replace;

public class ReplaceFile {
	private List<Replace> listReplace;
	private OutputFile outputFile;
	
	public void setListReplace(List<Replace> replaces) {
		this.listReplace = replaces;
	}
	
	public String getNewFile(FileReplace file) throws IOException {
		InputFile inputFile = new InputFile();
		file.setOldFile(inputFile.getFileLines(file.getOldPath()));
		
		for (String line : file.getOldFile()) {
			String lineReplace = line; 
            for (Replace replace : this.listReplace) {
            	lineReplace = lineReplace.replace(replace.getOldText(), replace.getNewText());
            }
            file.addLineNewFile(lineReplace);
        }
		outputFile = new OutputFile();
		outputFile.createNewFileOutput(file);
		return file.getNewPath();
	}
}
