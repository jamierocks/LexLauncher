package malgm.minecraft.versioninstaller.ui;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ModsListContainer extends JPanel implements TableModelListener {

	private static final long serialVersionUID = 1L;
	
	private JTable jt;
	
	private String[] columns = {"Mod name", "Installed", "Install"};
	private String[][] data = {
			{"Example", "Installed", "Install"}
	};
	
	public ModsListContainer() {
		init();
	}
	
	public void init() {
		jt = new JTable(data, columns);
		jt.setPreferredScrollableViewportSize(new Dimension(580, 240));
		jt.getModel().addTableModelListener(this);
		jt.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(jt);
		
		add(jsp);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
	}

}
