import java.awt.GridLayout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Authentification {
	JPanel myAuthPanel = new JPanel (new GridLayout(0,1));
	JTextField email = new JTextField();  
	JPasswordField motPass = new JPasswordField();
	JLabel emailLabel = new JLabel("E-Mail : *");
	JLabel motPassLabel = new JLabel("Mot de Passe : *"); 
	JLabel errorLabel = new JLabel();
	JButton btnOk = new JButton("OK") ;
	JButton btnAnnuler = new JButton("Annuler") ;  
	JDialog jDAuth ;
	 
	
	JDialog authDialog(JFrame parent) {
		
		
		jDAuth = new JDialog(parent);
		myAuthPanel.add(emailLabel);
		myAuthPanel.add(email);
		myAuthPanel.add(motPassLabel); 
		myAuthPanel.add(motPass);
		myAuthPanel.add(errorLabel);
		myAuthPanel.add(btnOk);
		myAuthPanel.add(btnAnnuler); 
		
		
		jDAuth.setContentPane(myAuthPanel);
		 
		jDAuth. pack(); 
		jDAuth. setModal(true);
		jDAuth.setLocationRelativeTo(parent);
		jDAuth.setDefaultCloseOperation(jDAuth.DISPOSE_ON_CLOSE);
		jDAuth. setVisible(true); 
		 
	return jDAuth;
	} 
	 
	
	
	Boolean authentif (String email , String password)  {
		
		boolean existe = false ;
		String DB_URL = "jdbc:mysql://localhost:3306/MyFaculty"; 
		String USERNAME = "root";
		String PASSWORD = "";
		Connection connection = null ;
		java.sql.Statement statement = null;
		ResultSet resultSet = null ;
				  
	     
		try { 
			  connection = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
			  statement = connection.createStatement();
				 
			  String sql = "select * from users where email = '"+email+"' AND password = '"+password+"' ;";	   
			  resultSet = statement.executeQuery(sql);
				
				 if(resultSet.next()) {  
				 statement.close(); 
				 existe = true ;		  
			}else {
				existe = false ;	
			}
			}
			 catch (SQLException sqlEx) {
			 System.out.println(sqlEx.getMessage());
			}
		return existe;    
		} 
	  
	
	 

/*	public static void main(String[] args) {
		Authentification a = new Authentification();
		JFrame	myFrame = new JFrame();
		
		
		
		a.btnOk.addActionListener((ActionListener) new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (a.authentif(a.email.getText(), a.motPass.getText()) == true ) {
					 System.out.println("Authentification avec succees");
				 }else {
					 a.errorLabel.setText("Echéc : verifier votre cordonneés"); 
					 System.out.println("Authentification echoué");
				 }
						}   
			  });
		

		myFrame.add(a.authPanel());
		
		//System.out.println(a.authentif("admin@gmail.com", "admin"));
		
		 myFrame.pack();
			myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			myFrame.setVisible(true);  
	}*/

}
