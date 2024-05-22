<?php
	class Modele {
		private $unPDO ;
		public function __construct (){
			try{
			$this->unPDO = new PDO ("mysql:host=localhost;dbname=sog","root","") ;
		}
			catch (PDOException $exp)
			{
				echo "Erreur connexion :".$exp->getMessage ();
			}
		}

		public function verifConnexion ($nomClient, $mdp){
			$requete= "SELECT * FROM Client WHERE nomClient=:nomClient and passwordc=:mdp";
			$select = $this->unPDO->prepare($requete);
			$select->bindValue (":nomClient", $nomClient, PDO::PARAM_STR);
			$select->bindValue (":mdp", $mdp, PDO::PARAM_STR);
			$select->execute (); 
			$unUser = $select->fetch ();
			return $unUser;
		}

				/**********Gestion des techniciens*********/

		public function selectAllTechniciens (){
			$requete = "select * from technicien ;" ;
			$select = $this-> unPDO->prepare ($requete);
			$select->execute ();
			return $select->fetchAll();
		}

		public function searchAllTechniciens ($filtre){
			$requete = "select * from technicien
					where nomT like :filtre or prenomT like :filtre or disponibilite like :filtre or tarifHoraire;" ;
			$donnees=array(":filtre"=> "%".$filtre."%");
			$select = $this-> unPDO->prepare ($requete);
			$select->execute ($donnees);
			return $select->fetchAll();
		}

		public function insertTechnicien ($tab){
			$requete = "insert into technicien values (null, :nomT, :prenomT, :disponibilite, :tarifHoraire); " ;
			$donnees =array( 	":nomT"=>$tab['nomT'],
								":prenomT"=>$tab['prenomT'],
								":disponibilite"=>$tab['disponibilite'],
								":tarifHoraire"=>$tab['tarifHoraire']
							);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
		}

		public function deleteTechnicien ($matricule){
			$requete ="delete from technicien where matricule = :matricule ;" ;
			$donnees =array(":matricule"=>$matricule);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
		}
		public function selectWhereTechnicien ($matricule){
			$requete ="select * from technicien where matricule=:matricule;" ;
			$donnees =array(":matricule"=>$matricule);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
			$unTechnicien = $select->fetch ();
			return $unTechnicien;
		}
		public function updateTechnicien ($tab){
			$requete ="update technicien set nomT=:nomT, prenomT=:prenomT, disponibilite=:disponibilite, tarifHoraire=:tarifHoraire where matricule=:matricule;";
			$donnees=array(		":nomT"=>$tab['nomT'],
								":prenomT"=>$tab['prenomT'],
								":disponibilite"=>$tab['disponibilite'],
								":tarifHoraire"=>$tab['tarifHoraire'],
								":matricule"=>$tab['matricule']
						);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
		}



        /**********Gestion des interventions*********/
		public function selectAllInterventions ( $numClient){
			$requete = "select * from intervention where numClient= ". $numClient.";" ;
			$select = $this-> unPDO->prepare ($requete);
			$select->execute ();
			return $select->fetchAll();
		}

		public function searchAllInterventions ($filtre, $numClient){
			$requete = "select * from intervention
					where numClient= ".$numClient." and dateAffectation like :filtre or libelleMateriel like :filtre;" ;
			$donnees=array(":filtre"=> "%".$filtre."%");
			$select = $this-> unPDO->prepare ($requete);
			$select->execute ($donnees);
			return $select->fetchAll();
		}

		public function insertIntervention($tab){
		$requete = "insert into intervention values (null, :dateAffectation, null, null, null, :libelleMateriel, 1, :numClient);";
			//j'ai mis 1 car dans la table j'ai inserer un technicien avec 1 comme matricule comme il en not null obliger
			$donnees =array(":dateAffectation"=>$tab['dateAffectation'],
							//":dateArrive"=>$tab['dateArrive'],
							//":dateFin"=>$tab['dateFin'],
							//":etat"=>$tab['etat'],
							":libelleMateriel"=>$tab['libelleMateriel'],
							//":matricule"=>$tab['matricule'],	
							":numClient"=>$_SESSION['numClient']
							);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
		}

		public function deleteIntervention ($numI){
			$requete ="delete from intervention where numI = :numI ;" ;
			$donnees =array(":numI"=>$numI);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
		}
		public function selectWhereIntervention ($numI){
			$requete ="select * from intervention where numI=:numI;" ;
			$donnees =array(":numI"=>$numI);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
			$uneIntervention = $select->fetch ();
			return $uneIntervention;
		}
		
		public function updateIntervention ($tab){															  
			$requete ="update intervention set dateAffectation=:dateAffectation, libelleMateriel=:libelleMateriel where numI= :numI;";
			$donnees=array(	":dateAffectation"=>$tab['dateAffectation'],
							":libelleMateriel"=>$tab['libelleMateriel'],
							":numI"=>$tab['numI']
						);
			$select = $this->unPDO->prepare ($requete);
			$select->execute ($donnees);
		}
	/**********Gestion des clients*********/
		public function selectAllClients (){
			$requete = "SELECT * FROM client;" ;
			$select = $this->unPDO->prepare($requete);
			$select->execute();
			return $select->fetchAll();
		}

		public function searchAllClients ($filtre){
			$requete = "SELECT * FROM client
						WHERE nomClient LIKE :filtre OR adresse LIKE :filtre OR ville LIKE :filtre OR codePostal LIKE :filtre;" ;
			$donnees = array(":filtre" => "%" . $filtre . "%");
			$select = $this->unPDO->prepare($requete);
			$select->execute($donnees);
			return $select->fetchAll();
		}

		public function insertClient($tab){
			$requete = "INSERT INTO client VALUES (null, :nomClient, :adresse, :ville, :codePostal, :numTel, :adressemail, :passwordc, :typeClient, :siret);" ;
			$donnees = array(":nomClient" => $tab['nomClient'],
							":adresse" => $tab['adresse'],
							":ville" => $tab['ville'],
							":codePostal" => $tab['codePostal'],
							":numTel" => $tab['numTel'],
							":adressemail" => $tab['adressemail'],
							":passwordc" => $tab['passwordc'],
							":typeClient" => $tab['typeClient'],
							":siret" => $tab['siret']
						);
			$select = $this->unPDO->prepare($requete);
			$select->execute($donnees);
		}

		public function deleteClient ($numClient){
			$requete = "DELETE FROM client WHERE numClient = :numClient ;" ;
			$donnees = array(":numClient" => $numClient);
			$select = $this->unPDO->prepare($requete);
			$select->execute($donnees);
		}

		public function selectWhereClient ($numClient){
			$requete = "SELECT * FROM client WHERE numClient = :numClient;" ;
			$donnees = array(":numClient" => $numClient);
			$select = $this->unPDO->prepare($requete);
			$select->execute($donnees);
			$unClient = $select->fetch();
			return $unClient;
		}

		public function updateClient ($tab){                                                              
			$requete = "UPDATE client SET nomClient = :nomClient, adresse = :adresse, ville = :ville, codePostal = :codePostal, numTel = :numTel, adressemail = :adressemail, passwordc = :passwordc, typeClient = :typeClient, siret = :siret WHERE numClient = :numClient;";
			$donnees = array(":nomClient" => $tab['nomClient'],
							":adresse" => $tab['adresse'],
							":ville" => $tab['ville'],
							":codePostal" => $tab['codePostal'],
							":numTel" => $tab['numTel'],
							":adressemail" => $tab['adressemail'],
							":passwordc" => $tab['passwordc'],
							":typeClient" => $tab['typeClient'],
							":siret" => $tab['siret'],
							":numClient" => $tab['numClient']
						);
			$select = $this->unPDO->prepare($requete);
			$select->execute($donnees);
		}


	}
?>