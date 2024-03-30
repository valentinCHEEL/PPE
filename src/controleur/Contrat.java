package controleur;
 
public class Contrat {
	private int numcontrat, numclient;
	private String datefin, datev, montantmht;
	public Contrat(int numcontrat, String datefin, String datev, String montantmht,
			int numclient) {
		this.numcontrat = numcontrat;
		this.datefin = datefin;
		this.datev = datev;
		this.montantmht = montantmht;
		this.numclient = numclient;
	}
	
	public Contrat (String datefin, String datev, String montantmht,
			int numclient) {
		this.numcontrat = 0;
		this.datefin = datefin;
		this.datev = datev;
		this.montantmht = montantmht;
		this.numclient = numclient;
	}
 
	public int getNumcontrat() {
		return numcontrat;
	}
 
	public void setNumcontrat(int numcontrat) {
		this.numcontrat = numcontrat;
	}
 
	public String getDatefin() {
		return datefin;
	}
 
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
 
	public String getDatev() {
		return datev;
	}
 
	public void setDatev(String datev) {
		this.datev = datev;
	}
 
	public String getMontantmht() {
		return montantmht;
	}
 
	public void setMontantmht(String montantmht) {
		this.montantmht = montantmht;
	}
 
 
	public int getNumclient() {
		return numclient;
	}
 
	public void setNumclient(int numclient) {
		this.numclient = numclient;
	}
	
	
}