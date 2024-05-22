<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier les informations du client</title>
    
</head>
<body>
    <h2>Modifier les informations du client</h2>
    <form action="modifier_profil.php" method="post">
        <label for="nomClient">Nom:</label><br>
        <input type="text" id="nomClient" name="nom" value ="<?= $_SESSION['client']['nomClient'] ?>" ><br>

        <label for="adresse">Adresse:</label><br>
        <input type="text" id="adresse" name="adresse" value ="<?= $_SESSION['client']['adresse'] ?>" ><br>

        <label for="ville">Ville:</label><br>
        <input type="text" id="ville" name="ville" value ="<?= $_SESSION['client']['ville'] ?>" ><br><br>

        <label for="code_postal">Code postal:</label><br>
        <input type="number" id="code_postal" name="code_postal" value ="<?= $_SESSION['client']['codePostal'] ?>"  ><br><br>

        <label for="telephone">Numero téléphone:</label><br>
        <input type="number" id="telephone" name="telephone"value ="<?= $_SESSION['client']['numTel'] ?>" ><br><br>

        <label for="adressemail">Adresse email:</label><br>
        <input type="email" id="adressemail" name="adressemail"value ="<?= $_SESSION['client']['adressemail'] ?>" ><br><br>

        <label for="passwordc">Mot de passe:</label><br>
        <input type="password" id="passwordc" name="passwordc"value ="<?= $_SESSION['client']['passwordc'] ?>" ><br><br>

        <input type="submit" value="Enregistrer les modifications">
    </form>

</body>
</html>
