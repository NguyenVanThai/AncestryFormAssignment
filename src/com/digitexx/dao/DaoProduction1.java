package com.digitexx.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.digitexx.dto.DtoForm;
import com.digitexx.form.PgConnection;

public class DaoProduction1 {
	private PgConnection pgCon;

	public DaoProduction1(String schema, String userName, String password) {
		pgCon = new PgConnection();
		pgCon.loadConnectionFromParameters("10.10.5.10", "5432", "Production1",
				schema, userName, password);
		
	}
	
	public List<DtoForm> getListForm(){
		List<DtoForm> results = new ArrayList<>();
		
		String query = "select * from form_info where is_key = TRUE";
		try(CachedRowSet rs = pgCon.retrieve(query, null)){
			while(rs.next()){
				results.add(new DtoForm(rs.getInt(1), rs.getString(2)));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return results;
	}
	

	
	
	public static void main(String args[]) {
		DaoProduction1 daoProduction1 = new DaoProduction1("db_15_066_ancestry_44635","ps_15_066_ancestry_44635","digi15_066_ancestry_44635");
		daoProduction1.getListForm();
	}
}
