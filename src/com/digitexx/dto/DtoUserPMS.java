/**
 * 
 */
package com.digitexx.dto;

/**
 * @author lqnhu
 * 
 */
public class DtoUserPMS {
	private long usr_id;
	private String usr_name;
	private String usr_fullname;
	private String usr_password;
	private int usr_grp_id;
	private int usr_status;
	private int usr_dept_id;
	private int usr_pos_id;

	private String usr_code;
	private String usr_note;

	/**
	 * @param usr_id
	 * @param usr_name
	 * @param usr_fullname
	 * @param usr_password
	 * @param usr_grp_id
	 * @param usr_status
	 * @param usr_dept_id
	 * @param usr_pos_id
	 * @param usr_code
	 * @param usr_note
	 */
	public DtoUserPMS(long usr_id, String usr_name, String usr_fullname,
			String usr_password, int usr_grp_id, int usr_status,
			int usr_dept_id, int usr_pos_id, String usr_code, String usr_note) {
		super();
		this.usr_id = usr_id;
		this.usr_name = usr_name;
		this.usr_fullname = usr_fullname;
		this.usr_password = usr_password;
		this.usr_grp_id = usr_grp_id;
		this.usr_status = usr_status;
		this.usr_dept_id = usr_dept_id;
		this.usr_pos_id = usr_pos_id;
		this.usr_code = usr_code;
		this.usr_note = usr_note;
	}

	public DtoUserPMS(long usr_id, String usr_name) {
		super();
		this.usr_id = usr_id;
		this.usr_name = usr_name;

	}

	public long getUsr_id() {
		return usr_id;
	}

	public String getUsr_name() {
		return usr_name;
	}

	public String getUsr_fullname() {
		return usr_fullname;
	}

	public String getUsr_password() {
		return usr_password;
	}

	public int getUsr_grp_id() {
		return usr_grp_id;
	}

	public int getUsr_status() {
		return usr_status;
	}

	public int getUsr_dept_id() {
		return usr_dept_id;
	}

	public int getUsr_pos_id() {
		return usr_pos_id;
	}

	public String getUsr_code() {
		return usr_code;
	}

	public String getUsr_note() {
		return usr_note;
	}

	public void setUsr_id(long usr_id) {
		this.usr_id = usr_id;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public void setUsr_fullname(String usr_fullname) {
		this.usr_fullname = usr_fullname;
	}

	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}

	public void setUsr_grp_id(int usr_grp_id) {
		this.usr_grp_id = usr_grp_id;
	}

	public void setUsr_status(int usr_status) {
		this.usr_status = usr_status;
	}

	public void setUsr_dept_id(int usr_dept_id) {
		this.usr_dept_id = usr_dept_id;
	}

	public void setUsr_pos_id(int usr_pos_id) {
		this.usr_pos_id = usr_pos_id;
	}

	public void setUsr_code(String usr_code) {
		this.usr_code = usr_code;
	}

	public void setUsr_note(String usr_note) {
		this.usr_note = usr_note;
	}

}
