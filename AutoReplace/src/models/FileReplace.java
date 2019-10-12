package models;

import java.util.List;

import constants.Constant;

public class FileReplace {
	private List<String> oldFile;
	private StringBuilder newFile;
	private String oldPath;
	private String newPath;

	public FileReplace() {
		this.newFile = new StringBuilder();
	}

	public FileReplace(List<String> oldFile) {
		this.oldFile = oldFile;
		this.newFile = new StringBuilder();
	}

	public List<String> getOldFile() {
		return oldFile;
	}

	public void setOldFile(List<String> oldFile) {
		this.oldFile = oldFile;
	}

	public StringBuilder getNewFile() {
		return newFile;
	}

	public void addLineNewFile(String newFile) {
		this.newFile.append(String.format("%s%s", newFile, Constant.LINE_SEPARATOR));
	}

	public void setOldPath(String oldPath) {
		this.oldPath = oldPath.replace("\\", "/");
	}

	public String getOldPath() {
		return oldPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath.replace("\\", "/");
	}

	public String getNewPath() {
		return newPath;
	}
}
