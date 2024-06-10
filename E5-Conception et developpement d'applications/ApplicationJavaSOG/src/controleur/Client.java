package controleur;

public class Client {
	private int numclient;
	private String nomclient, adresse, ville, codepostal, numtel, adressemail, passwordc, typeclient, siret;
	
	
	public Client(int numclient, String nomclient, String adresse, String ville, String codepostal, String numtel, String adressemail, String typeclient, String siret) 
	{
		this.numclient = numclient;
		this.nomclient = nomclient;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
		this.numtel = numtel;
		this.adressemail = adressemail;
		this.passwordc = passwordc;
		this.typeclient = typeclient;
		this.siret = siret;
	}
	
	public Client ( String nomclient, String adresse , String ville, String codepostal, String numtel, String adressemail, String typeclient, String siret) 
	{
		this.numclient = 0;
		this.nomclient = nomclient;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
		this.numtel = numtel;
		this.adressemail = adressemail;
		this.passwordc = passwordc;
		this.typeclient = typeclient;
		this.siret = siret;
	}

	public int getNumclient() {
		return numclient;
	}

	public void setNumclient(int numclient) {
		this.numclient = numclient;
	}

	public String getNomclient() {
		return nomclient;
	}

	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	public String getAdressemail() {
		return adressemail;
	}

	public void setAdressemail(String adressemail) {
		this.adressemail = adressemail;
	}

	public String getPasswordc() {
		return passwordc;
	}

	public void setPasswordc(String passwordc) {
		this.passwordc = passwordc;
	}

	public String getTypeclient() {
		return typeclient;
	}

	public void setTypeclient(String typeclient) {
		this.typeclient = typeclient;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	
	
}