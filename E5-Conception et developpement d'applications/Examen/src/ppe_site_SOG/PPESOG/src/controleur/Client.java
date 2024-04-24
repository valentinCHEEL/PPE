package controleur;

public class Client {
	private int numclient;
	private String nomclient, adresse, ville, adressemail,password,typeclient;
	int numtel, codepostal, siret;
	
	public Client(int numclient, String nomclient, String adresse, String ville, int codepostal, int numtel, String adressemail, String typeclient, int siret) 
	{
		this.numclient = numclient;
		this.nomclient = nomclient;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
		this.numtel = numtel;
		this.adressemail = adressemail;
		this.password = password;
		this.typeclient = typeclient;
		this.siret = siret;
	}
	
	public Client ( String nomclient, String adresse , String ville, int codepostal, int numtel, String adressemail, String typeclient, int siret) 
	{
		this.numclient = 0;
		this.nomclient = nomclient;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
		this.numtel = numtel;
		this.adressemail = adressemail;
		this.password = password;
		this.typeclient = typeclient;
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

	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public int getNumtel() {
		return numtel;
	}

	public void setNumtem(int numtel) {
		this.numtel = numtel;
	}

	public String getAdressemail() {
		return adressemail;
	}

	public void setAdressemail(String adressemail) {
		this.adressemail = adressemail;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeclient() {
		return typeclient;
	}

	public void setTypeClient(String typeclient) {
		this.typeclient = typeclient;
	}
	public int getSiret() {
		return siret;
	}

	public void setSiret(int siret) {
		this.siret = siret;
	}
	
}