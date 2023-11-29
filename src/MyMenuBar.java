
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar {
	 ActionListener menuItemListener ;  
	 	  
 
	 JMenuBar getMyMenuBar () {
		   
		 JMenu fileMenu = new JMenu("Fichier");
			JMenuItem menuItem = new JMenuItem("Ouvrire", 'O');
			 fileMenu.add(menuItem);
			 menuItem.addActionListener(menuItemListener);
			 menuItem = new JMenuItem("Enregistré", 'E');
			 fileMenu.add(menuItem);
			 menuItem.addActionListener(menuItemListener);
			 menuItem = new JMenuItem("Quitter",'Q');
			 fileMenu.add(menuItem);
			 menuItem.addActionListener(menuItemListener);
			 this.add(fileMenu);

		return this;}
	 
	 
 
} 
