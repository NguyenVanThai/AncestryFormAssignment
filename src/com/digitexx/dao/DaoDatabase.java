package com.digitexx.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.digitexx.dto.DtoDigiTexx;
import com.digitexx.dto.DtoForm;
import com.digitexx.dto.DtoInfoBatch;
import com.digitexx.dto.DtoInfoProject;
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

	public DaoDatabase() {
		pgCon = new PgConnection();
		pgCon.loadConnectionFromProperties("conf/db.properties");

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
		// String query = "sp_get_DPO('" + groupName + "')";

		String query = "select * from sp_get_DPO('" + groupName
				+ "') order by usrer_name";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
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
		// String query =
		// "select proj_id, proj_name, proj_schema, proj_uid, proj_pwd from tbl_projects where (proj_name like '%Ancestry%') and (proj_uid like '%ancestry%' and lower(proj_name) not like '%qc%')";
		String query = "select *from tbl_projects where (proj_name like '%Ancestry%') order by proj_name";

		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoProject(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getInt(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11), rs
						.getString(12), rs.getString(13), rs.getInt(14), rs
						.getInt(15), rs.getString(16), rs.getString(17), rs
						.getString(18), rs.getBoolean(19), rs.getBoolean(20),
						rs.getString(21), rs.getString(22), rs.getString(23),
						rs.getBoolean(24), rs.getBoolean(25),
						rs.getBoolean(27), rs.getBoolean(28),
						rs.getBoolean(29), rs.getBoolean(30), rs.getBoolean(31)));

			}
		} catch (Exception e) {
			// results = null;
			e.printStackTrace();

		}
		return results;

	}

	public DtoProject getProject() {
		DtoProject results = null;
		// String query =
		// "select proj_id, proj_name, proj_schema, proj_uid, proj_pwd from tbl_projects where (proj_name like '%Ancestry%') and (proj_uid like '%ancestry%' and lower(proj_name) not like '%qc%')";
		String query = "select *from tbl_projects where (proj_name like '%Ancestry%') AND proj_schema = 'db_14_000_qc_ancestry' ";

		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results = new DtoProject(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getInt(14),
						rs.getInt(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getBoolean(19), rs.getBoolean(20),
						rs.getString(21), rs.getString(22), rs.getString(23),
						rs.getBoolean(24), rs.getBoolean(25),
						rs.getBoolean(27), rs.getBoolean(28),
						rs.getBoolean(29), rs.getBoolean(30), rs.getBoolean(31));

			}
		} catch (Exception e) {
			// results = null;
			e.printStackTrace();

		}
		return results;

	}

	public List<DtoDigiTexx> getUserOfForm(int projecId, String listForm) {

		// System.out.println(list.toString());
		List<DtoDigiTexx> results = new ArrayList<>();
		String query = "select distinct(usr_name), * from tbl_list_user_in_project where form_id in ("
				+ listForm
				+ ") AND proj_id ="
				+ projecId
				+ " order by usr_name";
		List<String> d = new ArrayList<>();
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				if (!d.contains(rs.getString("usr_name"))) {
					results.add(new DtoDigiTexx(rs.getInt("proj_id"), rs
							.getInt("usr_id"), rs.getString("usr_name"), rs
							.getInt("form_id"), rs.getString("form_name")));
					d.add(rs.getString("usr_name"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

	public int[] setListUser(List<Object[]> listParams) {

		int[] results;
		String query = "insert into tbl_list_user_in_project (proj_id, proj_name,usr_id,usr_name,form_id,form_name) values (?,?,?,?,?,?)";
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

	public void deleteUser(String projId, List<Integer> list, String usrId) {

		int results;
		String temp = list.toString();
		temp = temp.substring(1, temp.length() - 1);
		// String query =
		// "delete from tbl_list_user_in_project where proj_id = ? and form_id = ? and usr_id = ?";
		String query = "delete from tbl_list_user_in_project where proj_id ="
				+ projId + "and form_id in (" + temp + ") and usr_id =" + usrId;

		// listParams.add(new
		// Object[]{222,"ancestry",222,"NguyeVanA",222,"Form1"});
		// List<Object[]> listParams = new ArrayList<>();
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		// listParams.add(new Object[] { "t1", "t1", "t1" });
		System.out.println(query);
		results = pgCon.execute(query, null);

	}

	public List<String> getUserOfForm(int projectID, int formID) {
		List<String> listUser = new ArrayList<String>();
		Object[] params = { projectID, formID };
		String query = "select usr_name from tbl_list_user_in_project where proj_id = ? and form_id = ?";
		try (CachedRowSet rs = pgCon.retrieve(query, params)) {
			while (rs.next()) {

				listUser.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	// /------------------------------ Database Production 1
	// --------------------------------------------------------------
	public List<DtoForm> getListForm() {
		List<DtoForm> results = new ArrayList<>();

		String query = "select * from form_info where is_key = TRUE order by form_id";
		try (CachedRowSet rs = pgCon.retrieve(query, null)) {
			while (rs.next()) {
				results.add(new DtoForm(rs.getInt(1), rs.getString(2)));

			}
		} catch (Exception e) {
			return results = null;
			// e.printStackTrace();
		}

		return results;
	}

	public List<DtoInfoProject> getInfoProject(int projectID) {

		// DaoDatabase production1 = new DaoDatabase("10.10.5.10", "5432",
		// "Production1",
		// "db_14_000_qc_ancestry", "rls_lvthai", "tumotdenchin");
		List<DtoInfoProject> listUser = new ArrayList<DtoInfoProject>();
		String query = "sp_projectinfo(?)";
		Object[] params = { projectID };
		try (CachedRowSet rs = pgCon.functionSetOffRetrieve(query, params)) {
			while (rs.next()) {
				listUser.add(new DtoInfoProject(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getString(9), rs.getInt(10)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	public List<DtoInfoBatch> getInfoBatch(int projectID, String path) {

		// DaoDatabase production1 = new DaoDatabase("10.10.5.10", "5432",
		// "Production1",
		// "db_14_000_qc_ancestry", "rls_lvthai", "tumotdenchin");
		System.out.println(path);
		List<DtoInfoBatch> listUser = new ArrayList<DtoInfoBatch>();
		String query = "sp_projectinfo_2(?,?)";
		Object[] params = { projectID, path };
		try (CachedRowSet rs = pgCon.functionSetOffRetrieve(query, params)) {
			while (rs.next()) {
				listUser.add(new DtoInfoBatch(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs
								.getInt(6), rs.getInt(7), rs.getInt(8), rs
								.getInt(9), rs.getInt(10), rs.getString(11), rs
								.getInt(12), rs.getInt(13)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	// public static void main(String[] arg) {
	// DaoDatabase data = new DaoDatabase("10.10.5.10", "5432", "pms",
	// "db_09_000_pms", "ps_pms", "digipms");
	// // for (DtoUser d : data.getListAllOfGroup("Nguyễn Thị Thùy Trang")) {
	// // System.out.println(d.getId() + "__" + d.getName());
	// // }
	//
	// }

}
