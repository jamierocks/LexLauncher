package malgm.minecraft.versioninstaller.ui.tabs.modslist;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.*;

public class ModsListContainer extends JPanel implements TableModelListener {

	private static final long serialVersionUID = 1L;
	
	private JTable jt;
	
	private String[] columns = {"Mod name", "Version", "Installed"};
	private String[][] data = {
			{"Example mod", "0.0.1", "Update"}
	};
	
	public ModsListContainer() {
		init();
	}
	
	public void init() {
		jt = new JTable(data, columns);
		jt.setPreferredScrollableViewportSize(new Dimension(580, 220));
		jt.getModel().addTableModelListener(this);
		jt.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		//TableColumn modname = jt.getColumnModel().getColumn(1);
		//TableColumn installed = jt.getColumnModel().getColumn(2);
		//TableColumn install = jt.getColumnModel().getColumn(2);
		
		add(jsp);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
	}

}
