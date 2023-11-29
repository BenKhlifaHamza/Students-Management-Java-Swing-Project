import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import javax.swing.tree.DefaultMutableTreeNode;

public class TreeAndButtons { 

	   JButton btnActualiser = new JButton("Actualiser");
		JButton btnEnregistrer = new JButton("Enregistrer");
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("FSM");
		JTree treeFsm = new JTree(racine); 
		JScrollPane treeFsmScrollPane = new JScrollPane(treeFsm);
		JPanel panelTreeButtons = new JPanel(new BorderLayout());
		JPanel panelButtons = new JPanel(new GridLayout(1,2));
		JPanel getTreeAndButtons () {
		 	 
			this.panelButtons.add(this.btnActualiser); 
			this.panelButtons.add(this.btnEnregistrer);  
			
			this. panelTreeButtons.add(treeFsmScrollPane ,BorderLayout.CENTER);
			this.panelTreeButtons.add(panelButtons, BorderLayout.SOUTH); 
			panelTreeButtons.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			
			return this. panelTreeButtons ;
			
		} 
		}  
      