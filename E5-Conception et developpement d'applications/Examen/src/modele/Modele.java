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
	private static Bdd uneBdd = new Bdd("localhost", "sitesog", "root", "");
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
			Client unClient = new Client (desRes.getInt("numclient"),
					desRes.getString("nomclient"), desRes.getString("adresse"),
					desRes.getString("ville"), desRes.getInt("codepostal"),
					desRes.getInt("numtel"), desRes.getString("adressemail"), 
					desRes.getString("typeclient"),desRes.getInt("siret"));
			lesClients.add(unClient);
		}
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : "+ requete);
		
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
					desRes.getInt("codepostal"),
					desRes.getInt("numtel"),
					desRes.getString("adressemail"),
					desRes.getString("typeclient"),
					desRes.getInt("siret"));
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
					desRes.getInt("codepostal"),
					desRes.getInt("numtel"),
					desRes.getString("adressemail"),
					desRes.getString("typeclient"),
					desRes.getInt("siret"));
		}
		unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : "+ requete);
		
	}
	
	return unClient;
}

public static void updateUser(User unUser) {
	String requete = "update user set nom '"
			+unUser.getNom()+"' , prenom = "
			+unUser.getPrenom()+ "' , email = '"
			+unUser.getEmail()+ "' , role='"
			+unUser.getRole()+ "' , mdp='"
			+unUser.getMdp()+ "' where iduser ="
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
/*************** Gestion des entreprises **************************
public static void insertEntreprise (Entreprise uneEntreprise) {
    String requete ="insert into entreprise values (null, '"
            +uneEntreprise.getNom()+"','"
            +uneEntreprise.getNum_Siret()+"','"
            +uneEntreprise.getAdresse()+"','"
            +uneEntreprise.getVille()+"','"
            +uneEntreprise.getCp()+"','"
            +uneEntreprise.getContact()+"','"
            +uneEntreprise.getIdclient()+"');";
   // System.out.println(requete);
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

public static void deleteEntreprise (int idEntreprise) {
    String requete ="delete from entreprise where identreprise = "+idEntreprise+";";
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
public static void updateEntreprise(Entreprise uneEntreprise) {
    String requete ="update entreprise set nom='" 
            +uneEntreprise.getNom()+"', num_siret ='"
            +uneEntreprise.getNum_Siret()+"', email ='"
            +uneEntreprise.getEmail()+"', adresse ='"
            +uneEntreprise.getAdresse()+"', ville ='"
            +uneEntreprise.getVille()+"', cp ='"
            +uneEntreprise.getCp()+"', contact ='"
             +uneEntreprise.getContact()+"', idclient ='"
            +uneEntreprise.getIdclient()+"' where identreprise = "
            +uneEntreprise.getIdentreprise()+";";
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
public static ArrayList<Entreprise> selectAllEntreprises (String filtre){
    ArrayList<Entreprise> lesEntreprises = new  ArrayList<Entreprise>(); 
    String requete ="" ; 
    if (filtre.contentEquals("")) {
        requete = "select * from  entreprise ; ";
    }else {
        requete = "select * from  entreprise where nom like '%" + filtre 
                + "%'  or  num_siret like '%"+filtre
                + "%'  or  email like '%"+filtre
                + "%'  or  adresse like '%"+filtre
                + "%'  or  ville like '%"+filtre
                + "%'  or  cp like '%"+filtre
                + "%'  or  contact like '%"+filtre+ "%'";
                
    }
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        while (desRes.next()) {
        	Entreprise uneEntreprise = new Entreprise(desRes.getInt("identreprise"),
                    desRes.getString("nom"), 
                    desRes.getString("num_siret"),desRes.getString("email"),
                    desRes.getString("adresse"),desRes.getString("ville"),
                    desRes.getString("cp"),desRes.getString("contact"),
                    desRes.getInt("idclient"));
                    
            lesEntreprises.add(uneEntreprise);
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return lesEntreprises; 
}
public static Entreprise selectWhereEntreprise (int idEntreprise) {
	Entreprise uneEntreprise = null; 
    String requete = "select * from entreprise where identreprise = " +idEntreprise+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            uneEntreprise = new Entreprise(desRes.getInt("identreprise"),
            		 desRes.getString("nom"), 
                     desRes.getString("num_siret"),desRes.getString("email"),
                     desRes.getString("adresse"),desRes.getString("ville"),
                     desRes.getString("cp"),desRes.getString("contact"),
                     desRes.getInt("idclient"));
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return uneEntreprise; 
}
public static Entreprise selectWhereEntreprise (String nom,String email, String adresse) {
	Entreprise uneEntreprise = null; 
    String requete = "select * from entreprise where nom='"+nom+"' and email='"+email+"' and adresse='"+adresse+ "';";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            uneEntreprise = new Entreprise(desRes.getInt("identreprise"),
            		 desRes.getString("nom"), 
                     desRes.getString("num_siret"),desRes.getString("email"),
                     desRes.getString("adresse"),desRes.getString("ville"),
                     desRes.getString("cp"),desRes.getString("contact"),
                     desRes.getInt("idclient"));
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return uneEntreprise; 
}

*/
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
    +unTechnicien.getTarifHoraire()+"','"
    +unTechnicien.getEmail()+"');";
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
			+unTechnicien.getEmail()+"', email ='"
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
				+"%' or tarifHoraire '%"+filtre
				+"%' or email like '%"+filtre +"%' ;";
	}
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaconnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		while (desRes.next()) {
			Technicien unTechnicien = new Technicien(desRes.getInt("matricule"),
					desRes.getString("nomT"),
					desRes.getString("prenomT"),desRes.getString("disponibilite"),
					desRes.getFloat("tarifHoraire"),
					desRes.getString("email"));
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
						desRes.getString("disponibilite"),desRes.getFloat("tarifHoraire"),
						desRes.getString("email"));
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
						desRes.getFloat("tarifHoraire"),
						desRes.getString("email"));
			
		}
        unStat.close();
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp) {
		System.out.println("Erreur de requete : " + requete);
	}
	return unTechnicien;
}

