package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

import models.FileReplace;

public class OutputFile {
	private BufferedWriter bufferedWriter;
	
	public void createNewFileOutput(FileReplace fileReplace) throws IOException {
		try {
			File file = new File(fileReplace.getNewPath());
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(fileReplace.getNewFile().toString());
		} 
		catch(Exception ex){
			if (bufferedWriter != null)
				bufferedWriter.close();
			
			throw ex;
		}
		finally {
			if (bufferedWriter != null)
				bufferedWriter.close();
		}
	}
}
