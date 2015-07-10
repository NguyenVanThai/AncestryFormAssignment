package com.digitexx.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.digitexx.dto.DtoDigiTexx;
import com.digitexx.dto.DtoForm;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoUser;
import com.digitexx.dto.DtoUserPMS;
import com.digitexx.form.PgConnection;

public class DaoDatabase {
	private PgConnection pgCon;

	public DaoDatabase(String server, String port, String database,
			String schema, String userName, String password) {
		pgCon = new PgConnection();
		pgCon.loadConnectionFromParameters(server, port, database, schema,
				userName, password);
	}

	public List<String> getListGroup() {
		List<String> listUser = new ArrayList<String>();
		String query = "sp_get_list_pjm_name()";
		// Object[] params = {1};
		try (CachedRowSet rs = pgCon.functionSetOffRetrieve(query, null)) {
			while (rs.next()) {
				listUser.add(rs.getString("sp_get_list_pjm_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	public List<DtoUserPMS> getUserOfGroup(String groupName) {
		List<DtoUserPMS> listUser = new ArrayList<>();
		String query = "sp_get_DPO('" + groupName + "')";
		try (CachedRowSet rs = pgCon.functionSetOffRetrieve(query, null)) {
			while (rs.next()) {
				listUser.add(new DtoUserPMS(rs.getLong("usrer_id"), rs
						.getString("usrer_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	public List<DtoUserPMS> getListAllUser() {
		List<DtoUserPMS> listUser = new ArrayList<>();
		String query = "SELECT * FROM tbl_users ORDER BY usr_name";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				listUser.add(new DtoUserPMS(rs.getLong(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getInt(5), rs
						.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getString(9), rs.getString(10)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	public List<DtoProject> getListProject() {
		List<DtoProject> results = new ArrayList<>();
		String query = "select proj_id, proj_name, proj_schema, proj_uid, proj_pwd from tbl_projects where (proj_name like '%Ancestry%') and (proj_uid like '%ancestry%' and lower(proj_name) not like '%qc%')";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoProject(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5)));

			}
		} catch (Exception e) {
			results = null;
			e.printStackTrace();

		}
		return results;

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

	public List<DtoDigiTexx> getUserOfForm(int projecId, String listForm) {

		// System.out.println(list.toString());
		List<DtoDigiTexx> results = new ArrayList<>();
		String query = "select distinct(usr_name), * from tbl_digitexx where form_id in ("
				+ listForm + ") AND proj_id =" + projecId;
		System.out.println(query);
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoDigiTexx(rs.getInt("proj_id"), rs
						.getInt("usr_id"), rs.getString("usr_name"), rs
						.getInt("form_id"), rs.getString("form_name")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	public static void main(String[] arg) {
		DaoDatabase data = new DaoDatabase("10.10.5.10", "5432", "pms",
				"db_09_000_pms", "ps_pms", "digipms");
		// for (DtoUser d : data.getListAllOfGroup("Nguyễn Thị Thùy Trang")) {
		// System.out.println(d.getId() + "__" + d.getName());
		// }

	}

}
