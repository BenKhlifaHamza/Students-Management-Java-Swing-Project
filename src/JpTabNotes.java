import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;


import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;


public class JpTabNotes {


	JLabel videNomLabel = new JLabel("");
	JLabel videEmailLabel = new JLabel("");
	JLabel nomPrenomLabel = new JLabel("Nom et Prenom :");
	JLabel emailLabel = new JLabel("E-mail :");
	JLabel securiteLabel = new JLabel("Securité :"); 
	JLabel reseauLabel = new JLabel("Réseau");
	JLabel javaLabel = new JLabel("Java :");
	JLabel phpLabel = new JLabel("PHP :");
	JLabel androidLabel = new JLabel("Android :");
	JLabel sgbdLabel = new JLabel("SGBD :");
	JLabel mathLabel = new JLabel("Math :"); 
	JLabel francaisLabel = new JLabel("Francais :"); 
	JLabel anglaisLabel = new JLabel("Anglais :");  
	JLabel pfeLabel = new JLabel("PFE :"); 
	  
	 
  
	JTextField securiteFiled = new JTextField();
	JTextField reseauFiled = new JTextField();
	JTextField javaFiled = new JTextField();
	JTextField phpFiled = new JTextField();
	JTextField androidFiled = new JTextField();
	JTextField sgbdFiled = new JTextField();
	JTextField mathFiled = new JTextField(); 
	JTextField francaisFiled = new JTextField();
	JTextField anglaisFiled = new JTextField(); 
	JTextField pfeFiled = new JTextField(); 
	
	JpTabNotesSud jpTabNotesSud = new JpTabNotesSud();
	GestionnaireExamens gestionExamens = new GestionnaireExamens();
 
	void afficherNotesEtudiant(String nom, String email) {
	Notes notes = this.gestionExamens.lireNotes(email);
	this.videNomLabel.setText(nom);
	this.videEmailLabel.setText(email);
		if(notes != null) {
			this.securiteFiled.setText(notes.getSecurite());
			this.reseauFiled.setText(notes.getReseaux());
			this.javaFiled.setText(notes.getJava());
			this.phpFiled.setText(notes.getPhp());
			this.androidFiled.setText(notes.getAndroid());
			this.sgbdFiled.setText(notes.getSgbd());
			this.mathFiled.setText(notes.getMath());
			this.francaisFiled.setText(notes.getFrancais());
			this.anglaisFiled.setText(notes.getAnglais());
			this.pfeFiled.setText(notes.getPfe());
		}else {
			this.securiteFiled.setText(null);this.reseauFiled.setText(null);this.javaFiled.setText(null);this.phpFiled.setText(null);this.androidFiled.setText(null);
			this.sgbdFiled.setText(null);this.mathFiled.setText(null);this.francaisFiled.setText(null);this.anglaisFiled.setText(null);this.pfeFiled.setText(null);
			
		 
		}
	}
	
	void sauvegarderNotesEtudiant(String email) {
		if(videEmailLabel.getText()!="") {
			Notes sauvgardeNotes = new Notes(this.videNomLabel.getText(),
					this.videEmailLabel.getText(),
					this.securiteFiled.getText(),
					this.reseauFiled.getText(),
					this.javaFiled.getText(),
					this.phpFiled.getText(),
					this.androidFiled.getText(),
					this.sgbdFiled.getText(),
					this.mathFiled.getText(),
					this.francaisFiled.getText(),
					this.anglaisFiled.getText(),
					this.pfeFiled.getText());
			if(this.gestionExamens.lireNotes(email)==null) {
				gestionExamens.insererNotes(sauvgardeNotes);
			}else {
				gestionExamens.modifierNotes(sauvgardeNotes);;
			}
		}
		 
	}
	
	
	
	
JPanel	constructJpTabNotes () {  
	JPanel informationPanel = new JPanel(new GridLayout(12,4)) ;
 
	 
this.jpTabNotesSud.btnVider.addActionListener(new ActionListener() {
	
	@Override  
	public void actionPerformed(ActionEvent e)  {
		securiteFiled.setText(null);reseauFiled.setText(null);javaFiled.setText(null);phpFiled.setText(null);androidFiled.setText(null);
		sgbdFiled.setText(null);mathFiled.setText(null);francaisFiled.setText(null);anglaisFiled.setText(null);pfeFiled.setText(null);
		videEmailLabel.setText("");videNomLabel.setText("");
	}
}); 
;
this.jpTabNotesSud.btnAnnuler.addActionListener(new ActionListener() {
	
	@Override  
	public void actionPerformed(ActionEvent e)  {
		if(videEmailLabel.getText()!= "") {afficherNotesEtudiant( videNomLabel.getText(),videEmailLabel.getText());}
		 
	}
}); 
;
	 
this.jpTabNotesSud.btnEnregistre.addActionListener(new ActionListener() {
	
	@Override  
	public void actionPerformed(ActionEvent e)  {
		sauvegarderNotesEtudiant(videEmailLabel.getText());	}
}); 
;  

	informationPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	informationPanel.add(nomPrenomLabel); informationPanel.add(this.videNomLabel); informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(emailLabel); informationPanel.add(this.videEmailLabel);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(securiteLabel); informationPanel.add(securiteFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(reseauLabel); informationPanel.add(reseauFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(javaLabel); informationPanel.add(javaFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(phpLabel); informationPanel.add(phpFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(androidLabel); informationPanel.add(androidFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(sgbdLabel); informationPanel.add(sgbdFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(mathLabel); informationPanel.add(mathFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(francaisLabel); informationPanel.add(francaisFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(anglaisLabel); informationPanel.add(anglaisFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());
	informationPanel.add(pfeLabel); informationPanel.add(pfeFiled);  informationPanel.add(new JLabel()); informationPanel.add(new JLabel());

		JPanel myFinalPanel = new JPanel(new BorderLayout(2,1) ) ;
		myFinalPanel.add(informationPanel , BorderLayout.NORTH);
		myFinalPanel.add(this.jpTabNotesSud.constructJpTabNotesSud() , BorderLayout.SOUTH);
return myFinalPanel;	  
}  

}
