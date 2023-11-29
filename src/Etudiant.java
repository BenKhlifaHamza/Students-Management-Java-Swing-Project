
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Etudiant { 
	 
	private String nom ,prenom ,  email , adresse , numeroPortable , numeroFix , classe , niveau ;
	
	public Etudiant ( String prenom ,String nom , String email , String adresse , String numeroPortable , String numeroFix , String classe , String niveau ) {
		this.prenom = prenom ;
		this.nom = nom ;
		this.email = email ;
		this.adresse = adresse ;
		this.numeroPortable = numeroPortable ;
		this.numeroFix = numeroFix ;
		this.classe = classe ; 
		this.niveau = niveau ;	
		  
	}
	public Etudiant() {} 
	   
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom; 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	} 
 
	public void setAdresse(String adresse) { 
		this.adresse = adresse;
	}

	public String getNumeroPortable() {
		return numeroPortable;
	}

	public void setNumeroPortable(String numeroPortable) {
		this.numeroPortable = numeroPortable;
	}

	public String getNumeroFix() {
		return numeroFix;
	}

	public void setNumeroFix(String numeroFix) {
		this.numeroFix = numeroFix; 
	} 
 
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	} 

	public String getNiveau() {  
		return niveau;  
	}  

	public void setNiveau(String niveau) {
		this.niveau = niveau;  
	}
  
	public String toString () { 
		return prenom ;   
	} 
	

	 
public static void	ajouterEtudiant (Etudiant etudiant) {
	try {
		
		FileWriter fileWriter =  new FileWriter("C:/Java/projects/fsm.txt" , true);
		
		String ligne = etudiant.getPrenom() + "," + etudiant.getNom() + "," + etudiant.getEmail() + "," + etudiant.getAdresse() + "," +
		 etudiant.getNumeroPortable() + "," + etudiant.getNumeroFix() + "," + etudiant.getClasse() + "," + etudiant.getNiveau() +":"  ;
        fileWriter.write(ligne);
		fileWriter.close();
		 } catch (IOException e) { 
		e.printStackTrace();  
		 }  

}

public void updateLine(String toUpdate, String updated) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader("C:/Java/projects/fsm.txt"));
    PrintWriter writer = new PrintWriter(new File("C:/Java/projects/fsm.txt"));
    String line;

    while ((line = file.readLine()) != null)
    {
        line = line.replace(toUpdate, updated);
        writer.println(line);
    }
    file.close();
    if (writer.checkError())
        throw new IOException("cannot write");
    writer.close();
}

}
