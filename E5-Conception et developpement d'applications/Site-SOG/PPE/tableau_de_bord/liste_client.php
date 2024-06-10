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
    <title>Tableau de bord - Gestion des Clients</title>
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
<h2 style="color: white;">Voici les clients enregistrés 
    <?php
        echo $_SESSION['nomT'] . "&nbsp;&nbsp;" . $_SESSION['prenomT'] . "&nbsp;&nbsp;!!!";
    ?>
</h2>

<?php
$leClient = null; // CLIENT à modifier
if (isset($_GET['action']) && isset($_GET['numClient']))
{
    $action = $_GET['action'];
    $numClient = $_GET['numClient'];

    switch($action)
    {
        case "sup" : $unControleur->deleteClient($numClient); 
        break;
        
        case "edit" : $leClient = $unControleur->selectWhereClient($numClient);         
        break;
    }
}

require_once("vue/vue_insert_client.php");

if (isset($_POST['Valider']))
{
    $unControleur->insertClient($_POST);
}
if (isset($_POST['Modifier']))
{
    $unControleur->updateClient($_POST);
    header("location: gestion_client.php");
}

if (isset($_POST['Filtrer']))
{
    $filtre = $_POST['filtre'];
    $lesClients = $unControleur->searchAllClients($filtre);

}else{
    $lesClients = $unControleur->selectAllClients();
}
require_once("vue/vue_select_client.php");
?>
</center>
