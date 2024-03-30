package controleur;
 
public class Technicien {

 

         private int matricule;
          private String nomT, prenomT, disponibilite ;
          private float tarifHoraire;
        public Technicien(int matricule, String nomT, String prenomT, String disponibilite, float tarifHoraire) {
            super();
            this.matricule = matricule;
            this.nomT = nomT;
            this.prenomT = prenomT;
            this.disponibilite = disponibilite;
            this.tarifHoraire = tarifHoraire;
        }
        public Technicien( String nomT, String prenomT, String disponibilite, float tarifHoraire) {
            super();
            this.matricule = 0;
            this.nomT = nomT;
            this.prenomT = prenomT;
            this.disponibilite = disponibilite;
            this.tarifHoraire = tarifHoraire;
        }
        public int getMatricule() {
            return matricule;
        }
        public void setMatricule(int Matricule) {
            this.matricule = matricule;
        }
        public String getNomT() {
            return nomT;
        }
        public void setNomT(String nomT) {
            this.nomT = nomT;
        }
        public String getPrenomT() {
            return prenomT;
        }
        public void setPrenomT(String prenomT) {
            this.prenomT = prenomT;
        }
        public String getDisponibilite() {
            return disponibilite;
        }
        public void setDisponibilite(String disponibilite) {
            this.disponibilite = disponibilite;
        }
        public float getTarifHoraire() {
            return tarifHoraire;
        }
        public void setTarifHoraire(float tarifHoraire) {
            this.tarifHoraire = tarifHoraire;
        }

    }