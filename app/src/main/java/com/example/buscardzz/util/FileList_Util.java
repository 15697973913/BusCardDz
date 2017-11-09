package com.example.buscardzz.util;


public class FileList_Util {
	private String taskId;//任务ID
	private String fileName;//文件名称
	private int fileSize;//文件大小
	private String fileIndexes;//文件索引
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileIndexes() {
		return fileIndexes;
	}
	public void setFileIndexes(String fileIndexes) {
		this.fileIndexes = fileIndexes;
	}
	@Override
	public String toString() {
		return "文件信息： [taskId=" + taskId + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", fileIndexes=" + fileIndexes + "]";
	}

}
