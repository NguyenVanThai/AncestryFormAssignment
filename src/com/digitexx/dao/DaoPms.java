package com.digitexx.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

import com.digitexx.dto.DtoGroup;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoUser;
import com.digitexx.form.PgConnection;

public class DaoPms {
	private PgConnection pgCon;

	public DaoPms() {
		pgCon = new PgConnection();
		pgCon.loadConnectionFromParameters("10.10.5.10", "5432", "pms",
				"db_09_000_pms", "ps_pms", "digipms");
	}

	// public List<String> getListUser() {
	// List<String> results = new ArrayList<>();
	// String query = "select * from tbl_users";
	// // Object[] params = {1};
	// try (CachedRowSet rs = pgCon.retrieve(query, null)) {
	// while (rs.next()) {
	// results.add(rs.getString("usr_name"));
	// System.out.println(rs.getString("usr_name"));
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return results;
	//
	// }

	// public List<String> getListUserFunction() {
	// List<String> results = new ArrayList<>();
	// String query = "sp_get_list_pjm_name()";
	// // Object[] params = {1};
	// try (CachedRowSet rs = pgCon.functionSetOffRetrieve(query, null)) {
	// while (rs.next()) {
	// results.add(rs.getString(1));
	// System.out.println(rs.getString(1));
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return results;
	//
	// }

	public List<DtoGroup> getListGroup() {
		List<DtoGroup> results = new ArrayList<>();
		String query = "select grp_id, grp_name from tbl_groups";
		// Object[] params = {1};
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoGroup(rs.getInt(1), rs.getString(2)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;

	}

	public List<DtoUser> getListUser(int groupId) {
		List<DtoUser> results = new ArrayList<>();
		String query = "select usr_id, usr_name from tbl_users where usr_grp_id = ?";
		Object[] params = { groupId };
		try (CachedRowSet rs = pgCon.retrieve(query, params)) {
			while (rs.next()) {
				results.add(new DtoUser(rs.getInt(1), rs.getString(2)));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;

	}

	public List<DtoProject> getListProject() {
		List<DtoProject> results = new ArrayList<>();
		String query = "select proj_id, proj_name, proj_schema, proj_uid, proj_pwd from tbl_projects where (proj_name like '%Ancestry%') and lower(proj_name) not like '%qc%' and lower(proj_name) not like '%training%'";

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

	public int[] setListUser(List<Object[]> listParams) {

		int[] results;
		String query = "insert into digitexx (proj_id, proj_name,usr_id,usr_name,form_id,form_name) values (?,?,?,?,?,?)";
		// listParams.add(new
		// Object[]{222,"ancestry",222,"NguyeVanA",222,"Form1"});
		// List<Object[]> listParams = new ArrayList<>();
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		results = pgCon.executeMultiple(query, listParams);
		return results;

	}

	public List<String> getListUserFromForm() {
		// List<String> listUser =

		return null;
	}

	public static void main(String args[]) {
		DaoPms s = new DaoPms();
		DaoProduction1 daoProduction1 = new DaoProduction1(s.getListProject()
				.get(0).getSchema(), s.getListProject().get(0).getUid(), s
				.getListProject().get(0).getPassword());
		// daoProduction1.getListForm();
		// s.getListProject().get(0).getSchema();
	}
}
