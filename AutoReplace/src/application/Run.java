package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import business.ReplaceFile;
import models.FileReplace;
import models.Replace;

public class Run {

	public static void main(String[] args) throws IOException {
		
		//EXAMPLE OF USE
		try {
			FileReplace file = new FileReplace();
			
			ReplaceFile replaceFile = new ReplaceFile();

			//set source file
			file.setOldPath("example.txt");
			
			//set target file
			file.setNewPath("exampleReplace.txt");
			
			//add what will be replaced
			List<Replace> replaceList = new ArrayList<Replace>(); 
			replaceList.add(new Replace("%", ""));
			replaceList.add(new Replace("000", ""));
			replaceList.add(new Replace("_", ""));			
			replaceFile.setListReplace(replaceList);
			
			String newFilePath = replaceFile.getNewFile(file);
			System.err.println(String.format("File saved in! %s", newFilePath));
		} catch (Exception ex) {
			throw ex;
		}

	}

}