 
import java.sql.Connection;
import java.sql.DriverManager ;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 

public class GestionnaireExamens {  
  
 void creerDbEtTable () {
	String MYSQL_SERVER_URL = "jdbc:mysql://localhost:3306/";
	String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty"; 
	String USERNAME = "root";
	String PASSWORD = "";
 	Connection connection = null;    
	java.sql.Statement statement = null;
	
	try {  
	 connection = DriverManager.getConnection(MYSQL_SERVER_URL,USERNAME, PASSWORD);
	 statement = connection.createStatement();
	 
	 statement.executeUpdate("CREATE DATABASE IF NOT EXISTS MyFaculty"); 
	 
	 connection.close();  
	 statement.close() ;  
	 
	 connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	 statement = connection.createStatement(); 
	 
	 String sql = "CREATE TABLE IF NOT EXISTS notes ("
	 		+ "id INT( 10 )NOT NULL PRIMARY KEY AUTO_INCREMENT, "
	 		+ "nom VARCHAR(200) NOT NULL, "
	 		+ "email VARCHAR(200) NOT NULL UNIQUE, securite VARCHAR(200), " 
	 		+ "reseau VARCHAR(200), java VARCHAR(200), "
	 		+ "php VARCHAR(200), android VARCHAR(200), "
	 		+ "sgbd VARCHAR(200), math VARCHAR(200), "
	 		+ "francais VARCHAR(200), anglais VARCHAR(200), "
	 		+ "pfe VARCHAR(200));";
	 statement.executeUpdate(sql);
	 statement.close();} catch (SQLException sqlEx) {
		 sqlEx.printStackTrace();
	 } 
} 

Notes lireNotes (String email)  {
	
	String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty"; 
	String USERNAME = "root";
	String PASSWORD = "";
	Connection connection = null ;
	java.sql.Statement statement = null;
	ResultSet resultSet = null ;
	Notes notes = null; 
	  
     
	try { 
		  connection = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
		  statement = connection.createStatement();
			 
		  String sql = "select * from notes where email = '"+email+"';";	  
		  resultSet = statement.executeQuery(sql);
			
			 while(resultSet.next()) {  
				 notes = new Notes(resultSet.getString("nom"),
						 resultSet.getString("email"),
						 resultSet.getString("securite"),
						 resultSet.getString("reseau"),
						 resultSet.getString("java"),
						 resultSet.getString("php"),
						 resultSet.getString("android"),
						 resultSet.getString("sgbd"),
				 		 resultSet.getString("math"),
						 resultSet.getString("francais"),
						 resultSet.getString("anglais"),
						 resultSet.getString("pfe")); }
				 	   
			 statement.close(); 		  
		} catch (SQLException sqlEx) {
		 System.out.println(sqlEx.getMessage());
		}    
			  
	return notes ;
} 


 
void insererNotes (Notes notes)  {

	String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty";
	String USERNAME = "root";
	String PASSWORD = "";
    java.sql.Statement statement = null;
	
	try {   
		 
		 Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);   
		 statement = connection.createStatement();
 
		 if(lireNotes(notes.getEmailEtudiant()) == null) { 
	 String sqlInsert =  "INSERT INTO notes (nom, email, securite, reseau, java, php, android, sgbd, math, francais, anglais, pfe)" +
	 "VALUES ('" +notes.getNomEtudiant() +"','" +notes.getEmailEtudiant() +"','" +notes.getSecurite() +"','" +notes.getReseaux() +"','" +notes.getJava() +"','" +notes.getPhp() +"','" +notes.getAndroid() +"','" +notes.getSgbd() +"','" +notes.getMath() +"','" +notes.getFrancais() +"','" +notes.getAnglais() +"','" +notes.getPfe() +"');";
	 int rows = statement.executeUpdate(sqlInsert);  
	 if (rows > 0) {  
	System.out.println("Row added successfully"); 
	 }else {System.out.println("Row not added"); }
	 statement.close();   
}else {System.out.println("Ce etudiant est déja noté"); }  
	} catch (Exception e) {
		System.out.println(e.getMessage()); 
	}
	
}

