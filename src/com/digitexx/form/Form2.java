package com.digitexx.form;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sun.awt.OSInfo.OSType;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.dao.DaoPms;
import com.digitexx.dao.DaoProduction1;
import com.digitexx.dto.DtoInfo;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoTable;

import info.clearthought.layout.TableLayout;

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
public class Form2 extends javax.swing.JFrame implements ListSelectionListener {
	private JPanel jPanel1;
	private JComboBox<String> jComboBoxProject;
	private JLabel jLabel1;
	static private JList jListFolderBatch;
	private JScrollPane jScrollPane1;
	private static List<DtoProject> listProject;
	private static DaoPms daoPms;
	private List<String> listFolderBatch;
	private JScrollPane jScrollPane2;
	private JTable jTable;
	private JLabel jLabel2;
	private JLabel jLabel3;
	DaoProduction1 daoProduction1;
	private int row = -1,col = 0;
	List<DtoInfo> listInfo;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Form2 inst = new Form2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Form2() {
		super();
		initGUI();
		daoPms = new DaoPms();

		listProject = daoPms.getListProject();

		String[] arrProject = new String[listProject.size()];

		for (int i = 0; i < listProject.size(); i++) {
			arrProject[i] = listProject.get(i).getName();
		}

		ComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(
				arrProject);
		jComboBoxProject.setModel(comboBoxModel);
		// jComboBoxProject.requestFocus();
		// jComboBoxProject.setSelectedIndex(0);
		if (jComboBoxProject.getModel().getSize() != 0) {
			// jComboBoxProjectItemStateChanged(new ItemEvent));
//			jComboBoxProject.setSelectedIndex(1);
		}
		// final int selectedIndex = jComboBoxProject.getSelectedIndex();
		// if (selectedIndex < jComboBoxProject.getItemCount()) {
		// jComboBoxProject.setSelectedIndex(selectedIndex + 1);
		// }
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(267, 154, 300,
							10, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("List Folder Batch");
					jLabel1.setPreferredSize(new java.awt.Dimension(178, 21));
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20));
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2, new AnchorConstraint(310, 987,
							977, 165, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(1017,
							425));
					{

						jTable = new JTable();
						
						/**
						 *@author nvthai
						 *Update cell selection 
						 */
						ListSelectionModel rowSelMod = jTable.getSelectionModel();
						ListSelectionModel colSelMod = jTable.getColumnModel().getSelectionModel();
						rowSelMod.addListSelectionListener(this);
						colSelMod.addListSelectionListener(this);
						jTable.setRowHeight(30);
						jTable.setCellSelectionEnabled(true);
						//end
						
						
						jScrollPane2.setViewportView(jTable);
						AnchorLayout jTableLayout = new AnchorLayout();
						jTable.setLayout(jTableLayout);
						jTable.setFillsViewportHeight(true);
						jTable.setPreferredSize(new java.awt.Dimension(1013,
								401));
						jTable.addVetoableChangeListener(new VetoableChangeListener() {
							public void vetoableChange(PropertyChangeEvent evt) {
								System.out.println("jTable.vetoableChange, event="+evt);
								//TODO add your code for jTable.vetoableChange
							}
						});
										jTable.addMouseListener(new MouseAdapter() {
											public void mouseClicked(MouseEvent evt) {
												jTableMouseClicked(evt);
											}
										});
					}
				}
				{

					jComboBoxProject = new JComboBox<>();
					jPanel1.add(jComboBoxProject, new AnchorConstraint(186,
							666, 245, 399, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));

					jComboBoxProject.setPreferredSize(new java.awt.Dimension(
							330, 38));
					jComboBoxProject.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							jComboBoxProjectItemStateChanged(evt);
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(310, 156,
							980, 10, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(181,
							427));
					{

						jListFolderBatch = new JList();
						jScrollPane1.setViewportView(jListFolderBatch);

						jListFolderBatch.setSelectedIndex(0);
						jListFolderBatch
								.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jListFolderBatch
								.setPreferredSize(new java.awt.Dimension(175,
										417));
						jListFolderBatch
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListFolderBatchValueChanged(evt);
									}
								});

					}
				}
				{
					jPanel1.add(jLabel1, new AnchorConstraint(266, 616, 300,
							532, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Table Data");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel1.setPreferredSize(new java.awt.Dimension(104, 22));
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(192, 400, 228,
							328, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Project:");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24));
					jLabel1.setPreferredSize(new java.awt.Dimension(89, 23));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(266, 152, 299,
							10, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("List Folder Batch");
					jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel2.setPreferredSize(new java.awt.Dimension(176, 21));
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(63, 550, 171,
							399, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("FORM 1");
					jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48));
					jLabel3.setPreferredSize(new java.awt.Dimension(186, 69));
				}
			}
			pack();
			this.setSize(1253, 676);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jListBatchValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			// String batchParen =
			// jListFolderBatch.getSelectedValue().toString();
			// if (jListBatch.getSelectedValue() != null) {
			// String batch = jListBatch.getSelectedValue().toString();
			// txtDate.setText(daoPms.getDate(batchParen, batch));
			// }
		}
	}

	private void jComboBoxProjectItemStateChanged(ItemEvent evt) {

		// Thread t = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// // thread goi progress bar.
		// if (evt.getStateChange() == ItemEvent.SELECTED) {
		// try{
		// int index = jComboBoxProject.getSelectedIndex();
		// String schema = listProject.get(index).getSchema();
		// daoProduction1 = new
		// DaoProduction1(listProject.get(index).getSchema(),
		// listProject.get(index).getUid(), listProject.get(index)
		// .getPassword());
		// listFolderBatch = new ArrayList<>();
		// listFolderBatch = daoProduction1.getListFolderBatch();
		//
		// ListModel jListGroupModel = new DefaultComboBoxModel(
		// listFolderBatch.toArray());
		// jListFolderBatch.setModel(jListGroupModel);
		// System.out.println(listProject.get(index).getSchema());
		// }catch(Exception e){
		// e.printStackTrace();
		// JOptionPane.showMessageDialog(null, "Project not support");
		// }

		if (evt.getStateChange() == ItemEvent.SELECTED) {
			// int index = jComboBoxProject.getSelectedIndex();
			// // List<String> list = new ArrayList<>();
			// String batch, date, total, total_form, total_finish,
			// total_unfinish;
			// List<DtoTable> listData = new ArrayList<>();
			// String schema = listProject.get(index).getSchema();
			// daoProduction1 = new DaoProduction1(listProject.get(index)
			// .getSchema(), listProject.get(index).getUid(), listProject
			// .get(index).getPassword());
			// listFolderBatch = daoProduction1.getListFolderBatch();
			//
			// int count = 0;
			// for (int i = 0; i < listFolderBatch.size(); i++) {
			// String folderBatch = listFolderBatch.get(i);
			//
			// List<String> listBatch = daoProduction1
			// .getListBatch(folderBatch);
			// for (int j = 0; j < listBatch.size(); j++) {
			// batch = listBatch.get(j).toString();
			// date = daoPms.getDate(folderBatch, batch);
			// total = daoProduction1.getTotalAmount(0, batch) + "";
			// total_form = daoProduction1.getTotalAmount(1, batch) + "";
			// total_finish = daoProduction1.getTotalAmount(2, batch) + "";
			// total_unfinish = daoProduction1.getTotalAmount(3, batch)
			// + "";
			//
			// listData.add(new DtoTable(folderBatch, batch, date, total,
			// total_form,
			// total_finish, total_unfinish));
			// }
			// }
			// System.out.println(listData.size());
			// DefaultTableModel model = new DefaultTableModel(null, new
			// String[]{"folder_batch", "batch", "date", "total",
			// "total_form", "total_finish", "total_unfinish"});
			// for(DtoTable a: listData){
			// model.addRow(a.toArray());
			// }
			// jTable.setModel(model);
			// jTable.revalidate();

			int index = jComboBoxProject.getSelectedIndex();
			daoProduction1 = new DaoProduction1(listProject.get(index)
					.getSchema(), listProject.get(index).getUid(), listProject
					.get(index).getPassword());
			listInfo = daoProduction1.getListDtoInfo();
			String[] totalColumn = new String[] { "folder_batch","batch", "date", "total",
					"total_form", "total_finish", "total_unfinish" };
			DefaultTableModel model = new DefaultTableModel(null, totalColumn);
			for (DtoInfo a : listInfo) {
				
				model.addRow(a.toArray(daoPms.getDate(a.getFilePath())));
			}
			jTable.setModel(model);
			System.out.println(listProject.get(index).getSchema());
		}
	}

	private void jListFolderBatchValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			int index = jListFolderBatch.getSelectedIndex();
			// DaoProduction1 daoProduction1 = new
			// DaoProduction1(listProject.get(
			// index).getSchema(), listProject.get(index).getUid(),
			// listProject.get(index).getPassword());
			// String folderBatch = listFolderBatch.get(index);
			// System.out.println(folderBatch + "__" + index);
			// ListModel listModel = new DefaultComboBoxModel(daoProduction1
			// .getListBatch(folderBatch).toArray());

			// jListBatch.setModel(listModel);
			//
			// jLabelTotalMount.setText(daoProduction1.getTotalAmount(0,
			// folderBatch) + "");
			// jLabelTotalFormNoInput.setText(daoProduction1.getTotalAmount(1,
			// folderBatch) + "");
			// jLabelTotalInput.setText(daoProduction1.getTotalAmount(2,
			// folderBatch) + "");
			// jLabelTotalNoInput.setText(daoProduction1.getTotalAmount(3,
			// folderBatch) + "");

			// jListBatch.setSelectedIndex(0);

