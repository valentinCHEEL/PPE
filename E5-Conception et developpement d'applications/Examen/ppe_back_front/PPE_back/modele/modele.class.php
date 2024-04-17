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
		public function selectAllInterventions (){
			$requete = "select * from intervention;" ;
			$select = $this-> unPDO->prepare ($requete);
			$select->execute ();
			return $select->fetchAll();
		}

		public function searchAllInterventions ($filtre){
			$requete = "select * from intervention
					where dateAffectation like :filtre or libelleMateriel like :filtre;" ;
			$donnees=array(":filtre"=> "%".$filtre."%");
			$select = $this-> unPDO->prepare ($requete);
			$select->execute ($donnees);
			return $select->fetchAll();
		}

		public function insertIntervention($tab){
			$requete = "insert into intervention values (null, :dateAffectation, null, null, null, :libelleMateriel, 1); " ;
			//j'ai mis 1 car dans la table j'ai inserer un technicien avec 1 comme matricule comme il en not null obliger
			//de faire ça !!!
			$donnees =array(":dateAffectation"=>$tab['dateAffectation'],
							//":dateArrive"=>$tab['dateArrive'],
							//":dateFin"=>$tab['dateFin'],
							//":etat"=>$tab['etat'],
							":libelleMateriel"=>$tab['libelleMateriel'],
							//":matricule"=>$tab['matricule']	
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
	}
?>