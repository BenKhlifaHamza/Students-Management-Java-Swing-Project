
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent; 
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
  
@SuppressWarnings("serial")  
public class GestionnaireEtudiants extends JFrame {
	boolean ouv = false ; 
	boolean auth = false ;
	Methodes methodes = new Methodes();
	Etudiant etudiantInfo = new Etudiant();
	DisplayInformation display = new DisplayInformation();
	JpFormulaire formulaire = new JpFormulaire();
	TreeAndButtons treeAndButtons = new TreeAndButtons();  
	JPanel panelTreeButtonsInfo = new JPanel(new GridLayout(1,2)); 
	JPanel panelAll = new JPanel(new BorderLayout());
	//JPanel finalpanelAll = new JPanel(new BorderLayout());  
	MyMenuBar menuBar = new MyMenuBar ();  
	JpTabNotes myJpTabNotes = new JpTabNotes(); 
	JTabbedPane tabbedPane = new JTabbedPane();     
	 Etudiant etudiant = new Etudiant();   
	 GestionnaireExamens gestionExamens = new GestionnaireExamens();  
	 ModifierEtudiantDialog modifierDialog ;
	   Authentification authentification = new Authentification();    
	public static void main(String[] args) {    
		
    ArrayList<Etudiant> nouvelesEtudiant = new ArrayList<Etudiant>() ;	 
	GestionnaireEtudiants myFrame = new GestionnaireEtudiants ();
	myFrame.setTitle("Gestionnaire Etudiant"); 
	myFrame.display.removeAll(); 
	myFrame.gestionExamens.creerDbEtTable();
		  
		myFrame.formulaire.	btnAnnuler.addActionListener(new  ActionListener() {
			@Override  
			public void actionPerformed(ActionEvent e)  {
				myFrame.formulaire.prenomFiled.setText(null);myFrame.formulaire. nomFiled.setText(null);myFrame.formulaire. emailFiled.setText(null); myFrame.formulaire.adresseFiled.setText(null);
				myFrame.formulaire.numeroPortableFiled.setText(null);myFrame.formulaire. numeroFixFiled.setText(null);myFrame.formulaire. classeFiled.setText(null);myFrame.formulaire. niveauFiled.setText(null);
			} 
		});    
  
		myFrame.formulaire.btnOk.addActionListener(new ActionListener() {
			 
				@Override      
				public void actionPerformed(ActionEvent e)  {
				if(myFrame.formulaire.prenomFiled.getText().isEmpty() || myFrame.formulaire.nomFiled.getText().isEmpty() ||myFrame.formulaire.emailFiled.getText().isEmpty() ||myFrame.formulaire.adresseFiled.getText().isEmpty() ||
						myFrame.formulaire.numeroPortableFiled.getText().isEmpty() ||myFrame.formulaire. classeFiled.getText().isEmpty() ||myFrame. formulaire.niveauFiled.getText().isEmpty()) {
					JOptionPane.showMessageDialog(myFrame, "Les champs avec * est obligatoire");	
				}else{ 
					Etudiant etudiant = new Etudiant();  
					etudiant.setPrenom(myFrame.formulaire.prenomFiled.getText())   ; etudiant.setNom(myFrame.formulaire.nomFiled.getText())   ; etudiant.setEmail(myFrame.formulaire.emailFiled.getText()); etudiant.setAdresse(myFrame.formulaire.adresseFiled.getText()); 
					etudiant.setNumeroPortable(myFrame.formulaire.numeroPortableFiled.getText()); etudiant.setNumeroFix(myFrame.formulaire.numeroFixFiled.getText()); etudiant.setClasse(myFrame.formulaire.classeFiled.getText()); etudiant.setNiveau(myFrame.formulaire.niveauFiled.getText()); 
					System.out.println(etudiant.getAdresse() + etudiant.getNom());
					if (Methodes.addNodeToFsm(etudiant, myFrame.treeAndButtons.treeFsm)) {
						nouvelesEtudiant.add(etudiant);
					}; 
					myFrame.etudiant = etudiant;
					
					myFrame.formulaire.prenomFiled.setText(null);myFrame. formulaire.nomFiled.setText(null); myFrame.formulaire.emailFiled.setText(null);myFrame.formulaire. adresseFiled.setText(null);
					myFrame.formulaire.numeroPortableFiled.setText(null); myFrame.formulaire.numeroFixFiled.setText(null);myFrame. formulaire.classeFiled.setText(null);myFrame.formulaire. niveauFiled.setText(null);
				} } });   
		   
		myFrame.treeAndButtons.btnEnregistrer.addActionListener(new ActionListener() {			 
				@Override   
	 	 		public void actionPerformed(ActionEvent e)  {
				System.out.println("Bouton Enregistré");} }); 
			 
		myFrame. treeAndButtons.btnActualiser.addActionListener(new ActionListener() {				 
			 public void actionPerformed(ActionEvent evt) {
				 DefaultTreeModel myTreeModel = (DefaultTreeModel)myFrame.treeAndButtons. treeFsm.getModel();
				 DefaultMutableTreeNode racine = (DefaultMutableTreeNode) myTreeModel.getRoot();
				 System.out.println(" Bouton Actualiser");
				 for (int i = 0; i < myFrame.treeAndButtons.treeFsm.getRowCount(); i++) {  
					 myFrame.treeAndButtons. treeFsm.expandRow(i); 
				  }  
				 for (int i = 0; i < racine.getChildCount(); i++) { 
					 System.out.println(racine.getChildAt(i));
					 } }});  
					 
           TreeSelectionListener arbreListener = new TreeSelectionListener () {
			 public void valueChanged(TreeSelectionEvent e) {
			 DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
					 myFrame.treeAndButtons. treeFsm.getLastSelectedPathComponent();
			 if (node == null) {
			 return;     
			 }     
			 if (node.isLeaf()&&node.getParent() != null) { 
			 Etudiant info = (Etudiant) node.getUserObject();  
			 myFrame.etudiantInfo = info ;
			 myFrame. myJpTabNotes.afficherNotesEtudiant(info.getNom()+" "+info.getPrenom(), info.getEmail());
  
			 myFrame.display.myFinalInfoPanel.removeAll(); 
			 //myFrame.display.returnInfo();
			 myFrame.display.affichage(info); 
	         myFrame.display.myFinalInfoPanel.revalidate();
	 	     myFrame.display.myFinalInfoPanel.repaint(); 
    
		 	 }else { 

		 		myFrame.display.myFinalInfoPanel.removeAll();
		 		myFrame.display.myFinalInfoPanel.add(new JScrollPane(Methodes.tableInfo(node))/*, BorderLayout.CENTER*/);
	 			myFrame.display.myFinalInfoPanel.revalidate();
	 			myFrame.display.myFinalInfoPanel.repaint();  
 
			 	     
			 }    
			 }    
			};      
			myFrame.menuBar.menuItemListener = new ActionListener() {
				 public void actionPerformed(ActionEvent event) {  
					 String itemName = event.getActionCommand();
					 System.out.println("Item [" + itemName + "] clicked."); 
                         
					 if (itemName.equals("Ouvrire")) { 
						 
					myFrame.ouv = true ;
						 Methodes.initialiserArbre(myFrame.treeAndButtons.treeFsm);
						 /***********---------------------------------------------------------*********/
						 myFrame.display.remouveInfo();
							myFrame.display.myFinalInfoPanel.revalidate();
					 	    myFrame.display.myFinalInfoPanel.repaint(); 
						   myFrame.etudiantInfo = null;
						   /***********---------------------------------------------------------*********/
					 System.out.println("Ouvrire"); 
					 }else if (itemName.equals("Enregistré")) {
						if(myFrame.ouv) { System.out.println("Enregistré");
						 Methodes.sauvegarder(myFrame.treeAndButtons.treeFsm);
						// myFrame.ouv = false ;
						 if(Methodes.toutEtudiant != null) {File f = new File("C:/Java/projects/fsm.txt");
						 f.delete(); 
						  
						 
						 for (int i = 0; i < Methodes.toutEtudiant.size(); i++) { 
							  
							Etudiant.ajouterEtudiant(Methodes.toutEtudiant.get(i));
													}
						 
						 Methodes.toutEtudiant = null; }} 
						  
										    
					}else if (itemName.equals("Quitter")) {  
						 System.out.println("Quitter"); 
						 System.exit(0);  
					}   
				      
					 else { 
						
						System.out.println("Quitter");   
					} }   
					 };  
					   
					
			 		 
					 
					 myFrame.display.btnModifier.addActionListener((ActionListener) new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 if ( myFrame.etudiantInfo !=null) {
								if(myFrame.etudiantInfo.getEmail() != null ) {
									 myFrame.modifierDialog = new ModifierEtudiantDialog(myFrame,myFrame. etudiantInfo,myFrame.treeAndButtons.treeFsm);
						 			 if(myFrame.modifierDialog.nouvelInfo != null) {myFrame.display.myFinalInfoPanel.removeAll();
									 myFrame.display.affichage( myFrame.modifierDialog.nouvelInfo);
									 myFrame.display.myFinalInfoPanel.revalidate();
							 	     myFrame.display.myFinalInfoPanel.repaint(); 
							 	    myFrame.etudiantInfo= myFrame.modifierDialog.nouvelInfo;}
								}
								 
							 } else {
								 System.out.println("Accune Action"); 
							 }
						 }    
						  });    
					 myFrame.display.btnSupprimer.addActionListener((ActionListener) new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							  if ( myFrame.etudiantInfo !=null) {
								  if(myFrame.etudiantInfo.getEmail() != null ) { 
							 int result = JOptionPane.showConfirmDialog(myFrame," Tu veux supprimer cet etudiant ? ",
									 "* Suppression Etudiant *",
									 
									 JOptionPane.YES_NO_OPTION); 
									 if (result == 0) {Methodes.supprimerNode(myFrame.etudiantInfo, myFrame.treeAndButtons.treeFsm);
									 //myFrame.gestionExamens.supprimerNotes(myFrame.etudiantInfo.getEmail());
								myFrame.display.remouveInfo();
								myFrame.display.myFinalInfoPanel.revalidate();
						 	    myFrame.display.myFinalInfoPanel.repaint(); 
							   myFrame.etudiantInfo = null ;} 
								  else { 
									  System.out.println("Accune Action");
										 myFrame.modifierDialog.dispose();
									 } }
						 	     
							 } else { 
								 System.out.println("Accune Action");
							 }
									}   
						  });
		 					 
					  
					 myFrame.authentification.btnOk.addActionListener((ActionListener) new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 if (myFrame.authentification.authentif(myFrame.authentification.email.getText(), myFrame.authentification.motPass.getText()) == true ) {
								 myFrame.authentification.errorLabel.setText("");
								 myFrame.auth = true ;
								 System.out.println("Authentification avec succees");
								  
						 	 	   
								  
						 		  myFrame.panelAll.removeAll();
						 		  
						 		  
						 		 myFrame.authentification.jDAuth.dispose();
						 		 
						 		 
						 		 //myFrame.panelAll = new JPanel(new BorderLayout());  
								    myFrame.treeAndButtons.treeFsm.addTreeSelectionListener(arbreListener);
									myFrame.panelTreeButtonsInfo.add(myFrame.treeAndButtons.getTreeAndButtons()); 
									myFrame.panelTreeButtonsInfo.add(myFrame.display.affichage(myFrame.etudiantInfo )); 
									myFrame.panelAll.add(myFrame.formulaire.jpFormulaire(), BorderLayout.NORTH); 
									myFrame.panelAll.add(myFrame.panelTreeButtonsInfo, BorderLayout.CENTER);
									myFrame. tabbedPane.add("Etudiants",myFrame. panelAll);
									myFrame. tabbedPane.add("Notes",myFrame. myJpTabNotes.constructJpTabNotes()); 
									myFrame.add(myFrame.tabbedPane);
									myFrame.setJMenuBar(myFrame.menuBar.getMyMenuBar());
								// SwingUtilities.updateComponentTreeUI(myFrame);
									   
								 
								 myFrame.invalidate(); 
								 myFrame.validate();
								 myFrame.repaint();
									
								 
								 myFrame.pack();
									myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			 						myFrame.setVisible(true);
								   
		 						   
								 
							 }else {
								 myFrame.authentification.errorLabel.setText("Echéc : verifier votre cordonneés"); 
								 System.out.println("Authentification echoué");
								 myFrame.auth = false ;
							 }
							 
							  
									}   
						  });
							   
					 myFrame.authentification.btnAnnuler.addActionListener((ActionListener) new ActionListener() { 
						 public void actionPerformed(ActionEvent e) {
							 System.exit(0);  
									}   
						  });
					 	    
			  
				 	      
					  
					 myFrame. authentification.authDialog(myFrame);
						//myFrame.panelAll.add( myFrame. authentification.authPanel() ,BorderLayout.NORTH);
						
						
						/*myFrame.add(myFrame.panelAll); 
						  myFrame.pack();
							myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
							myFrame.setVisible(true); */
						
				 
						 
					 
		 
		
		
		
		
          
		             
	}  
    
}   


  