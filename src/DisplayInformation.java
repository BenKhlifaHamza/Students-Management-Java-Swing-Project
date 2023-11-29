
import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 

@SuppressWarnings("serial")
public class DisplayInformation extends JPanel {
	JPanel myFinalInfoPanel = new JPanel(new BorderLayout());
	Etudiant globEtudiant = new Etudiant();
	
	 
	JLabel labelNom = new JLabel (); 
	JLabel labelPenom = new JLabel ();
	JLabel labelClasse = new JLabel ();  
	JLabel labelEmail = new JLabel ();  
	JLabel labelTelephone = new JLabel ();   
	JLabel labelAdresse = new JLabel ();  
	  
	JLabel labelNomInfo = new JLabel("Nom : "); 
	JLabel labelPenomInfo = new JLabel("Prenom : ");
	JLabel labelClasseInfo = new JLabel("Classe : "); 
	JLabel labelEmailInfo = new JLabel("E_mail : ");  
	JLabel labelTelephoneInfo = new JLabel("Téléphone : ");  
	JLabel labelAdresseInfo = new JLabel("Adresse : ");
	
	 JButton btnModifier = new JButton("Modifier");
	 JButton btnSupprimer = new JButton("Supprimer");  
	 

public void remouveInfo () {  
	 
	labelNom.setText("");
	 labelPenom.setText("");
	 labelClasse.setText(""); 
	 labelEmail.setText("");  
	 labelTelephone.setText("");  
	 labelAdresse.setText("");

} 
 

	public JPanel  affichage(Etudiant etudiant) { 
		  
	
		JPanel myInfoPanel = new JPanel(new GridLayout(7,2));  
		  
		//  if(etudiant == null) {etudiant = new Etudiant();}
		myInfoPanel.add(labelNomInfo);  
		myInfoPanel.add(labelNom);    
		this.labelNom.setText(etudiant.getNom());   
		myInfoPanel.add(labelPenomInfo);  
		myInfoPanel.add(labelPenom);
		this.labelPenom.setText(etudiant.getPrenom());
		  
			 
		myInfoPanel.add(labelClasseInfo);
		myInfoPanel.add(labelClasse);
		this.labelClasse.setText(etudiant.getClasse());
		
		myInfoPanel.add(labelEmailInfo); 
		myInfoPanel.add(labelEmail);
		this.labelEmail.setText(etudiant.getEmail());
		  
		myInfoPanel.add(labelTelephoneInfo); 
		myInfoPanel.add(labelTelephone);
		this.labelTelephone.setText(etudiant.getNumeroPortable());
		 
		myInfoPanel.add(labelAdresseInfo);
		myInfoPanel.add(labelAdresse);
		this.labelAdresse.setText(etudiant.getAdresse()); 
		
		myInfoPanel.add(btnModifier);
		myInfoPanel.add(btnSupprimer);
		
		this.myFinalInfoPanel.add(myInfoPanel , BorderLayout.NORTH);
		
		
		myFinalInfoPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
		
		
		
		return myFinalInfoPanel ;  
	}   
	  
	  
	
	
	
	
}
