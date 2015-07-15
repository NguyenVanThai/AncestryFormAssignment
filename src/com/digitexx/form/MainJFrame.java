package com.digitexx.form;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.image.ButtonIcon;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingUtilities;

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
public class MainJFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private ButtonIcon jButtonAssignment;
	private JButton jButtonForm1;
	private JLabel jLabel1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// String[] array = {"thai","thanh","toan","diem"};
				// List<String> list = new ArrayList<String>();
				// list.add("thai");
				// list.add("ok");
				// String ok = list.toString();
				// ok=ok.substring(1, ok.length()-1);

				// System.out.print(ok);
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
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Choose Type");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/image/icon.png")).getImage());

			{
				jPanel1 = new JPanel();
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(1, 1001, 1001, 1,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				AnchorLayout jPanel1Layout = new AnchorLayout();
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(449, 255));
				jPanel1.setBackground(new java.awt.Color(202,228,255));
				{
					jLabel1 = new JLabel();
					jLabel1.setText("CHOOSE TYPE");
					jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36));
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
				}
				{
					jButtonForm1 = new JButton();
					jButtonForm1.setText("PROJECT STATUS INFORMATION");
					jButtonForm1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonForm1ActionPerformed(evt);
						}
					});
				}
				{
					jButtonAssignment = new ButtonIcon();
					jPanel1.add(jButtonAssignment, new AnchorConstraint(629, 484, 798, 27, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.add(jButtonForm1, new AnchorConstraint(629, 976, 801, 508, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.add(jLabel1, new AnchorConstraint(178, 1001, 307,
							1, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setPreferredSize(new java.awt.Dimension(449, 33));
					jLabel1.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					jLabel1.setBackground(new java.awt.Color(167,167,167));
					jLabel1.setForeground(new java.awt.Color(0, 0, 0));
					jLabel1.setOpaque(true);
					jButtonForm1.setPreferredSize(new java.awt.Dimension(210, 44));
					jButtonAssignment.setText("FORM ASSIGNMENT");

					jButtonAssignment.setPreferredSize(new java.awt.Dimension(205, 43));
//					Icon icon1 = new ImageIcon(getClass().getClassLoader()
//							.getResource("com/digitexx/image/after.png"));
//					Icon icon2 = new ImageIcon(getClass().getClassLoader()
//							.getResource("com/digitexx/image/normal.png"));
//					jButtonAssignment.setIconAndIconSelected(icon1, icon2);

					jButtonAssignment.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAssignmentActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(455, 284);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButtonAssignmentActionPerformed(ActionEvent evt) {
		closeFrame();
		FormOneNew assignment = new FormOneNew(new MainJFrame());
		assignment.setVisible(true);
		assignment.setLocationRelativeTo(null);
	}

	private void jButtonForm1ActionPerformed(ActionEvent evt) {

		closeFrame();
		FormTwo assignment = new FormTwo(new MainJFrame());
		assignment.setVisible(true);
		assignment.setLocationRelativeTo(null);
	}

	public void closeFrame() {
		super.dispose();
	}

	private void jButtonForm1StateChanged(ChangeEvent e) {
		if (e.getSource() instanceof ButtonModel) {
			ButtonModel model = (ButtonModel) e.getSource();
			if (model.isEnabled()) {
				// if()
				ImageIcon icon = new ImageIcon(this.getClass().getResource(
						"normal.png"));
				jButtonForm1.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("com/digitexx/form/select.png")));
				// button.setIcon(icon());
			} else if (model.isSelected()) {
				ImageIcon icon = new ImageIcon(this.getClass().getResource(
						"select.png"));
				jButtonForm1.setIcon(icon);
			}
		}

		// else {
		// button.setIcon(iconA());
		// }
	}

}
