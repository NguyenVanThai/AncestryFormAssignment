package com.digitexx.dto;

public class DtoGroup {
	int id;
	String name;
	/**
	 * @param id
	 * @param name
	 */
	public DtoGroup(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	
	
}
