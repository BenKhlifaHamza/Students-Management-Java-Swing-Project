
public class Notes {
private String nomEtudiant ;
private String emailEtudiant ;
private String securite ;
private String reseaux ; 
private String java ; 
private String php ;
private String android ;
private String sgbd ;
private String math ;
private String francais ; 
private String anglais ;
private String pfe ;

public Notes(String nomEtudiant, String emailEtudiant, String securite, String reseaux, String java, String php,
		String android, String sgbd, String math, String francais, String anglais, String pfe) {
	
	this.nomEtudiant = nomEtudiant;
	this.emailEtudiant = emailEtudiant; 
	this.securite = securite;
	this.reseaux = reseaux;
	this.java = java;
	this.php = php;
	this.android = android; 
	this.sgbd = sgbd;
	this.math = math;
	this.francais = francais; 
	this.anglais = anglais;
	this.pfe = pfe;
}
public String getNomEtudiant() {
	return nomEtudiant;
}
public String getEmailEtudiant() {
	return emailEtudiant;
}
public String getSecurite() {
	return securite;
}
public String getReseaux() {
	return reseaux;
}
public String getJava() {
	return java;
}
public String getPhp() {
	return php;
}
public String getAndroid() {
	return android;
}
public String getSgbd() {
	return sgbd;
}
public String getMath() {
	return math;
}
public String getFrancais() {
	return francais;
}
public String getAnglais() {
	return anglais;
} 
public String getPfe() {
	return pfe;
}

}
  