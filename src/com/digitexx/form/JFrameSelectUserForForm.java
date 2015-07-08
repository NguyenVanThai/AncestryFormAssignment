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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;

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

import javax.swing.WindowConstants;
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

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrameSelectUserForForm inst = new JFrameSelectUserForForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);

				// ListModel jListGroupModelProject = new
				// DefaultComboBoxModel(arrProject);
				// jListProject.setModel(jListGroupModelProject);

			}
		});

	}

	public JFrameSelectUserForForm() {
		super();

		initGUI();
		daoPms = new DaoPms();

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
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(jPanel1, new AnchorConstraint(0, 1000, 1000, -1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(1276, 673));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(18, 709, 95, 224, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("ANCESTRY - FORM ASSIGNMENT");
					jLabel1.setFont(new java.awt.Font("Times New Roman",1,36));
					jLabel1.setPreferredSize(new java.awt.Dimension(618, 52));
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(191, 190, 224, 106, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("List Group");
					jLabel3.setFont(new java.awt.Font("Times New Roman",1,20));
					jLabel3.setBounds(109, 139, 107, 23);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4, new AnchorConstraint(189, 464, 223, 307, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel4.setText("List User's Group");
					jLabel4.setFont(new java.awt.Font("Times New Roman",1,20));
					jLabel4.setPreferredSize(new java.awt.Dimension(200, 23));
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5, new AnchorConstraint(189, 958, 223, 797, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel5.setText("List Member Choosed");
					jLabel5.setFont(new java.awt.Font("Times New Roman",1,20));
					jLabel5.setPreferredSize(new java.awt.Dimension(205, 23));
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(239, 245, 838, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 403));
					{

						// ListModel jListGroupModel = new DefaultComboBoxModel(
						// new String[] { "Item One", "Item Two" });
						jListGroup = new JList();
						jScrollPane1.setViewportView(jListGroup);
						// jListGroup.setModel(jListGroupModel);
						jListGroup.setPreferredSize(new java.awt.Dimension(269, 345));
						jListGroup
								.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
					jPanel1.add(jScrollPane2, new AnchorConstraint(244, 495, 840, 258, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(302, 401));
					{

						jListMember = new JList();
						jScrollPane2.setViewportView(jListMember);

						jListMember.setPreferredSize(new java.awt.Dimension(284, 375));
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
					jPanel1.add(jScrollPane3, new AnchorConstraint(398, 743, 710, 504, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane3.setPreferredSize(new java.awt.Dimension(305, 210));
					{

						jListForm = new JList();
						jScrollPane3.setViewportView(jListForm);

						jListForm.setPreferredSize(new java.awt.Dimension(301, 211));
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
					jPanel1.add(jScrollPane4, new AnchorConstraint(251, 993, 849, 753, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane4.setPreferredSize(new java.awt.Dimension(306, 402));
					{
						jListChoosed = new JList();
						jScrollPane4.setViewportView(jListChoosed);

						jListChoosed.setPreferredSize(new java.awt.Dimension(288, 350));
						jListChoosed
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListChoosedValueChanged(evt);
									}
								});
					}
				}
				{
					jButtonSave = new JButton();
					jPanel1.add(jButtonSave, new AnchorConstraint(908, 929, 981, 802, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonSave.setText("Save");
					jButtonSave.setFont(new java.awt.Font("Times New Roman",1,20));
					jButtonSave.setPreferredSize(new java.awt.Dimension(162, 49));
					jButtonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonSaveActionPerformed(evt);
						}
					});
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(343, 699, 376, 560, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("List Form's Project");
					jLabel2.setFont(new java.awt.Font("Times New Roman",1,20));
					jLabel2.setPreferredSize(new java.awt.Dimension(178, 22));
				}
				{
					// ComboBoxModel jComboBox1Model =
					// new DefaultComboBoxModel(
					// new String[] { "Item One", "Item Two" });
					jComboBoxProject = new JComboBox();
					jPanel1.add(jComboBoxProject, new AnchorConstraint(250, 742, 311, 508, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					// jComboBoxProject.setModel(jComboBox1Model);
					jComboBoxProject.setPreferredSize(new java.awt.Dimension(299, 41));
					jComboBoxProject.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							jComboBoxProjectItemStateChanged(evt);
						}
					});
				}
				{
					jButtonAdd = new JButton();
					jPanel1.add(jButtonAdd, new AnchorConstraint(749, 673, 795, 562, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonAdd.setText(">>");
					jButtonAdd.setFont(new java.awt.Font("Times New Roman",1,20));
					jButtonAdd.setPreferredSize(new java.awt.Dimension(141, 31));
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
					jPanel1.add(jLabel6, new AnchorConstraint(189, 662, 223, 567, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel6.setText("List  Project");
					jLabel6.setFont(new java.awt.Font("Times New Roman",1,20));
					jLabel6.setPreferredSize(new java.awt.Dimension(121, 23));
				}
				{
					jButtonDelete = new JButton();
					jPanel1.add(jButtonDelete, new AnchorConstraint(823, 673, 867, 562, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonDelete.setText("<<");
					jButtonDelete.setFont(new java.awt.Font("Times New Roman",1,20));
					jButtonDelete.setPreferredSize(new java.awt.Dimension(141, 29));
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
			this.setSize(1289, 712);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
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
			// Collections.sort(listOld);
			// Collections.sort(listNew);

			ListModel listModelOld = new DefaultComboBoxModel(listOld.toArray());
			ListModel listModelNew = new DefaultComboBoxModel(listNew.toArray());

			jListMember.setModel(listModelOld);
			jListChoosed.setModel(listModelNew);
		}

	}

	private void jListGroupValueChanged(ListSelectionEvent evt) {
		// System.out.println("jListGroup.valueChanged, event="+evt);
		// TODO add your code for jListGroup.valueChanged
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

	private void jListChoosedValueChanged(ListSelectionEvent evt) {
		System.out.println("jListChoosed.valueChanged, event=" + evt);
		// TODO add your code for jListChoosed.valueChanged
	}

	private void jComboBoxProjectItemStateChanged(ItemEvent evt) {
		// System.out.println(jComboBoxProject.getSelectedIndex());
		// if(evt.getStateChange() == ItemEvent.SELECTED ||
		// jComboBoxProject.getSelectedIndex() == 0)

		// System.out.println("jComboBoxProject.itemStateChanged, event="+evt);
		// TODO add your code for jComboBoxProject.itemStateChanged
		int index = jComboBoxProject.getSelectedIndex();
		DaoProduction1 daoProduction1 = new DaoProduction1(listProject.get(
				index).getSchema(), listProject.get(index).getUid(),
				listProject.get(index).getPassword());
		listForm = daoProduction1.getListForm();
		String[] arrForm = new String[listForm.size()];
		//
		for (int i = 0; i < listForm.size(); i++) {
			arrForm[i] = listForm.get(i).getName();
		}
		//
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
			JOptionPane.showMessageDialog(null,
				    "Data saved successfully.");
		} else {

			JOptionPane.showMessageDialog(null,
					"Please insert User to List Member Choosed.",
					"Error Input", JOptionPane.ERROR_MESSAGE);
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
			// Collections.sort(listOld);
			// Collections.sort(listNew);

			ListModel listModelOld = new DefaultComboBoxModel(listOld.toArray());
			ListModel listModelNew = new DefaultComboBoxModel(listNew.toArray());

			jListMember.setModel(listModelOld);
			jListChoosed.setModel(listModelNew);

		}
	}
}
