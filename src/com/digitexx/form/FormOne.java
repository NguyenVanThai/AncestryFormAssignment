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
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.dao.DaoDatabase;
import com.digitexx.dao.DaoProduction1;
import com.digitexx.dao.EmployeeComparator;
import com.digitexx.dto.DtoDigiTexx;
import com.digitexx.dto.DtoForm;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoUser;
import com.digitexx.dto.DtoUserPMS;
import com.sun.org.apache.bcel.internal.generic.DMUL;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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
public class FormOne extends JFrame {
	private JPanel jPanel1;
	private JLabel jLabel3;
	static private JList jListUserOfGroup;
	private JScrollPane jScrollPane5;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JSplitPane jSplitPane1;
	private JButton jButtonDelete;
	private JLabel jLabel6;
	private JButton jButtonAdd;
	private JComboBox jComboBoxProject;
	private JLabel jLabel2;
	static private JList jListUserChoosed;
	private JScrollPane jScrollPane4;
	static private JList jListForm;
	private JScrollPane jScrollPane3;
	static private JList jListUser;
	private JScrollPane jScrollPane2;
	private static JList jListGroup;
	private JScrollPane jScrollPane1;
	private JButton jButtonSave;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel1;

	private DaoProduction1 daoProduction1;
	private DaoDatabase daoPms;
	private static List<DtoUser> listUser;
	private static List<DtoProject> listProject;
	private static List<DtoForm> listForm;

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
	private List<DtoUserPMS> listOldUser;
	private List<DtoUserPMS> listTempUser;
	private List<DtoUserPMS> listNewUser;
	List<DtoDigiTexx> listDigiTexx;

	// private List<DtoUserPMS> listUserTemp;
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FormOne inst = new FormOne(null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);

