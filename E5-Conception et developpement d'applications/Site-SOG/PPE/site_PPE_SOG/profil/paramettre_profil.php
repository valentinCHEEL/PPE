<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier les paramètre de votre compte</title>

</head>
<center>
<body>
    <h2>Modifier les paramètre de votre compte <?php echo $_SESSION['nomClient']?> </h2>
    <form action="modifier_profil.php" method="post">
        <label for="nomClient">Nom:</label><br>
        <input type="text" id="nomClient" name="nom" value ="<?= $_SESSION['nomClient'] ?>" ><br><br>

        <label for="adresse">Adresse:</label><br>
        <input type="text" id="adresse" name="adresse" value ="<?= $_SESSION['adresse'] ?>" ><br><br>

        <label for="ville">Ville:</label><br>
        <input type="text" id="ville" name="ville" value ="<?= $_SESSION['ville'] ?>" ><br><br>

        <label for="code_postal">Code postal:</label><br>
        <input type="number" id="code_postal" name="code_postal" value ="<?= $_SESSION['codePostal'] ?>"  ><br><br>

        <label for="telephone">Numero téléphone:</label><br>
        <input type="number" id="telephone" name="telephone"value ="<?= $_SESSION['numTel'] ?>" ><br><br>

        <label for="adressemail">Adresse email:</label><br>
        <input type="email" id="adressemail" name="adressemail"value ="<?= $_SESSION['adressemail'] ?>" ><br><br>

        <label for="passwordc">Mot de passe:</label><br>
        <input type="password" id="passwordc" name="passwordc"value ="<?= $_SESSION['passwordc'] ?>" ><br><br>

        <input type="submit" name ="Valider" value="Enregistrer les modifications">
    </form>

</body>
</center>
</html>