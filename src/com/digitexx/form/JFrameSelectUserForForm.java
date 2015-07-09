package com.digitexx.form;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.dao.DaoPms;
import com.digitexx.dao.DaoProduction1;
import com.digitexx.dto.DtoForm;
import com.digitexx.dto.DtoGroup;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoUser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DebugGraphics;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
public class JFrameSelectUserForForm extends JFrame {
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JButton jButtonDelete;
	private JLabel jLabel6;
	private JButton jButtonAdd;
	private JComboBox jComboBoxProject;
	private JLabel jLabel2;
	static private JList jListChoosed;
	private JScrollPane jScrollPane4;
	static private JList jListForm;
	private JScrollPane jScrollPane3;
	static private JList jListMember;
	private JScrollPane jScrollPane2;
	private static JList jListGroup;
	private JScrollPane jScrollPane1;
	private JButton jButtonSave;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel1;

	private static DaoPms daoPms;
	private DaoProduction1 daoProduction1;

	private static List<DtoGroup> listGroup;
	private static List<DtoUser> listUser;
	private static List<DtoProject> listProject;
	private static List<DtoForm> listForm;
	private Map<Integer, String> map = new HashMap<>();
	private List<DtoUser> listUserCoppy;
	private List<String> listParent = new ArrayList<String>();
	private List<String> listOld = new ArrayList<String>();
	private List<String> listNew = new ArrayList<String>();
	private List<String> listOK = new ArrayList<String>();
	private MainJFrame parent;
	/**
	 * Auto-generated main method to display this JFrame
	 */

//	public static void main(String[] args) {
//
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				JFrameSelectUserForForm inst = new JFrameSelectUserForForm();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//
//				// ListModel jListGroupModelProject = new
//				// DefaultComboBoxModel(arrProject);
//				// jListProject.setModel(jListGroupModelProject);
//
//			}
//		});
//
//	}

