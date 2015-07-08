package com.digitexx.forms;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FormManagementCategory extends javax.swing.JDialog implements ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton buttonDelete;
	private JButton buttonAdd;
	private JButton buttonRefesh;
	private JScrollPane jScrollPane1;
	private JTable table;
	private String data = "";
	private int row = -1,col = 0;
	private String columnDB = "";
	private long idCategory = -1;

	
	public FormManagementCategory(JFrame frame) {
		super(frame);
		initGUI();
		this.setLocationRelativeTo(null);
		loadTable();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setTitle("Manage Category");
			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(""), "Category", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				{
					jScrollPane1 = new JScrollPane();
					{
						TableModel tblDataModel = 
								new DefaultTableModel(
										new String[][] {},
										new String[] {"No","ID","Category","Status"});
						table = new JTable(){
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;
							boolean[] columnEditables = new boolean[] { false,false,true,true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						};
						
						ListSelectionModel rowSelMod = table.getSelectionModel();

						ListSelectionModel colSelMod = table.getColumnModel().getSelectionModel();

						rowSelMod.addListSelectionListener(this);
						colSelMod.addListSelectionListener(this);
						
						jScrollPane1.setViewportView(table);
						table.setModel(tblDataModel);
						table.setRowHeight(30);
						
						tblDataModel.addTableModelListener(new TableModelListener() {
					      public void tableChanged(TableModelEvent tme) {
					        if (tme.getType() == TableModelEvent.UPDATE) {
					        	data = (String) table.getModel().getValueAt(row, col);					        	
					        	//DaoManagementTime.updateCelltable(data,idCategory,columnDB);
					        }
					      }
						});
						
						table.setCellSelectionEnabled(true);
					}
				}
				{
					buttonRefesh = new JButton();
					buttonRefesh.setText("Refesh");
					buttonRefesh.setSize(91, 21);
					buttonRefesh.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							loadTable();
						}
					});
				}
				{
					buttonAdd = new JButton();
					buttonAdd.setText("Add Category");
					buttonAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							addCategoryActionPerform(evt);
						}
					});
				}
				{
					buttonDelete = new JButton();
					buttonDelete.setText("Delete");
					buttonDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							deleteCategoryActionPerform(evt);
						}
					});
				}
				panelLayout.setHorizontalGroup(panelLayout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					    .addComponent(buttonRefesh, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, Short.MAX_VALUE)
					    .addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					    .addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					    .addGap(0, 234, GroupLayout.PREFERRED_SIZE))
					.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 618, Short.MAX_VALUE));
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap(19, 19)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(buttonRefesh, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(buttonAdd, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(buttonDelete, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addComponent(panel, 0, 266, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(panel, 0, 392, Short.MAX_VALUE));
			this.setSize(632, 407);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent le) {
		if(!le.getValueIsAdjusting()){			
			
			int[] rows = table.getSelectedRows();
		    for (int i = 0; i < rows.length; i++){
		      row = rows[i];
		    }

		    int[] cols = table.getSelectedColumns();

		    for (int i = 0; i < cols.length; i++){
		    	col = cols[i];
		    	if(col == 1)
		    		columnDB = "category_id".trim();
		    	else if(col == 2)
		    		columnDB = "category_name".trim();
		    	else if(col == 3)
		    		columnDB = "category_status".trim();
		    	
		    	
			    System.out.println("col name :"+columnDB);
		    }

		    Object valueAt = table.getValueAt(row,1);
		    idCategory = Long.parseLong(valueAt+"");
		    col = table.convertColumnIndexToModel(col);
		    row = table.convertRowIndexToModel(row);
		}
		
	}
	
		
	private void loadTable(){
		TableModel tblDataModel = 
				new DefaultTableModel(
						new String[][] {},
						new String[] {"No","ID","Category"});
		table = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false,false,true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		ListSelectionModel rowSelMod = table.getSelectionModel();

		ListSelectionModel colSelMod = table.getColumnModel().getSelectionModel();

		rowSelMod.addListSelectionListener(this);
		colSelMod.addListSelectionListener(this);
		
		jScrollPane1.setViewportView(table);
		table.setModel(tblDataModel);
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setWidth(0);
		
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		centerRenderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
		centerRenderer.setHorizontalAlignment( javax.swing.JLabel.CENTER );
		
		tblDataModel.addTableModelListener(new TableModelListener() {
	      public void tableChanged(TableModelEvent tme) {
	        if (tme.getType() == TableModelEvent.UPDATE) {
	        	data = (String) table.getModel().getValueAt(row, col);
	        	//DaoManagementTime.updateCelltable(data,idCategory,columnDB);
	        }
	      }
		});
		
		table.setCellSelectionEnabled(true);
	
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		/*List<Object[]> allCategory = DaoManagementTime.getAllCategory();
		for(int i = 0 ;i < allCategory.size() ; i++ ){
			dtm.addRow(allCategory.get(i));
		}*/
		table.setModel(dtm);
	}
	
	private void addCategoryActionPerform(ActionEvent e){
		//AddCategoryDialog dlg = new AddCategoryDialog(null);
		/*dlg.setModal(true);
		dlg.setVisible(true);*/
		loadTable();
	}
	private void deleteCategoryActionPerform(ActionEvent e){
		if(row == -1){
			JOptionPane.showMessageDialog(null, "Select row delete");
		}else{
			//DaoManagementTime.deleteCategory(idCategory);
			loadTable();
		}
	}
}