				// ListModel jListGroupModelProject = new
				// DefaultComboBoxModel(arrProject);
				// jListProject.setModel(jListGroupModelProject);

			}
		});

	}

	public FormOne(MainJFrame parent) {
		super();
		daoPms = new DaoDatabase("10.10.5.10", "5432", "pms", "db_09_000_pms",
				"ps_pms", "digipms");

		listFormModel = new DefaultListModel<String>();
		listUserModel = new DefaultListModel<String>();
		listGroupModel = new DefaultListModel<String>();
		listUserOfGroupMode = new DefaultListModel<String>();
		listUserChoose = new DefaultListModel<String>();
		comboBoxProjectModel = new DefaultComboBoxModel<String>();

		listOldUser = new ArrayList<DtoUserPMS>();
		listTempUser = new ArrayList<DtoUserPMS>();
		listNewUser = new ArrayList<DtoUserPMS>();

		initGUI();
		try {
			comboBoxProjectModel.removeAllElements();

			listAllUser = daoPms.getListAllUser();
			listUserModel.removeAllElements();
			listGroupModel.removeAllElements();

			listGroup = daoPms.getListGroup();
			listProject = daoPms.getListProject();

			listGroupModel.addElement("All");
			for (String s : listGroup) {
				listGroupModel.addElement(s);
			}

			for (DtoProject d : listProject) {

				comboBoxProjectModel.addElement(d.getName());
			}

			jListGroup.setModel(listGroupModel);
			jComboBoxProject.setModel(comboBoxProjectModel);

			listUserModel.add(0, this.username);
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
					jSplitPane1 = new JSplitPane();
					jPanel1.add(jSplitPane1, new AnchorConstraint(172, 990,
							870, 758, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
					jSplitPane1.setPreferredSize(new java.awt.Dimension(295,
							391));
					jSplitPane1.setResizeWeight(0.5);
					{
						jPanel2 = new JPanel();
						GroupLayout jPanel2Layout = new GroupLayout(
								(JComponent) jPanel2);
						jPanel2.setLayout(jPanel2Layout);
						jSplitPane1.add(jPanel2, JSplitPane.RIGHT);
						jPanel2.setPreferredSize(new java.awt.Dimension(294,
								190));
						{
							jScrollPane4 = new JScrollPane();
							{
								jListUserChoosed = new JList();
								jScrollPane4.setViewportView(jListUserChoosed);

								jListUserChoosed.setBorder(BorderFactory
										.createTitledBorder(""));

							}
						}
						jPanel2Layout.setHorizontalGroup(jPanel2Layout
								.createSequentialGroup().addComponent(
										jScrollPane4, 0, 294, Short.MAX_VALUE));
						jPanel2Layout.setVerticalGroup(jPanel2Layout
								.createSequentialGroup().addComponent(
										jScrollPane4, 0, 214, Short.MAX_VALUE));
					}
					{
						jPanel3 = new JPanel();
						GroupLayout jPanel3Layout = new GroupLayout(
								(JComponent) jPanel3);
						jPanel3.setLayout(jPanel3Layout);
						jSplitPane1.add(jPanel3, JSplitPane.LEFT);
						{
							jScrollPane5 = new JScrollPane();
							{

								jListUserOfGroup = new JList();
								jScrollPane5.setViewportView(jListUserOfGroup);
								jListUserOfGroup.setBorder(BorderFactory
										.createTitledBorder(""));

							}
						}
						jPanel3Layout.setHorizontalGroup(jPanel3Layout
								.createSequentialGroup().addComponent(
										jScrollPane5, 0, 294, Short.MAX_VALUE));
						jPanel3Layout.setVerticalGroup(jPanel3Layout
								.createSequentialGroup().addComponent(
										jScrollPane5, 0, 168, Short.MAX_VALUE));
					}

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

			resetAll();

			if ("All".equalsIgnoreCase((String) jListGroup.getSelectedValue())) {

				listUserModel.removeAllElements();
				for (DtoUserPMS s : listAllUser) {
					listUserModel.addElement(s.getUsr_name());
				}
				listOldUser.addAll(listAllUser);
			} else {
				String groupName = (String) jListGroup.getSelectedValue();
				try {
					List<DtoUserPMS> listUsers = daoPms
							.getUserOfGroup(groupName);
					listUserModel.removeAllElements();
					for (DtoUserPMS s : listUsers) {
						listUserModel.addElement(s.getUsr_name());
					}
					listOldUser.addAll(listUsers);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void jListUserValueChanged(ListSelectionEvent evt) {

	}

	private void jListFormValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
			int[] listIndex = jListForm.getSelectedIndices();
			String list = "";
			for (int i = 0; i < listIndex.length; i++) {
				if (i == 0) {
					list = listForm.get(listIndex[i]).getId() + "";
				} else {
					list += "," + listForm.get(listIndex[i]).getId();
				}
			}

			int projecIndex = jComboBoxProject.getSelectedIndex();

			listDigiTexx = daoPms.getUserOfForm(listProject.get(projecIndex)
					.getId(), list);
			listUserOfGroupMode.removeAllElements();
			for (DtoDigiTexx d : listDigiTexx) {
				listUserOfGroupMode.addElement(d.getUserName());
			}
			jListUserOfGroup.setModel(listUserOfGroupMode);
		}
	}

	private void jComboBoxProjectItemStateChanged(ItemEvent evt) {

		int index = jComboBoxProject.getSelectedIndex();
		new DaoDatabase("10.10.5.10", "5432", "pms", "db_09_000_pms", "ps_pms",
				"digipms");
		DaoDatabase daoProduction1 = new DaoDatabase("10.10.5.10", "5432",
				"Production1", listProject.get(index).getSchema(), listProject
						.get(index).getUid(), listProject.get(index)
						.getPassword());
		listForm = daoProduction1.getListForm();
		listForm.sort(new EmployeeComparator());
		// String[] arrForm = new String[listForm.size()];
		// for (int i = 0; i < listForm.size(); i++) {
		// arrForm[i] = listForm.get(i).getName();
		// }
		listFormModel.removeAllElements();
		for (DtoForm d : listForm) {
			listFormModel.addElement(d.getName());
		}

		jListForm.setModel(listFormModel);

	}

	private void jButtonSaveActionPerformed(ActionEvent evt) {

	}

	protected void jButtonAddAddActionListener(ActionEvent arg0) {

		int[] arrIndex = jListUser.getSelectedIndices();
		if (arrIndex.length > 0) {
			listTempUser.clear();
			for (int a : arrIndex) {

				for (int i = 0; i < listDigiTexx.size(); i++) {
					if (listOldUser.get(a).getUsr_id() == listDigiTexx.get(i)
							.getUserId()) {

						JOptionPane.showMessageDialog(null, listOldUser.get(a)
								.getUsr_name() + " is existed.", "Error Input",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				listTempUser.add(listOldUser.get(a));
			}

			listOldUser.removeAll(listTempUser);
			listNewUser.addAll(listTempUser);
			listUserModel.removeAllElements();
			listUserChoose.removeAllElements();

			for (DtoUserPMS a : listOldUser) {
				listUserModel.addElement(a.getUsr_name());
			}

			for (DtoUserPMS b : listNewUser) {
				listUserChoose.addElement(b.getUsr_name());
			}

			jListUser.setModel(listUserModel);
			jListUserChoosed.setModel(listUserChoose);
		}

	}

	private void jButtonDeleteActionPerformed(ActionEvent evt) {
		int[] arrIndex = jListUserChoosed.getSelectedIndices();
		if (arrIndex.length > 0) {
			listTempUser.clear();
			for (int a : arrIndex) {

				listTempUser.add(listNewUser.get(a));
			}

			listNewUser.removeAll(listTempUser);
			listOldUser.addAll(listTempUser);

			listUserModel.removeAllElements();
			listUserChoose.removeAllElements();

			for (DtoUserPMS a : listOldUser) {
				listUserModel.addElement(a.getUsr_name());
			}

			for (DtoUserPMS b : listNewUser) {
				listUserChoose.addElement(b.getUsr_name());
			}

			jListUser.setModel(listUserModel);
			jListUserChoosed.setModel(listUserChoose);
		}
	}

	private void thisWindowClosed(WindowEvent evt) {
		// parent.setVisible(true);
		// parent.setLocationRelativeTo(null);
	}

	private void jListFormPropertyChange(PropertyChangeEvent evt) {

	}

	private void resetAll() {
		listNewUser.clear();
		listTempUser.clear();
		listUserChoose.removeAllElements();
		jListUserChoosed.setModel(listUserChoose);
	}
}
