<?php
   require_once("controleur/controleur.class.php");
    $unControleur = new Controleur();
?>
<h2>Gestion des Interventions</h2>

<?php
    $leIntervention = null; //INTERVENTION a modifier
    if (isset($_GET['action']) && isset($_GET['numI']))
    {
        $action = $_GET['action'];
        $numI = $_GET['numI'];

        switch($action)
        {
            case "sup" : $unControleur->deleteIntervention($numI); 
            break;
            
            case "edit" :$leIntervention=$unControleur->selectWhereIntervention ($numI);         
            break;
        }
    }

    require_once ("vue/vue_insert_intervention.php");
    
    if (isset($_POST['Valider']))
    {
        $unControleur->insertIntervention ($_POST);
    }
    if (isset($_POST['Modifier']))
    {
        $unControleur->updateIntervention ($_POST);
        header("location: gestion_intervention.php?");
    }

    if (isset($_POST['Filtrer']))
    {
        $filtre = $_POST['filtre'];
        $lesInterventions = $unControleur->searchAllInterventions($filtre);
    
    }else{
        $lesInterventions = $unControleur->selectAllInterventions ();
    }
    require_once ("vue/vue_select_intervention.php");

?>