/*************** Gestion des Materiels **************************

public static void insertMateriel (Materiel  unMateriel) {
    String requete ="insert into materiel values (null, '"
            +unMateriel.getType()+"','"
            +unMateriel.getNbrejourloues()+"','"
            +unMateriel.getMontant()+"','"
            +unMateriel.getNoticeentretien()+"','"
            +unMateriel.getIdcontrat()+"');";
   // System.out.println(requete);
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

public static void deleteMateriel (int idMateriel) {
    String requete ="delete from materiel where idmateriel = "+idMateriel+";";
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
public static void updateMateriel(Materiel unMateriel) {
    String requete ="update materiel set type='" 
            +unMateriel.getType()+"', nbrejourloues ='"
            +unMateriel.getNbrejourloues()+"', montant ='"
            +unMateriel.getMontant()+"', noticeentretien ='"
            +unMateriel.getNoticeentretien()+"', idcontrat ='"
            +unMateriel.getIdcontrat()+"' where idmateriel = "
            +unMateriel.getIdmateriel()+";";
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
public static ArrayList<Materiel> selectAllMateriels (String filtre){
    ArrayList<Materiel> lesMateriels = new  ArrayList<Materiel>(); 
    String requete ="" ; 
    if (filtre.contentEquals("")) {
        requete = "select * from  materiel ; ";
    }else {
        requete = "select * from  materiel where type like '%" + filtre 
                + "%'  or  nbrejourloues like '%"+filtre
                + "%'  or  montant like '%"+filtre
                + "%'  or  noticeentretien like '%"+filtre+ "%'";
                
    }
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        while (desRes.next()) {
        	Materiel unMateriel = new Materiel(desRes.getInt("idmateriel"),
                    desRes.getString("type"), 
                    desRes.getString("nbrejourloues"),desRes.getString("montant"),
                    desRes.getString("noticeentretien"),
                    desRes.getInt("idcontrat"));
                    
            lesMateriels.add(unMateriel);
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return lesMateriels; 
}
public static Materiel selectWhereMateriel (int idMateriel) {
	Materiel unMateriel = null; 
    String requete = "select * from materiel where idmateriel = " +idMateriel+";";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            unMateriel = new Materiel(desRes.getInt("idmateriel"),
                    desRes.getString("type"), 
                    desRes.getString("nbrejourloues"),desRes.getString("montant"),
                    desRes.getString("noticeentretien"),
                    desRes.getInt("idcontrat"));
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return unMateriel; 
}
public static Materiel selectWhereMateriel (String type, String nbrejourloues, String montant) {
	Materiel unMateriel = null; 
    String requete = "select * from materiel where type='"+type+"' and nbrejourloues='"+nbrejourloues+"' and montant='"+montant+ "';";
    try {
        uneBdd.seConnecter();
        Statement unStat = uneBdd.getMaconnexion().createStatement(); 
        ResultSet desRes = unStat.executeQuery(requete);
        if (desRes.next()) {
            unMateriel = new Materiel(desRes.getInt("idmateriel"),
                    desRes.getString("type"), 
                    desRes.getString("nbrejourloues"),desRes.getString("montant"),
                    desRes.getString("noticeentretien"),
                    desRes.getInt("idcontrat"));
        }
        unStat.close(); 
        uneBdd.seDeConnecter();
    }
    catch (SQLException exp) {
        System.out.println("Erreur de requete : " + requete);
    }
    return unMateriel; 
}



*/
 
/*************** Gestion des Interventions ***************************/

public static void insertIntervention (Intervention uneIntervention) {
    String requete ="insert into intervention values (null, '"
            +uneIntervention.getDateAffectation()+"','"
            +uneIntervention.getDateArrive()+"','"
            +uneIntervention.getDateFin()+"','"
            +uneIntervention.getEtat()+"','"
            +uneIntervention.getLibelleMateriel()+"','"
            +uneIntervention.getMatricule()+"');";
            
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
            +uneIntervention.getEtat()+"', matricule ='"
            +uneIntervention.getMatricule()+"' where numI = "
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
                    desRes.getInt("numI"));
                    
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
                    desRes.getInt("numI"));
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
                    desRes.getInt("matricule"));
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