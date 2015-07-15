package com.digitexx.dto;

public class DtoInfoBatch {
	private String filePath;
	private String folderBatch;
	private String batch;
	private String date;
	private String form;
	private int formId;
	private int total;
	private int totalForm;
	private int totalFinish;
	private int totalUnfinish;
	private String percent;
	private int totalRecord;
	private int totalUser;

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

	public DtoInfoBatch() {
		super();
	}

	/**
	 * @param filePath
	 * @param folderBatch
	 * @param batch
	 * @param date
	 * @param form
	 * @param formId
	 * @param total
	 * @param totalForm
	 * @param totalFinish
	 * @param totalUnfinish
	 * @param totalRecord
	 * @param percent
	 */
	public DtoInfoBatch(String filePath, String folderBatch, String batch,
			String date, String form, int formId, int total, int totalForm,
			int totalFinish, int totalUnfinish, String percent,
			int totalRecord, int totalUser) {
		super();
		this.filePath = filePath;
		this.folderBatch = folderBatch;
		this.batch = batch;
		this.date = date;
		this.form = form;
		this.formId = formId;
		this.total = total;
		this.totalForm = totalForm;
		this.totalFinish = totalFinish;
		this.totalUnfinish = totalUnfinish;
		this.totalRecord = totalRecord;
		this.percent = percent;
		this.totalUser = totalUser;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
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

	public int getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}

	public String[] toArray() {

		return new String[] { this.folderBatch, this.batch, this.date,
				this.form, this.total + "", this.totalForm + "",
				this.totalFinish + "", this.totalUnfinish + "",
				this.totalRecord + "", this.percent, this.totalUser + "" };
	}

	public String[] toArrayBatch() {

		return new String[] { this.folderBatch, this.batch, getDate(),
				this.form, this.formId + "", this.total + "",
				this.totalForm + "", this.totalFinish + "",
				this.totalUnfinish + "", this.totalRecord + "", this.percent };
	}
}