	public JFrameSelectUserForForm(MainJFrame parent) {
		super();

		initGUI();
		daoPms = new DaoPms();
		this.parent = parent;
		listGroup = daoPms.getListGroup();
		listProject = daoPms.getListProject();

		final String[] arrGroup = new String[listGroup.size()];
		final String[] arrProject = new String[listProject.size()];

		for (int i = 0; i < listGroup.size(); i++) {
			arrGroup[i] = listGroup.get(i).getName();
		}

		for (int i = 0; i < listProject.size(); i++) {
			arrProject[i] = listProject.get(i).getName();
		}

		ListModel jListGroupModelGroup = new DefaultComboBoxModel(arrGroup);
		jListGroup.setModel(jListGroupModelGroup);
		jListGroup.setSelectedIndex(0);

		//

		ComboBoxModel comboBoxModel = new DefaultComboBoxModel(arrProject);
		jComboBoxProject.setModel(comboBoxModel);

		jComboBoxProject.requestFocus();
		jComboBoxProject.setSelectedIndex(0);
		jComboBoxProjectItemStateChanged(null);

		// jComboBox1.setSelectedIndex(1);
		// jComboBoxProject.setSelectedIndex(comboBoxModel.getSize()-1);
		// jComboBoxProject.setSelectedIndex(1);
		// jComboBoxProject.setSelectedIndex(0);
		// jComboBoxProject.setSelectedItem(0);
		// ListModel jListGroupModelProject = new
		// DefaultComboBoxModel(arrProject);
		// jListProject.setModel(jListGroupModelProject);

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Form Assignment");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
				public void windowDeiconified(WindowEvent evt) {
					System.out.println("this.windowDeiconified, event="+evt);
					//TODO add your code for this.windowDeiconified
				}
			});
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(0, 1000, 1000, -1,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBounds(-1, 0, 1274, 560);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(24, 1001, 88, 0,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("ANCESTRY - FORM ASSIGNMENT");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36));
					jLabel1.setPreferredSize(new java.awt.Dimension(1275, 43));
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel1.setBounds(0, 14, 1275, 38);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(128, 241, 161, 5,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("LIST GROUP");
					jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel3.setPreferredSize(new java.awt.Dimension(301, 22));
					jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel3.setBounds(6, 76, 301, 20);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4, new AnchorConstraint(128, 494, 161,
							257, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel4.setText("LIST USER");
					jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel4.setPreferredSize(new java.awt.Dimension(302, 22));
					jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel4.setBounds(327, 76, 302, 20);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5, new AnchorConstraint(128, 990, 161,
							753, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel5.setText("LIST USER CHOOSED");
					jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel5.setPreferredSize(new java.awt.Dimension(302, 22));
					jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel5.setBounds(959, 76, 302, 20);
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(170, 242,
							897, 5, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(302,
							407));

					{

						// ListModel jListGroupModel = new DefaultComboBoxModel(
						// new String[] { "Item One", "Item Two" });
						jListGroup = new JList();
						jScrollPane1.setViewportView(jListGroup);

						jListGroup
								.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jListGroup.setBorder(BorderFactory
								.createTitledBorder(""));
						jListGroup
								.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
						jListGroup
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListGroupValueChanged(evt);
									}
								});
					}
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2, new AnchorConstraint(170, 494,
							897, 257, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(302,
							407));
					{

						jListMember = new JList();
						jScrollPane2.setViewportView(jListMember);

						jListMember.setSize(304, 404);
						jListMember.setBorder(BorderFactory
								.createTitledBorder(""));
						jListMember
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListMemberValueChanged(evt);
									}
								});
					}
				}
				{
					jScrollPane3 = new JScrollPane();
					jPanel1.add(jScrollPane3, new AnchorConstraint(293, 743,
							738, 502, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane3.setPreferredSize(new java.awt.Dimension(307,
							249));
					{

						jListForm = new JList();
						jScrollPane3.setViewportView(jListForm);

						jListForm.setBorder(BorderFactory
								.createTitledBorder(""));
						jListForm
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListFormValueChanged(evt);
									}
								});
					}
				}
				{
					jScrollPane4 = new JScrollPane();
					jPanel1.add(jScrollPane4, new AnchorConstraint(170, 991,
							897, 750, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane4.setPreferredSize(new java.awt.Dimension(307,
							407));
					{
						jListChoosed = new JList();
						jScrollPane4.setViewportView(jListChoosed);

						jListChoosed.setBorder(BorderFactory
								.createTitledBorder(""));
						
					}
				}
				{
					jButtonSave = new JButton();
					jPanel1.add(jButtonSave, new AnchorConstraint(913, 942,
							984, 814, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jButtonSave.setText("Save");
					jButtonSave.setFont(new java.awt.Font("Times New Roman", 1,
							20));
					jButtonSave
							.setPreferredSize(new java.awt.Dimension(163, 40));
					jButtonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonSaveActionPerformed(evt);
						}
					});
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(253, 744, 284,
							508, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("LIST FORM");
					jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel2.setPreferredSize(new java.awt.Dimension(301, 21));
					jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel2.setBounds(647, 151, 300, 19);
				}
				{
					// ComboBoxModel jComboBox1Model =
					// new DefaultComboBoxModel(
					// new String[] { "Item One", "Item Two" });
					jComboBoxProject = new JComboBox();
					jPanel1.add(jComboBoxProject, new AnchorConstraint(171,
							742, 235, 504, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					// jComboBoxProject.setModel(jComboBox1Model);
					jComboBoxProject.setPreferredSize(new java.awt.Dimension(
							304, 43));
					jComboBoxProject.setBounds(642, 102, 303, 39);
					jComboBoxProject.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							jComboBoxProjectItemStateChanged(evt);
						}
					});
				}
				{
					jButtonAdd = new JButton();
					jPanel1.add(jButtonAdd, new AnchorConstraint(759, 677, 815,
							563, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jButtonAdd.setText(">>");
					jButtonAdd.setFont(new java.awt.Font("Times New Roman", 3,
							20));
					jButtonAdd
							.setPreferredSize(new java.awt.Dimension(145, 31));
					jButtonAdd.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent evt) {
							System.out.println("jButtonAdd.keyReleased, event="
									+ evt);
							// TODO add your code for jButtonAdd.keyReleased
						}
					});
					jButtonAdd.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							jButtonAddAddActionListener(arg0);
						}
					});

				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6, new AnchorConstraint(128, 742, 161,
							508, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel6.setText("LIST PROJECT");
					jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20));
					jLabel6.setPreferredSize(new java.awt.Dimension(298, 22));
					jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel6.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabel6.setBounds(647, 76, 298, 20);
				}
				{
					jButtonDelete = new JButton();
					jPanel1.add(jButtonDelete, new AnchorConstraint(834, 677,
							890, 563, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jButtonDelete.setText("<<");
					jButtonDelete.setFont(new java.awt.Font("Times New Roman",
							3, 20));
					jButtonDelete.setPreferredSize(new java.awt.Dimension(145,
							31));
					jButtonDelete.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent evt) {
							System.out.println("jButtonAdd.keyReleased, event="
									+ evt);
							// TODO add your code for jButtonAdd.keyReleased
						}
					});
					jButtonDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonDeleteActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(1289, 599);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	

	private void jListGroupValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			JList source = (JList) evt.getSource();
			int selected = source.getSelectedIndex();
			int id = listGroup.get(selected).getId();
			listUser = daoPms.getListUser(id);
			// String[] arrUser = new String[listUser.size()];
			listParent.clear();
			for (int i = 0; i < listUser.size(); i++) {
				// arrUser[i] = listUser.get(i).getName();
				listParent.add(listUser.get(i).getName());
			}
			listOld.clear();
			listNew.clear();
			listOld.addAll(listParent);

			ListModel listModel = new DefaultComboBoxModel(listParent.toArray());

			jListMember.setModel(listModel);

			jListChoosed.setModel(new DefaultComboBoxModel());

		}

	}

	private void jListMemberValueChanged(ListSelectionEvent evt) {
		// System.out.println("jListMember.valueChanged, event=" + evt);
		// TODO add your code for jListMember.valueChanged
	}

	private void jListFormValueChanged(ListSelectionEvent evt) {
		map.put(jListForm.getSelectedIndex(),
				(String) jListForm.getSelectedValue());

		System.out.println(jListForm.getSelectedIndex());
	}

	private void jComboBoxProjectItemStateChanged(ItemEvent evt) {

		int index = jComboBoxProject.getSelectedIndex();
		DaoProduction1 daoProduction1 = new DaoProduction1(listProject.get(
				index).getSchema(), listProject.get(index).getUid(),
				listProject.get(index).getPassword());
		listForm = daoProduction1.getListForm();

		String[] arrForm = new String[listForm.size()];
		for (int i = 0; i < listForm.size(); i++) {
			arrForm[i] = listForm.get(i).getName();
		}
		ListModel comboBoxModel = new DefaultComboBoxModel(arrForm);
		jListForm.setModel(comboBoxModel);
		if (arrForm.length > 0) {
			jListForm.setSelectedIndex(0);
		}

	}

	private void jButtonSaveActionPerformed(ActionEvent evt) {
		if (listNew.size() > 0) {
			List<DtoForm> listSaveForm = new ArrayList<DtoForm>();

			int[] index = jListForm.getSelectedIndices();

			int indexProject = jComboBoxProject.getSelectedIndex();
			int projectID = listProject.get(indexProject).getId();
			String projectName = listProject.get(indexProject).getName();

			for (int i : index) {
				listSaveForm.add(listForm.get(i));
			}

			List<DtoUser> listSaveUser = new ArrayList<DtoUser>();
			for (int i = 0; i < listUser.size(); i++) {
				if (listNew.contains(listUser.get(i).getName())) {
					listSaveUser.add(listUser.get(i));

				}
			}

			List<Object[]> listParams = new ArrayList<Object[]>();
			for (int i = 0; i < listSaveForm.size(); i++) {
				for (int j = 0; j < listSaveUser.size(); j++) {

					listParams.add(new Object[] { projectID, projectName,
							listSaveUser.get(j).getId(),
							listSaveUser.get(j).getName(),
							listSaveForm.get(i).getId(),
							listSaveForm.get(i).getName() });

				}
			}
			daoPms.setListUser(listParams);
			JOptionPane.showMessageDialog(null, "Data saved successfully.");
		} else {

			JOptionPane.showMessageDialog(null,
					"Please insert User to List Member Choosed.",
					"Error Input", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void jButtonAddAddActionListener(ActionEvent arg0) {

		List<String> list = jListMember.getSelectedValuesList();
		if (list.size() > 0) {
			List<String> listTemp = new ArrayList<String>();
			int[] arrIndex = jListMember.getSelectedIndices();

			for (int a : arrIndex) {
				listTemp.add(listOld.get(a));
			}

			listOld.removeAll(listTemp);
			listNew.addAll(list);
			 Collections.sort(listOld);
			 Collections.sort(listNew);

			ListModel listModelOld = new DefaultComboBoxModel(listOld.toArray());
			ListModel listModelNew = new DefaultComboBoxModel(listNew.toArray());

			jListMember.setModel(listModelOld);
			jListChoosed.setModel(listModelNew);
		}

	}
	
	private void jButtonDeleteActionPerformed(ActionEvent evt) {
		List<String> list = jListChoosed.getSelectedValuesList();
		if (list.size() > 0) {
			List<String> listTemp = new ArrayList<String>();
			int[] arrIndex = jListChoosed.getSelectedIndices();

			for (int a : arrIndex) {
				listTemp.add(listNew.get(a));
			}

			listNew.removeAll(listTemp);
			listOld.addAll(list);
			 Collections.sort(listOld);
			 Collections.sort(listNew);

			ListModel listModelOld = new DefaultComboBoxModel(listOld.toArray());
			ListModel listModelNew = new DefaultComboBoxModel(listNew.toArray());

			jListMember.setModel(listModelOld);
			jListChoosed.setModel(listModelNew);

		}
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		parent.setVisible(true);
		parent.setLocationRelativeTo(null);
	}
}
