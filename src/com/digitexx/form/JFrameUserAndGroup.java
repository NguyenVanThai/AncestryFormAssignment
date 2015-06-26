package com.digitexx.form;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.dao.DaoPms;
import com.digitexx.dto.DtoGroup;
import com.digitexx.dto.DtoProject;
import com.digitexx.dto.DtoUser;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
public class JFrameUserAndGroup extends JFrame {
	private JPanel jPanel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private static JList jListGroup;
	private JScrollPane jScrollPane1;
	private JList jListMember;
	private JScrollPane jScrollPane2;
	private JList jList2;
	private JScrollPane jScrollPane3;
	private JList jList3;
	private JScrollPane jScrollPane4;
	private JList jList4;
	private JScrollPane jScrollPane5;
	private static JList jListProject;
	private JScrollPane jScrollPane6;
	private JButton jButton1;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel1;

	private static DaoPms daoPms;
	private static List<DtoGroup> listGroup;
	private static List<DtoUser> listUser;
	private static List<DtoProject> listProject;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrameUserAndGroup inst = new JFrameUserAndGroup();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);

				// ListModel jListGroupModelProject = new
				// DefaultComboBoxModel(arrProject);
				// jListProject.setModel(jListGroupModelProject);

			}
		});

	}

	public JFrameUserAndGroup() {
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

		ListModel jListGroupModelProject = new DefaultComboBoxModel(arrProject);
		jListProject.setModel(jListGroupModelProject);

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(0, 1000, 948, -4,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBounds(-3, 0, 958, 696);
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1, new AnchorConstraint(530, 947, 604,
							777, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jButton1.setText("Save");
					jButton1.setPreferredSize(new java.awt.Dimension(163, 49));
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(47, 574, 80, 439,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("LIST USER");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 22));
					jLabel1.setBounds(421, 44, 130, 21);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(538, 598, 582,
							426, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("LIST GROUP");
					jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 22));
					jLabel2.setBounds(409, 364, 166, 28);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(125, 194, 158,
							110, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("List Group");
					jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
					jLabel3.setPreferredSize(new java.awt.Dimension(81, 22));
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4, new AnchorConstraint(125, 593, 158,
							438, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel4.setText("List Member's Group");
					jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
					jLabel4.setPreferredSize(new java.awt.Dimension(148, 22));
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5, new AnchorConstraint(126, 947, 158,
							786, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel5.setText("List Member Choosed");
					jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
					jLabel5.setPreferredSize(new java.awt.Dimension(154, 21));
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6, new AnchorConstraint(616, 218, 647,
							110, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel6.setText("List Project");
					jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
					jLabel6.setBounds(109, 402, 104, 20);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7, new AnchorConstraint(616, 612, 644,
							438, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel7.setText("List Form's Project");
					jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14));
					jLabel7.setPreferredSize(new java.awt.Dimension(166, 18));
				}
				{
					jLabel8 = new JLabel();
					jPanel1.add(jLabel8, new AnchorConstraint(613, 957, 645,
							785, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel8.setText("List Form Choosed");
					jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14));
					jLabel8.setPreferredSize(new java.awt.Dimension(165, 21));
				}
				{
					jScrollPane6 = new JScrollPane();
					jPanel1.add(jScrollPane6, new AnchorConstraint(667, 268,
							983, 34, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane6.setPreferredSize(new java.awt.Dimension(224,
							220));
					{
						ListModel jList5Model = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });

						jListProject = new JList();
						jScrollPane6.setViewportView(jListProject);
						jListProject.setModel(jList5Model);
						jListProject.setPreferredSize(new java.awt.Dimension(
								221, 211));
						jListProject.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jListProject
								.addListSelectionListener(new ListSelectionListener() {
									public void valueChanged(
											ListSelectionEvent evt) {
										jListProjectValueChanged(evt);
									}
								});
					}
				}
				{
					jScrollPane5 = new JScrollPane();
					jPanel1.add(jScrollPane5, new AnchorConstraint(664, 621,
							983, 386, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane5.setPreferredSize(new java.awt.Dimension(225,
							222));
					{

						ListModel jList4Model = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
						jList4 = new JList();
						jScrollPane5.setViewportView(jList4);
						jList4.setModel(jList4Model);
						jList4.setPreferredSize(new java.awt.Dimension(211, 204));
					}
				}
				{
					jScrollPane4 = new JScrollPane();
					jPanel1.add(jScrollPane4, new AnchorConstraint(664, 973,
							983, 737, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane4.setPreferredSize(new java.awt.Dimension(226,
							222));
					{
						ListModel jList3Model = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });

						jList3 = new JList();
						jScrollPane4.setViewportView(jList3);
						jList3.setModel(jList3Model);
						jList3.setPreferredSize(new java.awt.Dimension(210, 134));
					}
				}
				{
					jScrollPane3 = new JScrollPane();
					jPanel1.add(jScrollPane3, new AnchorConstraint(168, 975,
							521, 738, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane3.setPreferredSize(new java.awt.Dimension(228,
							170));
					jScrollPane3.setBounds(709, 107, 228, 227);
					{
						ListModel jList2Model = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });

						jList2 = new JList();
						jScrollPane3.setViewportView(jList2);
						jList2.setModel(jList2Model);
						jList2.setPreferredSize(new java.awt.Dimension(210, 134));
					}
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2, new AnchorConstraint(166, 624,
							513, 387, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(228,
							170));
					jScrollPane2.setBounds(372, 106, 228, 223);
					{
						ListModel jList1Model = new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });

						jListMember = new JList();
						jScrollPane2.setViewportView(jListMember);
						jListMember.setModel(jList1Model);
						jListMember.setPreferredSize(new java.awt.Dimension(224, 229));
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(166, 273,
							521, 36, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(228,
							170));
					jScrollPane1.setBounds(34, 106, 228, 228);
					{

						// ListModel jListGroupModel = new DefaultComboBoxModel(
						// new String[] { "Item One", "Item Two" });
						jListGroup = new JList();
						jScrollPane1.setViewportView(jListGroup);
						// jListGroup.setModel(jListGroupModel);
						jListGroup.setPreferredSize(new java.awt.Dimension(224, 235));
						jListGroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jListGroup.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent evt) {
								jListGroupValueChanged(evt);
							}
						});
					}
				}
			}
			pack();
			this.setSize(971, 735);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jListProjectValueChanged(ListSelectionEvent evt) {
		System.out.println("jListProject.valueChanged, event=" + evt);
		// TODO add your code for jListProject.valueChanged
	}
	
	private void jListGroupValueChanged(ListSelectionEvent evt) {
//		System.out.println("jListGroup.valueChanged, event="+evt);
		//TODO add your code for jListGroup.valueChanged
		if (!evt.getValueIsAdjusting()){
            JList source = (JList)evt.getSource();
            int selected = source.getSelectedIndex();
    		int id = listGroup.get(selected).getId();
    		listUser = daoPms.getListUser(id);
    		String[] arrUser = new String[listUser.size()];
    		for(int i=0;i<listUser.size();i++){
    			arrUser[i] = listUser.get(i).getName();
    		}
    		
    		ListModel listModel = new DefaultComboBoxModel(arrUser);
    		jListMember.setModel(listModel);
    		
        }
		
	}

}
