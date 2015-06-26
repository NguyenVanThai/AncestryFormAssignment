package com.digitexx.dto;

public class DtoProject {
	int id;
	String name;
	String schema;
	String uid;
	String password;
	/**
	 * @param id
	 * @param name
	 * @param schema
	 */
	public DtoProject(int id, String name, String schema, String uid, String password) {
		super();
		this.id = id;
		this.name = name;
		this.schema = schema;
		this.uid = uid;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
