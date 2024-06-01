<?php
require_once ("modele/modele.class.php");
class Controleur {
        private $unModele ;

        public function __construct (){
            $this->unModele = new Modele ();
        }

        public function verifConnexion ( $nomClient, $passwordc ){
            return $this->unModele->verifConnexion($nomClient, $passwordc);
        }
   /*********************Gestion technicien******************/
   
        public function selectAllTechniciens(){
            return $this->unModele->selectAllTechniciens();
        }

        public function searchAllTechniciens($filtre){
            return $this->unModele->searchAllTechniciens($filtre);
        }

        public function insertTechnicien($tab){
            $this->unModele->insertTechnicien($tab);
        }

        public function deleteTechnicien ($matricule){
            $this->unModele->deleteTechnicien($matricule);
        }
        public function selectWhereTechnicien($matricule){
            return $this->unModele->selectWhereTechnicien($matricule);
        }
        public function updateTechnicien ($tab){
            return $this->unModele->updateTechnicien($tab);
        }

        /*********************Gestion intervention***************** */
        public function selectAllInterventions($numClient){
            return $this->unModele->selectAllInterventions( $numClient);
        }

        public function searchAllInterventions($filtre, $numClient){
            return $this->unModele->searchAllInterventions($filtre, $numClient);
        }

        public function insertIntervention ($tab){
            $this->unModele->insertIntervention($tab);
        }

        public function deleteIntervention ($numI){
            $this->unModele->deleteIntervention($numI);
        }

        public function selectWhereIntervention($numI){
            return $this->unModele->selectWhereIntervention($numI);
        }

        public function updateIntervention ($tab){
            return $this->unModele->updateIntervention($tab);
        }

        /*********************Gestion des clients******************/

        public function selectAllClients(){
            return $this->unModele->selectAllClients();
        }

        public function searchAllClients($filtre){
            return $this->unModele->searchAllClients($filtre);
        }

        public function insertClient($tab){
            $this->unModele->insertClient($tab);
        }

        public function deleteClient($numClient){
            $this->unModele->deleteClient($numClient);
        }

        public function selectWhereClient($numClient){
            return $this->unModele->selectWhereClient($numClient);
        }

        public function updateClient($tab){
            return $this->unModele->updateClient($tab);
        }

    }
?>