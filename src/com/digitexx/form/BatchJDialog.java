package com.digitexx.form;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.digitexx.dto.DtoInfo;

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
public class BatchJDialog extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTableInfo;
	private DtoInfo dtoInfo;

	/**
	 * Auto-generated main method to display this JDialog
	 */

	public BatchJDialog(JFrame frame, DtoInfo dtoInfo) {
		super(frame);
		initGUI();
		this.dtoInfo = dtoInfo;
		String[] totalColumn = new String[] { "folder_batch", "batch", "date",
				"total", "total_form", "total_finish", "total_unfinish" };
		DefaultTableModel jTable1Model = new DefaultTableModel(null, totalColumn);
		jTable1Model.addRow(dtoInfo.toArray(dtoInfo.getDate()));
		jTableInfo.setModel(jTable1Model);
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout(
						(JComponent) jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					jScrollPane1 = new JScrollPane();
					{

						jTableInfo = new JTable();
						jScrollPane1.setViewportView(jTableInfo);

					}
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout
						.createSequentialGroup().addComponent(jScrollPane1, 0,
								384, Short.MAX_VALUE));
				jPanel1Layout.setVerticalGroup(jPanel1Layout
						.createSequentialGroup()
						.addGap(6)
						.addComponent(jScrollPane1, 0, 250, Short.MAX_VALUE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED, 0,
								GroupLayout.PREFERRED_SIZE));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addComponent(jPanel1, 0, 261, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addComponent(jPanel1, 0, 384, Short.MAX_VALUE));
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
