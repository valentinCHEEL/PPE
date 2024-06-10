<?php
    session_start();

// Connexion à la base de données

$servername = "localhost";
$nom = "root";
$passwordc = "";
$database = "sog";

$conn = new mysqli($servername, $nom, $passwordc, $database);

if ($conn->connect_error) {
    die("La connexion a échoué: " . $conn->connect_error);
}

if (isset($_POST['Valider'])){
// Récupération des données du formulaire
$numClient = $_SESSION['numClient'];
$nomClient = $_POST['nom'];
$adresse = $_POST['adresse'];
$ville = $_POST['ville'];
$codePostal = $_POST['code_postal'];
$numTel = $_POST['telephone'];
$adressemail = $_POST['adressemail'];
$passwordc =  $_POST['passwordc']; // hacher le mdp 

// Requête de mise à jour des informations dans la base de données
$requete = "UPDATE client SET nomClient='".$nomClient."', adresse='".$adresse."', ville='".$ville."', 
    codePostal='".$codePostal."', numTel='".$numTel."', adressemail='".$adressemail."',
    passwordc='".$passwordc."' WHERE numClient='".$numClient."' ; ";
    //echo $requete; 
 
if ($conn->query($requete) === TRUE) {
    $_SESSION['nomClient'] = $nomClient;
    $_SESSION['adresse'] = $adresse;
    $_SESSION['ville'] = $ville;
    $_SESSION['codePostal'] = $codePostal;
    $_SESSION['numTel'] = $numTel;
    $_SESSION['adressemail'] = $adressemail;
    $_SESSION['passwordc'] = $passwordc;
    $_SESSION['numClient'] = $_SESSION['numClient'];
    echo "Modification appliquée";
    // var_dump($_SESSION);
} else {
    echo "Modification rejetée: " . $conn->error;
}

$conn->close();
}
?>

<html>
    <a href="profil.php" class="btn-modifier">Retour</a>
</html>
