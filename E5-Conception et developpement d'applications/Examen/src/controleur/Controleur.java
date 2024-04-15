package controleur;

import java.util.ArrayList;

import modele.Modele;

public class Controleur {
	public static User selectWhereUSer (String email, String mdp) {
		//tester email et la complexité mdp.
		return Modele.selectWhereUser(email, mdp);
	}
	
	/*********************gestion des clients ***************/
	public static void insertClient (Client unClient) {
		Modele.insertClient(unClient);
	}
	
	public static void deleteClient (int numClient) {
		Modele.deleteClient(numClient);
	}
	
	public static void updateClient (Client unClient) {
		Modele.updateClient(unClient);
	}
	
	public static ArrayList<Client> selectAllClients (String filtre) {
		return Modele.selectAllClients(filtre);
	}
	
	public static Client selectWhereClient (int numClient) {
		return Modele.selectWhereClient(numClient);
	}

	public static void updateUser(User unUser) {
		Modele.updateUser(unUser);
		
	}
	
	public static Client selectWhereClient (String nom, String email) {
		return Modele.selectWhereClient(nom, email);
	} 
	
	
	
	/***************GESTION DES CONTRATS ************************/
	public static void insertContrat(Contrat unContrat) {
		Modele.insertContrat(unContrat);
	}
	public static void deleteContrat(int numContrat) {
		Modele.deleteContrat(numContrat);
	}
	public static void updateContrat(Contrat unContrat) {
		Modele.updateContrat(unContrat);
	}

	public static ArrayList<Contrat> selectAllContrats( String filtre) {
		return Modele.selectAllContrats(filtre);
	}
	public static Contrat selectWhereContrat(int numContrat) {
		return Modele.selectWhereContrat(numContrat);
	}


	public static Contrat selectWhereContrat (String datefin, String datev, Float montantmht) {
		return Modele.selectWhereContrat(datefin, datev, montantmht);
	 }

	
	
	/*******GESTION DES TECHNICIENS **********/
    public static void insertTechnicien (Technicien unTechnicien) {
        Modele.insertTechnicien(unTechnicien);
    }

    public static void deleteTechnicien (int matricule) {
        Modele.deleteTechnicien(matricule);
    }

    public static void updateTechnicien (Technicien unTechnicien) {
        Modele.updateTechnicien(unTechnicien);
    }

    public static ArrayList<Technicien> selectAllTechniciens (String filtre) {
        return Modele.selectAllTechniciens(filtre);
    }

    public static Technicien selectWhereTechnicien (int matricule) {
        return Modele.selectWhereTechnicien(matricule);
    }


    public static Technicien selectWhereTechnicien (String nomT, String prenomT) {
        return Modele.selectWhereTechnicien(nomT, prenomT);
    }
	
	
	
	
	/************gestion des interventions ***********/
	 
	public static void insertIntervention( Intervention uneIntervention) {
		Modele.insertIntervention(uneIntervention);
	}
	public static void deleteIntervention(int numI) {
		Modele.deleteIntervention(numI);
	}
	public static void updateIntervention(Intervention uneIntervention) {
		Modele.updateIntervention(uneIntervention);
	}
	 
	public static ArrayList<Intervention> selectAllInterventions( String filtre) {
		return Modele.selectAllInterventions(filtre);
	}
	public static Intervention selectWhereIntervention(int numI) {
		return Modele.selectWhereIntervention(numI);
	}
	 
	 
	public static Intervention selectWhereIntervention (String dateAffectation,String dateArrive, String dateFin, String etat, String libelleMateriel) {
		return Modele.selectWhereIntervention (dateAffectation, dateArrive ,dateFin,etat,libelleMateriel);
	}
	

	}


