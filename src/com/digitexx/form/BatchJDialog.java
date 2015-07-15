package com.digitexx.form;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.digitexx.dao.DaoDatabase;
import com.digitexx.dto.DtoInfo;
import com.digitexx.dto.DtoInfoBatch;
import com.digitexx.dto.DtoInfoProject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BatchJDialog extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JLabel jLabel2;
	private JList jList1;
	private JScrollPane jScrollPane2;
	private JPanel jPanel3;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JTable jTableInfo;

	List<DtoInfoBatch> listInfoBatch;
	private int projectID;
	private DaoDatabase daoPms;

	/**
	 * Auto-generated main method to display this JDialog
	 */

	public BatchJDialog(int projectID, List<DtoInfoBatch> listInfoBatch) {

		initGUI();
		this.listInfoBatch = listInfoBatch;
		this.projectID = projectID;
		String[] totalColumn = new String[] { "FolderBatch", "BatchName", "DeliveryDate",
				"FormName", "TotalImage", "UnkeyTotalImage", "FinishTotalImage",
				"UnfinishTotalImage", "TotalRecord", "%Finish", "TotalUser" };
		DefaultTableModel model = new DefaultTableModel(null, totalColumn) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		for (DtoInfoBatch a : listInfoBatch) {

			model.addRow(a.toArray());
		}
		jTableInfo.setModel(model);
//		this.setLocationRelativeTo(null);
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setTitle("Batch Detail Information");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/image/icon.png")).getImage());
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout(
						(JComponent) jPanel1);
				jPanel1.setLayout(jPanel1Layout);
//				jPanel1.setPreferredSize(new java.awt.Dimension(770, 397));
				{
					jScrollPane1 = new JScrollPane();
					{

						jTableInfo = new JTable();
						jScrollPane1.setViewportView(jTableInfo);

						jTableInfo.setRowHeight(30);
						jTableInfo.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jTableInfoMouseClicked(evt);
							}
						});

					}
				}
				{
					jPanel3 = new JPanel();
					GroupLayout jPanel3Layout = new GroupLayout(
							(JComponent) jPanel3);
					jPanel3.setLayout(jPanel3Layout);
					{
						jScrollPane2 = new JScrollPane();
						jScrollPane2.setBounds(0, 25, 376, 253);
						{
							
							jList1 = new JList();
							jScrollPane2.setViewportView(jList1);
							jList1.setLayoutOrientation(JList.HORIZONTAL_WRAP);

						}
					}
					{
						jLabel2 = new JLabel();
						jLabel2.setText("LIST USER");
						jLabel2.setBounds(0, 0, 376, 25);
						jLabel2.setFont(new java.awt.Font("Times New Roman", 1,
								20));
						jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
					}
					jPanel3Layout
							.setHorizontalGroup(jPanel3Layout
									.createParallelGroup()
									.addComponent(jScrollPane2,
											GroupLayout.Alignment.LEADING, 0,
											376, Short.MAX_VALUE)
									.addGroup(
											jPanel3Layout
													.createSequentialGroup()
													.addComponent(jLabel2, 0,
															376,
															Short.MAX_VALUE)
													.addPreferredGap(
															LayoutStyle.ComponentPlacement.RELATED)));
					jPanel3Layout
							.setVerticalGroup(jPanel3Layout
									.createSequentialGroup()
									.addComponent(jLabel2,
											GroupLayout.PREFERRED_SIZE, 25,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(jScrollPane2, 0, 253,
											Short.MAX_VALUE));
				}
				{
					jLabel1 = new JLabel();
					GroupLayout jLabel1Layout = new GroupLayout(
							(JComponent) jLabel1);
					jLabel1.setLayout(jLabel1Layout);
					jLabel1.setText("BATCH DETAIL INFORMATION");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36));
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1Layout.setVerticalGroup(jLabel1Layout
							.createSequentialGroup());
					jLabel1Layout.setHorizontalGroup(jLabel1Layout
							.createSequentialGroup());
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout
						.createParallelGroup()
						.addComponent(jLabel1, GroupLayout.Alignment.LEADING,
								0, 770, Short.MAX_VALUE)
						.addComponent(jScrollPane1,
								GroupLayout.Alignment.LEADING, 0, 770,
								Short.MAX_VALUE)
						.addComponent(jPanel3, GroupLayout.Alignment.LEADING,
								0, 770, Short.MAX_VALUE));
				jPanel1Layout
						.setVerticalGroup(jPanel1Layout
								.createSequentialGroup()
								.addGap(8)
								.addComponent(jLabel1,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane1, 0, 225,
										Short.MAX_VALUE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel3, 0, 104, Short.MAX_VALUE));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addComponent(jPanel1, 0, 397, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addComponent(jPanel1, 0, 770, Short.MAX_VALUE));
			this.setSize(1231, 484);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jTableInfoMouseClicked(MouseEvent evt) {
		int row = jTableInfo.getSelectedRow();
		daoPms = new DaoDatabase("10.10.5.10", "5432", "pms", "db_09_000_pms",
				"ps_pms", "digipms");
		
		List<String> listUser = daoPms.getUserOfForm(projectID, listInfoBatch
				.get(row).getFormId());
		System.out.println(listUser.size() + "");
		ListModel jList1Model = new DefaultComboBoxModel(
				listUser.toArray());
		jList1.setModel(jList1Model);
	}

}
