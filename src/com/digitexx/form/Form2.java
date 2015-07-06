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
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
public class Form2 extends javax.swing.JFrame {
	private JPanel jPanel1;
	static private JList jListBatch;
	private JScrollPane jScrollPane3;
	private JLabel jLabelTotalNoInput;
	private JLabel jLabelTotalInput;
	private JLabel jLabelTotalFormNoInput;
	private JLabel jLabelTotalMount;
	private JComboBox<String> jComboBoxProject;
	static private JList jListFolderBatch;
	private JScrollPane jScrollPane1;
	private static List<DtoProject> listProject;
	private static DaoPms daoPms;
	private List<String> listFolderBatch;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel txtDate;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel1;
	DaoProduction1 daoProduction1;

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
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jLabelTotalMount = new JLabel();
					jPanel1.add(jLabelTotalMount, new AnchorConstraint(239,
							723, 304, 639, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabelTotalMount.setText("jLabelTotalMount");
					jLabelTotalMount.setPreferredSize(new java.awt.Dimension(
							104, 42));
				}
				{

					jComboBoxProject = new JComboBox<>();
					jPanel1.add(jComboBoxProject, new AnchorConstraint(83, 671,
							146, 405, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));

					jComboBoxProject.setPreferredSize(new java.awt.Dimension(
							329, 40));
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
					jScrollPane1.setPreferredSize(new java.awt.Dimension(179,
							370));
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
					jScrollPane3 = new JScrollPane();
					jPanel1.add(jScrollPane3, new AnchorConstraint(217, 364,
							788, 175, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane3.setPreferredSize(new java.awt.Dimension(234,
							364));
					{
						ListModel jList2Model = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
						jListBatch = new JList();
						jScrollPane3.setViewportView(jListBatch);
						jListBatch.setModel(jList2Model);
						jListBatch.setSelectedIndex(0);
						jListBatch
								.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jListBatch.setPreferredSize(new java.awt.Dimension(152,
								356));
						jListBatch
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListBatchValueChanged(evt);
									}
								});
					}
				}
				{
					jLabelTotalFormNoInput = new JLabel();
					jPanel1.add(jLabelTotalFormNoInput, new AnchorConstraint(
							239, 810, 304, 727, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabelTotalFormNoInput.setText("jLabelTotalMount");
					jLabelTotalFormNoInput
							.setPreferredSize(new java.awt.Dimension(103, 42));
				}
				{
					jLabelTotalInput = new JLabel();
					jPanel1.add(jLabelTotalInput, new AnchorConstraint(239,
							895, 304, 815, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabelTotalInput.setText("jLabelTotalMount");
					jLabelTotalInput.setPreferredSize(new java.awt.Dimension(
							100, 42));
				}
				{
					jLabelTotalNoInput = new JLabel();
					jPanel1.add(jLabelTotalNoInput, new AnchorConstraint(239,
							990, 304, 904, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabelTotalNoInput.setText("jLabelTotalMount");
					jLabelTotalNoInput.setPreferredSize(new java.awt.Dimension(
							107, 42));
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(159, 723, 222,
							639, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Total Amount");
					jLabel1.setPreferredSize(new java.awt.Dimension(104, 40));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(157, 806, 222,
							722, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("Total Amount Form No Input");
					jLabel2.setPreferredSize(new java.awt.Dimension(104, 41));
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(157, 888, 222,
							804, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("Total input");
					jLabel3.setPreferredSize(new java.awt.Dimension(103, 41));
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4, new AnchorConstraint(157, 973, 222,
							889, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel4.setText("Total no input");
					jLabel4.setPreferredSize(new java.awt.Dimension(104, 42));
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5, new AnchorConstraint(162, 491, 217,
							407, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel5.setText("Date Delivery");
					jLabel5.setPreferredSize(new java.awt.Dimension(104, 35));
				}
				{
					txtDate = new JLabel();
					jPanel1.add(txtDate, new AnchorConstraint(233, 579, 308, 407, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtDate.setText("jLabelTotalMount");
					txtDate.setPreferredSize(new java.awt.Dimension(213, 48));
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
			String batchParen = jListFolderBatch.getSelectedValue().toString();
			if (jListBatch.getSelectedValue() != null) {
				String batch = jListBatch.getSelectedValue().toString();
				txtDate.setText( daoPms.getDate(batchParen, batch));
			}

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

		jLabelTotalMount.setText(daoProduction1.getTotalAmount(0, null) + "");
		jLabelTotalFormNoInput.setText(daoProduction1.getTotalAmount(1, null)
				+ "");
		jLabelTotalInput.setText(daoProduction1.getTotalAmount(2, null) + "");
		jLabelTotalNoInput.setText(daoProduction1.getTotalAmount(3, null) + "");
		System.out.print(listProject.get(index).getSchema());

		// }
		// });
		// }
	}

	private void jListFolderBatchValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			int index = jListFolderBatch.getSelectedIndex();
			// DaoProduction1 daoProduction1 = new
			// DaoProduction1(listProject.get(
			// index).getSchema(), listProject.get(index).getUid(),
			// listProject.get(index).getPassword());
			String folderBatch = listFolderBatch.get(index);
			System.out.println(folderBatch + "__" + index);
			ListModel listModel = new DefaultComboBoxModel(daoProduction1
					.getListBatch(folderBatch).toArray());

			jListBatch.setModel(listModel);

			jLabelTotalMount.setText(daoProduction1.getTotalAmount(0,
					folderBatch) + "");
			jLabelTotalFormNoInput.setText(daoProduction1.getTotalAmount(1,
					folderBatch) + "");
			jLabelTotalInput.setText(daoProduction1.getTotalAmount(2,
					folderBatch) + "");
			jLabelTotalNoInput.setText(daoProduction1.getTotalAmount(3,
					folderBatch) + "");

			// jListBatch.setSelectedIndex(0);
		}
	}

}
