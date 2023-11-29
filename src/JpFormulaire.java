

import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
 
@SuppressWarnings("serial")
public class JpFormulaire extends JPanel { 
   
	JTextField prenomFiled = new JTextField();  
	JTextField nomFiled = new JTextField();
	JTextField emailFiled = new JTextField();
	JTextField adresseFiled = new JTextField();
	JTextField numeroPortableFiled = new JTextField(); 
	JTextField numeroFixFiled = new JTextField();
	JTextField classeFiled = new JTextField(); 
	JTextField niveauFiled = new JTextField();    
	JButton btnOk = new JButton("OK");
	JButton btnAnnuler = new JButton("ANNULER");  
	Etudiant etudiant = new Etudiant(); 
	String prenom , nom , email , adresse , numeroPortable , numeroFix , classe , niveau ; 
	
	public JPanel  jpFormulaire() {
		GridLayout myGridLayout =new GridLayout(6,4,5,5);
		JPanel myPanel = new JPanel(myGridLayout);
		myPanel.setLayout(myGridLayout);
		myPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		 
		myPanel.add(new JLabel("Prenom*"));
		myPanel.add(this.prenomFiled);
		
		myPanel.add(new JLabel("Nom*"));
		myPanel.add(this.nomFiled); 
		 
		myPanel.add(new JLabel("E-mail*"));
		myPanel.add(this.emailFiled);
		  
		myPanel.add(new JLabel("Adresse*"));
		myPanel.add(this.adresseFiled); 

		myPanel.add(new JLabel("Numero Portable*"));
		myPanel.add(this.numeroPortableFiled);
		
		myPanel.add(new JLabel("Numero Fix")); 
		myPanel.add(this.numeroFixFiled); 
		
		myPanel.add(new JLabel("Classe*")); 
		myPanel.add(this.classeFiled);
		
		myPanel.add(new JLabel("Niveau*"));
		myPanel.add(this.niveauFiled);
		
		myPanel.add(new JLabel("* Champ Obligatoire"));
		myPanel.add(new JLabel());myPanel.add(new JLabel());myPanel.add(new JLabel());myPanel.add(new JLabel());
		  
		
		 
		
		

		
		myPanel.add(this.add(btnOk));  
		myPanel.add(this.add(btnAnnuler));
		return myPanel; 
		  
	 
	} 
	 
}
/**/