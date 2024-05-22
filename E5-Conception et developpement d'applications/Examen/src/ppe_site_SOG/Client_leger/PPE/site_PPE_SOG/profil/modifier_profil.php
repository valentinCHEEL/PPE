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

// Récupération des données du formulaire
$numClient = $_SESSION['client']['numClient'];
$nomClient = $_POST['nom'];
$adresse = $_POST['adresse'];
$ville = $_POST['ville'];
$codePostal = $_POST['code_postal'];
$numTel = $_POST['telephone'];
$adressemail = $_POST['adressemail'];
$passwordc = $_POST['passwordc'];

// Requête de mise à jour des informations dans la base de données
$sql = "UPDATE client SET nomClient='$nomClient', adresse='$adresse', ville='$ville', codePostal='$codePostal', numTel='$numTel', adressemail='$adressemail',passwordc='$passwordc' WHERE numClient='$numClient'";
if ($conn->query($sql) === TRUE) {
    echo "Modification appliquée";
} else {
    echo "Modification rejetée: " . $conn->error;
}

$conn->close();
?>

<html>
<a href="profil.php" class="btn-modifier">Retour</a>

</html>
