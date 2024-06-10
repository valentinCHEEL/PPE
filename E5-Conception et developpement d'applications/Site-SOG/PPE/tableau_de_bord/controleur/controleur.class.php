<?php
require_once ("modele/modele.class.php");
class Controleur {
        private $unModele ;

        public function __construct (){
            $this->unModele = new Modele ();
        }

   /*********************Gestion technicien******************/
/*
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
*/
  /*********************Gestion intervention***************** */
  public function selectAllInterventions(){
    return $this->unModele->selectAllInterventions();
}

public function searchAllInterventions($filtre){
    return $this->unModele->searchAllInterventions($filtre);
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
}
?>