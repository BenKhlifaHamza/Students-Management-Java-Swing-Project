
import java.awt.GridLayout;


import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;




public class JpTabNotesSud {


	JButton btnEnregistre =new JButton("Enregistré");
	JButton btnAnnuler =new JButton("Annuler");
	JButton btnVider =new JButton("Vider");  
	 
	  
	JPanel	constructJpTabNotesSud () {  
		 
		JPanel btnsPanel = new JPanel(new GridLayout(1,6)) ;
  
		
		btnsPanel.add(btnEnregistre);
		btnsPanel.add(btnAnnuler); 
		btnsPanel.add(btnVider);  
		btnsPanel.add(new JLabel());  
		btnsPanel.add(new JLabel());
		btnsPanel.add(new JLabel()); 
			 
		 
	return btnsPanel;	  
	} 
		 

}