void modifierNotes(Notes notes) {
	String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty";
	String USERNAME = "root";
	String PASSWORD = "";
    java.sql.Statement statement = null;
	
	try {   
		 
		 Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);   
		 statement = connection.createStatement();
 
		 if(lireNotes(notes.getEmailEtudiant()) != null) { 
	 String sqlUpdate =  "UPDATE notes SET "
	 		+ "nom = '" +notes.getNomEtudiant() +"',"
	 		+ "email = '" +notes.getEmailEtudiant() +"', "
	 		+ "securite = '" +notes.getSecurite() +"',"
	 		+ "reseau = '" +notes.getReseaux() +"', "
	 		+ "java = '" +notes.getJava() +"'," 
	 		+ "php = '" +notes.getPhp() +"'," 
	 		+ "android = '" +notes.getAndroid() +"',"
	 		+ "sgbd = '" +notes.getSgbd() +"', "
	 		+ "math = '" +notes.getMath() +"', " 
	 		+ "francais = '" +notes.getFrancais() +"',"
	 		+ "anglais = '" +notes.getAnglais() +"',"
	 		+ "pfe = '" +notes.getPfe() +"' WHERE email = '"+notes.getEmailEtudiant()+"';";
	 			
	 int rows = statement.executeUpdate(sqlUpdate);  
	 if (rows > 0) {   
	System.out.println("Row updatd successfully"); 
	 }else {System.out.println("Row not updated"); }
	 statement.close();   
}else {System.out.println("Ce etudiant nexiste pas"); }  
	} catch (Exception e) {
		System.out.println(e.getMessage()); 
	}
	
	 
}
void supprimerNotes(String email){
	String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty";
	String USERNAME = "root";
	String PASSWORD = "";
    java.sql.Statement statement = null;
    try {   
		 
		 Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);   
		 statement = connection.createStatement();
		 if(lireNotes(email)!=null) {String sqlDelete = "DELETE FROM notes  WHERE email = '"+email+"';";
		 int rows = statement.executeUpdate(sqlDelete);
		 if (rows > 0) {   
				System.out.println("Row deleted successfully"); 
				 }else {System.out.println("Row not deleted"); }
	    statement.close(); }else {
	    	System.out.println("Etudiant nexiste pas");
	    }
		  

	} catch (Exception e) {
		System.out.println(e.getMessage()); 
	}
	
}  
void afficherNotes() {
	String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty"; 
	String USERNAME = "root";
	String PASSWORD = "";
	Connection connection = null ;
	java.sql.Statement statement = null;
	ResultSet resultSet = null ; 
	 
	  
     
	try {  
		  connection = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
		  statement = connection.createStatement();
			 
		  String sql = "select * from notes ;";	   
		  resultSet = statement.executeQuery(sql);
			 
			 while(resultSet.next()) {  
				System.out.println("Nom Etudiant "+resultSet.getString("id")+" : "+resultSet.getString("nom"));
				System.out.println("E-mail         : "+resultSet.getString("email"));
				System.out.println("Securité : "+resultSet.getString("securite"));
				System.out.println("Réseaux  : "+resultSet.getString("reseau"));
				System.out.println("Java     : "+resultSet.getString("java"));
				System.out.println("Php      : "+resultSet.getString("php"));
				System.out.println("Android  : "+resultSet.getString("android"));
				System.out.println("SGBD     : "+resultSet.getString("sgbd"));
				System.out.println("Math     : "+resultSet.getString("math"));
				System.out.println("Francais : "+resultSet.getString("francais"));
				System.out.println("Anglais  : "+resultSet.getString("anglais"));
				System.out.println("Pfe      : "+resultSet.getString("pfe"));
				 
				 }	   
			 statement.close(); 		  
		} catch (SQLException sqlEx) {
		 System.out.println(sqlEx.getMessage());
		}     
			 
	
	 
}


}
