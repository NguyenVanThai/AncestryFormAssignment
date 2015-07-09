package com.digitexx.form;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainJFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton jButtonAssignment;
	private JButton jButtonForm1;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainJFrame inst = new MainJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(113, 1000, 253, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("CHOOSE TYPE");
					jLabel1.setFont(new java.awt.Font("Times New Roman",1,36));
					jLabel1.setPreferredSize(new java.awt.Dimension(510, 46));
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
				}
				{
					jButtonForm1 = new JButton();
					jPanel1.add(jButtonForm1, new AnchorConstraint(446, 953, 583, 600, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonForm1.setText("FORM 1");
					jButtonForm1.setPreferredSize(new java.awt.Dimension(180, 45));
					jButtonForm1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonForm1ActionPerformed(evt);
						}
					});
				}
				{
					jButtonAssignment = new JButton();
					jPanel1.add(jButtonAssignment, new AnchorConstraint(446, 410, 583, 57, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonAssignment.setText("FORM ASSIGNMENT");
					jButtonAssignment.setPreferredSize(new java.awt.Dimension(180, 45));
					jButtonAssignment.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAssignmentActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(526, 369);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButtonAssignmentActionPerformed(ActionEvent evt) {
		closeFrame();
		JFrameSelectUserForForm assignment = new JFrameSelectUserForForm(new MainJFrame());
		assignment.setVisible(true);
		assignment.setLocationRelativeTo(null);
	}
	
	private void jButtonForm1ActionPerformed(ActionEvent evt) {
		closeFrame();
		Form2 assignment = new Form2(new MainJFrame());
		assignment.setVisible(true);
		assignment.setLocationRelativeTo(null);
	}
	public void closeFrame(){
	    super.dispose();
	}
}
