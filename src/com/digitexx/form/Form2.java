package com.digitexx.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
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
import com.sun.org.apache.bcel.internal.generic.LNEG;

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
	private static List<DtoProject> listProject;
	private static DaoPms daoPms;
	private List<String> listFolderBatch;
	private JScrollPane jScrollPane2;
	private JTable jTable;
	private JLabel jLabel3;
	DaoProduction1 daoProduction1;
	private int row = -1, col = 0;
	List<DtoInfo> listInfo;
	private MainJFrame parent;

	// public static void main(String[] args) {
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// Form2 inst = new Form2();
	// inst.setLocationRelativeTo(null);
	// inst.setVisible(true);
	// }
	// });
	// }

	public Form2(MainJFrame parent) {
		super();
		initGUI();
		this.parent = parent;
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
			// jComboBoxProject.setSelectedIndex(1);
		}
		// final int selectedIndex = jComboBoxProject.getSelectedIndex();
		// if (selectedIndex < jComboBoxProject.getItemCount()) {
		// jComboBoxProject.setSelectedIndex(selectedIndex + 1);
		// }
	}

	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(0, 1000, 1000, 0,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(1032, 637));
				jPanel1.setBounds(0, 0, 1024, 637);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(267, 154, 300,
							10, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("List Folder Batch");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20));
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2, new AnchorConstraint(310, 994,
							980, 9, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(1009,
							427));
					jScrollPane2.setBounds(9, 197, 1008, 427);
					{

						jTable = new JTable();

						/**
						 * @author nvthai Update cell selection
						 */
						ListSelectionModel rowSelMod = jTable
								.getSelectionModel();
						ListSelectionModel colSelMod = jTable.getColumnModel()
								.getSelectionModel();
						rowSelMod.addListSelectionListener(this);
						// colSelMod.addListSelectionListener(this);
						jTable.setRowHeight(30);
						jTable.setCellSelectionEnabled(true);
						// end

						jScrollPane2.setViewportView(jTable);
						AnchorLayout jTableLayout = new AnchorLayout();
						jTable.setLayout(jTableLayout);
						jTable.setFillsViewportHeight(true);
						jTable.setPreferredSize(new java.awt.Dimension(1006,
								424));
						jTable.addVetoableChangeListener(new VetoableChangeListener() {
							public void vetoableChange(PropertyChangeEvent evt) {
								System.out
										.println("jTable.vetoableChange, event="
												+ evt);
								// TODO add your code for jTable.vetoableChange
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
					jPanel1.add(jComboBoxProject, new AnchorConstraint(154,
							687, 214, 334, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));

					jComboBoxProject.setBounds(342, 92, 361, 38);
					jComboBoxProject.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							jComboBoxProjectItemStateChanged(evt);
						}
					});
				}
				{
					jPanel1.add(jLabel1, new AnchorConstraint(264, 1000, 300,
							0, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("TABLE DATA");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1.setBounds(0, 154, 1024, 23);
				}
				{
					jLabel1 = new JLabel();
					GroupLayout jLabel1Layout = new GroupLayout(
							(JComponent) jLabel1);
					jLabel1.setLayout(jLabel1Layout);
					jPanel1.add(jLabel1, new AnchorConstraint(162, 335, 198,
							235, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("PROJECT:");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel1.setBounds(240, 97, 103, 23);
					jLabel1Layout.setVerticalGroup(jLabel1Layout
							.createParallelGroup());
					jLabel1Layout.setHorizontalGroup(jLabel1Layout
							.createParallelGroup());
				}
				{
					jLabel3 = new JLabel();
					GroupLayout jLabel3Layout = new GroupLayout(
							(JComponent) jLabel3);
					jLabel3.setLayout(jLabel3Layout);
					jPanel1.add(jLabel3, new AnchorConstraint(19, 1000, 126, 0,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("ANCESTRY - FORM ASSIGNMENT");
					jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36));
					jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel3.setBounds(0, 7, 1027, 52);
					jLabel3Layout.setVerticalGroup(jLabel3Layout
							.createParallelGroup());
					jLabel3Layout.setHorizontalGroup(jLabel3Layout
							.createParallelGroup());
				}
			}
			pack();
			this.setSize(1040, 676);
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
			// daoProduction1 = new DaoProduction1(listProject.get(index)
			// .getSchema(), listProject.get(index).getUid(), listProject
			// .get(index).getPassword());
			// listInfo = daoProduction1.getListDtoInfo();
			// String[] totalColumn = new String[] { "folder_batch","batch",
			// "date", "total",
			// "total_form", "total_finish", "total_unfinish" };
			// DefaultTableModel model = new DefaultTableModel(null,
			// totalColumn);
			// for (DtoInfo a : listInfo) {
			//
			// model.addRow(a.toArray(daoPms.getDate(a.getFilePath())));
			// }
			// jTable.setModel(model);
			// System.out.println(listProject.get(index).getSchema());

			final JDialog dlgProgress = new JDialog(this, "", true);// true
																	// means
																	// that the
																	// dialog
																	// created
																	// is modal
			dlgProgress.setSize(new Dimension(100, 100));
			dlgProgress.setResizable(true);
			dlgProgress.setUndecorated(true);
			final JLabel lblStatus = new JLabel(); // this is just a
			// // label
			// // in which you
			// // can
			// // indicate the
			// // state of the
			// // processing
			URL url = this.getClass().getResource("loading.gif");
			ImageIcon image = new ImageIcon(url);
			lblStatus.setIcon(image);
			dlgProgress.add(BorderLayout.CENTER, lblStatus);
			dlgProgress.setLocationRelativeTo(jTable);
			dlgProgress.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // prevent
																				// the
																				// user
																				// from
																				// closing
																				// the
																				// dialog
																				// dlgProgress.setSize(300,
																				// 90);

			SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					// longProcessingTask();
					int index = jComboBoxProject.getSelectedIndex();
					daoProduction1 = new DaoProduction1(listProject.get(index)
							.getSchema(), listProject.get(index).getUid(),
							listProject.get(index).getPassword());
					System.out.println(listProject.get(index).getSchema());
					listInfo = daoProduction1.getListDtoInfo();
					String[] totalColumn = new String[] { "folder_batch",
							"batch", "date", "total", "total_form",
							"total_finish", "total_unfinish" };
					DefaultTableModel model = new DefaultTableModel(null,
							totalColumn) {
						public boolean isCellEditable(int rowIndex,
								int mColIndex) {
							return false;
						}
					};
					;
					for (DtoInfo a : listInfo) {

						model.addRow(a.toArray(daoPms.getDate(a.getFilePath())));
					}
					jTable.setModel(model);

					return null;
				}

				@Override
				protected void done() {
					dlgProgress.dispose();// close the modal dialog
				}
			};

			sw.execute(); // this will start the processing on a separate thread
			dlgProgress.setVisible(true); // this will block user input as long
											// as the processing task is working
		}
	}

	private void jListFolderBatchValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			// int index = jListFolderBatch.getSelectedIndex();
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

			// String folderBatch = listFolderBatch.get(index);
			//
			// Object[] listBatch = daoProduction1.getListBatch(folderBatch)
			// .toArray();
			// ListModel listModel = new DefaultComboBoxModel();
			// String[] totalColumn = new String[] { "batch", "date", "total",
			// "total_form", "total_finish", "total_unfinish" };
			// String[][] data = new
			// String[listBatch.length][totalColumn.length];
			// String batchParen =
			// jListFolderBatch.getSelectedValue().toString();
			// String batch, date, total, total_form, total_finish,
			// total_unfinish;
			//
			// for (int i = 0; i < data.length; i++) {
			//
			// batch = listBatch[i].toString();
			// date = daoPms.getDate(batchParen, batch);
			// total = daoProduction1.getTotalAmount(0, batch) + "";
			// total_form = daoProduction1.getTotalAmount(1, batch) + "";
			// total_finish = daoProduction1.getTotalAmount(2, batch) + "";
			// total_unfinish = daoProduction1.getTotalAmount(3, batch) + "";
			// data[i] = new String[] { batch, date, total, total_form,
			// total_finish, total_unfinish };
			// }
			//
			// TableModel jTable1Model = new DefaultTableModel(data,
			// totalColumn);
			// jTable.setModel(jTable1Model);
			//
			// DefaultTableModel a = new DefaultTableModel();

			// jTable.getTableHeader().setPreferredSize(
			// new java.awt.Dimension(640, 0));

		}
	}

	private void jTableMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 1) {
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Select a row !",
						"Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				/*
				 * DtoInfo d = new DtoInfo(); String folderbatch = (String)
				 * jTable.getValueAt(row, 0); String batch = (String)
				 * jTable.getValueAt(row, 1); String date = (String)
				 * jTable.getValueAt(row, 2); String total = (String)
				 * jTable.getValueAt(row, 3); String totalForm = (String)
				 * jTable.getValueAt(row, 4); String totalFinish = (String)
				 * jTable.getValueAt(row, 5); String finalUnFinish = (String)
				 * jTable.getValueAt(row, 6);
				 */
				DtoInfo dto = listInfo.get(row);
				BatchJDialog jd = new BatchJDialog(new Form2(parent), dto);
				jd.setModal(true);
				jd.setLocationRelativeTo(jPanel1);
				jd.setVisible(true);

			}

		}
	}

	@Override
	public void valueChanged(ListSelectionEvent le) {
		if (!le.getValueIsAdjusting()) {

			int[] rows = jTable.getSelectedRows();
			for (int i = 0; i < rows.length; i++) {
				row = rows[i];
			}

			int[] cols = jTable.getSelectedColumns();

			for (int i = 0; i < cols.length; i++) {
				col = cols[i];
			}

			Object valueAt = jTable.getValueAt(row, 1);

			col = jTable.convertColumnIndexToModel(col);
			row = jTable.convertRowIndexToModel(row);

			System.out.println("CELL :[" + row + "," + col + "]");
		}

	}

	private void thisWindowClosed(WindowEvent evt) {
		parent.setVisible(true);
		parent.setLocationRelativeTo(null);
	}

}
