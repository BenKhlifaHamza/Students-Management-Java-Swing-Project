
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
    
public class Methodes {      
	
	static ArrayList<Etudiant> toutEtudiant = null ;
	
	static boolean addNodeToFsm(Etudiant e ,  JTree myTree) {
		boolean succe =true ;
		 DefaultTreeModel myTreeModel = (DefaultTreeModel) myTree.getModel(); 
		 DefaultMutableTreeNode racine = (DefaultMutableTreeNode) myTreeModel.getRoot();
		 DefaultMutableTreeNode nouveauEtudiant =  new DefaultMutableTreeNode(e);
		 DefaultMutableTreeNode nouveauClasse = new DefaultMutableTreeNode(e.getClasse()); 
		 if (!racine.isLeaf()) {    
				boolean classeExist = false ;  
					  for (int i = 0; i < racine.getChildCount(); i++) { 
						 DefaultMutableTreeNode ancienClasse = (DefaultMutableTreeNode) racine.getChildAt(i);
						 if(ancienClasse.toString().equals(nouveauClasse.toString())) {
		 					 classeExist = true ;     
							 boolean etudiantExist = false ; 
							 for (int j = 0 ; j< ancienClasse.getChildCount() ; j++) {					 
		 		               DefaultMutableTreeNode ancienEtudiant =(DefaultMutableTreeNode)ancienClasse.getChildAt(j); 
		 		              Etudiant ancienEtudiantObject = (Etudiant) ancienEtudiant.getUserObject();
		 		             Etudiant nouvelEtudiantObject = (Etudiant) nouveauEtudiant.getUserObject();
				               if(ancienEtudiantObject.getEmail().equals(nouvelEtudiantObject.getEmail())) {etudiantExist = true ;succe = false;}}
						  if (etudiantExist == false) { 
						    ancienClasse.add(nouveauEtudiant);   
							}	} }    
		 	  if(classeExist== false) {   
							 nouveauClasse.add(nouveauEtudiant);   
							 racine.add(nouveauClasse);}
		 	 
				}else { 
					 nouveauClasse.add(nouveauEtudiant);  
					 racine.insert(nouveauClasse, 0);}	
		 
		  
		 myTreeModel.reload();
		 return succe;
		}  
	    
	
	static  void supprimerNode(Etudiant e ,  JTree myTree) {
		
		 DefaultTreeModel myTreeModel = (DefaultTreeModel) myTree.getModel(); 
		 DefaultMutableTreeNode racine = (DefaultMutableTreeNode) myTreeModel.getRoot();
		 DefaultMutableTreeNode nouveauClasse = new DefaultMutableTreeNode(e.getClasse()); 
		    
			int i = 0 ;	 
		 while (i < racine.getChildCount() && !(racine.getChildAt(i).toString().equals(nouveauClasse.toString()))) {
			i++;
		} 
		 DefaultMutableTreeNode classe = (DefaultMutableTreeNode) racine.getChildAt(i);
	if(classe.getChildCount() == 1) {
		racine.remove(i);
		myTreeModel.reload();
	}
	else {
		if(racine.getChildAt(i).toString().equals(nouveauClasse.toString())){
				for (int j = 0; j < classe.getChildCount(); j++) {
				 DefaultMutableTreeNode etudiant = (DefaultMutableTreeNode) classe.getChildAt(j);
				 Etudiant ancienEtudiantObject = (Etudiant) etudiant.getUserObject();
				 if(ancienEtudiantObject.getEmail().equals(e.getEmail())) {
					 classe.remove(j);
					 myTreeModel.reload();} 
				  	} } } }
		 
	
	static  void modifierNode(Etudiant ancien , Etudiant nouv ,  JTree myTree) {
		
		
		if(!(ancien.getClasse().equals(nouv.getClasse()))) {
			supprimerNode(ancien, myTree);
			addNodeToFsm(nouv, myTree);
			
		}else {  
		
		 DefaultTreeModel myTreeModel = (DefaultTreeModel) myTree.getModel(); 
		 DefaultMutableTreeNode racine = (DefaultMutableTreeNode) myTreeModel.getRoot();
		 DefaultMutableTreeNode nouveauClasse = new DefaultMutableTreeNode(ancien.getClasse()); 
		    
			int i = 0 ;	 
		 while (i < racine.getChildCount() && !(racine.getChildAt(i).toString().equals(nouveauClasse.toString()))) {
			i++;
		}  
		 DefaultMutableTreeNode classe = (DefaultMutableTreeNode) racine.getChildAt(i);
 
	
		if(racine.getChildAt(i).toString().equals(nouveauClasse.toString())){
				for (int j = 0; j < classe.getChildCount(); j++) {
				 DefaultMutableTreeNode etudiant = (DefaultMutableTreeNode) classe.getChildAt(j);
				 Etudiant ancienEtudiantObject = (Etudiant) etudiant.getUserObject();
				 if(ancienEtudiantObject.getEmail().equals(ancien.getEmail())) {
					 classe.remove(j);
					 classe.insert(new DefaultMutableTreeNode(nouv), j);
					 myTreeModel.reload();}
				  	} } }}  
	  
	
	
	        
   
public static void initialiserArbre(JTree treeFsm) {
	 DefaultTreeModel myTreeModel = (DefaultTreeModel) treeFsm.getModel();
	 DefaultMutableTreeNode racine = (DefaultMutableTreeNode) myTreeModel.getRoot();
		
	racine.removeAllChildren(); 
		    
		try {
			FileReader fileReader = 
			 new FileReader("C:/Java/projects/fsm.txt"); 
			BufferedReader bufferedReader = 
			 new BufferedReader(fileReader);
			String ligne;
			while ((ligne = bufferedReader.readLine()) != null) {
			 String[] etudiants = ligne.split(":");
			
			 for (int i = 0; i < etudiants.length; i++) {  
				String[] infos  = etudiants[i].split(",");
				 for (int j = 1; j < infos.length; j++) {
				 }
				 
 Etudiant e = new Etudiant( infos[0],infos[1], infos[2], infos[3], infos[4], infos[5], infos[6], infos[7]);Methodes.addNodeToFsm(e, treeFsm); 
			 }
  
			}
			bufferedReader.close();
			fileReader.close();
			 } catch (IOException e) {
			e.printStackTrace();
			 }
	}	 
	 
	 
	
