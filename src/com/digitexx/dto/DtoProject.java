package com.digitexx.dto;

public class DtoProject {
	int id;
	String proj_name;
	int proj_prjtype_id;
	int proj_unit_id;
	String proj_path;
	String proj_serverip;
	String proj_dbname;
	String proj_schema;
	String proj_uid;
	String proj_pwd;
	String proj_pathfilejar;
	String proj_linuxpath;
	String proj_winpath;
	int proj_importtype;
	int proj_prjstatus_id;
	String proj_otherargument;
	String proj_listtable;
	String proj_deniedcolumn;
	boolean proj_isdigisoft;
	boolean run_ocr_server;
	String ocr_language;
	String win_browser_path;
	String linux_browser_path;
	boolean proj_autochecklist;
	boolean run_bar_server;
	boolean run_omr_server;
	boolean run_pdfa_server;
	boolean proj_isgroupproject;
	boolean run_adr_server;
	boolean run_csf_server;
	boolean sys_warning_msg;

	/**
	 * @param id
	 * @param proj_name
	 * @param proj_prjtype_id
	 * @param proj_unit_id
	 * @param proj_path
	 * @param proj_serverip
	 * @param proj_dbname
	 * @param proj_schema
	 * @param proj_uid
	 * @param proj_pwd
	 * @param proj_pathfilejar
	 * @param proj_linuxpath
	 * @param proj_winpath
	 * @param proj_importtype
	 * @param proj_prjstatus_id
	 * @param proj_otherargument
	 * @param proj_listtable
	 * @param proj_deniedcolumn
	 * @param proj_isdigisoft
	 * @param run_ocr_server
	 * @param ocr_language
	 * @param win_browser_path
	 * @param linux_browser_path
	 * @param proj_autochecklist
	 * @param run_bar_server
	 * @param run_omr_server
	 * @param run_pdfa_server
	 * @param proj_isgroupproject
	 * @param run_adr_server
	 * @param run_csf_server
	 * @param sys_warning_msg
	 */
	public DtoProject(int id, String proj_name, int proj_prjtype_id,
			int proj_unit_id, String proj_path, String proj_serverip,
			String proj_dbname, String proj_schema, String proj_uid,
			String proj_pwd, String proj_pathfilejar, String proj_linuxpath,
			String proj_winpath, int proj_importtype, int proj_prjstatus_id,
			String proj_otherargument, String proj_listtable,
			String proj_deniedcolumn, boolean proj_isdigisoft,
			boolean run_ocr_server, String ocr_language,
			String win_browser_path, String linux_browser_path,
			boolean proj_autochecklist, boolean run_bar_server,
			boolean run_omr_server, boolean run_pdfa_server,
			boolean proj_isgroupproject, boolean run_adr_server,
			boolean run_csf_server) {
		super();
		this.id = id;
		this.proj_name = proj_name;
		this.proj_prjtype_id = proj_prjtype_id;
		this.proj_unit_id = proj_unit_id;
		this.proj_path = proj_path;
		this.proj_serverip = proj_serverip;
		this.proj_dbname = proj_dbname;
		this.proj_schema = proj_schema;
		this.proj_uid = proj_uid;
		this.proj_pwd = proj_pwd;
		this.proj_pathfilejar = proj_pathfilejar;
		this.proj_linuxpath = proj_linuxpath;
		this.proj_winpath = proj_winpath;
		this.proj_importtype = proj_importtype;
		this.proj_prjstatus_id = proj_prjstatus_id;
		this.proj_otherargument = proj_otherargument;
		this.proj_listtable = proj_listtable;
		this.proj_deniedcolumn = proj_deniedcolumn;
		this.proj_isdigisoft = proj_isdigisoft;
		this.run_ocr_server = run_ocr_server;
		this.ocr_language = ocr_language;
		this.win_browser_path = win_browser_path;
		this.linux_browser_path = linux_browser_path;
		this.proj_autochecklist = proj_autochecklist;
		this.run_bar_server = run_bar_server;
		this.run_omr_server = run_omr_server;
		this.run_pdfa_server = run_pdfa_server;
		this.proj_isgroupproject = proj_isgroupproject;
		this.run_adr_server = run_adr_server;
		this.run_csf_server = run_csf_server;
		;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProj_name() {
		return proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	public int getProj_prjtype_id() {
		return proj_prjtype_id;
	}

	public void setProj_prjtype_id(int proj_prjtype_id) {
		this.proj_prjtype_id = proj_prjtype_id;
	}

	public int getProj_unit_id() {
		return proj_unit_id;
	}

	public void setProj_unit_id(int proj_unit_id) {
		this.proj_unit_id = proj_unit_id;
	}

	public String getProj_path() {
		return proj_path;
	}

	public void setProj_path(String proj_path) {
		this.proj_path = proj_path;
	}

	public String getProj_serverip() {
		return proj_serverip;
	}

	public void setProj_serverip(String proj_serverip) {
		this.proj_serverip = proj_serverip;
	}

	public String getProj_dbname() {
		return proj_dbname;
	}

	public void setProj_dbname(String proj_dbname) {
		this.proj_dbname = proj_dbname;
	}

	public String getProj_schema() {
		return proj_schema;
	}

	public void setProj_schema(String proj_schema) {
		this.proj_schema = proj_schema;
	}

	public String getProj_uid() {
		return proj_uid;
	}

	public void setProj_uid(String proj_uid) {
		this.proj_uid = proj_uid;
	}

	public String getProj_pwd() {
		return proj_pwd;
	}

	public void setProj_pwd(String proj_pwd) {
		this.proj_pwd = proj_pwd;
	}

	public String getProj_pathfilejar() {
		return proj_pathfilejar;
	}

	public void setProj_pathfilejar(String proj_pathfilejar) {
		this.proj_pathfilejar = proj_pathfilejar;
	}

	public String getProj_linuxpath() {
		return proj_linuxpath;
	}

	public void setProj_linuxpath(String proj_linuxpath) {
		this.proj_linuxpath = proj_linuxpath;
	}

	public String getProj_winpath() {
		return proj_winpath;
	}

	public void setProj_winpath(String proj_winpath) {
		this.proj_winpath = proj_winpath;
	}

	public int getProj_importtype() {
		return proj_importtype;
	}

	public void setProj_importtype(int proj_importtype) {
		this.proj_importtype = proj_importtype;
	}

	public int getProj_prjstatus_id() {
		return proj_prjstatus_id;
	}

	public void setProj_prjstatus_id(int proj_prjstatus_id) {
		this.proj_prjstatus_id = proj_prjstatus_id;
	}

	public String getProj_otherargument() {
		return proj_otherargument;
	}

	public void setProj_otherargument(String proj_otherargument) {
		this.proj_otherargument = proj_otherargument;
	}

	public String getProj_listtable() {
		return proj_listtable;
	}

	public void setProj_listtable(String proj_listtable) {
		this.proj_listtable = proj_listtable;
	}

	public String getProj_deniedcolumn() {
		return proj_deniedcolumn;
	}

	public void setProj_deniedcolumn(String proj_deniedcolumn) {
		this.proj_deniedcolumn = proj_deniedcolumn;
	}

	public boolean isProj_isdigisoft() {
		return proj_isdigisoft;
	}

	public void setProj_isdigisoft(boolean proj_isdigisoft) {
		this.proj_isdigisoft = proj_isdigisoft;
	}

	public boolean isRun_ocr_server() {
		return run_ocr_server;
	}

	public void setRun_ocr_server(boolean run_ocr_server) {
		this.run_ocr_server = run_ocr_server;
	}

	public String getOcr_language() {
		return ocr_language;
	}

	public void setOcr_language(String ocr_language) {
		this.ocr_language = ocr_language;
	}

	public String getWin_browser_path() {
		return win_browser_path;
	}

	public void setWin_browser_path(String win_browser_path) {
		this.win_browser_path = win_browser_path;
	}

	public String getLinux_browser_path() {
		return linux_browser_path;
	}

	public void setLinux_browser_path(String linux_browser_path) {
		this.linux_browser_path = linux_browser_path;
	}

	public boolean isProj_autochecklist() {
		return proj_autochecklist;
	}

	public void setProj_autochecklist(boolean proj_autochecklist) {
		this.proj_autochecklist = proj_autochecklist;
	}

	public boolean isRun_bar_server() {
		return run_bar_server;
	}

	public void setRun_bar_server(boolean run_bar_server) {
		this.run_bar_server = run_bar_server;
	}

	public boolean isRun_omr_server() {
		return run_omr_server;
	}

	public void setRun_omr_server(boolean run_omr_server) {
		this.run_omr_server = run_omr_server;
	}

	public boolean isRun_pdfa_server() {
		return run_pdfa_server;
	}

	public void setRun_pdfa_server(boolean run_pdfa_server) {
		this.run_pdfa_server = run_pdfa_server;
	}

	public boolean isProj_isgroupproject() {
		return proj_isgroupproject;
	}

	public void setProj_isgroupproject(boolean proj_isgroupproject) {
		this.proj_isgroupproject = proj_isgroupproject;
	}

	public boolean isRun_adr_server() {
		return run_adr_server;
	}

	public void setRun_adr_server(boolean run_adr_server) {
		this.run_adr_server = run_adr_server;
	}

	public boolean isRun_csf_server() {
		return run_csf_server;
	}

	public void setRun_csf_server(boolean run_csf_server) {
		this.run_csf_server = run_csf_server;
	}

	public boolean isSys_warning_msg() {
		return sys_warning_msg;
	}

	public void setSys_warning_msg(boolean sys_warning_msg) {
		this.sys_warning_msg = sys_warning_msg;
	}

}
