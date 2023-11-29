import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

@SuppressWarnings("serial")
public class ModifierEtudiantDialog extends JDialog {

	private JTextField tfPren = new JTextField();
	private JTextField tfName = new JTextField();
	private JTextField tfMail = new JTextField();
	private JTextField tfAdr = new JTextField();
	private JTextField tfTel = new JTextField();
	private JTextField tfFix = new JTextField();
	private JTextField tfClas = new JTextField(); 
	private JTextField tfNiv = new JTextField();  
	

	 JButton btnOk = new JButton("OK"); 
	 JButton btnCancel = new JButton("Cancel"); 
	 Etudiant nouv ; 
	public Etudiant nouvelInfo ; 
 	 
	   
	public ModifierEtudiantDialog(JFrame parent, Etudiant ancienInfo , JTree tree){
		super(parent); 
		 setTitle("Modifier Etudiant"); 
		 
		 tfPren.setText(ancienInfo.getPrenom());
		 tfName.setText(ancienInfo.getNom()); 
		 tfMail.setText(ancienInfo.getEmail());
		 tfAdr.setText(ancienInfo.getAdresse());
		 tfTel.setText(ancienInfo.getNumeroPortable()); 
		 tfFix.setText(ancienInfo.getNumeroFix());
		 tfClas.setText(ancienInfo.getClasse());
		 tfNiv.setText(ancienInfo.getNiveau()); 
		 
		 JPanel modifierEtudiant = new JPanel(new GridLayout(0, 2, 5, 5));
		 modifierEtudiant.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		 modifierEtudiant.add(new JLabel("Prenom   :"));
		 modifierEtudiant.add(tfPren); 
		 modifierEtudiant.add(new JLabel("Nom      :")); 
		 modifierEtudiant.add(tfName);
		 modifierEtudiant.add(new JLabel("E-mail   :"));
		 modifierEtudiant.add(tfMail); 
		 modifierEtudiant.add(new JLabel("Adresse  :"));
		 modifierEtudiant.add(tfAdr); 
		 modifierEtudiant.add(new JLabel("Portable :"));
		 modifierEtudiant.add(tfTel); 
		 modifierEtudiant.add(new JLabel("Fix      :"));
		 modifierEtudiant.add(tfFix); 
		 modifierEtudiant.add(new JLabel("Classe   :")); 
		 modifierEtudiant.add(tfClas); 
		 modifierEtudiant.add(new JLabel("Niveau   :")); 
		 modifierEtudiant.add(tfNiv); 
		 modifierEtudiant.add(btnOk);  
		 modifierEtudiant.add(btnCancel);
		 
		 
		 btnOk.addActionListener((ActionListener) new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 nouvelInfo = new Etudiant(tfPren.getText(), tfName.getText(), tfMail.getText() , tfAdr.getText(), tfTel.getText(), tfFix.getText(), tfClas.getText(), tfNiv.getText());
			Methodes.modifierNode(ancienInfo, nouvelInfo, tree); 
			dispose();  
			 }   
			  });
		
			  
			  btnCancel.addActionListener((ActionListener) new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
												 dispose();
					
					 }  
					  });
		 
		 setContentPane(modifierEtudiant);
 
		 pack(); 
		 setModal(true);
		 setLocationRelativeTo(parent);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setVisible(true);  
		}

}
