<?php 
session_start();
?>

<?php
   require_once("controleur/controleur.class.php");
    $unControleur = new Controleur();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord</title>
    <link rel="stylesheet" href="../site_PPE_SOG/styles/intervention.css">
</head>
<body>
<a href="index.php" class="back-button">Retour</a>
</body>
</html>
<center>
<p>
    <?php 
        echo "<br>Matricule : " . $_SESSION['numTechnicien'];
    ?>
</p>
<h2 style="color: white;">Voici les interventions à prendre sur le planning 
    <?php
        echo $_SESSION['nomT'] . "&nbsp;&nbsp;" .$_SESSION['prenomT'] . "&nbsp;&nbsp;!!!";
    ?>
</h2>

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
</center>