//			String folderBatch = listFolderBatch.get(index);
//
//			Object[] listBatch = daoProduction1.getListBatch(folderBatch)
//					.toArray();
//			ListModel listModel = new DefaultComboBoxModel();
//			String[] totalColumn = new String[] { "batch", "date", "total",
//					"total_form", "total_finish", "total_unfinish" };
//			String[][] data = new String[listBatch.length][totalColumn.length];
//			String batchParen = jListFolderBatch.getSelectedValue().toString();
//			String batch, date, total, total_form, total_finish, total_unfinish;
//
//			for (int i = 0; i < data.length; i++) {
//
//				batch = listBatch[i].toString();
//				date = daoPms.getDate(batchParen, batch);
//				total = daoProduction1.getTotalAmount(0, batch) + "";
//				total_form = daoProduction1.getTotalAmount(1, batch) + "";
//				total_finish = daoProduction1.getTotalAmount(2, batch) + "";
//				total_unfinish = daoProduction1.getTotalAmount(3, batch) + "";
//				data[i] = new String[] { batch, date, total, total_form,
//						total_finish, total_unfinish };
//			}
//
//			TableModel jTable1Model = new DefaultTableModel(data, totalColumn);
//			jTable.setModel(jTable1Model);
//
//			DefaultTableModel a = new DefaultTableModel();

			// jTable.getTableHeader().setPreferredSize(
			// new java.awt.Dimension(640, 0));

		}
	}
	
	private void jTableMouseClicked(MouseEvent evt) {
		if(evt.getClickCount() == 1){
			if(row == -1){
				JOptionPane.showMessageDialog(null, "Select a row !","Warning", JOptionPane.WARNING_MESSAGE);
			}else{
				/*DtoInfo d = new DtoInfo();
				String folderbatch = (String) jTable.getValueAt(row, 0);
				String batch = (String) jTable.getValueAt(row, 1);
				String date = (String) jTable.getValueAt(row, 2);
				String total = (String) jTable.getValueAt(row, 3);
				String totalForm = (String) jTable.getValueAt(row, 4);
				String totalFinish = (String) jTable.getValueAt(row, 5);
				String finalUnFinish = (String) jTable.getValueAt(row, 6);*/
				DtoInfo dto = listInfo.get(row);
				BatchJDialog jd = new BatchJDialog(new Form2(), dto);
				jd.setModal(true);
				jd.setVisible(true);
				
			}
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent le) {
		if(!le.getValueIsAdjusting()){			
			
			int[] rows = jTable.getSelectedRows();
		    for (int i = 0; i < rows.length; i++){
		      row = rows[i];
		    }

		    int[] cols = jTable.getSelectedColumns();

		    for (int i = 0; i < cols.length; i++){
		    	col = cols[i];
		    }

		    Object valueAt = jTable.getValueAt(row,1);
		    
		    col = jTable.convertColumnIndexToModel(col);
		    row = jTable.convertRowIndexToModel(row);
		    
		    
		    System.out.println("CELL :["+row+","+col+"]");
		}
		
	}

}
