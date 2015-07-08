package com.digitexx.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.digitexx.dto.DtoForm;
import com.digitexx.dto.DtoInfo;
import com.digitexx.form.PgConnection;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class DaoProduction1 {
	private PgConnection pgCon;

	public DaoProduction1(String schema, String userName, String password) {
		pgCon = new PgConnection();
		pgCon.loadConnectionFromParameters("10.10.5.10", "5432", "Production1",
				schema, userName, password);

	}

	public List<DtoForm> getListForm() {
		List<DtoForm> results = new ArrayList<>();

		String query = "select * from form_info where is_key = TRUE";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoForm(rs.getInt(1), rs.getString(2)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	public List<String> getListFolderBatch() {
		List<String> results = new ArrayList<>();
		// String query =
		// "select regexp_replace(regexp_replace(filepath, '^.+Images/', ''),'/.+$','') as batch  from management group by  batch";
		String query = "select distinct regexp_replace(regexp_replace(filepath, '^.+Images/', ''),'/.+$','') as batch  from management ";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	public List<String> getListBatch(String folderBatch) {
		List<String> results = new ArrayList<>();
		// Object[] params = { folderBatch, folderBatch };
		String query = "select regexp_replace(regexp_replace(filepath, '^.+/Images/"
				+ folderBatch
				+ "/', ''), '/.+$', '') as subphase from management  where filepath like '%/Images/"
				+ folderBatch + "/%' group by subphase";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	public List<String> getListForm(String folderBatch, String batch) {
		List<String> results = new ArrayList<>();
		// Object[] params = { folderBatch, folderBatch };
		String param = folderBatch + "/" + batch;
		String query = "select distinct b.name from management as a, form_info as b where filepath like '%"
				+ param + "%' AND a.formid = b.form_id ;";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(rs.getString(1) + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	public int getTotalAmount(int type, String batch) {
		int total = 0;
		String batchTemp = "";
		if (!(batch == null || batch.isEmpty())) {

			batchTemp = " AND (filepath like" + "'%" + batch + "%')";
		}
		String query = "select count(*) from management ";
		switch (type) {
		case 0:
			if (!batchTemp.equals("")) {
				query += " where (filepath like" + "'%" + batch + "%')";
			}
			break;
		case 1:// Total Amount Form Not input
			query += "where formid IN  (select form_id from form_info where (form_key = FALSE))"
					+ batchTemp;
			break;
		case 2:
			query += "where (step = 4) AND (badimage = 0)" + batchTemp;
			break;
		case 3:
			query += "where (step != 4) AND (badimage = 0)" + batchTemp;
			break;
		}

		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	// public String[] getData(String batch) {
	// int total = 0;
	// String batchTemp = "";
	// if (!(batch == null || batch.isEmpty())) {
	//
	// batchTemp = " AND (filepath like" + "'%" + batch + "%')";
	// }
	// String query = "select count(*) from management ";
	// switch (type) {
	// case 0:
	// if (!batchTemp.equals("")) {
	// query += " where (filepath like" + "'%" + batch + "%')";
	// }
	// break;
	// case 1:// Total Amount Form Not input
	// query +=
	// "where formid IN  (select form_id from form_info where (form_key = FALSE))"
	// + batchTemp;
	// break;
	// case 2:
	// query += "where (step = 4) AND (badimage = 0)" + batchTemp;
	// break;
	// case 3:
	// query += "where (step != 4) AND (badimage = 0)" + batchTemp;
	// break;
	// }
	//
	// try (CachedRowSet rs = pgCon.retrieve(query, null)) {
	// while (rs.next()) {
	// total = rs.getInt(1);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return total;
	// }
	public List<DtoInfo> getListDtoInfo() {
		String query = "select m.filepath,regexp_replace(regexp_replace(filepath, '^.+Images/', ''),'/.+$','') as folderbatch, "
				+ "regexp_replace(regexp_replace(filepath, '^.+Images/[^/]+/', ''),'/.+$','') as batch, "
				+ "count(*) as total, "
				+ "sum(case when f.is_key = false then 1 else 0 end) as total_form_notinput, "
				+ "sum(case when (m.step = 4 AND m.badimage = 0) then 1 else 0 end) as total_finish, "
				+ "sum(case when (m.step !=4) then 1 else 0 end) as total_unfinish "
				+ "from  management m left join form_info f  on f.form_id = m.formid group by 1,2;";
		List<DtoInfo> results = new ArrayList<DtoInfo>();
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoInfo(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;

	}

	public static void main(String args[]) {
		DaoProduction1 daoProduction1 = new DaoProduction1(
				"db_15_066_ancestry_44635", "ps_15_066_ancestry_44635",
				"digi15_066_ancestry_44635");
		daoProduction1.getListForm();
	}

}
