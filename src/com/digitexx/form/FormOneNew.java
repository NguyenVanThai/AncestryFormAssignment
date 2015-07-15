package com.digitexx.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.dao.DaoDatabase;
import com.digitexx.dao.EmployeeComparator;
import com.digitexx.dto.DtoDigiTexx;
import com.digitexx.dto.DtoForm;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoUser;
import com.digitexx.dto.DtoUserPMS;

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
public class FormOneNew extends JFrame {
	private JPanel jPanel1;
	private JLabel jLabel3;
	static private JList<String> jListUserChoose;
	private JScrollPane jScrollPane5;
	private JPanel jPanel3;
	private JButton jButtonDelete;
	private JLabel jLabel6;
	private JButton jButtonAdd;
	private JComboBox jComboBoxProject;
	private JLabel jLabel2;
	static private JList jListForm;
	private JScrollPane jScrollPane3;
	static private JList jListUser;
	private JScrollPane jScrollPane2;
	private static JList jListGroup;
	private JScrollPane jScrollPane1;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel1;

	private DaoDatabase daoProduction1;
	private DaoDatabase daoPms;
	private static List<DtoUser> listUser;
	private static List<DtoProject> listProject;
	private static List<DtoForm> listForm;
	private static List<DtoForm> listFormChoose;

	private List<DtoUser> listUserCoppy;
	private List<String> listParent = new ArrayList<String>();
	private List<String> listOld = new ArrayList<String>();
	private List<String> listNew = new ArrayList<String>();
	private List<String> listOK = new ArrayList<String>();

	private String username = "";
	private MainJFrame parent;
	private DefaultListModel<String> userWorkListModel;
	// private List<BeanUserPMS> listUserPMS = new ArrayList<BeanUserPMS>();
	// private List<BeanUserWorking> listUserByRole = new
	// ArrayList<BeanUserWorking>();
	private List<String> listGroup = new ArrayList<String>();
	private DefaultListModel<String> listUserModel;
	private DefaultListModel<String> listGroupModel;
	private DefaultListModel<String> listFormModel;
	private DefaultListModel<String> listUserOfGroupMode;
	private DefaultListModel<String> listUserChoose;
	private DefaultComboBoxModel<String> comboBoxProjectModel;
	private List<DtoUserPMS> listAllUser;

	List<DtoDigiTexx> listDigiTexx;

	// private List<DtoUserPMS> listUserTemp;
	// public static void main(String[] args) {
	//
	// SwingUtilities.invokeLater(new Runnable() {
	// public void run() {
	// FormOneNew inst = new FormOneNew(null);
	// inst.setLocationRelativeTo(null);
	// inst.setVisible(true);
	//
	// // ListModel jListGroupModelProject = new
	// // DefaultComboBoxModel(arrProject);
	// // jListProject.setModel(jListGroupModelProject);
	//
	// }
	// });
	//
	// }

