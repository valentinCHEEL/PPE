package controleur;
 
public class Intervention {
		private int numI;
		  private String dateAffectation, dateArrive, dateFin, etat, libelleMateriel ;
		  private int matricule, numclient;
		public Intervention(int numI, String dateAffectation, String dateArrive, String dateFin, String etat, String libelleMateriel,
				int matricule, int numclient) {
			super();
			this.numI = numI;
			this.dateAffectation = dateAffectation;
			this.dateArrive = dateArrive;
			this.dateFin = dateFin;
			this.etat = etat;
			this.libelleMateriel = libelleMateriel;
			this.matricule = matricule;
			this.numclient = numclient;
		}
		  
		public Intervention(  String dateAffectation, String dateArrive, String dateFin, String etat, String libelleMateriel, int matricule, int numclient) {
			super();
			this.numI = 0;
			this.dateAffectation = dateAffectation;
			this.dateArrive = dateArrive;
			this.dateFin = dateFin;
			this.etat = etat;
			this.libelleMateriel = libelleMateriel;
			this.matricule = matricule;
			this.numclient = numclient;
		}
		
		
		public int getNumI() {
			return numI;
		}

		public void setNumI(int numI) {
			this.numI = numI;
		}

		public String getDateAffectation() {
			return dateAffectation;
		}

		public void setDateAffectation(String dateAffectation) {
			this.dateAffectation = dateAffectation;
		}

		public String getDateArrive() {
			return dateArrive;
		}

		public void setDateArrive(String dateArrive) {
			this.dateArrive = dateArrive;
		}

		public String getDateFin() {
			return dateFin;
		}

		public void setDateFin(String dateFin) {
			this.dateFin = dateFin;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
			this.etat = etat;
		}

		public String getLibelleMateriel() {
			return libelleMateriel;
		}

		public void setLibelleMateriel(String libelleMateriel) {
			this.libelleMateriel = libelleMateriel;
		}

		public int getMatricule() {
			return matricule;
		}

		public void setMatricule(int matricule) {
			this.matricule = matricule;
		}

		public int getNumclient() {
			return numclient;
		}

		public void setNumclient(int numclient) {
			this.numclient = numclient;
		}
 

 
	}