	public static JTable  tableInfo (DefaultMutableTreeNode node) {
		 
		 DefaultMutableTreeNode racine =  new DefaultMutableTreeNode("FSM");
		
		if ( node.toString().equals(racine.toString())){  
			
			 
			String[] columnNames = {"Classe", "Nombre Etudiants"};
			Object[][] tableData = {};
			DefaultTableModel dtm = new DefaultTableModel(tableData, columnNames);
			 
			 
			for (int i = 0; i < node.getChildCount(); i++) { 
				 DefaultMutableTreeNode classe = (DefaultMutableTreeNode) node.getChildAt(i);
				 dtm.addRow((new Object[] {classe.toString(), classe.getChildCount()}));
				 System.out.println(classe);
			}
			JTable table = new JTable(dtm);
			    
			return table;   
			   
			
		}else if (!node.isLeaf() && node.getParent().toString().equals(racine.toString())) {
			
			
			String[] columnNames = {"Prenom", "Nom","Telephone"};
			Object[][] tableData = {};
			DefaultTableModel dtm = new DefaultTableModel(tableData, columnNames);
			
			for (int i = 0; i < node.getChildCount(); i++) { 
				 DefaultMutableTreeNode etudiant = (DefaultMutableTreeNode) node.getChildAt(i);
				 Etudiant info = (Etudiant)etudiant.getUserObject();
				 dtm.addRow((new Object[] {info.getPrenom(), info.getNom(),info.getNumeroPortable()}));
				 System.out.println(etudiant);
				} 
			JTable table = new JTable(dtm); 
			
			return table ; 
		}   
		else { 

			return null; 
		}   
	 
	} 
	
	
	public static void sauvegarder(JTree myTree) {
		
		
		 DefaultTreeModel myTreeModel = (DefaultTreeModel) myTree.getModel(); 
		 DefaultMutableTreeNode racine = (DefaultMutableTreeNode) myTreeModel.getRoot();
		 
		 if(racine.getChildCount()>0) {
			 toutEtudiant = new ArrayList<Etudiant>();
			 for (int i = 0 ; i< racine.getChildCount(); i++) {
			  
			 DefaultMutableTreeNode classe = (DefaultMutableTreeNode) racine.getChildAt(i);
			 
			   for (int j = 0 ; j < classe.getChildCount() ; j++) {
				   DefaultMutableTreeNode etudiant = (DefaultMutableTreeNode) classe.getChildAt(j);
					 Etudiant ancienEtudiantObject = (Etudiant) etudiant.getUserObject();
				 toutEtudiant.add(ancienEtudiantObject);
			   }
			  
			   
		 } }
		
	}
	

		  
} 