	public FormOneNew(MainJFrame parent) {
		super();
		this.parent = parent;
		daoPms = new DaoDatabase();

		listFormModel = new DefaultListModel<String>();
		listUserModel = new DefaultListModel<String>();
		listGroupModel = new DefaultListModel<String>();
		listUserOfGroupMode = new DefaultListModel<String>();
		listUserChoose = new DefaultListModel<String>();
		comboBoxProjectModel = new DefaultComboBoxModel<String>();

		listFormChoose = new ArrayList<>();

		initGUI();
		try {
			comboBoxProjectModel.removeAllElements();

			listUserModel.removeAllElements();
			listGroupModel.removeAllElements();

			listGroup = daoPms.getListGroup();
			listProject = daoPms.getListProject();

			listGroupModel.addElement("All");
			for (String s : listGroup) {
				listGroupModel.addElement(s);
			}

			for (DtoProject d : listProject) {

				comboBoxProjectModel.addElement(d.getProj_name());
			}

			jListGroup.setModel(listGroupModel);
			jComboBoxProject.setModel(comboBoxProjectModel);

			listUserModel.add(0, this.username);

			jComboBoxProjectItemStateChanged(null);
			jComboBoxProject.setSelectedIndex(0);
			jListGroup.setSelectedIndex(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Form Assignment");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("com/digitexx/image/icon.png")).getImage());
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}

				public void windowDeiconified(WindowEvent evt) {
					System.out.println("this.windowDeiconified, event=" + evt);
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
					jPanel3 = new JPanel();
					jPanel1.add(jPanel3, new AnchorConstraint(174, 988, 897,
							757, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					GroupLayout jPanel3Layout = new GroupLayout(
							(JComponent) jPanel3);
					jPanel3.setLayout(jPanel3Layout);
					jPanel3.setPreferredSize(new java.awt.Dimension(294, 405));
					{
						jScrollPane5 = new JScrollPane();
						{

							jListUserChoose = new JList();
							jScrollPane5.setViewportView(jListUserChoose);
							jListUserChoose.setBorder(BorderFactory
									.createTitledBorder(""));

						}
					}
					jPanel3Layout.setHorizontalGroup(jPanel3Layout
							.createSequentialGroup().addComponent(jScrollPane5,
									0, 294, Short.MAX_VALUE));
					jPanel3Layout.setVerticalGroup(jPanel3Layout
							.createSequentialGroup().addComponent(jScrollPane5,
									0, 168, Short.MAX_VALUE));
				}
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
						jListGroup.setModel(listGroupModel);
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

						jListUser = new JList();
						jScrollPane2.setViewportView(jListUser);
						listUserModel = new DefaultListModel<String>();
						jListUser.setModel(listUserModel);
						jListUser.setSize(304, 404);
						jListUser.setBorder(BorderFactory
								.createTitledBorder(""));
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
								.addPropertyChangeListener(new PropertyChangeListener() {
									public void propertyChange(
											PropertyChangeEvent evt) {
										jListFormPropertyChange(evt);
									}
								});
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
					jComboBoxProject.setMaximumRowCount(20);
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
			resetAll();

			if ("All".equalsIgnoreCase((String) jListGroup.getSelectedValue())) {
				listAllUser = daoPms.getListAllUser();
				listUserModel.removeAllElements();

				for (DtoUserPMS s : listAllUser) {
					listUserModel.addElement(s.getUsr_name());
				}

			} else {
				String groupName = (String) jListGroup.getSelectedValue();
				try {
					listAllUser = daoPms.getUserOfGroup(groupName);
					listUserModel.removeAllElements();
					for (DtoUserPMS s : listAllUser) {
						listUserModel.addElement(s.getUsr_name());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void jListUserValueChanged(ListSelectionEvent evt) {

	}

	private void jListFormValueChanged(ListSelectionEvent evt) {
		if (evt.getValueIsAdjusting()) {
			showUserOfGroup();
			// System.out.println(listFormChoose.size());
		}
	}

	
	private void jComboBoxProjectItemStateChanged(ItemEvent evt) {

		int index = jComboBoxProject.getSelectedIndex();
		// new DaoDatabase("10.10.5.10", "5432", "pms", "db_09_000_pms",
		// "ps_pms",
		// "digipms");
		
		daoProduction1 = new DaoDatabase(listProject.get(index).getProj_serverip(), "5432", listProject.get(index).getProj_dbname(),
				listProject.get(index).getProj_schema(), listProject.get(index)
						.getProj_uid(), listProject.get(index).getProj_pwd());

		listForm = daoProduction1.getListForm();
		if (listForm != null) {
			// listForm.sort(new EmployeeComparator());
			System.out.println(listProject.get(index).getProj_schema());
			listFormModel.removeAllElements();
			for (DtoForm d : listForm) {
				listFormModel.addElement(d.getName());
			}

			jListForm.setModel(listFormModel);
			jListForm.setSelectedIndex(0);
			showUserOfGroup();
		} else {
			JOptionPane.showMessageDialog(null, "Project data empty!",
					"Warning", JOptionPane.ERROR_MESSAGE);
			listFormModel.removeAllElements();
			jListForm.setModel(listFormModel);
			return;
		}
	}

	private void jButtonSaveActionPerformed(ActionEvent evt) {

	}

	protected void jButtonAddAddActionListener(ActionEvent arg0) {
		// if (jListUser.getSelectedIndices().length <= 0) {
		// JOptionPane.showMessageDialog(null, "Please choose user.",
		// "Warning", JOptionPane.ERROR_MESSAGE);
		// return;
		// }
		int[] arrIndex = jListUser.getSelectedIndices();
		if (arrIndex.length > 0) {
			List<DtoUserPMS> listTempUser = new ArrayList<DtoUserPMS>();
			listTempUser.clear();

			for (int a : arrIndex) {
				for (int i = 0; i < listDigiTexx.size(); i++) {
					if (listAllUser.get(a).getUsr_id() == listDigiTexx.get(i)
							.getUserId()) {
						JOptionPane.showMessageDialog(null, listAllUser.get(a)
								.getUsr_name() + " is existed.", "Error Input",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				listTempUser.add(listAllUser.get(a));
			}

			int indexProject = jComboBoxProject.getSelectedIndex();
			int projectID = listProject.get(indexProject).getId();
			String projectName = listProject.get(indexProject).getProj_name();
			List<Object[]> listParams = new ArrayList<Object[]>();
			for (int i = 0; i < listFormChoose.size(); i++) {
				for (int j = 0; j < listTempUser.size(); j++) {

					listParams.add(new Object[] { projectID, projectName,
							listTempUser.get(j).getUsr_id(),
							listTempUser.get(j).getUsr_name(),
							listFormChoose.get(i).getId(),
							listFormChoose.get(i).getName() });

				}
			}
			// listTempUser
			daoPms.setListUser(listParams);
			showUserOfGroup();
			JOptionPane.showMessageDialog(null, listTempUser.size()
					+ " users has inserted.");
		} else {
			JOptionPane.showMessageDialog(null, "Please choose user.",
					"Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jButtonDeleteActionPerformed(ActionEvent evt) {
		int[] arrIndex = jListUserChoose.getSelectedIndices();
		if (arrIndex.length > 0) {
			int indexProject = jComboBoxProject.getSelectedIndex();
			int projectID = listProject.get(indexProject).getId();
			List<DtoDigiTexx> listTempUser = new ArrayList<DtoDigiTexx>();
			List<Object[]> listParams = new ArrayList<Object[]>();
			List<Integer> list = new ArrayList<Integer>();
			;
			listTempUser.clear();
			if (arrIndex.length > 0) {
				for (int a : arrIndex) {

					listTempUser.add(listDigiTexx.get(a));

				}
			}

			for (int i = 0; i < listFormChoose.size(); i++) {
				list.add(listFormChoose.get(i).getId());
			}

			// for (int i = 0; i < listFormChoose.size(); i+.+) {
			for (int j = 0; j < listTempUser.size(); j++) {

				// // listParams.add(new Object[] { projectID,
				// // listFormChoose.get(i).getId(),
				// // listTempUser.get(j).getUserId() });
				//
				daoPms.deleteUser(projectID + "", list, listTempUser.get(j)
						.getUserId() + "");

			}
			// }
			// daoPms.deleteUser(listParams);
			showUserOfGroup();
			JOptionPane.showMessageDialog(null, listTempUser.size()
					+ " users has deleted.");
		} else {
			JOptionPane.showMessageDialog(null, "Please choose user.",
					"Warning", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void thisWindowClosed(WindowEvent evt) {
		parent.setVisible(true);
		parent.setLocationRelativeTo(null);
	}

	private void jListFormPropertyChange(PropertyChangeEvent evt) {

	}

	private void resetAll() {
		// jListUserChoose.setModel(null);
	}

	private void showUserOfGroup() {
		int[] listIndex = jListForm.getSelectedIndices();
		List<Integer> formChoose = new ArrayList<Integer>();

		listFormChoose.clear();
		// for (int i = 0; i < listIndex.length; i++) {
		// if (i == 0) {
		// list = listForm.get(listIndex[i]).getId() + "";
		// } else {
		// list += "," + listForm.get(listIndex[i]).getId();
		// }
		// listFormChoose.add(listForm.get(listIndex[i]));
		// }
		//
		for (int a : listIndex) {
			listFormChoose.add(listForm.get(a));
			formChoose.add(listForm.get(a).getId());
		}
		String list = formChoose.toString();
		list = list.substring(1, list.length() - 1);
		// System.out.println(list);
		int projecIndex = jComboBoxProject.getSelectedIndex();
		//
		listDigiTexx = daoPms.getUserOfForm(listProject.get(projecIndex)
				.getId(), list);
		listUserOfGroupMode.removeAllElements();
		for (DtoDigiTexx d : listDigiTexx) {
			listUserOfGroupMode.addElement(d.getUserName());
		}
		jListUserChoose.setModel(listUserOfGroupMode);

	}
}
