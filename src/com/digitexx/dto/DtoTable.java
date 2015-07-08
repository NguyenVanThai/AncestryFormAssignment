package com.digitexx.dto;

public class DtoTable {
private String folderBatch;
private String batch;
private String date;
private String total;
private String totalForm;
private String totalFinish;
private String totalUnFinish;



/**
 * @param folderBatch
 * @param batch
 * @param date
 * @param total
 * @param totalForm
 * @param totalFinish
 * @param totalUnFinish
 */
public DtoTable(String folderBatch, String batch, String date, String total,
		String totalForm, String totalFinish, String totalUnFinish) {
	super();
	this.folderBatch = folderBatch;
	this.batch = batch;
	this.date = date;
	this.total = total;
	this.totalForm = totalForm;
	this.totalFinish = totalFinish;
	this.totalUnFinish = totalUnFinish;
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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
public String getTotalForm() {
	return totalForm;
}
public void setTotalForm(String totalForm) {
	this.totalForm = totalForm;
}
public String getTotalFinish() {
	return totalFinish;
}
public void setTotalFinish(String totalFinish) {
	this.totalFinish = totalFinish;
}
public String getTotalUnFinish() {
	return totalUnFinish;
}
public void setTotalUnFinish(String totalUnFinish) {
	this.totalUnFinish = totalUnFinish;
}

public String[] toArray(){
	return new String[]{
			folderBatch,
			batch,
			date,
			total,
			totalForm,
			totalFinish,
			totalUnFinish
	};
	
}
}
