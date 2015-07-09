package com.digitexx.form;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.dao.DaoPms;
import com.digitexx.dao.DaoProduction1;
import com.digitexx.dto.DtoProject;

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
public class Form3 extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JComboBox<String> jComboBoxProject;
	private JList jListForm;
	private JList jListBatch;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane2;
	static private JList jListFolderBatch;
	private JScrollPane jScrollPane1;
	private static List<DtoProject> listProject;
	private static DaoPms daoPms;
	private List<String> listFolderBatch;
	private JLabel jLabel1;
	private JLabel jLabel;
	private JList jListUser;
	private JScrollPane jScrollPane4;
	DaoProduction1 daoProduction1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				Form3 inst = new Form3();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}

	public Form3() {
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
			jComboBoxProjectItemStateChanged(null);
		}
		// final int selectedIndex = jComboBoxProject.getSelectedIndex();
		// if (selectedIndex < jComboBoxProject.getItemCount()) {
		// jComboBoxProject.setSelectedIndex(selectedIndex + 1);
		// }
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(0, 1000, 1000, 0,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(902, 637));
				{

					jComboBoxProject = new JComboBox<>();
					jPanel1.add(jComboBoxProject, new AnchorConstraint(76, 436,
							140, 171, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));

					jComboBoxProject.setBounds(264, 134, 328, 39);
					jComboBoxProject.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							jComboBoxProjectItemStateChanged(evt);
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(217, 153,
							790, 9, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setBounds(12, 187, 180, 366);
					{

						jListFolderBatch = new JList();
						jScrollPane1.setViewportView(jListFolderBatch);

						jListFolderBatch.setSelectedIndex(0);
						jListFolderBatch
								.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jListFolderBatch
								.setPreferredSize(new java.awt.Dimension(150,
										347));
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
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jScrollPane2.setBounds(211, 187, 215, 363);
					{
						ListModel jListFormModel = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
						jListBatch = new JList();
						jScrollPane2.setViewportView(jListBatch);
						jListBatch.setPreferredSize(new java.awt.Dimension(197, 353));
						jListBatch
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListBatchValueChanged(evt);
									}
								});
						jListBatch.setModel(jListFormModel);
					}
				}
				{
					jScrollPane3 = new JScrollPane();
					jPanel1.add(jScrollPane3);
					jScrollPane3.setBounds(438, 187, 183, 365);
					{
						ListModel jListUserModel = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
						jListForm = new JList();
						jScrollPane3.setViewportView(jListForm);
						jListForm.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent evt) {
								jListFormValueChanged(evt);
							}
						});
						jListForm.setModel(jListUserModel);
					}
				}
				{
					jScrollPane4 = new JScrollPane();
					jPanel1.add(jScrollPane4);
					jScrollPane4.setBounds(633, 184, 220, 371);
					{
						ListModel jListUserModel = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
						jListUser = new JList();
						jScrollPane4.setViewportView(jListUser);
						jListUser.setModel(jListUserModel);
						jListUser
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListUserValueChanged(evt);
									}
								});
					}
				}
				{
					jLabel = new JLabel();
					jPanel1.add(jLabel);
					jLabel.setText("Total User: ");
					jLabel.setBounds(633, 155, 80, 17);
					jLabel.setFont(new java.awt.Font("Times New Roman",1,20));
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("FORM 2");
					jLabel1.setBounds(337, 34, 191, 75);
					jLabel1.setFont(new java.awt.Font("Times New Roman",1,48));
				}
			}
			pack();
			this.setSize(887, 603);
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
			String folderBatch = jListFolderBatch.getSelectedValue().toString();
			String batch = jListBatch.getSelectedValue().toString();
			ListModel listModel = new DefaultComboBoxModel(daoProduction1
					.getListForm(folderBatch, batch).toArray());
			System.out.println(folderBatch + "_" + batch + "_"
					+ listModel.getSize());
			jListForm.setModel(listModel);

		}
	}

	private void jComboBoxProjectItemStateChanged(ItemEvent evt) {

		// Thread t = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// // thread goi progress bar.
		// if (evt.getStateChange() == ItemEvent.SELECTED) {
		int index = jComboBoxProject.getSelectedIndex();
		String schema = listProject.get(index).getSchema();
		daoProduction1 = new DaoProduction1(listProject.get(index).getSchema(),
				listProject.get(index).getUid(), listProject.get(index)
						.getPassword());
		listFolderBatch = new ArrayList<>();
		listFolderBatch = daoProduction1.getListFolderBatch();

		ListModel jListGroupModel = new DefaultComboBoxModel(
				listFolderBatch.toArray());
		jListFolderBatch.setModel(jListGroupModel);

		// jLabelTotalMount.setText(daoProduction1.getTotalAmount(0, null) +
		// "");
		// jLabelTotalFormNoInput.setText(daoProduction1.getTotalAmount(1, null)
		// + "");
		// jLabelTotalInput.setText(daoProduction1.getTotalAmount(2, null) +
		// "");
		// jLabelTotalNoInput.setText(daoProduction1.getTotalAmount(3, null) +
		// "");
		// System.out.print(listProject.get(index).getSchema());

		// }
		// });
		// }
	}

	private void jListFolderBatchValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			String folderBatch = jListFolderBatch.getSelectedValue().toString();
			ListModel listModel = new DefaultComboBoxModel(daoProduction1
					.getListBatch(folderBatch).toArray());
			jListBatch.setModel(listModel);
		}
	}

	private void jListUserValueChanged(ListSelectionEvent evt) {
		
	}
	
	private void jListFormValueChanged(ListSelectionEvent evt) {
		if (evt.getValueIsAdjusting()) {
			String nameForm = jListForm.getSelectedValue().toString();
			ListModel listModel = new DefaultComboBoxModel(daoPms.getListUser(nameForm).toArray());
			jListUser.setModel(listModel);
			System.out.println(nameForm);
			jLabel.setText("Total: " + jListUser.getModel().getSize());
		}
	}

}
