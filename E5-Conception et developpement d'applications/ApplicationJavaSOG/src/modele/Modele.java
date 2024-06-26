package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controleur.Client;
import controleur.Contrat;
import controleur.Intervention;
import controleur.Technicien;
import controleur.User;

public class Modele {
	private static Bdd uneBdd = new Bdd("localhost", "sog", "root", "");
	public static User selectWhereUser (String email, String mdp) {
		String requete = "select * from user where email ='"+email+"' and "
				+ "mdp = '"+mdp+"'; ";
		User unUser = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unUser = new User (
						unRes.getInt("iduser"), unRes.getString("nom"), 
						unRes.getString("prenom"), unRes.getString("email"),
						unRes.getString("mdp"), unRes.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+ requete);
			
		}
		return unUser;
	}
	
/***********************GESTION DES Clients *******************/
	public static void insertClient(Client unClient) {
	    String requete = "INSERT INTO client (nomclient, adresse, ville, codepostal, numtel, adressemail, typeclient, siret) VALUES ('"
	                    + unClient.getNomclient() + "', '"
	                    + unClient.getAdresse() + "', '"
	                    + unClient.getVille() + "', '"
	                    + unClient.getCodepostal() + "', '"
	                    + unClient.getNumtel() + "', '"
	                    + unClient.getAdressemail() + "', '"
	                    + unClient.getTypeclient() + "', '"
	                    + unClient.getSiret() + "');";
	    System.out.println(requete);
	    try {
	        uneBdd.seConnecter();
	        Statement unStat = uneBdd.getMaconnexion().createStatement();
	        unStat.execute(requete);
	        unStat.close();
	        uneBdd.seDeConnecter();
	    } catch (SQLException exp) {
	        System.out.println("Erreur de requete : " + requete);
	    }
	}

public static void deleteClient (int numClient) {
	String requete ="delete from client where numclient ="+numClient+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch(SQLException exp) {
	System.out.println("Erreur de requete : "+ requete);
	}
}

public static void updateClient(Client unClient) {
    String requete = "UPDATE client SET nomclient = '"
                    +unClient.getNomclient() + "', adresse='"
                    +unClient.getAdresse() + "', ville='"
                    +unClient.getVille() + "', codepostal='"
                    +unClient.getCodepostal() + "', numtel='"
                    +unClient.getNumtel() + "', adressemail='"
                    +unClient.getAdressemail() + "', typeclient='"
                    +unClient.getTypeclient() + "', siret='"
                    +unClient.getSiret() + "' WHERE numClient = "
                    +unClient.getNumclient() + ";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        unStat.execute(requete);
        unStat.close();
        uneBdd.seDeConnecter();
    } catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}


public static ArrayList<Client> selectAllClients (String filtre){
	ArrayList<Client> lesClients = new ArrayList<Client>();
	String requete = "";
	if (filtre.contentEquals("")) {
		requete = "select * from client; ";
	} else {
		requete = "select * from client where nomclient like '%" + filtre
		+ "%' or adresse like '%" +filtre
		+ "%' or ville like '%" +filtre
		+ "%' or codepostal like '%" +filtre
		+ "%' or numtel like '%" +filtre
		+ "%' or adressemail like '%" +filtre
		+ "%' or typeclient like '%" +filtre
		+ "%' or siret like '%" +filtre + "%' ;";
	}
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		while (desRes.next()) {
			Client unClient = new Client (desRes.getInt("numClient"),
					desRes.getString("nomClient"), desRes.getString("adresse"),
					desRes.getString("ville"), desRes.getString("codePostal"),
					desRes.getString("numTel"), desRes.getString("adressemail"), 
					desRes.getString("typeClient"),desRes.getString("siret"));
			lesClients.add(unClient);
		}
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : "+ requete);
		exp.printStackTrace();
	}
	
	return lesClients;
}


public static Client selectWhereClient (int numClient) {
	Client unClient = null;
	String requete = "select * from client where numclient = "+numClient+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		if (desRes.next()) {
			unClient = new Client(desRes.getInt("numClient"),
					desRes.getString("nomclient"),
					desRes.getString("adresse"), 
					desRes.getString("ville"),
					desRes.getString("codepostal"),
					desRes.getString("numtel"),
					desRes.getString("adressemail"),
					desRes.getString("typeclient"),
					desRes.getString("siret"));
		}
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : "+ requete);
		
	}
	
	return unClient;
}

public static Client selectWhereClient (String nomclient, String adressemail) {
	Client unClient = null;
	String requete = "select * from client where nomclient = '" +nomclient+ "' and adressemail = '" +adressemail+"';";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		if (desRes.next()) {
			unClient = new Client(desRes.getInt("numClient"),
					desRes.getString("nomclient"),
					desRes.getString("adresse"), 
					desRes.getString("ville"),
					desRes.getString("codepostal"),
					desRes.getString("numtel"),
					desRes.getString("adressemail"),
					desRes.getString("typeclient"),
					desRes.getString("siret"));
		}
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : "+ requete);
		
	}
	
	return unClient;
}

