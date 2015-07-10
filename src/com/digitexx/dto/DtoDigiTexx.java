package com.digitexx.dto;

public class DtoDigiTexx {
	private int id;
	private int projecId;
	private String projecName;
	private int userId;
	private String userName;
	private int formid;
	private String formName;

	/**
	 * @param id
	 * @param projecId
	 * @param projecName
	 * @param userId
	 * @param userName
	 * @param formid
	 * @param formName
	 */
	public DtoDigiTexx(int id, int projecId, String projecName, int userId,
			String userName, int formid, String formName) {
		super();
		this.id = id;
		this.projecId = projecId;
		this.projecName = projecName;
		this.userId = userId;
		this.userName = userName;
		this.formid = formid;
		this.formName = formName;
	}

	public DtoDigiTexx(int projecId, int userId, String userName, int formid,
			String formName) {
		super();
		this.projecId = projecId;
		this.userId = userId;
		this.userName = userName;
		this.formid = formid;
		this.formName = formName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjecId() {
		return projecId;
	}

	public void setProjecId(int projecId) {
		this.projecId = projecId;
	}

	public String getProjecName() {
		return projecName;
	}

	public void setProjecName(String projecName) {
		this.projecName = projecName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
