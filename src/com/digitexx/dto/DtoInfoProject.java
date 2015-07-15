package com.digitexx.dto;

public class DtoInfoProject {
	private String filePath;
	private String folderBatch;
	private String batch;
	private String date;

	private int total;
	private int totalForm;
	private int totalFinish;
	private int totalUnfinish;
	private int totalRecord;
	private String percent;

	/**
	 * @param filePath
	 * @param folderBatch
	 * @param batch
	 * @param date
	 * @param total
	 * @param totalForm
	 * @param totalFinish
	 * @param totalUnfinish
	 * @param totalRecord
	 * @param percent
	 */
	public DtoInfoProject(String filePath, String folderBatch, String batch,
			String date, int total, int totalForm, int totalFinish,
			int totalUnfinish, String percent, int totalRecord) {
		super();
		this.filePath = filePath;
		this.folderBatch = folderBatch;
		this.batch = batch;
		this.date = date;
		this.total = total;
		this.totalForm = totalForm;
		this.totalFinish = totalFinish;
		this.totalUnfinish = totalUnfinish;
		this.totalRecord = totalRecord;
		this.percent = percent;
	}

	public DtoInfoProject() {
		super();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFolderBatch() {
		return folderBatch;
	}

	public void setFolderBatch(String folderBatch) {
		this.folderBatch = folderBatch;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalForm() {
		return totalForm;
	}

	public void setTotalForm(int totalForm) {
		this.totalForm = totalForm;
	}

	public int getTotalFinish() {
		return totalFinish;
	}

	public void setTotalFinish(int totalFinish) {
		this.totalFinish = totalFinish;
	}

	public int getTotalUnfinish() {
		return totalUnfinish;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTotalUnfinish(int totalUnfinish) {
		this.totalUnfinish = totalUnfinish;
	}

	public String[] toArray() {

		return new String[] { this.folderBatch, this.batch, getDate(),
				this.total + "", this.totalForm + "", this.totalFinish + "",
				this.totalUnfinish + "", this.totalRecord + "", this.percent };
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getBatch() + "--" + getFolderBatch();
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

}