/******** Gestion user ****/

public static void updateUser(User unUser) {
	String requete = "update user set nom = '"
			+unUser.getNom()+"' , prenom = '"
			+unUser.getPrenom()+ "' , email = '"
			+unUser.getEmail()+ "' , mdp='"
			+unUser.getMdp()+ "' , role='"
			+unUser.getRole()+ "' where iduser ="
			+unUser.getIduser()+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : "+ requete);
		
	}
	
	
}

/**********************GESTION DES CONTRATS********/
public static void insertContrat (Contrat unContrat) {
    String requete ="insert into contrat values (null, '"
            +unContrat.getDatefin()+"','"
            +unContrat.getDatev()+"','"
            +unContrat.getMontantmht()+"','"
            +unContrat.getNumclient()+"');";
   System.out.println(requete);
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        unStat.execute(requete);
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}

public static void deleteContrat (int numContrat) {
    String requete ="delete from contrat where numcontrat = "+numContrat+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        unStat.execute(requete);
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}
public static void updateContrat(Contrat unContrat) {
    String requete ="update contrat set datefin='" 
            +unContrat.getDatefin()+"', datev ='"
            +unContrat.getDatev()+"', montantmht ='"
            +unContrat.getMontantmht()+"', numclient ='"
            +unContrat.getNumclient()+"' where numcontrat = "
            +unContrat.getNumcontrat()+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        unStat.execute(requete);
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}
public static ArrayList<Contrat> selectAllContrats (String filtre){
    ArrayList<Contrat> lesContrats = new  ArrayList<Contrat>(); 
    String requete ="" ; 
    if (filtre.contentEquals("")) {
        requete = "select * from  contrat ; ";
    }else {
        requete = "select * from  contrat where datefin like '%" + filtre 
                + "%'  or  datev like '%"+filtre
                + "%'  or  montantmht like '%"+filtre+ "%'";
                
    }
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        while (desRes.next()) {
        	Contrat unContrat = new Contrat(desRes.getInt("numcontrat"),
                    desRes.getString("datefin"), 
                    desRes.getString("datev"),desRes.getFloat("montantmht"),
                    desRes.getInt("numclient"));
                    
            lesContrats.add(unContrat);
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return lesContrats; 
}
public static Contrat selectWhereContrat (int numContrat) {
	Contrat unContrat = null; 
    String requete = "select * from contrat where numcontrat = " +numContrat+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            unContrat = new Contrat(desRes.getInt("numcontrat"),
                    desRes.getString("datefin"), 
                    desRes.getString("datev"),desRes.getFloat("montantmht"),
                    desRes.getInt("numclient"));
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return unContrat; 
}
public static Contrat selectWhereContrat (String datefin,String datev, Float montantmht) {
	Contrat unContrat = null; 
    String requete = "select * from contrat where datefin='"+datefin+"' and datev='"+datev+"' and montantmht='"+montantmht+ "';";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            unContrat = new Contrat(desRes.getInt("numcontrat"),
                    desRes.getString("datefin"), 
                    desRes.getString("datev"),desRes.getFloat("montantmht"),
                    desRes.getInt("numclient"));
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return unContrat; 
}




/**********************GESTION DES TECHNICIENS ********/
public static void insertTechnicien (Technicien unTechnicien) {
	String requete ="insert into technicien values (null, '"
	+unTechnicien.getNomT()+"','"
	+unTechnicien.getPrenomT()+"','"
    +unTechnicien.getDisponibilite()+"','"
    +unTechnicien.getTarifHoraire()+"');";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		unStat.execute(requete);
       unStat.close();
		
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
	
}
 
public static void deleteTechnicien(int matricule) {
	String requete ="delete from technicien where matricule ="+matricule+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		unStat.execute(requete);
       unStat.close();
		
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
}


 
public static void updateTechnicien(Technicien unTechnicien) {
	String requete = "update technicien set nomT='"
			+unTechnicien.getNomT()+"', prenomT ='"
			+unTechnicien.getPrenomT()+"', disponibilite ='"
			+unTechnicien.getDisponibilite()+"', tarifHoraire ='"
			+unTechnicien.getTarifHoraire()+"' where matricule ="
			+unTechnicien.getMatricule()+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		unStat.execute(requete);
        unStat.close();
		
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
  }
public static ArrayList<Technicien> selectAllTechniciens (String filtre){
	ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
	String requete ="";
	if (filtre.contentEquals("")) {
		requete = "select * from technicien ; ";	
	}else {
		requete = "select * from technicien where nom like '%" +filtre
				+"%' or nomT like '%"+filtre
				+"%' or prenomT like '%"+filtre
				+"%' or disponibilite '%"+filtre
				+"%' or tarifHoraire like '%"+filtre +"%' ;";
	}
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		while (desRes.next()) {
			Technicien unTechnicien = new Technicien(desRes.getInt("matricule"),
					desRes.getString("nomT"),
					desRes.getString("prenomT"),
					desRes.getString("disponibilite"),
					desRes.getFloat("tarifHoraire"));
			lesTechniciens.add(unTechnicien);
		}
        unStat.close();
		
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
	return lesTechniciens;
}
public static Technicien selectWhereTechnicien (int matricule) {
	Technicien unTechnicien = null;
	String requete = "select * from technicien where matricule ="+matricule+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		if (desRes.next()) {
			 unTechnicien = new Technicien(desRes.getInt("matricule"),
					 desRes.getString("nomT"),
						desRes.getString("prenomT"),
						desRes.getString("disponibilite"),desRes.getFloat("tarifHoraire"));
		}
        unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
	return unTechnicien;
}
public static Technicien selectWhereTechnicien (String nomT, String prenomT) {
	Technicien unTechnicien = null;
	String requete = "select * from technicien where nomT ='"+nomT+"'and prenomT ='"+prenomT+"';";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		if (desRes.next()) {
			 unTechnicien = new Technicien(desRes.getInt("matricule"),
					 desRes.getString("nomT"),
						desRes.getString("prenomT"),desRes.getString("disponibilite"),
						desRes.getFloat("tarifHoraire"));
			
		}
        unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
	return unTechnicien;
}


 
/*************** Gestion des Interventions ***************************/

public static void insertIntervention (Intervention uneIntervention) {
    String requete ="insert into intervention values (null, '"
            +uneIntervention.getDateAffectation()+"','"
            +uneIntervention.getDateArrive()+"','"
            +uneIntervention.getDateFin()+"','"
            +uneIntervention.getEtat()+"','"
            +uneIntervention.getLibelleMateriel()+"','"
            +uneIntervention.getMatricule()+"','"
            +uneIntervention.getNumclient()+"');";
            
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        unStat.execute(requete);
        unStat.close();
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}
 
public static void deleteIntervention (int numI ) {
    String requete ="delete from intervention  where numI  = "+numI +";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        unStat.execute(requete);
        unStat.close();
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}
public static void updateIntervention (Intervention  uneIntervention) {
    String requete ="update intervention  set dateAffectation='"
            +uneIntervention.getDateAffectation()+"', dateArrive ='"
            +uneIntervention.getDateArrive()+"', dateFin ='"
            +uneIntervention.getDateFin()+"', etat='"
            +uneIntervention.getEtat()+"', libelleMateriel='"
            +uneIntervention.getLibelleMateriel()+"', matricule ='"
            +uneIntervention.getMatricule()+"', numclient ='"
            +uneIntervention.getNumclient()+"' where numI = "
            +uneIntervention.getNumI()+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        unStat.execute(requete);
        unStat.close();
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
}
public static ArrayList<Intervention> selectAllInterventions (String filtre){
    ArrayList<Intervention> lesInterventions = new  ArrayList<Intervention>();
    String requete ="" ;
    if (filtre.contentEquals("")) {
        requete = "select * from  intervention ; ";
    }else {
        requete = "select * from  Intervention where dateAffectation like '%" + filtre
                + "%'  or  dateArrive like '%"+filtre
                + "%'  or  dateFin like '%"+filtre
                + "%'  or  etat like '%"+filtre
                + "%'  or  libelleMateriel like '%"+filtre+ "%'";
                
    }
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        ResultSet desRes = unStat.executeQuery(requete);
        while (desRes.next()) {
        	Intervention uneIntervention = new Intervention(desRes.getInt("numI"),
                    desRes.getString("dateAffectation"),
                    desRes.getString("dateArrive"),desRes.getString("dateFin"),
                    desRes.getString("etat"),desRes.getString("libelleMateriel"),
                    desRes.getInt("matricule"),desRes.getInt("numclient"));
                    
            lesInterventions.add(uneIntervention);
        }
        unStat.close();
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return lesInterventions;
}
public static Intervention selectWhereIntervention (int numI) {
	Intervention uneIntervention = null;
    String requete = "select * from intervention where numI = " +numI+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            uneIntervention = new Intervention(desRes.getInt("numI"),
            		desRes.getString("dateAffectation"),
                    desRes.getString("dateArrive"),desRes.getString("dateFin"),
                    desRes.getString("etat"),desRes.getString("libelleMateriel"),
                    desRes.getInt("matricule"),desRes.getInt("numclient"));
        }
        unStat.close();
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return uneIntervention;
}
public static Intervention selectWhereIntervention (String dateAffectation,String dateArrive, String dateFin, String etat, String libelleMateriel) {
	Intervention uneIntervention = null;
    String requete = "select * from intervention where dateAffectation='"+dateAffectation+"' and dateArrive='"+dateArrive+"' and dateFin='"+dateFin+ "' and etat='"+etat+"' and libelleMateriel='"+libelleMateriel+ "';";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement();
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            uneIntervention = new Intervention (desRes.getInt("numI"),
            		desRes.getString("dateAffectation"),
                    desRes.getString("dateArrive"),desRes.getString("dateFin"),
                    desRes.getString("etat"),desRes.getString("libelleMateriel"),
                    desRes.getInt("matricule"),desRes.getInt("numclient"));
        }
        unStat.close();
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return uneIntervention;
}
 


}